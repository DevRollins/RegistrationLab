//  Devin Rollins
//  drollins1108@gmail.com
//  CSC 3280 section 2
//  *** HONOR CODE***
//  I will practice academic and personal integrity and excellence of character and expect the same from others.

import java.util.*;

public class CSregistrationLab {
    
    public static String minutes2Time(int mins){
        int twelve = 720;
        int time = twelve + mins;
        int hours = time / 60;
        if (hours > 12) {
            hours -= 12;
        }
        int minutes = time % 60;
        String formattedTime = "";
        formattedTime += String.format("%s:",hours);
        if (minutes < 10) {
            formattedTime += String.format("0%s PM:", minutes);
        } else{
            formattedTime += String.format("%s PM:", minutes);
        }
        return formattedTime;

    }

    public static void main(String[] args) throws Exception {
            // Make variables
            int numLaptops;
            int numDays;
            int numStudents;

            // Make Scanner for input
            Scanner input = new Scanner(System.in);

            // Scan 1st line of input file (number of laptops)
            numLaptops = input.nextInt();

            // Make a new Stack of Laptops
            CSlaptopStack laptops = new CSlaptopStack(numLaptops);

            // Scan laptops and PUSH them into the stack
            for (int i = 0; i < numLaptops; i++) {
                    laptops.push(input.nextInt());
            }

            // Make the FOUR queues for each of the needed queues
            CSqueue outsideLine = new CSqueue();
            CSqueue laptopCheckOutLine = new CSqueue();
            CSqueue studentsRegistering = new CSqueue();
            CSqueue laptopReturnLine = new CSqueue();

            // Make ONE linked-list for the Daily Registration Report
            CSregistrations dailyRegistrations = new CSregistrations();

            // Make LCM & LRM
            CSstudent studentWithLCM = null; // Reference to student who is working with the LCM
            CSstudent studentWithLRM = null; // Reference to student who is working with the LRM
            // We use them to point to students who are currently interacting with the LCM or LRM

            // Scan number of days of the simulation
            numDays = input.nextInt();

            // OUTER FOR LOOP over all days of simulation
            for (int i = 0; i < numDays; i++) {
                    // Print header message to output for given day
                    System.out.println("**********");
                    System.out.println("Day " + (i + 1) + ":");
                    System.out.println("**********");
                    System.out.println();

                    // Scan the number of students for this day
                    numStudents = input.nextInt();
                    int studentsRemaining = numStudents; // used for MAIN LOOP condition

                    // INNER FOR LOOP to scan/save all students for given day
                    for (int j = 0; j < numStudents; j++) {
                            // Make a NEW CSstudent object and SAVE data
                            CSstudent tempStudent = new CSstudent();
                            tempStudent.setEnterTime(input.nextInt());
                            tempStudent.setLastName(input.next());
                            tempStudent.setFirstName(input.next());
                            tempStudent.setID(input.nextInt());
                            tempStudent.setNumCourses(input.nextInt());
                            tempStudent.setNext(null);

                            // Make temp CScourse array to temporarily hold the courses for this particular student
                            CScourse[] tempCourses = new CScourse[tempStudent.getNumCourses()];

                            // FOR loop over the number of courses for above NEW student
                            for (int k = 0; k < tempStudent.getNumCourses(); k++) {
                                    // Make a NEW CScourse object and SAVE data
                                    CScourse tempCourse = new CScourse();
                                    tempCourse.setCourseNumber(input.next());
                                    tempCourse.setCourseDays(input.next());
                                    String courseTime = input.nextLine();
                                    tempCourse.setCourseTime(courseTime.substring(1));
                                    // Save the course into the tempCourses array
                                    tempCourses[k] = tempCourse;
                            }

                            // Finally, save the array of courses into the tempStudent courses member
                            tempStudent.setCourses(tempCourses);

                            // ENQUEUE tempStudent into outsideLine queue
                            outsideLine.enqueue(tempStudent);

                    } // END loop SCANNING/SAVING all students to outsideLine

                    //**********************************************************************/
                    //********************** MAIN SIMULATION FOR LOOP **********************/
                    //**********************************************************************/
                    for (int minutes = 0; minutes < 300 || studentsRemaining > 0; minutes++) {
                        if (!laptopReturnLine.isEmpty() && laptopReturnLine.getFront().getEnterTime() + 7 == minutes) { //Everybody successfully registers 7 minutes after arriving
                           studentWithLRM = laptopReturnLine.dequeue(); //This person is returning their laptop, so dequeue them from the line
                           laptops.push(studentWithLRM.getLaptopSerialNumber());    //Add that laptop BACK to the STACK
                           studentWithLRM.setTimeRemaining(studentWithLRM.getTimeRemaining() - 1);          //Print the time and action
                           System.out.printf("%s %s %s has successfully registered and returned laptop # %s.\n",minutes2Time(minutes),studentWithLRM.getFirstName(), studentWithLRM.getLastName(), studentWithLRM.getLaptopSerialNumber());
                           dailyRegistrations.insert(studentWithLRM);   //Insert that student into the daily registrations linked-list
                           studentWithLRM = null;   //Set that student to null to indicate the LRM is available
                           studentsRemaining--;         //Decrement the students remaining so that we're not in here forever
                        }
                        
                        //Use SEPARATE if cases 
                        if(!laptopCheckOutLine.isEmpty() && !laptops.isEmpty() && laptopCheckOutLine.getFront().getEnterTime() + 1 == minutes){    //Everyone checks out a laptop 1 minute from arrival
                            studentWithLCM = laptopCheckOutLine.dequeue();  //Dequeue that student 
                            studentWithLCM.setLaptopSerialNumber(laptops.pop());    //Give them a laptop                         
                            studentWithLCM.setTimeRemaining(studentWithLCM.getTimeRemaining() - 1); //It takes a minute to check out a laptop, so timeRemaining is now 6 minutes. Print time and action
                            System.out.printf("%s %s %s has checked-out laptop # %s.\n", minutes2Time(minutes), studentWithLCM.getFirstName(), studentWithLCM.getLastName(), studentWithLCM.getLaptopSerialNumber());
                            studentsRegistering.enqueue(studentWithLCM);    //Enqueue that student into the registering line.
                            studentWithLCM = null;
                        }
                       
                        
                        if (!studentsRegistering.isEmpty() && studentsRegistering.getFront().getEnterTime() + 6 == minutes) {   //Students will start registering 6 minutes after entering
                            CSstudent finishingStu = studentsRegistering.dequeue(); //Dequeue them from the line
                            finishingStu.setTimeRemaining(finishingStu.getTimeRemaining() - 5);   //It takes 5 minutes to register.
                            System.out.printf("%s %s %s has finished registering and entered the Laptop Return Line.\n", minutes2Time(minutes),finishingStu.getFirstName(), finishingStu.getLastName());
                            laptopReturnLine.enqueue(finishingStu);     //Enqueue the student into the laptop return line
                        }                  

                        //Dequeue a student from the outside line                           
                        if  (!outsideLine.isEmpty() && outsideLine.getFront().getEnterTime() == minutes) {  //Make sure it's time for that student to come in
                            CSstudent registStudent = outsideLine.dequeue();   // Dequeue that student from the outside line and then print time and info
                            registStudent.setNext(null);    //Set their next to null in order to avoid them bringing everyone else along
                            laptopCheckOutLine.enqueue(registStudent);  //Enqueue the student into the checkout line
                            System.out.printf(minutes2Time(minutes) + " %s %s has arrived at the Registration Lab and entered the Laptop Check-out Line.\n", registStudent.getFirstName(), registStudent.getLastName());

                        } 
                        
                        //I tried my best, but it seems I've run out of time. 
                    } //*********** END main FOR Loop of Simulation ***********//

                    // PRINT Daily Registration Report
                    // Notice that the printing of the daily registration report happens AFTER the
                    // main for loop over each minute...and that should make sense, right? Once the day
                    // has completed, then and only then are you ready to traverse/print the linked-list
                    // of the completed registrations.
                    System.out.printf("*** Day %s: CS Daily Registration Report ***:\n",i + 1);
                    System.out.println();       
                    System.out.printf("The Registration Lab received %s registrations as follows:\n",dailyRegistrations.size());
                    System.out.println();
                    dailyRegistrations.printList(); //Call the printList method from the CSregistrations class
                    //Clear all queues for the next day
                    outsideLine.clear();
                    laptopCheckOutLine.clear();
                    laptopReturnLine.clear();

            }
    }

}


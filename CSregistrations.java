//  Devin Rollins
//  drollins1108@gmail.com
//  CSC 3280 section 2
//  *** HONOR CODE***
//  I will practice academic and personal integrity and excellence of character and expect the same from others.

public class CSregistrations {
	// head: reference variable to the first node of the list
    private CSstudent head;
    
    // CONSTRUCTORS
    public CSregistrations() {
        head = null;
    }
    
    public int size(){
        CSstudent helper = head;
        int counter = 0;
        while(helper != null){
            counter++;
        }
        return counter;
    }

    public boolean isEmpty() {
            return head == null;
    }
    
    public CSstudent insert(CSstudent stu){
        // Case they have both differing first and last name
        
        String stuName = stu.getFirstName() + " " + stu.getLastName();
        if (head == null || head.getFullName(head).compareTo(stuName) > 0) {
            head = stu;
            return stu;
        }
        else{
            CSstudent helper = head;
            String tempStuName = helper.getFirstName() + " " + helper.getLastName();
            while (helper.getNext() != null){
                if (tempStuName.compareTo(stuName) > 0) {
                    helper = helper.getNext();
                }
            }
            CSstudent newStu = stu;
            helper.setNext(newStu);
        }
        return head;
    }
    
    public void printList(){
        CSstudent helper = head;
        while(helper != null){
            System.out.println(helper); //Call the overriden toString() method from the CSstudent class
            helper = helper.getNext();
        }
        System.out.println();
    }
    
    @Override
    public String toString(){
        String studentInfo = "";
        studentInfo += String.format("%s, %s, ID# %s\n", head.getLastName(), head.getFirstName(), head.getID());
        studentInfo += String.format("      Time Registered:  %s\n", head.getTimeRegistered());
        studentInfo += "      Classes:\n";
        for (int i = 0; i < head.getNumCourses()-1; i++) {
            studentInfo += head.getCourses();
        }
        return studentInfo;
    }
    
    public void clear(){
        head = null;
    }
}

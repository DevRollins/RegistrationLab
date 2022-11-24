//  Devin Rollins
//  drollins1108@gmail.com
//  CSC 3280 section 2
//  *** HONOR CODE***
//  I will practice academic and personal integrity and excellence of character and expect the same from others.

public class CSstudent {
    private String firstName;
    private String lastName;
    private int ID;
    private int laptopSerialNumber;
    private int numCourses;
    private CScourse[] courses;
    private int enterTime;
    private int timeRemaining = 7;  //Set this to 7 because everyone finishes registering in 7 minutes
    private int timeRegistered;
    private CSstudent next;
    private String fullName;

    public CSstudent() {
    }

    public CSstudent(String firstName, String lastName, int ID, int laptopSerialNumber, int numCourses, CScourse[] courses, int enterTime, int timeRemaining, int timeRegistered, CSstudent next) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.laptopSerialNumber = laptopSerialNumber;
        this.numCourses = numCourses;
        this.courses = courses;
        this.enterTime = enterTime;
        this.timeRemaining = timeRemaining;
        this.timeRegistered = timeRegistered;
        this.next = next;
    }
    
    //Create another compareTo() method to automatically sort 
    
    public CSstudent(String firstName, String lastName, CSstudent next){
        this.firstName = firstName;
        this.lastName = lastName;
        this.next = next;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLaptopSerialNumber() {
        return laptopSerialNumber;
    }

    public void setLaptopSerialNumber(int laptopSerialNumber) {
        this.laptopSerialNumber = laptopSerialNumber;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public CScourse[] getCourses() {
        return courses;
    }

    public void setCourses(CScourse[] courses) {
        this.courses = courses;
    }

    public int getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getTimeRegistered() {
        return timeRegistered;
    }

    public void setTimeRegistered(int timeRegistered) {
        this.timeRegistered = timeRegistered;
    }

    public CSstudent getNext() {
        return next;
    }

    public void setNext(CSstudent next) {
        this.next = next;
    }
    
    public String getFullName(CSstudent person){
        String name = "";
        String fName = person.getFirstName();
        String lName = person.getLastName();
        name += fName + " " + lName;
        return name;
    }
}

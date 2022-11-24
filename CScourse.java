//  Devin Rollins
//  drollins1108@gmail.com
//  CSC 3280 section 2
//  *** HONOR CODE***
//  I will practice academic and personal integrity and excellence of character and expect the same from others.

public class CScourse {
    private String courseNumber;
    private String courseDays;
    private String courseTime;

    public CScourse() {
    }

    public CScourse(String courseNumber, String courseDays, String courseTime) {
        this.courseNumber = courseNumber;
        this.courseDays = courseDays;
        this.courseTime = courseTime;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseDays() {
        return courseDays;
    }

    public void setCourseDays(String courseDays) {
        this.courseDays = courseDays;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    
    
    @Override
    public String toString(){
        String courseData = "";
        courseData += String.format("      | %s | %s | %s |\n", courseNumber, courseDays, courseTime);
        return courseData;
    }
    
}

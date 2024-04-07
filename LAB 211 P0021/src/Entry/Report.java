package Entry;
public class Report {
    String id;
    String name;
    String courseName;
    int totalCourse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public Report(String id, String name, String courseName, int totalCourse) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }
    
}

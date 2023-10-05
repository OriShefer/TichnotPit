public class Course {

    private String courseName;
    private String courseColor;
    private int numOfStudents;
    private boolean wonSportsDay;

    public Course(String courseName, String courseColor, int numOfStudents, boolean wonSportsDay) {
        this.courseName = courseName;
        this.courseColor = courseColor;
        this.numOfStudents = numOfStudents;
        this.wonSportsDay = wonSportsDay;
    }

    public String courseName() {
        return courseName;
    }

    public void changeCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String courseColor() {
        return courseColor;
    }

    public void changeCourseColor(String courseColor) {
        this.courseColor = courseColor;
    }

    public int numOfStudents() {
        return numOfStudents;
    }

    public void changeNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public boolean wonSportsDay() {
        return wonSportsDay;
    }

    public void changeWonSportsDay(boolean wonSportsDay) {
        this.wonSportsDay = wonSportsDay;
    }

    @Override
    public String toString(){

        String winLose = this.wonSportsDay() ? "Won" : "Lost";

        return "Course: " + this.courseName() + "\n" +
                "Number of students is: "+this.numOfStudents()+ "\n" +
                "The course " + winLose + " the Sports Day";

    }

    @Override
    public boolean equals(Object course) {
        boolean isEqual = true;

        if ((course == null) || (this.getClass() != course.getClass())) {
            isEqual = false;
        } else if (this != course) {
            Course otherCourse = (Course) course;
            isEqual = this.courseName().equals(otherCourse.courseName());
        }

        return isEqual;
    }


}

public class Course {
    private String courseName;
    private Obstacle[] obstacleCourse;

    public Course(String courseName, Obstacle[] obstacleCourse) {
        this.courseName = courseName;
        this.obstacleCourse = obstacleCourse;
    }

    public void doCourse(Team team) {
        System.out.println("Doing course " + this.courseName + "...");
        for (Obstacle ob : this.obstacleCourse) {
            for (Animal al : team.getTeamArray()) {
                ob.doIt(al);
            }
        }
    }
}

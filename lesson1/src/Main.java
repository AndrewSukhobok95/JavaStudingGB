public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Cat1", 10, 6),
                new Dog("Dog1", 10, 7, 8),
                new Duck("Duck1", 6, 10, 5),
                new Sparrow("Sparrow1", 10, 6)
        };

        Team team = new Team("teamA", animals);
        team.prepareForNewCompetition(); // Reset OnDistance to true
        Course course1 = new Course("Course1", new Obstacle[] {new Road(4), new Water(3), new Wall(1), new Break(2)});
        course1.doCourse(team);
        team.infoDoneDistanceMembers();

        team.prepareForNewCompetition();
        Course course2 = new Course("Course2", new Obstacle[] {new Road(4), new Break(2)});
        course2.doCourse(team);
        team.infoDoneDistanceMembers();
    }

}

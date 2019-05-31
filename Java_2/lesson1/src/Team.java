public class Team {
    private String teamName;
    private Animal[] teamArray;

    public Team(String teamName, Animal[] teamArray) {
        this.teamName = teamName;
        this.teamArray = teamArray;
        if(teamArray.length!=4){
            System.out.println("The number of members is " + teamArray.length + " instead of 4.");
        }
    }

    public Animal[] getTeamArray() {
        return teamArray;
    }

    public void infoDoneDistanceMembers() {
        boolean showFailedAnimals = false;
        System.out.println("These members of " + this.teamName + " completed the course:");
        for(Animal m : this.teamArray) {
            if(m.isOnDistance()) {
                System.out.println("- " + m.getAnimalType() + " " + m.getAnimalName());
            }else{
                showFailedAnimals = true;
            }
        }
        if(showFailedAnimals) {
            System.out.println("These members of " + this.teamName + " failed:");
            for (Animal m : this.teamArray) {
                if (!m.isOnDistance()) {
                    System.out.println("- " + m.getAnimalType() + " " + m.getAnimalName());
                }
            }
        }
        System.out.println();
    }

    public void prepareForNewCompetition() {
        for(Animal m : this.teamArray) {
            m.setOnDistance(true);
        }
    }
}

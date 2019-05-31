public class Animal implements Run {

    protected String animalType;
    protected String animalName;
    private int canRunDistance;
    private boolean onDistance = true;

    public Animal(String type, String name, int canRunDistance) {
        this.animalType = type;
        this.animalName = name;
        this.canRunDistance = canRunDistance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() { return animalName; }

    public Animal setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
        return this;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void run(int dist) {
        if (this.canRunDistance < dist) {
            this.onDistance = false;
        }
    }
}

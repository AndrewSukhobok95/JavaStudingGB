public class Duck extends Animal implements Swim, Fly {
    int swimDistance;
    int flyDistance;

    protected Duck(String name, int runDistance, int swimDistance, int flyDistance) {
        super("duck", name, runDistance);
        this.swimDistance = swimDistance;
        this.flyDistance = flyDistance;
    }

    @Override
    public void swim(int distance) {
        if (this.swimDistance < distance) {
            setOnDistance(false);
        }
    }

    @Override
    public void fly(int size) {
        if(this.flyDistance<size){
            setOnDistance(false);
        }
    }
}

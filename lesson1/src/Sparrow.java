public class Sparrow extends Animal implements Fly{
    private int flyDistance;

    protected Sparrow(String name, int runDistance, int flyDistance) {
        super("sparrow", name, runDistance);
        this.flyDistance = flyDistance;
    }

    @Override
    public void fly(int flyDistance) {
        if(this.flyDistance<flyDistance){
            setOnDistance(false);
        }
    }
}

public class Dog extends Animal implements Run, Jump, Swim {
    private final int swimDistance;
    private int jumpHeight;

    protected Dog(String name, int runDistance, int jumpHeight, int swimDistance) {
        super("dog", name, runDistance);
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
    }

//    @Override
//    public void run(int dist) {
//        super.run(dist);
//        //dosomehting
//    }

    @Override
    public void jump(int height) {
        if (this.jumpHeight < height) {
            setOnDistance(false);
        }
    }

    @Override
    public void swim(int swimDistance) {
        if (this.swimDistance < swimDistance) {
            setOnDistance(false);
        }
    }
}

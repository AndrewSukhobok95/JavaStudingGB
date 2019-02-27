public class Water extends Obstacle {
    protected Water(int size) {
        super(size);
    }

    @Override
    public void doIt(Animal a) {
        if (a instanceof Swim) {
            ((Swim) a).swim(size);
        } else {
            a.setOnDistance(false);
        }
    }
}

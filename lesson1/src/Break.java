public class Break extends Obstacle{
    protected Break(int size){ super(size); }

    @Override
    public void doIt(Animal a) {
        if(a instanceof Fly){
            ((Fly) a).fly(size);
        }else{
            a.setOnDistance(false);
        }
    }
}

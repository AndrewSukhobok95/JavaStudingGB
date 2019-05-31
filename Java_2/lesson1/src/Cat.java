public class Cat extends Animal implements Jump {
    private int jumpHeight;

    protected Cat(String name, int runDistance, int jumpHeight) {
        super("cat", name, runDistance);
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void jump(int height) {
        if (this.jumpHeight < height) {
            setOnDistance(false);
        }
    }
}

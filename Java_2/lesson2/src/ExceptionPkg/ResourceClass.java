package ExceptionPkg;

public class ResourceClass implements AutoCloseable{
    public void close() throws Exception {
        System.out.println("Closing!");
    }
}

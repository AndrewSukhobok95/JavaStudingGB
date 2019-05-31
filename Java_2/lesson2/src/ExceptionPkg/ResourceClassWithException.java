package ExceptionPkg;

public class ResourceClassWithException implements AutoCloseable {
    public void close() throws Exception {
        throw new RuntimeException("RuntimeException in close function!");
    }
}

public class NotInsideLibraryException extends Exception {

    public NotInsideLibraryException() {
        super("U must be inside a library");
    }
}

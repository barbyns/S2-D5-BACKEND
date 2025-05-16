package catalogo;

public class CustomExceptions {
    public static class ISBNNotFoundException extends Exception {
        public ISBNNotFoundException(String message) {
            super(message);
        }
    }

    public static class ISBNAlreadyExistsException extends Exception {
        public ISBNAlreadyExistsException(String message) {
            super(message);
        }
    }
}

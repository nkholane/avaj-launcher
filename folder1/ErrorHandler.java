package folder1;

public class ErrorHandler extends Exception {
 String error;
    public ErrorHandler(String error) {
            this.error = error;
    }

    public String toString() {
        return "ErrorHandler: " + error;
    }
}

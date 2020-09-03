package folder1;

public class ErrorHandler extends Exception {
    public ErrorHandler(String error) {
            toString(error);
    }

    public String toString(String error) {
        return "ErrorHandler:" + error;
    }
}

package analizadorjava;

public class Wrapper {

    private String message;
    private boolean error;
    private static Wrapper _instance;

    public static Wrapper getInstance() {
        if (_instance == null) {
            _instance = new Wrapper();
        }
        return _instance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}

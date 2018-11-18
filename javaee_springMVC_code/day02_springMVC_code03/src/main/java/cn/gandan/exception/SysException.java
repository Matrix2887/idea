package cn.gandan.exception;

public class SysException extends Exception {

    private static final long serialVersionUID = 4055945147128016300L;

    private String message;

    public SysException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

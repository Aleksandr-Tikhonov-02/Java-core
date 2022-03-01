package lab2.exceptions;

public class FileIsNotFoundException extends  Throwable{
    private final String msg_;
    {
        msg_ = "File is not found";
    }

    public FileIsNotFoundException(){}

    @Override
    public String getMessage() {
        return msg_;
    }
}

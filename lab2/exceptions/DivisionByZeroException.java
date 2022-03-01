package lab2.exceptions;

public class DivisionByZeroException extends  Exception{
    private final String msg_;
    {
        msg_ = "Division by Zero";
    }

    public DivisionByZeroException(){}

    @Override
    public String getMessage() {
        return msg_;
    }
}

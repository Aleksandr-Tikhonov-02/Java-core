package lab2.exceptions;

public class BigMatrixSizeException extends Exception {
    private final String msg_;
    {
        msg_ = "Size of Matrix can't be more than 1 million";
    }

    public BigMatrixSizeException(){}

    @Override
    public String getMessage() {
        return msg_;
    }
}

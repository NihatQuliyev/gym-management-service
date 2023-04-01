package exception;
import enums.ExceptionEnum;
public class InvalidOptionException extends RuntimeException{
    public InvalidOptionException() {
        super(ExceptionEnum.INVALID_OPTION.name());
    }

}

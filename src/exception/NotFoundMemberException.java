package exception;
import enums.ExceptionEnum;
public class NotFoundMemberException extends RuntimeException{
    public NotFoundMemberException() {
        super(ExceptionEnum.MEMBER_NOT_FOUND.name());
    }
}

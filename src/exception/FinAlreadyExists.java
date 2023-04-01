package exception;

import enums.ExceptionEnum;

public class FinAlreadyExists extends RuntimeException{
    public FinAlreadyExists() {
        super(ExceptionEnum.FIND_ALREADY_EXISTS.name());
    }
}

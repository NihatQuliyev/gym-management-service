package exception;

import enums.ExceptionEnum;

public class NotFoundFin extends RuntimeException {

    public NotFoundFin() {
        super(ExceptionEnum.NOT_FOUND_FIN.name());
    }

}

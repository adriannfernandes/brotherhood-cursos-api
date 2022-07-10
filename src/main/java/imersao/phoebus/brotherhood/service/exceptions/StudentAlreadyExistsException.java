package imersao.phoebus.brotherhood.service.exceptions;

public class StudentAlreadyExistsException extends Exception{

    public StudentAlreadyExistsException() {
        super();
    }

    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}

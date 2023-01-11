package edai.proyectoFinal.lib.exceptions;

public class DuplicatedKeyException extends Throwable {
    public DuplicatedKeyException(){
        super();
    }
    public DuplicatedKeyException(String message){
        super(message);
    }
}

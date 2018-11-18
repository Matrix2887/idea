package cn.gandan.day05.text;

public class NameOutOfBoundsException extends RuntimeException{
    public NameOutOfBoundsException(){
    }

    public NameOutOfBoundsException(String message){
        super(message);
    }
}

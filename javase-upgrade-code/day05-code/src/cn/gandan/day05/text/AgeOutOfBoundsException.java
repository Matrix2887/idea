package cn.gandan.day05.text;

public class AgeOutOfBoundsException extends RuntimeException{
    public AgeOutOfBoundsException(){
    }

    public AgeOutOfBoundsException(String message){
        super(message);
    }
}

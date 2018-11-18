package cn.gandan.day05.text;

public class GanderOutOfBoundsException extends RuntimeException{
    public GanderOutOfBoundsException(){
    }

    public GanderOutOfBoundsException(String message){
        super(message);
    }
}

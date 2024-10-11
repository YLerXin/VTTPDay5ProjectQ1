package exceptions;

public class myAppException extends Exception{



    public myAppException(){}

    public myAppException(String msg){
        //super has to be in the first line
        super(msg);
    }
    public myAppException(String msg,Throwable cause){

    }

    
    
}

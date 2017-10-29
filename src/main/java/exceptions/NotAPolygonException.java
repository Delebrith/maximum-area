package exceptions;

public class NotAPolygonException extends Exception {

    @Override
    public String getMessage(){
        return "Crossing detected. Not a polygon";
    }
}

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
    List<String> errors =new ArrayList<String>();

    public void add(String error){
        errors.add(error);
    }

    public String listErrors(){
        String errorsString ="";
        for(String error: errors){
            errorsString = errorsString.concat(error);
        }
        return errorsString;
    }

    public boolean isEmpty(){
        return this.errors.isEmpty();
    }
}

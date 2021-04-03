public class Calculator {
    ErrorHandler errorHandler = new ErrorHandler();

    public String add(String value){
        if(checkIfLastCharIsSeparator(value)){
            registerErrorLastCharIsSeparator(value);
        }
        return getSum(value);
    }

    private boolean checkIfLastCharIsSeparator(String value){
        if(value.isEmpty()){
            return false;
        }
        if(value.charAt(value.length()-1)==',' || value.charAt(value.length()-1)=='\n'){
            return true;
        }
        return false;
    }

    private String getIllegalCharPosition(String value){
        String index = new String();
        if(hasCustomSeparator(value)){
            if(value.contains(",")){
                Integer indexOf = value.indexOf(",")+1;
                index = indexOf.toString();
            }
        }
        return index;
    }

    private void registerErrorLastCharIsSeparator(String value){
        if(value.charAt(value.length()-1)==','){
            errorHandler.add(value+" is invalid and should return the message Number expected but EOF found.");
        }
        if(value.contains(",\n")) {
            int position = value.indexOf(",\n") + 1;
            errorHandler.add("Number expected but '\\n' found at position " + position + ".");
        }
    }

    private String getSum(String value){
        Double sum = 0.0;
        if(hasCustomSeparator(value)){
            if(hasIllegalSeparator(value))
            return getIllegalSeparatorMessage(value);
        }
        String[] values = getValues(value);

        if(value.isEmpty()){
            return "0";
        }

        if(hasNegativeNumbers(values)){
            errorHandler.add("Negative not allowed :"+getNegativeNumbers(values));

        }

        for(String stringValue:values){
            sum+=Double.parseDouble(stringValue);
        }

        if(errorHandler.isEmpty()){

        return sum.toString();
        }else{

            return errorHandler.listErrors();
        }
    }

    private String getNegativeNumbers(String[] values) {
        String negativeNumbers ="";
        for(String stringValue:values){
            if(Double.parseDouble(stringValue)<0){
                negativeNumbers = negativeNumbers.concat(" "+stringValue);
            }
        }
        return negativeNumbers;
    }

    private boolean hasNegativeNumbers(String[] values) {

        for(String stringValue:values){
            if(Double.parseDouble(stringValue)<0){
                return true;
            }
        }
       return false;
    }

    private String getIllegalSeparatorMessage(String value) {
        return value+" is invalid and should return the message '"+getStringSeparator(value)+
                "' expected but ',' found at position "+getIllegalCharPosition(value)+".";
    }

    private boolean hasIllegalSeparator(String value) {
        if (value.contains(",")){
            return true;
        }
        return false;
    }

    private boolean hasCustomSeparator(String value) {
        if(value.startsWith("//")){
            return true;
        }
            return false;
        }

    private String[] getValues(String value) {
        String[] values;
        if(hasCustomSeparator(value)){
            String separator = getStringSeparator(value);
            values = value.substring(value.indexOf("\n")+1).split(separator);

        }else{
            values = value.split(",|\n");
        }
        return values;
    }
    private String getStringSeparator(String value) {
        return value.substring(2,value.indexOf("\n"));
    }
}

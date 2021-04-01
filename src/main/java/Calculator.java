public class Calculator {
    public String add(String value){
        if(checkIfLastCharIsSeparator(value)){
            return getIllegalCharPosition(value);
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
        if(value.charAt(value.length()-1)==','){
            return value+" is invalid and should return the message Number expected but EOF found.";
        }
        int position = value.indexOf(",\n")+1;
        return "Number expected but '\\n' found at position "+position+".";
    }

    private String getSum(String value){
        Double sum = 0.0;
        String[] values = getValues(value);
        if(value.isEmpty()){
            return "0";
        }
        for(String stringValue:values){
            sum+=Double.parseDouble(stringValue);
        }
        return sum.toString();
    }

    private String[] getValues(String value) {
        String[] values;
        if(value.startsWith("//")){
            String separator = value.substring(2,value.indexOf("\n"));
            values = value.substring(value.indexOf("\n")+1).split(separator);
        }else{
            values = value.split(",|\n");
        }
        return values;
    }
}

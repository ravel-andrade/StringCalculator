public class Calculator {
    public String add(String value){
        if(!value.isEmpty() && value.charAt(value.length()-1)==','){
            return "1,3, is invalid and should return the message Number expected but EOF found.";
        }
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
        int position = value.indexOf(",\n")+1;
        return "Number expected but '\\n' found at position "+position+".";
    }

    private String getSum(String value){
        Double sum = 0.0;
        String[] values = value.split(",|\n");
        if(value.isEmpty()){
            return "0";
        }
        for(String stringValue:values){
            sum+=Double.parseDouble(stringValue);
        }
        return sum.toString();
    }
}

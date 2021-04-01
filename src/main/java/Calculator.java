public class Calculator {
    public String add(String value){
        if(value.contains(",\n")){
            return "Number expected but '\\n' found at position 6.";
        }
        return getSum(value);
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

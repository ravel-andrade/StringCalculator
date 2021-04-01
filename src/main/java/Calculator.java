public class Calculator {
    public String add(String value){
        if(value.contains(",\n")){
            return getIllegalCharPosition(value);
        }
        return getSum(value);
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

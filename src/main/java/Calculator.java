public class Calculator {
    public String add(String value){
        return getSum(value);
    }

    private String getSum(String value){
        Integer sum = 0;
        String[] values = value.split(",");
        if(value.isEmpty()){
            return "0";
        }
        for(String stringValue:values){
            sum+=Integer.parseInt(stringValue);
        }
        return sum.toString();
    }
}

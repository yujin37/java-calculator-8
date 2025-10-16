package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumericStringValidator {
    //표준 구분자와 숫자로만 이루어져있는지 확인
    public static List<Number> digitsAndStandard(String values){
        List<Number> digits = new ArrayList<>();
        for(int i=0; i<values.length();i++){
            char c = values.charAt(i);
            if(i%2 == 0 && Character.isDigit(c)){
                digits.add(Integer.parseInt(String.valueOf(c)));
            }
            else if (i % 2 == 1 && (values.charAt(i) == ':' || values.charAt(i) == ',')) {
            } else {
                throw new IllegalArgumentException();
            }
        }
        return digits;
    }
    public static String processValidator(String values){
        if(values.matches("^[0-9:,]+$")){
            System.out.println(digitsAndStandard(values));
        }
        else{
            System.out.println("특수 구분자나 잘못된 값일 겁니다.");
        }

        return "0";
    }

}

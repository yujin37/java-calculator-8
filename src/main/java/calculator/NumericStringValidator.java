package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumericStringValidator {
    //표준 구분자와 숫자로만 이루어져있는지 확인
    public static List<Integer> digitsAndStandard(String values){
        String[] digits;
        //현재 두 자리 이상의 숫자의 경우에는 에러가 발생한다.
        digits = values.split("[:,]");
        List<Integer> intDigits = new ArrayList<>();
        for(int i = 0; i< digits.length; i++){
            int num = Integer.parseInt(digits[i]);
            intDigits.add(num);
        }
        return intDigits;
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

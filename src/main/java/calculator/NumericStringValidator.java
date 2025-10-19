package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    public static List<Integer> digitsAndSpecial(String values, char specialTag){
        String[] digits;
        String tag = "[:," + Pattern.quote(String.valueOf(specialTag)) + "]";
        String cuttedValue = values.substring(values.indexOf("\\n") + 2);
        digits = cuttedValue.split(tag);

        List<Integer> intDigits = new ArrayList<>();
        for(int i = 0; i<digits.length;i++){
            int num = Integer.parseInt(digits[i]);
            intDigits.add(num);
        }
        return intDigits;
    }
    public static Integer processValidator(String values){
        List<Integer> splitSpecial;
        if (values.startsWith("//") && values.startsWith("\\n", 3)) {
            splitSpecial = digitsAndSpecial(values, values.charAt(2));
        }
        else if (values.matches("^[0-9:,]+$")){
            splitSpecial = digitsAndStandard(values);
        }else{
            throw new IllegalArgumentException("입력이 잘못 되었습니다.");
        }
        return NumericStringPlus.digitPlusCalculator(splitSpecial);

    }

}

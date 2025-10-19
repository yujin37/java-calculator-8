package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumericStringValidator {
    //표준 구분자와 숫자로만 이루어져있는지 확인
    public static List<Integer> digitsAndStandard(String values){
        String[] digits;
        digits = values.split("[:,]");

        return parseDigits(digits);
    }
    public static List<Integer> digitsAndSpecial(String values){
        String[] digits;
        char specialTag = values.charAt(2);
        String tag = "[:," + Pattern.quote(String.valueOf(specialTag)) + "]";
        String cuttedValue = values.substring(values.indexOf("\\n") + 2);
        digits = cuttedValue.split(tag);

        return parseDigits(digits);
    }

    public static List<Integer> parseDigits(String[] stringDigits){
        List<Integer> intDigits = new ArrayList<>();
        for(int i = 0; i< stringDigits.length; i++){
            int num = Integer.parseInt(stringDigits[i]);
            intDigits.add(num);
        }
        return intDigits;
    }
    public static Integer processValidator(String values){
        List<Integer> splitSpecial;
        if (values.startsWith("//") && values.startsWith("\\n", 3)) {
            splitSpecial = digitsAndSpecial(values);
        }
        else if (values.matches("^[0-9:,]+$")){
            splitSpecial = digitsAndStandard(values);
        }else{
            throw new IllegalArgumentException("입력이 잘못 되었습니다.");
        }
        return NumericStringPlus.digitPlusCalculator(splitSpecial);

    }

}

package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumericStringValidator {
    //표준 구분자와 숫자로만 이루어져있는지 확인
    private static List<Integer> digitsAndStandard(String values){
        String[] digits;
        digits = values.split("[:,]");

        return parseDigits(digits);
    }
    private static List<Integer> digitsAndSpecial(String values){
        String[] digits;
        char specialTag = values.charAt(2);
        String tag = "[:," + Pattern.quote(String.valueOf(specialTag)) + "]";
        String cuttedValue = values.substring(values.indexOf("\\n") + 2);
        digits = cuttedValue.split(tag);

        return parseDigits(digits);
    }

    private static List<Integer> parseDigits(String[] stringDigits){
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
        } else if (values.matches("^[0-9:,]+$")){
            splitSpecial = digitsAndStandard(values);
        } else {
            throw new IllegalArgumentException("입력 형식이 잘못 되었습니다. 표준 구분자(:;)와 양수 숫자로 이루어지지 않았거나 특수 구분자 입력 규칙을 지키지 않았습니다."); // 알림 메시지 상세하게 변경하기
        }
        return NumericStringPlus.digitPlusCalculator(splitSpecial);

    }

}

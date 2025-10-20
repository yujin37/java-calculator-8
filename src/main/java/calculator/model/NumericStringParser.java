package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumericStringParser {
    private static String[] digitsAndStandard(String values){
        String[] digits;
        digits = values.split("[:,]");

        return digits;
    }
    private static String[] digitsAndSpecial(String values){
        String[] digits;
        char specialTag = values.charAt(2);
        String tag = "[:," + Pattern.quote(String.valueOf(specialTag)) + "]";
        String cuttedValue = values.substring(values.indexOf("\\n") + 2);
        digits = cuttedValue.split(tag);
        return digits;
    }

    private static List<Integer> parseDigits(String[] stringDigits){
        List<Integer> intDigits = new ArrayList<>();
        for(int i = 0; i< stringDigits.length; i++){
            int num = Integer.parseInt(stringDigits[i]);
            intDigits.add(num);
        }
        return intDigits;
    }
    public static List<Integer> parseProcessor(String inputValue){
        String[] splitDigit;
        if (inputValue.startsWith("//") && inputValue.startsWith("\\n", 3)){
            splitDigit = digitsAndSpecial(inputValue);
        } else {
            splitDigit = digitsAndStandard(inputValue);
        }
        return parseDigits(splitDigit);
    }
}

package calculator.controller;

import calculator.model.NumericStringParser;
import calculator.model.NumericStringPlus;
import calculator.model.NumericStringValidator;
import java.util.List;

public class NumericStringInputProcessor {
    public static Integer processNumericString(String inputString) {
        NumericStringValidator.processValidator(inputString);
        List<Integer> splitDigits = NumericStringParser.parseProcessor(inputString);
        return NumericStringPlus.digitPlusCalculator(splitDigits);

    }
}
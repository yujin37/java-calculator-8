package calculator;

import camp.nextstep.edu.missionutils.Console;

public class NumericStringInputProcessor {
    public static String readInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    public static void printResult(String outputValue) {
        System.out.println(outputValue);
    }
    public static void processNumericString() {
        String inputString = readInputString();
        String outputString = NumericStringValidator.processValidator(inputString);
        printResult(outputString);
    }
}

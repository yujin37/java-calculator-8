package calculator;

import camp.nextstep.edu.missionutils.Console;

public class NumericStringInputProcessor {
    public static String readInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    public static void printResult(Integer outputValue) {
        System.out.println("결과 : " + outputValue);
    }
    public static void processNumericString() {
        String inputString = readInputString();
        Integer outputInt = NumericStringValidator.processValidator(inputString);
        printResult(outputInt);
    }
}

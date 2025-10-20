package calculator.view;

import calculator.controller.NumericStringInputProcessor;
import camp.nextstep.edu.missionutils.Console;

public class NumericStringView {
    private static String readInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    private static void printResult(Integer outputValue) {
        System.out.println("결과 : " + outputValue);
    }
    public static void readAndOutput(){
        String inputValue = readInputString();
        printResult(NumericStringInputProcessor.processNumericString(inputValue));
    }
}

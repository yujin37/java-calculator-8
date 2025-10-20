package calculator.model;


public class NumericStringValidator {

    public static void processValidator(String values){
        boolean firstRule = values.startsWith("//") && (values.startsWith("\\n",3));
        boolean secondRule = values.matches("^[0-9:,]+$");
        if (!firstRule && !secondRule) {
            throw new IllegalArgumentException(
                    "입력 형식이 잘못 되었습니다. 표준 구분자(:;)와 양수 숫자로 이루어지지 않았거나 특수 구분자 입력 규칙을 지키지 않았습니다."
            );
        }
    }

}

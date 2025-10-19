package calculator;

import java.util.List;

public class NumericStringPlus {
    public static Integer digitPlusCalculator(List<Integer> integerBox){
        Integer plusResult = 0;
        for(int i = 0;i<integerBox.size();i++){
            plusResult += integerBox.get(i);
        }
        return plusResult;
    }
}

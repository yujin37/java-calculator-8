package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NumericStringPlusTest extends NsTest{
    @Test
    void 덧셈_확인() {
        assertEquals(NumericStringPlus.digitPlusCalculator(Arrays.asList(1,2,4)), 7);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

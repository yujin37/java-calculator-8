package calculator;
import calculator.controller.NumericStringInputProcessor;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumericStringParserTest extends NsTest{
    @Test
    void 커스텀_구분자_사용_알파벳() {
        String customAlpha = "//o\\n1";
        assertThat(NumericStringInputProcessor.processNumericString(customAlpha)).isEqualTo(1);
    }
    @Test
    void 커스텀_구분자_사용_숫자() {
        String customAlpha = "//3\\n1";
        assertThat(NumericStringInputProcessor.processNumericString(customAlpha)).isEqualTo(1);
    }

    @Test
    void 커스텀_구분자_사용_공백() {
        String customAlpha = "// \\n1";
        assertThat(NumericStringInputProcessor.processNumericString(customAlpha)).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

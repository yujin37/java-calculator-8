package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumericStringValidatorTest extends NsTest {
    @Test
    void 커스텀_구분자_사용_알파벳() {
        String customAlpha = "//o\\n1";
        assertThat(NumericStringValidator.digitsAndSpecial(customAlpha)).isEqualTo(Arrays.asList(1));
    }
    @Test
    void 커스텀_구분자_사용_숫자() {
        String customAlpha = "//3\\n1";
        assertThat(NumericStringValidator.digitsAndSpecial(customAlpha)).isEqualTo(Arrays.asList(1));
    }

    @Test
    void 커스텀_구분자_사용_공백() {
        String customAlpha = "// \\n1";
        assertThat(NumericStringValidator.digitsAndSpecial(customAlpha)).isEqualTo(Arrays.asList(1));
    }
    @Test
    void 예외_테스트_커스텀_소수점() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//3.14\\n13.142"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_커스텀_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1ab2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_커스텀_특정숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//3\\n1332"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

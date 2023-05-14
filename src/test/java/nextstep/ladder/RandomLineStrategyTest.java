package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RandomLineStrategyTest {


    static class RandomFalse extends Random {
        @Override
        public boolean nextBoolean() {
            return false;
        }
    }

    static class RandomTrue extends Random{
        @Override
        public boolean nextBoolean(){
            return true;
        }
    }

    @Test
    @DisplayName("drawLine_테스트")
    public void drawLine_테스트(){

        RandomLineStrategy lineTrue = new RandomLineStrategy(new RandomTrue());
        RandomLineStrategy linefalse = new RandomLineStrategy(new RandomFalse());

        assertThat(lineTrue.drawLine(false)).isTrue();
        assertThat(lineTrue.drawLine(true)).isFalse();
        assertThat(linefalse.drawLine(false)).isFalse();
        assertThat(linefalse.drawLine(true)).isFalse();
    }
}

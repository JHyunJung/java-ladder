package nextstep.ladder;

import nextstep.ladder.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @Test
    @DisplayName("LadderGame_생성_테스트")
    public void LadderGame_생성_테스트() {

        Ladder ladder = new Ladder(5, 5);
        Participant participant = new Participant("test", "test2");
        LadderResult ladderResult = new LadderResult("1", "2");

        assertThat(new LadderGame(ladder, participant, ladderResult))
                .isEqualTo(new LadderGame(ladder, participant, ladderResult));
    }


    static class RandomTrue extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

    @Test
    @DisplayName("LadderGame_play_method_test")
    public void LadderGame_play_method_test() {

        RandomLineStrategy lineTrue = new RandomLineStrategy(new RandomTrue());

        Ladder ladder = new Ladder(2, 3, lineTrue);
        Participant participant = new Participant("test", "test2", "test3");
        LadderResult ladderResult = new LadderResult("1", "2", "3");
        LadderGame ladderGame = new LadderGame(ladder, participant, ladderResult);

        Map<String, String> result = ladderGame.play();

        Assertions.assertThat(result.get("test")).isEqualTo("1");
        Assertions.assertThat(result.get("test2")).isEqualTo("2");
        Assertions.assertThat(result.get("test3")).isEqualTo("3");
    }
}

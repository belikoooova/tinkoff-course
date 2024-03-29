package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProjectTest {
    private static final int INDEX_OF_INCORRECT_WORD = 0;
    private static final int INDEX_OF_CORRECT_WORD = 1;

    @Test
    @DisplayName("Test with incorrect word")
    void runWithIncorrectString() {
        // given
        String[] input = new String[] {"yes"};
        UnitTestGame game = new UnitTestGame(INDEX_OF_INCORRECT_WORD, input);
        ArrayList<String> expectedStrings = new ArrayList<>();
        expectedStrings.add(HumanReadableMessage.HELLO.toString());
        expectedStrings.add(HumanReadableMessage.INCORRECT_LENGTH_OF_WORD.toString());
        expectedStrings.add(HumanReadableMessage.EXIT.toString());

        // when
        game.run();
        var actualStrings = game.getReceivedString();

        // then
        boolean result = true;
        for (int i = 0; i < expectedStrings.size(); ++i) {
            result &= expectedStrings.get(i).equals(actualStrings.get(i));
        }
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Win with correct string")
    void winWithCorrectString() {
        // given
        String[] input = new String[] {"H", "no", "P", "no", "p", "no", "L", "no", "o", "no", "e", "yes"};
        UnitTestGame game = new UnitTestGame(INDEX_OF_CORRECT_WORD, input);
        ArrayList<String> expectedStrings = new ArrayList<>();
        expectedStrings.add(HumanReadableMessage.HELLO.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_GUESSED.toString());
        expectedStrings.add("The word: h****");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_NOT_GUESSED.toString());
        expectedStrings.add("Mistakes 1 of 5");
        expectedStrings.add("The word: h****");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_ALREADY_HAS_BEEN_WRITTEN.toString());
        expectedStrings.add("The word: h****");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_GUESSED.toString());
        expectedStrings.add("The word: h*ll*");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_GUESSED.toString());
        expectedStrings.add("The word: h*llo");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_GUESSED.toString());
        expectedStrings.add("The word: hello");
        expectedStrings.add(HumanReadableMessage.WIN.toString());
        expectedStrings.add(HumanReadableMessage.EXIT.toString());

        // when
        game.run();
        var actualStrings = game.getReceivedString();

        // then
        boolean result = true;
        for (int i = 0; i < expectedStrings.size(); ++i) {
            result &= expectedStrings.get(i).equals(actualStrings.get(i));
        }
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Lose with correct word")
    void loseWithCorrectString() {
        // given
        String[] input = new String[] {"H", "no", "P", "no", "q", "no", "w", "no", "r", "no", "f", "yes"};
        UnitTestGame game = new UnitTestGame(INDEX_OF_CORRECT_WORD, input);
        ArrayList<String> expectedStrings = new ArrayList<>();
        expectedStrings.add(HumanReadableMessage.HELLO.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_GUESSED.toString());
        expectedStrings.add("The word: h****");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        for (int i = 0; i < 4; ++i) {
            expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
            expectedStrings.add(HumanReadableMessage.LETTER_IS_NOT_GUESSED.toString());
            expectedStrings.add(String.format("Mistakes %d of 5", i + 1));
            expectedStrings.add("The word: h****");
            expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        }
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_NOT_GUESSED.toString());
        expectedStrings.add("Mistakes 5 of 5");
        expectedStrings.add("The word: h****");
        expectedStrings.add(HumanReadableMessage.LOSE.toString());
        expectedStrings.add(HumanReadableMessage.EXIT.toString());

        // when
        game.run();
        var actualStrings = game.getReceivedString();

        // then
        boolean result = true;
        for (int i = 0; i < expectedStrings.size(); ++i) {
            result &= expectedStrings.get(i).equals(actualStrings.get(i));
        }
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Exit with correct word")
    void exitWithCorrectString() {
        // given
        String[] input = new String[] {"H", "yes", "yes"};
        UnitTestGame game = new UnitTestGame(INDEX_OF_CORRECT_WORD, input);
        ArrayList<String> expectedStrings = new ArrayList<>();
        expectedStrings.add(HumanReadableMessage.HELLO.toString());
        expectedStrings.add(HumanReadableMessage.GUESS_LETTER.toString());
        expectedStrings.add(HumanReadableMessage.LETTER_IS_GUESSED.toString());
        expectedStrings.add("The word: h****");
        expectedStrings.add(HumanReadableMessage.GIVE_UP.toString());
        expectedStrings.add(HumanReadableMessage.EXIT.toString());

        // when
        game.run();
        var actualStrings = game.getReceivedString();

        // then
        boolean result = true;
        for (int i = 0; i < expectedStrings.size(); ++i) {
            result &= expectedStrings.get(i).equals(actualStrings.get(i));
        }
        assertThat(result).isTrue();
    }
}

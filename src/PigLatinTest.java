import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.InputMismatchException;

public class PigLatinTest {

	@Test
	public void testTranslateSentence() {
		String sentence = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";

		//return String.join(" ", words);
		String translation = PigLatin.translateSentence(sentence);
		String truth = PigLatin.translateWord("Lorem") + " " +
				PigLatin.translateWord("ipsum") + " " +
				PigLatin.translateWord("dolor") + " " +
				PigLatin.translateWord("sit") + " " +
				PigLatin.translateWord("amet") + ", " +
				PigLatin.translateWord("consectetuer") + " " +
				PigLatin.translateWord("adipiscing") + " " +
				PigLatin.translateWord("elit") + ".";
		assertEquals(translation, truth);
	}

	@Test
	public void testTranslateWord() {

		String[] english_words = new String[]{"pig", "Latin", "cheers", "smile", "eat", "omelet"};
		String[] piglatin_words = new String[]{"igpay", "Atinlay", "eerschay", "ilesmay", "eatway", "omeletway"};

		for (int i = 0; i < english_words.length; ++i) {
			String piglatin_word = PigLatin.translateWord(english_words[i]);
			assertEquals(piglatin_words[i], piglatin_word);
		}
	}

@Test
	public void testChoice() {

		String choice1 = "1";
		String testPrint1 = "Please enter the sentence you want to translate: ";
		String printVariable1 = PigLatin.executeChoice(choice1);
		assertEquals(testPrint1, printVariable1);


		String choice2 = "2";
		String testPrint2 = "Translate the following word into piglatin: ";
		String printVariable2 = PigLatin.executeChoice(choice2);
		assertEquals(testPrint2, printVariable2);


		String choice3 = "1+2";
		String testPrint3 = "Not a valid choice!";
		String printVariable3 = PigLatin.executeChoice(choice3);
		assertEquals(testPrint3, printVariable3);
		}

	@Test
	public void testpracticeMode() {

		String randomWord="pig";
		String pigLatinAnswer="pig";

		String practiceResult=PigLatin.verifyAnswer(pigLatinAnswer,randomWord);
		assertEquals(practiceResult,"Wrong! You guessed: pig Correct answer: igpay");

		randomWord="pig";
		pigLatinAnswer="igpay";

		practiceResult=PigLatin.verifyAnswer(pigLatinAnswer,randomWord);
		assertEquals(practiceResult,"Correct!");
    }

	@Test(expected = InputMismatchException.class)
	public void testInputVerificationFails() {
		// Test the translation of single words
		PigLatin.translateWord("a,");
		PigLatin.translateWord("a.");
		PigLatin.translateWord("a/");
		PigLatin.translateWord("a ");
		PigLatin.translateWord("a'");
		PigLatin.translateWord("a-");
		PigLatin.translateWord("a_");

		// Test the translation of sentences
		PigLatin.translateSentence("a/");
		PigLatin.translateSentence("a'");
		PigLatin.translateSentence("a-");
		PigLatin.translateSentence("a_");
		PigLatin.translateSentence("a#");
		PigLatin.translateSentence("a^");
		PigLatin.translateSentence("a");
	}
}

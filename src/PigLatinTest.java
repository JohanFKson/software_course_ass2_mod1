import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
public class PigLatinTest {

	@Test
	public void testTranslateSentence() {
		PigLatin t = new PigLatin();

		String sentence = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";

		//return String.join(" ", words);
		String translation = t.translateSentence(sentence);
		String truth = t.translateWord("Lorem") + " " +
				t.translateWord("ipsum") + " " +
				t.translateWord("dolor") + " " +
				t.translateWord("sit") + " " +
				t.translateWord("amet") + ", " +
				t.translateWord("consectetuer") + " " +
				t.translateWord("adipiscing") + " " +
				t.translateWord("elit") + ".";
		assertEquals(translation, truth);
	}

	@Test
	public void testTranslateWord() {
		PigLatin t = new PigLatin();

		String[] english_words = new String[]{"pig", "Latin", "cheers", "smile", "eat", "omelet"};
		String[] piglatin_words = new String[]{"igpay", "Atinlay", "eerschay", "ilesmay", "eatway", "omeletway"};

		for (int i = 0; i < english_words.length; ++i) {
			String piglatin_word = t.translateWord(english_words[i]);
			assertEquals(piglatin_words[i], piglatin_word);
		}
	}

@Test
	public void testChoice() {
		PigLatin t = new PigLatin();

		String choice1 = "1";
		String testPrint1 = "Please enter the sentence you want to translate: ";
		String printVariable1 = t.executeChoice(choice1);
		assertEquals(testPrint1, printVariable1);


		String choice2 = "2";
		String testPrint2 = "Translate the following word into piglatin: ";
		String printVariable2 = t.executeChoice(choice2);
		assertEquals(testPrint2, printVariable2);


		String choice3 = "1+2";
		String testPrint3 = "Not a valid choice!";
		String printVariable3 = t.executeChoice(choice3);
		assertEquals(testPrint3, printVariable3);
		}

@Test
   public void testpracticeMode() {
	PigLatin t = new PigLatin();

	String randomWord="pig";
	String pigLatinAnswer="pig";

	String practiceResult=t.verifyAnswer(pigLatinAnswer,randomWord);
	assertEquals(practiceResult,"Wrong! You guessed: pig Correct answer: igpay");

	randomWord="pig";
	pigLatinAnswer="igpay";

	practiceResult=t.verifyAnswer(pigLatinAnswer,randomWord);
	assertEquals(practiceResult,"Correct!");
    }
}
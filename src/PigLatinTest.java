import static org.junit.Assert.assertEquals;
import org.junit.Test;

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

		for(int i = 0; i < english_words.length; ++i) {
			String piglatin_word = t.translateWord(english_words[i]);
			assertEquals(piglatin_words[i], piglatin_word);
		}	

	}
}
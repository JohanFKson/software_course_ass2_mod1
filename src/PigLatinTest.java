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
}
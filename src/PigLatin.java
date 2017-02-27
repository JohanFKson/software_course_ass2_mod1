public class PigLatin {

	public static String translate(String word) {
		return "test";
	}

	public static String translateWord(String word) {
		return "test2";
	}

	public static String translateSentence(String sentence) {
		return "test2";
	}

	public static void main(String[] args) {
		System.out.print("Please enter the word you want to translate: ");
		String word = "test"; // System.console().readLine();
		String translation = translate(word);
		System.out.println("Translation: " + translation);
	}
}	
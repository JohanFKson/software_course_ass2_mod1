import java.util.regex.*;
public class PigLatin {

	public static String translateWord(String word) {
		return word+"test";
	}

	public static String translateSentence(String sentence) {

		PigLatin translator = new PigLatin();
		String translation = "";

		String regex = "([a-zA-Z]*)([^a-zA-Z]*)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);


        String word, separator;
        while(matcher.find()) {
        	word = matcher.group(1);
        	separator = matcher.group(2);
        	if (word.length() > 0)
        		translation += translator.translateWord(word);
        	translation += separator;
        }

		return translation;
	}

	public static void main(String[] args) {
		System.out.print("Please enter the sentence you want to translate: ");
		String sentence = System.console().readLine();
		String translation = translateSentence(sentence);
		System.out.println("Translation: " + translation);
	}
}	
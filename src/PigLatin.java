import java.util.regex.*;
import java.util.regex.*;
public class PigLatin {

	public static String translateWord(String english_word) {
		Pattern pattern = Pattern.compile("^([^aeiouAEIOU]*)([aeiouAEIOU]*\\w*)$");
		Matcher matcher = pattern.matcher(english_word);

		matcher.find();
		String piglatin_word;

		if(matcher.group(1).length() > 0) {
			piglatin_word = matcher.group(2) + matcher.group(1) + "ay";
		} else {
			piglatin_word = matcher.group(0) + "way";
		}

		if(english_word.substring(0, 1).equals(english_word.substring(0, 1).toUpperCase())) {
			piglatin_word = piglatin_word.substring(0, 1).toUpperCase() + piglatin_word.substring(1).toLowerCase();
		}

		return piglatin_word;
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
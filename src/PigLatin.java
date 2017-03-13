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

	public static String executeChoice(String choice){
		String printVariable;

		if (choice.equals("1")) {
			printVariable=("Please enter the sentence you want to translate: ");

		}
		else if (choice.equals("2")) {
			printVariable="A word will be generated at random";
		}
		else {
			printVariable="Not a valid choice. The program will terminate.";
		}

		return printVariable;
	}



	public static void main(String[] args) {
		System.out.println("Now, make your choice:\n Translate (type 1)\n Practice (press 2)");
		String choice=System.console().readLine();

		String printVariable=executeChoice(choice);

		System.out.println(printVariable);
		if (choice.equals("1")) {
			String sentence = System.console().readLine();
			String translation = translateSentence(sentence);
			printVariable = ("Translation: " + translation);
			System.out.println(printVariable);
		}



	}
}	
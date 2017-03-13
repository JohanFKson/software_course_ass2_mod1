import java.util.regex.*;
import java.util.regex.*;
import java.util.Random;
import java.io.*;
public class PigLatin {
	private static Boolean verifyWord(String word) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
		Matcher matcher = pattern.matcher(word);
		return matcher.matches();
	}

	private static Boolean verifySentence(String sentence) {
		Pattern pattern = Pattern.compile("^[a-zA-Z,. ]*$");
		Matcher matcher = pattern.matcher(sentence);
		return matcher.matches();
	}

	public static String executeChoice(String choice){
		String printVariable;

		if (choice.equals("1")) {
			printVariable=("Please enter the sentence you want to translate: ");
		}
		else if (choice.equals("2")) {
			printVariable="Translate the following word into piglatin: ";
		}
		else {
			printVariable="Not a valid choice!";
		}
		return printVariable;
	}

	public static String translateWord(String english_word) {
		if(!verifyWord(english_word))
			throw new java.util.InputMismatchException("The words can only include a-z. Failure on: `"+english_word+"`");

		Pattern pattern = Pattern.compile("^([^aeiouAEIOU]*)([aeiouAEIOU]*\\w*)$");
		Matcher matcher = pattern.matcher(english_word);

		matcher.find();
		String piglatin_word;

		if(matcher.group(1).length() > 0) {
			piglatin_word = matcher.group(2) + matcher.group(1) + "ay";
		} else
			piglatin_word = matcher.group(0) + "way";


		if(english_word.substring(0, 1).equals(english_word.substring(0, 1).toUpperCase())) {
			piglatin_word = piglatin_word.substring(0, 1).toUpperCase() + piglatin_word.substring(1).toLowerCase();
		}

		return piglatin_word;
	}

	public static String translateSentence(String sentence) {
		if(!verifySentence(sentence))
			throw new java.util.InputMismatchException("The software only handles inputs with a-z and sword separators ` `, `,` and `.`.\nFailure on: `"+sentence+"`");

		String translation = "";

		String regex = "([a-zA-Z]*)([^a-zA-Z]*)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        String word, separator;
        while(matcher.find()) {
        	word = matcher.group(1);
        	separator = matcher.group(2);
        	if (word.length() > 0)
        		translation += PigLatin.translateWord(word);
        	translation += separator;
        }

		return translation;
	}

	public static String dictionary() {
		Random rand=new Random();
		String[] dictionary= {"pig", "Latin", "banana","trash","happy","duck","glove","dopest","me","too","thanks","will","moist","wet","cheers","shesh","smile","eat","omelet","are","egg"};

		int n=rand.nextInt(dictionary.length);
		String randomword=dictionary[n];
		return randomword;
	}
	public static String practiceMode() {

		String randomWord=dictionary();
		System.out.println(randomWord);
		String pigLatinGuess=System.console().readLine();

		String practiceResult=verifyAnswer(pigLatinGuess,randomWord);

		return practiceResult;
	}

	public static String verifyAnswer(String pigLatinGuess, String randomWord){

		if(!verifyWord(randomWord))
			throw new java.util.InputMismatchException("The words can only include a-z. Failure on: `"+randomWord+"`");

		String practiceResult;
		String pigLatinAnswer=translateWord(randomWord);

		if (pigLatinGuess.equals(pigLatinAnswer)) {
			practiceResult=("Correct!");
		}
		else
			practiceResult=("Wrong!" + " You guessed: " + pigLatinGuess + " Correct answer: " + pigLatinAnswer);

		return practiceResult;

	}


	public static void main(String[] args) {
		String result;

		System.out.println("Now, make your choice:\n Translate (type 1)\n Practice (press 2)");
		String choice=System.console().readLine();
		String printVariable=executeChoice(choice);

		if (choice.equals("1")) {
			System.out.println(printVariable);
			String sentence = System.console().readLine();
			String translation = translateSentence(sentence);
			result=("Translation: " + translation);
		}
		else if (choice.equals("2")) {
			System.out.println(printVariable);
			result=practiceMode();
		}
		else {
			System.out.println(printVariable);
			result = "Terminating program!";
		}

		System.out.println(result);
	}
}

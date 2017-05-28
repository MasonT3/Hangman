
public class hangmanRun {

	public static void main(String[] args){
		HangmanLogic hangman = new HangmanLogic("word");
		
		
		hangman.drawBoard();
		hangman.printHiddenWord();
		hangman.printAmountOfFaults();
		hangman.printGuessedLetters();
		hangman.guessLetter("A");

	}
}

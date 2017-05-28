
import java.util.ArrayList;

public class HangmanLogic {
	private String word;//word they guess for
	private int successfulGuesses;
	private String guess;//their guess
	private int amountOfFaults = 0;//how many times they have guessed incorrectly
	ArrayList<String> guesses = new ArrayList<String>();//list of guesses
	StringBuilder progress = new StringBuilder();
	
	public HangmanLogic(String wordToGuess){
		
		this.word = wordToGuess.toUpperCase();
		for (int i = 0; i < this.word.length(); i++){
			this.progress.append("_");
		}
	}
	
	//draws the board
	public void drawBoard(){
		
		if (this.amountOfFaults == 0){
		System.out.println("     ----");
		System.out.print("     |");
		System.out.println("  |");
		System.out.println("        |");
		System.out.println("        |");
		System.out.println("        |");
		System.out.println("    -----");
		}
		
		if (this.amountOfFaults == 1){
			System.out.println("     ----");
			System.out.print("     |");
			System.out.println("  |");
			System.out.print("     O"); //head
			System.out.println("  |");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("    -----");
		}
		if (this.amountOfFaults == 2){
			System.out.println("     ----");
			System.out.print("     |");
			System.out.println("  |");
			System.out.print("     O"); // head
			System.out.println("  |");
			System.out.print("     |"); // body
			System.out.println("  |");
			System.out.println("        |");
			System.out.println("    -----");
		}
		if (this.amountOfFaults == 3){
			System.out.println("     ----");
			System.out.print("     |");
			System.out.println("  |");
			System.out.print("     O"); // head
			System.out.println("  |");
			System.out.print("     |"); //body
			System.out.println("  |");
			System.out.print("    /");//left leg
			System.out.println("   |");
			System.out.println("    -----");
		}
		if (this.amountOfFaults == 4){
			System.out.println("     ----");
			System.out.print("     |");
			System.out.println("  |");
			System.out.print("     O"); // head
			System.out.println("  |");
			System.out.print("     |"); //body
			System.out.println("  |");
			System.out.print("    /");//left leg
			System.out.print(" \\"); //right leg
			System.out.println(" |");
			System.out.println("    -----");
		}
		if (this.amountOfFaults == 5){
			System.out.println("     ----");
			System.out.print("     |");
			System.out.println("  |");
			System.out.print("     O"); // head
			System.out.println("  |");
			System.out.print("     |"); //body
			System.out.print("--");//right arm
			System.out.println("|");
			System.out.print("    /");//left leg
			System.out.print(" \\");//right leg
			System.out.println(" |");
			System.out.println("    -----");
		}
		if (this.amountOfFaults == 6){
			System.out.println("     ----");
			System.out.print("     |");
			System.out.println("  |");
			System.out.print("     O"); // head
			System.out.println("  |");
			System.out.print("   --");//left arm
			System.out.print("|"); //body
			System.out.print("--");//right arm
			System.out.println("|");
			System.out.print("    /");//left leg
			System.out.print(" \\");//right leg
			System.out.println(" |");
			System.out.println("    -----");
		}
	}
	
	//gets guess and sees if it fits in word
	public void guessLetter(String letter){
		this.guess = letter;
		this.guess.toUpperCase();
		if (this.word.contains(letter)){
			this.successfulGuesses++;
			drawBoard();
			updateProgress();
			printAmountOfFaults();
			printGuessedLetters();
			checkGameState();
			
		} else {
			addGuess();
			//updateGuesses();
			drawBoard();
			printAmountOfFaults();
			printGuessedLetters();
			updateProgress();
			checkGameState();
		}
		
	}
	public void addGuess(){
		if (!this.guesses.contains(this.guess)){
			this.guesses.add(this.guess);
			this.amountOfFaults++;
		}
	}
	
	//prints the amount of characters in underscores
	public void printHiddenWord(){
		int i = 0;
		System.out.print("  ");
		while (i < this.word.length()){
			System.out.print(" _");
			i++;
		}
		System.out.println("");
		System.out.println("");
	}
	//prints of amount of faults
	public void printAmountOfFaults(){
		System.out.println("");
		System.out.println("# of Faults: "+ this.amountOfFaults);
	}
	//prints letters already guessed
	public void printGuessedLetters(){
		System.out.println("Guessed:" + this.guesses);
	}
	
	//Fill in blanks with correct guesses
	public void updateProgress(){
		int guessIndex = this.word.indexOf(this.guess);
		char guess = this.guess.charAt(0);
		
		try {
		this.progress.setCharAt(guessIndex, guess);
		}
		catch(IndexOutOfBoundsException e) {
		}
		System.out.println(this.progress);
		
		}

	//checks to see if game is finished
	public void checkGameState(){
		if (this.amountOfFaults == 6){
			System.out.println("Game Over! Better luck next time!");
		}else if (this.guesses.size() > 26){
			System.out.println("Game Over! Better luck next time!");
		}else if (this.successfulGuesses == this.word.length()){
			System.out.println("Congratulations! You won!");
		}
	}
}
	



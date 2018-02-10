
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		//Welcome messages + directions before game starts
		System.out.println("              "
				+ "|  Welcome to 2048-terminalversion,  |");
		System.out.println("              "
				+ "|     recreated by Jaime Lovera      |");
		System.out.println("---------------------------------"
				+ "-------------------------");
		System.out.println("                     ~~HOW-TO~~");
		System.out.println(" |->  w : UP-----------\\");
		System.out.println(" |->  a : LEFT          \\ Each "
				+ "key press followed"
				+ " by 'ENTER'");
		System.out.println(" |->  s : DOWN          /");
		System.out.println(" |->  d : RIGHT--------/");
		System.out.println("To reset game type 'reset'");
		System.out.println("----------------------------"
				+ "------------------------------");
		System.out.println("\n");
		System.out.println("           BEGIN!");
		Board game2048 = new Board();
		int keepGameRunning = 0;
		String input;
		game2048.newTile();
		game2048.newTile();
		game2048.printBoard();

		do {
			Scanner in = new Scanner(System.in);
			input = in.nextLine();
			//moves the board and prints new board, depending
			//on the direction given by the user using wasd keys
			if ("w".equalsIgnoreCase(input)) {
				game2048.move("Up","On");
				//skips 35 lines to make terminal look less 
				//messy while playing.
				for (int i=1; i<=35; i++){
				    System.out.println("\n");
				}
				game2048.printBoard();
			} else if ("s".equalsIgnoreCase(input)) {
				game2048.move("Down","On");
				//skips 35 lines to make terminal look less 
				//messy while playing.
				for (int i=1; i<=35; i++){
				    System.out.println("\n");
				}
				game2048.printBoard();
			} else if ("d".equalsIgnoreCase(input)) {
				game2048.move("Right","On");
				//skips 35 lines to make terminal look less 
				//messy while playing.
				for (int i=1; i<=35; i++){
				    System.out.println("\n");
				}
				game2048.printBoard();
			} else if ("a".equalsIgnoreCase(input)) {
				game2048.move("Left","On");
				//skips 35 lines to make terminal look less 
				//messy while playing.
				for (int i=1; i<=35; i++){
				    System.out.println("\n");
				}
				game2048.printBoard();
			} else if ("reset".equalsIgnoreCase(input)) {
				game2048.reset();
				game2048.newTile();
				game2048.newTile();
				//skips 35 lines to make terminal look less 
				//messy while playing.
				for (int i=1; i<=35; i++){
				    System.out.println("\n");
				}
				System.out.println("       New game started!");
				System.out.println("-----------------------------");
				game2048.printBoard();
			} else { //this gets printed if user inputs something not listed
				     //in instructions.
				//skips 35 lines to make terminal look less 
				//messy while playing.
				for (int i=1; i<=35; i++){
				    System.out.println("\n");
				}
				game2048.printBoard();
				System.out.println("-----------------------"
						+ "-------------------");
				System.out.println("       INPUT NOT RECOGNIZED");
				System.out.println("Please enter a direction using the");
				System.out.println("following keys followed "
						+ "by the enter key:");
				System.out.println("W-up, A-left, S-down, D-right.");
				System.out.println("In addition, to reset "
						+ "game type 'reset'");
	
				
			}
			game2048.gameFinished();
		} while (keepGameRunning==0); //keeps looping asking for new input
		                              //while the game hasnt been won or
		                              //lost. once won or lost it prints 
		                              //accordingly, and suggest user to
		                              //reset game.
	}

}
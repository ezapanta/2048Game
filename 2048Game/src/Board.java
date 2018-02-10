import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {
	//class variables.
	private static int[][] grid = new int[4][4];
	boolean tilesChanged = false;
	int[] originalLine1= new int[4];
	int[] originalLine2= new int[4];
	int[] originalLine3= new int[4];
	int[] originalLine4= new int[4];
	int[] reversedML1= new int[4];
	int[] reversedML2= new int[4];
	int[] reversedML3= new int[4];
	int[] reversedML4= new int[4];

	//creates 4x4 board with all zeros.
	public int[][] board(){
		return grid;
	}
	//returns value at specified location on board.
	public int getTile(int row, int col) {
		return grid[row][col];
	}
	//sets a tile at specified location to specified value
	public void setTile(int row, int col, int value) {
		grid[row][col] = value;
	}
	//generates a new tile of value 2 at random empty location
	public void newTile() {
		ArrayList<int[]> emptyTileList = new ArrayList<int[]>();
		// Get the index of empty tiles
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (getTile(i, j) == 0) {
					int[] emptyIndex = {i, j};
					emptyTileList.add(emptyIndex);
				}
			}
		}
		// Set one tile from empty list and set value to 2.
		if (emptyTileList.size() > 0) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(emptyTileList.size());
			int[] emptyTileIndex = emptyTileList.get(randomIndex);
			setTile(emptyTileIndex[0], emptyTileIndex[1],2);
		}
	}	
	//prints the current values of the board to the terminal
	public void printBoard(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(grid[i][j] + "        ");
			}
			//skip to next line
			System.out.println(); 
		}
	}
	//resets the board to an empty board and places two random tiles.
	public void reset() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				setTile(i, j, 0);
			}
		}
	}

	//method to merge lines, according to the direction moved
	public int[] merge(int[] line, String direction) {
		int[] resultLine = new int[4];
		int resultIndex = 0;
		boolean lastTileMerged = false;
		int lastTileAdded = 0;

		//shift blocks over. If 2 tiles are equal they merge. But only the first pair.
		//when it is merged multiply by 2.
		//merges LEFT or UP
		if(direction == "Left" || direction == "Up"){
			for (int i = 0; i < 4; i++) {
				int currentTile = line[i];
				if (currentTile > 0) {
					if ((currentTile == lastTileAdded) && !lastTileMerged) {
						resultLine[resultIndex  - 1] = currentTile * 2;
						lastTileAdded = currentTile * 2;
						lastTileMerged = true; 
					} else {
						resultLine[resultIndex] = currentTile;
						lastTileAdded = currentTile;
						lastTileMerged = false;
						resultIndex ++;
					}
				}
			}
		}
		//merges RIGHT or DOWN
		else if (direction == "Right" || direction == "Down") {
			for (int i = 3; i >= 0; i--) {
				int currentTile = line[i];
				if (currentTile > 0) {
					//then merge
					if ((currentTile == lastTileAdded) && !lastTileMerged) {
						resultLine[resultIndex  - 1] = currentTile * 2;
						lastTileAdded = currentTile * 2;
						lastTileMerged = true; 
					} else {
						//or else don't merge
						resultLine[resultIndex] = currentTile;
						lastTileAdded = currentTile;
						lastTileMerged = false;
						resultIndex ++;
					}
				}
			}
		}
		return resultLine;
	}



	//Determine whether game is finished or not
	public boolean gameFinished() {
		// If 2048 is achieved
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (grid[i][j] == 2048) {
					System.out.println("----------------------------------");
					System.out.println("           You win!!");
					System.out.println("  To start new game type 'reset'");
					return true;
				}
			}
		}

		//for each row and column see if there are repeated values.
		//goes through each row.
		for (int i = 0; i < 4; i++) {
			int prevTile = grid[i][0];
			for (int j = 1; j < 4; j++) {
				if (grid[i][j] == prevTile || grid[i][j] == 0
						//added the ==0 here so that if there is still a
						//zero on the board the game continues.
						|| prevTile == 0) {
					return false;
				}
				prevTile = grid[i][j];
			}
		}
		//goes through each column
		for (int i = 0; i < 4; i++) {
			int prevTile = grid[0][i];
			for (int j = 1; j < 4; j++) {
				if (grid[j][i] == prevTile || grid[j][i] == 0
						//added the ==0 here so that if there is still a
						//zero on the board the game continues.
						|| prevTile == 0) {
					return false;
				}
				prevTile = grid[j][i];
			}
		}
		System.out.println("----------------------------------");
		System.out.println("          Game Over!!");
		System.out.println("  To start new game type 'reset'");
		return true;
	}

	//moves all tiles in the given direction and adds a new random tile 
	//if any tiles are moved.
	public void move(String direction, String newTileOnOff) {

		//copy original line to a array.
		if(direction == "Up"){
			for(int i = 0; i < 4; i++){
				originalLine1[i] = grid[i][0];
			}
			for(int i = 0; i < 4; i++){
				originalLine2[i] = grid[i][1];
			}
			for(int i = 0; i < 4; i++){
				originalLine3[i] = grid[i][2];
			}
			for(int i = 0; i < 4; i++){
				originalLine4[i] = grid[i][3];
			}
		}
		if(direction == "Down"){
			for(int i = 0; i < 4; i++){
				originalLine1[i] = grid[i][0];
			}
			for(int i = 0; i < 4; i++){
				originalLine2[i] = grid[i][1];
			}
			for(int i = 0; i < 4; i++){
				originalLine3[i] = grid[i][2];
			}
			for(int i = 0; i < 4; i++){
				originalLine4[i] = grid[i][3];
			}
		}
		if(direction == "Right"){
			for(int i = 0; i < 4; i++){
				originalLine1[i] = grid[0][i];
			}
			for(int i = 0; i < 4; i++){
				originalLine2[i] = grid[1][i];
			}
			for(int i = 0; i < 4; i++){
				originalLine3[i] = grid[2][i];
			}
			for(int i = 0; i < 4; i++){
				originalLine4[i] = grid[3][i];
			}
		}
		if(direction == "Left"){
			for(int i = 0; i < 4; i++){
				originalLine1[i] = grid[0][i];
			}
			for(int i = 0; i < 4; i++){
				originalLine2[i] = grid[1][i];
			}
			for(int i = 0; i < 4; i++){
				originalLine3[i] = grid[2][i];
			}
			for(int i = 0; i < 4; i++){
				originalLine4[i] = grid[3][i];
			}
		}

		// Create new merged line of original line and put it in an array.
		int[] mergedLine1 = merge(originalLine1,direction);
		int[] mergedLine2 = merge(originalLine2,direction);
		int[] mergedLine3 = merge(originalLine3,direction);
		int[] mergedLine4 = merge(originalLine4,direction);

		//changed mergedlines for RIGHT or DOWN to their reverse order since they get
		//reversed in the proccess of merging, and in order to compare
		//this merged line to the original line to look for a change
		//it must be changed back to normal.
		if(direction == "Right" || direction == "Down"){
			int end=3;
			for(int i =0; i<4; i++){
				reversedML1[i]=mergedLine1[end];
				reversedML2[i]=mergedLine2[end];
				reversedML3[i]=mergedLine3[end];
				reversedML4[i]=mergedLine4[end];
				end--;

			}
			//check to see if list changed (when direction was right/down)
			if(Arrays.equals(originalLine1, reversedML1)
					&& Arrays.equals(originalLine2, reversedML2)
					&& Arrays.equals(originalLine3, reversedML3)
					&& Arrays.equals(originalLine4, reversedML4)){
				tilesChanged = false;
			}

			else {
				tilesChanged = true;
			}
		}
		//check to see if list changed (when direction was left/up)
		if(direction == "Left" || direction == "Up"){
			if (Arrays.equals(originalLine1, mergedLine1)
					&& Arrays.equals(originalLine2, mergedLine2)
					&& Arrays.equals(originalLine3, mergedLine3)
					&& Arrays.equals(originalLine4, mergedLine4)) {
				tilesChanged = false;
			}
			else {
				tilesChanged = true;
			}
		}

		//modify board line to show new values
		for (int i = 0; i < 4; i++) {
			if(direction == "Up"){
				setTile(i,0,mergedLine1[i]);
				setTile(i,1,mergedLine2[i]);
				setTile(i,2,mergedLine3[i]);
				setTile(i,3,mergedLine4[i]);
			}
			if(direction == "Down"){
				setTile(i,0,reversedML1[i]);
				setTile(i,1,reversedML2[i]);
				setTile(i,2,reversedML3[i]);
				setTile(i,3,reversedML4[i]);
			}
			if(direction == "Right"){
				setTile(0,i,reversedML1[i]);
				setTile(1,i,reversedML2[i]);
				setTile(2,i,reversedML3[i]);
				setTile(3,i,reversedML4[i]);
			}
			if(direction == "Left"){
				setTile(0,i,mergedLine1[i]);
				setTile(1,i,mergedLine2[i]);
				setTile(2,i,mergedLine3[i]);
				setTile(3,i,mergedLine4[i]);
			}
		}
		if ( tilesChanged==true && newTileOnOff == "On") {
			newTile();
		}
	}
}
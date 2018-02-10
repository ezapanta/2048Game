import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class GameTester {
	//I Tested my move method, and in order to to that i used two other methods
	//setTile() and getTile() so I also made a test for those.
	//so 3 tests in total.
	
	//my move method implements the new random tile method. I cant test it 
	//and compare it to a original board since the move method added
	//a random tile so the test would always fail.
	//to FIX this i added an extra parameter to tell the method either to
	//add the random tile after every move or to not, basically
	// a on/off switch. this allows to test my method with junit testing.
	@Test
	public void testGetTile(){
		int value1 = 10;
		int value2 = 5;
		Board setTileBoard = new Board();
		setTileBoard.setTile(0,0,10);
		setTileBoard.setTile(3,2,5);
		int setTileValue1 =setTileBoard.getTile(0,0);
		int setTileValue2 =setTileBoard.getTile(3,2);
		assertEquals(value1,setTileValue1);
		assertEquals(value2,setTileValue2);


	}

	@Test
	public void testSetTile(){
		//making a normal 2d array with elements that will
		//be compared to new array using setTile method in Board class.
		int[][] originalBoard = new int[4][4];
		originalBoard[0][0]= 0;
		originalBoard[0][1]= 0;
		originalBoard[0][2]= 2;
		originalBoard[0][3]= 0;
		originalBoard[1][0]= 0;
		originalBoard[1][1]= 2;
		originalBoard[1][2]= 2;
		originalBoard[1][3]= 0;
		originalBoard[2][0]= 4;
		originalBoard[2][1]= 4;
		originalBoard[2][2]= 8;
		originalBoard[2][3]= 0;
		originalBoard[3][0]= 0;
		originalBoard[3][1]= 0;
		originalBoard[3][2]= 2;
		originalBoard[3][3]= 2;
		
		//values of original in rows to easily compare
		int[] row0 = originalBoard[0];
		int[] row1 = originalBoard[1];
		int[] row2 = originalBoard[2];
		int[] row3 = originalBoard[3];

		Board setTileBoard = new Board();
		setTileBoard.setTile(0,0,0);
		setTileBoard.setTile(0,1,0);
		setTileBoard.setTile(0,2,2);
		setTileBoard.setTile(0,3,0);
		setTileBoard.setTile(1,0,0);
		setTileBoard.setTile(1,1,2);
		setTileBoard.setTile(1,2,2);
		setTileBoard.setTile(1,3,0);
		setTileBoard.setTile(2,0,4);
		setTileBoard.setTile(2,1,4);
		setTileBoard.setTile(2,2,8);
		setTileBoard.setTile(2,3,0);
		setTileBoard.setTile(3,0,0);
		setTileBoard.setTile(3,1,0);
		setTileBoard.setTile(3,2,2);
		setTileBoard.setTile(3,3,2);
		
		//values of board using setTile to original values in rows,
		//to easily compare
		int[] newRow0 = new int[4];
		int[] newRow1 = new int[4];
		int[] newRow2 = new int[4];
		int[] newRow3 = new int[4];
		for(int i=0; i<4; i++){
			newRow0[i] = setTileBoard.getTile(0, i);
			newRow1[i] = setTileBoard.getTile(1, i);
			newRow2[i] = setTileBoard.getTile(2, i);
			newRow3[i] = setTileBoard.getTile(3, i);
		}
		//test if they are equal
		assertArrayEquals(row0, newRow0);
		assertArrayEquals(row1, newRow1);
		assertArrayEquals(row2, newRow2);
		assertArrayEquals(row3, newRow3);
	}

	@Test
	public void testMove() {
		int[][] expectedValues = new int[4][4];
		Board originalBoard = new Board();
		int [][] originalValues = new int[4][4];
		String[] directionList = new String[]{"Up","Down","Left","Right"};

		//THIS PART CHECKS THE FIRST ORIGINAL BOARD. SECOND IS CHECKED BELOW
		//using this for loop so it loops through using all 4 directions.
		//variable 'i' is used as elements in string array above directionList.
		for(int i=0; i<4; i++){
			//I put this up here so that in every new loop the Board is set
			//back to the original values since they change once I use the 
			//move method on the board
			originalBoard.setTile(0,0,0);
			originalBoard.setTile(0,1,0);
			originalBoard.setTile(0,2,2);
			originalBoard.setTile(0,3,0);
			originalBoard.setTile(1,0,0);
			originalBoard.setTile(1,1,2);
			originalBoard.setTile(1,2,2);
			originalBoard.setTile(1,3,0);
			originalBoard.setTile(2,0,4);
			originalBoard.setTile(2,1,4);
			originalBoard.setTile(2,2,8);
			originalBoard.setTile(2,3,0);
			originalBoard.setTile(3,0,0);
			originalBoard.setTile(3,1,0);
			originalBoard.setTile(3,2,2);
			originalBoard.setTile(3,3,2);
			String direction = directionList[i];
			originalBoard.move(direction,"Off");
			
			//make a new 2d array and populate with original board values
			for(int row=0; row<4; row++){
				for(int col=0; col<4; col++){
					originalValues[row][col]=originalBoard.getTile(row,col);
				}
			}
			
			//populate expectedValues array with expected values based on
			//current direction in loop
			if(direction == "Up"){
				expectedValues[0][0]= 4;
				expectedValues[0][1]= 2;
				expectedValues[0][2]= 4;
				expectedValues[0][3]= 2;
				expectedValues[1][0]= 0;
				expectedValues[1][1]= 4;
				expectedValues[1][2]= 8;
				expectedValues[1][3]= 0;
				expectedValues[2][0]= 0;
				expectedValues[2][1]= 0;
				expectedValues[2][2]= 2;
				expectedValues[2][3]= 0;
				expectedValues[3][0]= 0;
				expectedValues[3][1]= 0;
				expectedValues[3][2]= 0;
				expectedValues[3][3]= 0;
			}
			else if(direction=="Down"){
				expectedValues[0][0]= 0;
				expectedValues[0][1]= 0;
				expectedValues[0][2]= 0;
				expectedValues[0][3]= 0;
				expectedValues[1][0]= 0;
				expectedValues[1][1]= 0;
				expectedValues[1][2]= 4;
				expectedValues[1][3]= 0;
				expectedValues[2][0]= 0;
				expectedValues[2][1]= 2;
				expectedValues[2][2]= 8;
				expectedValues[2][3]= 0;
				expectedValues[3][0]= 4;
				expectedValues[3][1]= 4;
				expectedValues[3][2]= 2;
				expectedValues[3][3]= 2;
			}
			else if(direction=="Left"){
				expectedValues[0][0]= 2;
				expectedValues[0][1]= 0;
				expectedValues[0][2]= 0;
				expectedValues[0][3]= 0;
				expectedValues[1][0]= 4;
				expectedValues[1][1]= 0;
				expectedValues[1][2]= 0;
				expectedValues[1][3]= 0;
				expectedValues[2][0]= 8;
				expectedValues[2][1]= 8;
				expectedValues[2][2]= 0;
				expectedValues[2][3]= 0;
				expectedValues[3][0]= 4;
				expectedValues[3][1]= 0;
				expectedValues[3][2]= 0;
				expectedValues[3][3]= 0;
			}
			else if(direction=="Right"){
				expectedValues[0][0]= 0;
				expectedValues[0][1]= 0;
				expectedValues[0][2]= 0;
				expectedValues[0][3]= 2;
				expectedValues[1][0]= 0;
				expectedValues[1][1]= 0;
				expectedValues[1][2]= 0;
				expectedValues[1][3]= 4;
				expectedValues[2][0]= 0;
				expectedValues[2][1]= 0;
				expectedValues[2][2]= 8;
				expectedValues[2][3]= 8;
				expectedValues[3][0]= 0;
				expectedValues[3][1]= 0;
				expectedValues[3][2]= 0;
				expectedValues[3][3]= 4;
			}
			//loop through and compares the elements in the same row/col of both 
			//originalvalues and values once board was moved.
			for(int row=0; row<4; row++){
				for(int col=0; col<4; col++){
					int originalValue = originalValues[row][col];
					int movedValue = expectedValues[row][col];
					assertEquals(originalValue, movedValue);
				}
			}
		}
		
		
		//THIS SECOND PART IS THE SAME CODE AS ABOVE BUT CHECKS THE SECOND
		//ORIGINAL BOARD GIVEN IN INSTRUCTIONS
		for(int i=0; i<4; i++){
			//I put this up here so that in every new loop the Board is set
			//back to the original values since they change once I use the 
			//move method on the board
			originalBoard.setTile(0,0,8);
			originalBoard.setTile(0,1,2);
			originalBoard.setTile(0,2,2);
			originalBoard.setTile(0,3,16);
			originalBoard.setTile(1,0,8);
			originalBoard.setTile(1,1,2);
			originalBoard.setTile(1,2,4);
			originalBoard.setTile(1,3,8);
			originalBoard.setTile(2,0,8);
			originalBoard.setTile(2,1,4);
			originalBoard.setTile(2,2,2);
			originalBoard.setTile(2,3,8);
			originalBoard.setTile(3,0,8);
			originalBoard.setTile(3,1,0);
			originalBoard.setTile(3,2,2);
			originalBoard.setTile(3,3,2);
			String direction = directionList[i];
			originalBoard.move(direction,"Off");
			
			//make a new 2d array and populate with original board values
			for(int row=0; row<4; row++){
				for(int col=0; col<4; col++){
					originalValues[row][col]=originalBoard.getTile(row,col);
				}
			}
			
			//populate expectedValues array with expected values based on
			//current direction in loop
			if(direction == "Up"){
				expectedValues[0][0]= 16;
				expectedValues[0][1]= 4;
				expectedValues[0][2]= 2;
				expectedValues[0][3]= 16;
				expectedValues[1][0]= 16;
				expectedValues[1][1]= 4;
				expectedValues[1][2]= 4;
				expectedValues[1][3]= 16;
				expectedValues[2][0]= 0;
				expectedValues[2][1]= 0;
				expectedValues[2][2]= 4;
				expectedValues[2][3]= 2;
				expectedValues[3][0]= 0;
				expectedValues[3][1]= 0;
				expectedValues[3][2]= 0;
				expectedValues[3][3]= 0;
			}
			else if(direction=="Down"){
				expectedValues[0][0]= 0;
				expectedValues[0][1]= 0;
				expectedValues[0][2]= 0;
				expectedValues[0][3]= 0;
				expectedValues[1][0]= 0;
				expectedValues[1][1]= 0;
				expectedValues[1][2]= 2;
				expectedValues[1][3]= 16;
				expectedValues[2][0]= 16;
				expectedValues[2][1]= 4;
				expectedValues[2][2]= 4;
				expectedValues[2][3]= 16;
				expectedValues[3][0]= 16;
				expectedValues[3][1]= 4;
				expectedValues[3][2]= 4;
				expectedValues[3][3]= 2;
			}
			else if(direction=="Left"){
				expectedValues[0][0]= 8;
				expectedValues[0][1]= 4;
				expectedValues[0][2]= 16;
				expectedValues[0][3]= 0;
				expectedValues[1][0]= 8;
				expectedValues[1][1]= 2;
				expectedValues[1][2]= 4;
				expectedValues[1][3]= 8;
				expectedValues[2][0]= 8;
				expectedValues[2][1]= 4;
				expectedValues[2][2]= 2;
				expectedValues[2][3]= 8;
				expectedValues[3][0]= 8;
				expectedValues[3][1]= 4;
				expectedValues[3][2]= 0;
				expectedValues[3][3]= 0;
			}
			else if(direction=="Right"){
				expectedValues[0][0]= 0;
				expectedValues[0][1]= 8;
				expectedValues[0][2]= 4;
				expectedValues[0][3]= 16;
				expectedValues[1][0]= 8;
				expectedValues[1][1]= 2;
				expectedValues[1][2]= 4;
				expectedValues[1][3]= 8;
				expectedValues[2][0]= 8;
				expectedValues[2][1]= 4;
				expectedValues[2][2]= 2;
				expectedValues[2][3]= 8;
				expectedValues[3][0]= 0;
				expectedValues[3][1]= 0;
				expectedValues[3][2]= 8;
				expectedValues[3][3]= 4;
			}
			//loop through and compares the elements in the same row/col of both 
			//originalvalues and values once board was moved.
			for(int row=0; row<4; row++){
				for(int col=0; col<4; col++){
					int originalValue = originalValues[row][col];
					int movedValue = expectedValues[row][col];
					assertEquals(originalValue, movedValue);
					assertEquals(originalValue, movedValue);
					assertEquals(originalValue, movedValue);
					assertEquals(originalValue, movedValue);
				}
			}
		}
		
	}
}

import java.io.*;
import java.lang.*;
import java.util.*;

public class HillClimber {
	
	public int[][] board = new int[4][4];

	//init
	public HillClimber(){
		//board = {{1,2,3,4},{5,6,7,8},{1,2,3,4},{1,2,3,4}};
		for (int i=0; i < 4; i++){
			for (int j=0; j < 4; j++){
				board[i][j] = j+1;
			}
		}
	}
	
	public void printState(){
		String line = "";
		for (int i=0; i < 4; i++){
			for (int j=0; j < 4; j++){
				line+= board[i][j];
			}
			System.out.println(line);
			line = "";
		}
	}
	
	public static void main(String args[]){
		System.out.println("Test");
		
		
	}
}
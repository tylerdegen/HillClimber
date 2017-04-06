//Tyler Degen
//CSE 3521
//Lab 3

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Random;

public class GeneticAlgorithm {
	
	public int[][] board = new int[4][4];
	public boolean[][] asterisk = new boolean[4][4];
	Random rand = new Random();
	//do I want to do a double digit mod or do I want to just have a regular mod
	//index is occurrence of asterisk (1st, 2nd, etc.), value is [x/4][x%4]
	int[] indexOfAst = new int[16];
	int indexOfIndex = 0;
	
	//init
	public GeneticAlgorithm(String filename){
		//board = {{1,2,3,4},{5,6,7,8},{1,2,3,4},{1,2,3,4}};
		try{
		FileInputStream fstream = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader (in));
		String line;
		
		line = br.readLine();
		
		if(line.charAt(0) != '4'){
			System.out.println("SHOULD START WITH FOUR");
		}
		
		//take each char by char
		//if asterisk, mark in the array of ast and set rand val
		int i = 0;
		char c = 'a';
		int val = 0;
		while ((line = br.readLine()) != null){
			//System.out.println(line);
			for (int j = 0; j < 4; j++){
				c = line.charAt(j);
				if (c == '*'){
					asterisk[i][j] = true;
					val = rand.nextInt(4) + 1;
					//so to set index, i*4 + j
					indexOfAst[indexOfIndex] = (i*4) + j;
					indexOfIndex++;
				}
				else{
					val = Character.getNumericValue(c);
				}
				board[i][j] = val;
			}
			i++;
		}
		in.close();
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		
		/*
		for (int i=0; i < 4; i++){
			for (int j=0; j < 4; j++){
				board[i][j] = j+1;
			}
		}
		*/
		
		
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
	
	public void printInternalState(int[][] state){
		String line = "";
		for (int i=0; i < 4; i++){
			for (int j=0; j < 4; j++){
				line+= state[i][j];
			}
			System.out.println(line);
			line = "";
		}
	}
	
	//returns number of points accrued, zero implies success state
	public int checkState(){
		int points = 0;
		//check row
		boolean one, two, three, four;
		//initially all false
		boolean[] has = new boolean[5];
		int value;
		one = two = three = four = false;
		
		//check rows
		for (int i = 0; i < 4; i++){
			//go through each row digit
			for (int j = 0; j < 4; j++){
				value = board[i][j];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
			Arrays.fill(has, false);
		}
		
		//check columns
		for (int i = 0; i < 4; i++){
			//go through each column digit
			for (int j = 0; j < 4; j++){
				value = board[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
			Arrays.fill(has, false);
		}
		
		//check quadrants
		//q2
		for (int i = 0; i < 2; i++){
			//go through each column digit
			for (int j = 0; j < 2; j++){
				value = board[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		//q1
		for (int i = 2; i < 4; i++){
			//go through each column digit
			for (int j = 0; j < 2; j++){
				value = board[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		//q3
		for (int i = 0; i < 2; i++){
			//go through each column digit
			for (int j = 2; j < 4; j++){
				value = board[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		//q4
		for (int i = 2; i < 4; i++){
			//go through each column digit
			for (int j = 2; j < 4; j++){
				value = board[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		return points;
	}
	
		//returns number of points accrued, zero implies success state
	public int checkInternalState(int[][] state){
		int points = 0;
		//check row
		boolean one, two, three, four;
		//initially all false
		boolean[] has = new boolean[5];
		int value;
		one = two = three = four = false;
		
		//check rows
		for (int i = 0; i < 4; i++){
			//go through each row digit
			for (int j = 0; j < 4; j++){
				value = state[i][j];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
			Arrays.fill(has, false);
		}
		
		//check columns
		for (int i = 0; i < 4; i++){
			//go through each column digit
			for (int j = 0; j < 4; j++){
				value = state[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
			Arrays.fill(has, false);
		}
		
		//check quadrants
		//q2
		for (int i = 0; i < 2; i++){
			//go through each column digit
			for (int j = 0; j < 2; j++){
				value = state[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		//q1
		for (int i = 2; i < 4; i++){
			//go through each column digit
			for (int j = 0; j < 2; j++){
				value = state[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		//q3
		for (int i = 0; i < 2; i++){
			//go through each column digit
			for (int j = 2; j < 4; j++){
				value = state[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		//q4
		for (int i = 2; i < 4; i++){
			//go through each column digit
			for (int j = 2; j < 4; j++){
				value = state[j][i];
				if (has[value]){
					points++;
				}
				else{
					has[value] = true;
				}
			}
		}
		Arrays.fill(has, false);
		
		return points;
	}
	
	public int generateChild(int[][] parent, int[][] child, int i, int j){
		int bestVal = parent[i][j];
		int conflict = checkInternalState(board);
		int tempCheckState;
		
		for (int x = 0; x <4; x++){
			child[i][j] = x;
			tempCheckState = checkInternalState(child);
			if (tempCheckState < conflict){
				conflict = tempCheckState;
				bestVal = x;
			}
		}
		child[i][j] = bestVal;
		return bestVal;
	}
	
	public void gen_alg(){
		int tempInd1 = rand.nextInt(indexOfIndex);
		int temp1 = indexOfAst[tempInd1];
		int tempI1 = temp1/4;
		int tempJ1 = temp1%4;
		
		int tempInd2 = rand.nextInt(indexOfIndex);
		while (tempInd2 == tempInd1){
			tempInd2 = rand.nextInt(indexOfIndex);
		}
		int temp2 = indexOfAst[tempInd2];
		int tempI2 = temp2/4;
		int tempJ2 = temp2%4;
		
		int[][] child1 = new int[4][4];
		for (int i=0; i < board.length; i++)
		{
			int[] aBoard = board[i];
			int aLength = aBoard.length;
			child1[i] = new int[aLength];
			System.arraycopy(aBoard, 0, child1[i], 0, aLength);
		}
		
		int[][] child2 = new int[4][4];
		for (int i=0; i < board.length; i++)
		{
			int[] aBoard = board[i];
			int aLength = aBoard.length;
			child2[i] = new int[aLength];
			System.arraycopy(aBoard, 0, child2[i], 0, aLength);
		}
		
		int newVal1 = generateChild(board, child1, tempI1, tempJ1);
		int newVal2 = generateChild(board, child2, tempI2, tempJ2);
		
		//reproduce
		child1[tempI2][tempI2] = child2[tempI2][tempI2];
		child2[tempI1][tempI1] = child1[tempI1][tempI1];
		int child1Val = checkInternalState(child1);
		int child2Val = checkInternalState(child2);
		
		if (child1Val < child2Val){
			board[tempI1][tempI1] = newVal1;
			board[tempI2][tempI2] = newVal2;
		}
		
		
	}
	
	public static void main(String args[]){
		System.out.println("Test");
		
		
	}
}
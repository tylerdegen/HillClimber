//Tyler Degen
//CSE 3521
//Lab 3

import java.io.*;
import java.lang.*;
import java.util.*;

public class GeneticAlgorithmTest {
	private GeneticAlgorithmTest(){}
	
	public static void main(String args[]){
		//System.out.println("Test");
		
		String filename = args[0];
		//System.out.println(filename);
		GeneticAlgorithm g = new GeneticAlgorithm(filename);
		System.out.println("Initial state: ");
		g.printState();
		System.out.println(g.checkState());
		//h.climb();
		
		for(int i = 0; i < 500 && g.checkState() != 0; i++){
			g.gen_alg();
			System.out.println("Iteration " + i + ": ");
			g.printState();
			System.out.println(g.checkState());
		}
	}
}
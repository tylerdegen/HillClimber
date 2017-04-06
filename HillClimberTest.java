import java.io.*;
import java.lang.*;
import java.util.*;

public class HillClimberTest {
	private HillClimberTest(){}
	
	public static void main(String args[]){
		//System.out.println("Test");
		
		String filename = args[0];
		//System.out.println(filename);
		HillClimber h = new HillClimber(filename);
		System.out.println("Initial state: ");
		h.printState();
		System.out.println(h.checkState());
		//h.climb();
		
		for(int i = 0; i < 500 && h.checkState() != 0; i++){
			h.climb();
			System.out.println("Iteration " + i + ": ");
			h.printState();
			System.out.println(h.checkState());
		}
	}
}
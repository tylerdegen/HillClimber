import java.io.*;
import java.lang.*;
import java.util.*;

public class HillClimberTest {
	private HillClimberTest(){}
	
	public static void main(String args[]){
		System.out.println("Test");
		
		HillClimber h = new HillClimber("test.txt");
		h.printState();
		System.out.println(h.checkState());
		//h.climb();
		
		for(int i = 0; i < 50 || h.checkState() == 0; i++){
			h.climb();
			h.printState();
			System.out.println(h.checkState());
		}
	}
}
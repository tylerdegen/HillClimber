Tyler Degen
Artificial Intelligence MWF 9:10
Naeem Shareef 

In order to run this code, please use the following command

javac *.java

to compile all of the code. To run it on a testfile, either invoke it from the terminal with

java GeneticAlgorithmTest test.txt
java HillClimberTest test.txt

These algorithms will run 500 iterations or until they reach a goal state. The hillclimber randomly selects an asterisk to replace with a value, finds the best value, and then if the testvalue of the new state with the replaced value is better, it will make that the default board. The genetic algorithm makes two random children and then chooses the best child.


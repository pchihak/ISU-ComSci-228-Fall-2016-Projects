package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @Paul Chihak
 *
 */

/**
 * 
 * The PredatorPrey class performs the predator-prey simulation over a grid world 
 * with squares occupied by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class PredatorPrey 
{
	/**
	 * Update the new world from the old world in one cycle. 
	 * @param wOld  old world
	 * @param wNew  new world 
	 */
	public static void updateWorld(World wOld, World wNew){
		// For every life form (i.e., a Living object) in the grid wOld, generate  
		// a Living object in the grid wNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class.
		for(int i = 0; i < wOld.getWidth(); i++){
			for (int j = 0; j < wOld.getWidth(); j++){
				wNew.grid[i][j] = wOld.grid[i][j].next(wNew);
			}
		}
	}

	/**
	 * Repeatedly generates worlds either randomly or from reading files. 
	 * Over each world, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		// Generate predator-prey simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random world, 2 to read a world from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two worlds even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the world 
		//    odd from the world even; in an odd numbered cycle, generate even 
		//    from odd. 
		// 4. Print out initial and final worlds only.  No intermediate worlds should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate worlds.)
		// 
		// 5. You may save some randomly generated worlds as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated.

		World even = new World(1);   // the world after an even number of cycles 
		World odd;                   // the world after an odd number of cycles

		String choice = null;
		String inputFile;
		Scanner scanner = null;
		int key = 0;
		int cycles = 0, width = 0;
		int numSimulation = 1;
		
		while(true){
			scanner = new Scanner(System.in);
			System.out.println("The Predator - Prey Simulator");
			System.out.print("Keys: 1 (random word) 2 (file input) 3 (exit)\n");
			System.out.print("Trial " + numSimulation + ": ");
			choice = scanner.next();
			key = Integer.parseInt(choice);

			if (key == 1){
				System.out.println("Random world");
				System.out.print("Enter grid width: ");
				choice = scanner.next();
				width = Integer.parseInt(choice);
				System.out.print("Enter the number of cycles ");
				choice = scanner.next();
				cycles = Integer.parseInt(choice);
				even = new World(width);
				even.randomInit();
			}
			else if (key == 2){
				System.out.println("World input from a file");
				System.out.print("File name: ");
				inputFile = scanner.next();
				System.out.print("Enter the number of cycles: ");
				cycles = Integer.parseInt(scanner.next());
				even = new World(inputFile);
			}
			else if (key >= 3){
				break;
			}

			odd = new World(even.getWidth());
			odd.randomInit();

			System.out.println("\nInitial world:\n");
			System.out.println(even.toString());
			for(int i = 0; i < cycles; i++){
				if(i % 2 == 0){
					updateWorld(even, odd);
				}
				else{
					updateWorld(odd, even);
				}
			}
			System.out.println("Final world:\n");
			if(cycles % 2 == 0){
				System.out.println(even.toString());
			}
			else{
				System.out.println(odd.toString());
			}
			//System.out.println("Output file name test."); //Used for testing World.write(String inputFile);
			//even.write(scanner.next());
			numSimulation++;
		}
		scanner.close();
	}
}

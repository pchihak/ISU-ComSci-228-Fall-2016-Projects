/**
 *  
 * @Paul Chihak
 *
 */

package edu.iastate.cs228.hw1;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The world is represented as a square grid of size width X width. 
 *
 */
public class World 
{
	private int width; // grid size: width X width 

	public Living[][] grid;

	/**
	 *  Default constructor reads from a file 
	 */
	public World(String inputFileName) throws FileNotFoundException
	{
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid world in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done.
		try
		{
			File source = new File (inputFileName);
			Scanner scanner = new Scanner(source);
			width = 0;
			
			while(scanner.hasNextLine()){
				width++;
				scanner.nextLine();
			}
			grid = new Living[width][width];
			
			scanner.close();
			scanner = new Scanner(source);

			while(scanner.hasNext()){
				for(int i = 0; i < width; i++){
					for (int j = 0; j < width; j++){
						String str = scanner.next();
						switch(str.charAt(0))
						{
						case 'G' :
							grid[i][j] = new Grass(this, i, j);
							break;
						case 'E' :
							grid[i][j] = new Empty(this, i, j);
							break;
						case 'R' :
							
							grid[i][j] = new Rabbit(this, i, j, Character.getNumericValue(str.charAt(1)));
							break;
						case 'B' :
							grid[i][j] = new Badger(this, i, j, Character.getNumericValue(str.charAt(1)));
							break;
						case 'F' :
							grid[i][j] = new Fox(this, i, j, Character.getNumericValue(str.charAt(1)));
							break;
						default :
							System.out.println("Error Invalid Entry");
						}
					}
				}
			}
			scanner.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Error File not found");
		}
	}

	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public World(int w)
	{
		width = w;
		grid = new Living[width][width];
	}


	public int getWidth()
	{
		return width; 
	}

	/**
	 * Initialize the world by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();
		for (int i = 0; i < width; i++){
			for (int j = 0; j < width; j++){
				switch(generator.nextInt(5)){
				case Living.BADGER:
					grid[i][j] = new Badger(this, j, i, 0);
					break;
				case Living.EMPTY:
					grid[i][j] = new Empty(this, j, i);
					break;
				case Living.FOX:
					grid[i][j] = new Fox(this, j, i, 0);
					break;
				case Living.GRASS:
					grid[i][j] = new Grass(this, j, i);
					break;
				case Living.RABBIT:
					grid[i][j] = new Rabbit(this, j, i, 0);
					break;
				default:
					System.out.println("Error RandomInit failed");
				}
			}
		}

	}


	/**
	 * Output the world grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		int age;
		String strGrid = "";
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				switch(grid[i][j].who()){
				case BADGER:
					age = ((Animal) grid[i][j]).myAge();
					strGrid += ("B" + age + " ");
					break;
				case EMPTY:
					strGrid += ("E  ");
					break;
				case FOX:
					age = ((Animal) grid[i][j]).myAge();
					strGrid += ("F" + age + " ");
					break;
				case GRASS:
					strGrid += ("G  ");
					break;
				case RABBIT:
					age = ((Animal) grid[i][j]).myAge();
					strGrid += ("R" + age + " ");
					break;
				}
			}
			strGrid += '\n';
		}
		return strGrid;
	}


	/**
	 * Write the world grid to an output file.  Also useful for saving a randomly 
	 * generated world for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file.
		PrintWriter writer = new PrintWriter (new File(outputFileName));
		writer.print(toString());
		writer.close();
	}			
}

/**
 *  
 * @Paul Chihak
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */

package edu.iastate.cs228.hw1;

public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (World w, int r, int c, int a) 
	{
		super(w, r, c, a);
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param wNew     world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox.
		int population[] = new int[5];
		census(population);
		if (age == FOX_MAX_AGE){
			return new Empty(wNew, row, column);
		}
		else if (population[BADGER] > population[FOX]){
			return new Badger(wNew, row, column, 0);
		}
		else if (population[BADGER] + population[FOX] > population[RABBIT]){
			return new Empty(wNew, row, column);
		}
		return new Fox(wNew, row, column, ++age);
	}
}

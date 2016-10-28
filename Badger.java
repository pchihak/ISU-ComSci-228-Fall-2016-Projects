/**
 *  
 * @Paul Chihak
 *
 */

package edu.iastate.cs228.hw1;

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (World w, int r, int c, int a) 
	{
		super(w, r, c, a);
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER;
	}
	
	/**
	 * A badger dies of old age or hunger, from isolation and attack by a group of foxes. 
	 * @param wNew     world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew)
	{
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		if (age == BADGER_MAX_AGE){
			return new Empty(wNew, row, column);
		}
		else if (population[BADGER] == 1 && population[FOX] > 1){
			return new Fox(wNew, row, column, 0);
		}
		else if (population[BADGER] + population[FOX] > population[RABBIT]){
			return new Empty(wNew, row, column);
		}
		return new Badger(wNew, row, column, ++age);
	}
}

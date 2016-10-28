/**
 *  
 * @Paul Chihak
 *
 */

package edu.iastate.cs228.hw1;

/**
 * Grass remains if more than rabbits in the neighborhood;
 * otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (World w, int r, int c) 
	{
		super(w, r, c);
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits in the neighborhood. Rabbits may also 
	 * multiply fast enough to take over Grass. 
	 */
	public Living next(World wNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		int population[] = new int[5];
		census(population);
		if (population[RABBIT] >= (3 * population[GRASS])){
			return new Empty(wNew, row, column);
		}
		else if (population[RABBIT] >= 3){
			return new Rabbit(wNew, row, column, 0);
		}
		return new Grass(wNew, row, column); 
	}
}

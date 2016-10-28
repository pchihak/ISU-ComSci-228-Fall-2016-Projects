/**
 *  
 * @Paul Chihak
 *
 */

package edu.iastate.cs228.hw1;

/*
 * This class is to be extended by the Badger, Fox, and Rabbit classes. 
 */
public abstract class Animal extends Living implements MyAge
{
	protected int age;   // age of the animal
	
	Animal(World world, int row, int column, int a){
		super(world, row, column);
		age = a;
	}
	@Override
	/**
	 * 
	 * @return age of the animal 
	 */
	public int myAge()
	{
		return age; 
	}
}

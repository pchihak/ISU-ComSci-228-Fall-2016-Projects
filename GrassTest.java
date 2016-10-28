package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class GrassTest {
	private World world;
	private String testString = "G  G  R0 \n" +
			"B0 B2 G  \n" +
			"R1 F0 E  \n";

	@Test
	public void constructorStateTest() throws IOException{
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);
		writer.write(testString);
		assertEquals(testString, world.toString()); //Constructor test
		assertEquals(State.GRASS, world.grid[0][1].who()); //State test
		file.delete();
		writer.close();
	}

	@Test
	public void grassNextTest() throws IOException{ 
		World world = new World(2);
		World wNew = world;
		world.randomInit();
		Living alive;
		world.grid[0][0] = new Grass(world, 0, 0);
		world.grid[0][1] = new Rabbit(world, 0, 1, 0);
		world.grid[1][0] = new Rabbit(world, 1, 0, 0);
		world.grid[1][1] = new Rabbit(world, 1, 1, 0);

		alive = world.grid[0][0].next(wNew);
		assertEquals(alive.who(), State.EMPTY);
		
        world.grid[0][0] = new Grass(world, 0, 0);
        world.grid[0][1] = new Empty(world, 0, 1);
        world.grid[1][0] = new Empty(world, 1, 0);
        world.grid[1][1] = new Empty(world, 1, 1);

        alive = world.grid[0][0].next(wNew);
		assertEquals(alive.who(), State.GRASS);
		
		world.grid[0][0] = new Rabbit(world, 0, 0, 0);
        world.grid[0][1] = new Rabbit(world, 0, 1, 0);
        world.grid[0][2] = new Rabbit(world, 0, 2, 0);
        world.grid[1][0] = new Grass(world, 1, 0);
        world.grid[1][1] = new Grass(world, 1, 1);
        world.grid[1][2] = new Empty(world, 1, 2);
        world.grid[2][0] = new Empty(world, 2, 0);
        world.grid[2][1] = new Empty(world, 2, 1);
        world.grid[2][2] = new Empty(world, 2, 2);
        
        alive = world.grid[1][1].next(wNew);
		assertEquals(alive.who(), State.RABBIT);
	}
}

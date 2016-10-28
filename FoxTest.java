package edu.iastate.cs228.hw1;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class FoxTest {
	
	private World world;
	private String testString = "F6 G  R0 \n" +
 								"B0 B2 G  \n" +
 								"R1 F0 E  \n";
	
	@Test
	public void foxTest() throws IOException{
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);
		writer.write(testString);
		assertEquals(testString, world.toString()); //Constructor test
		assertEquals(State.FOX, world.grid[0][0].who()); //State test
		assertEquals(world.grid[0][0].next(null).who(), State.EMPTY);
		file.delete();
		writer.close();
		
		String test = "B0 G  R0 \n" +
					"B0 F2 G  \n" +
					"R1 B0 E  \n";

		file = new File("testString.txt");
		writer = new FileWriter(file);
		writer.write(test);
		
		assertEquals(world.grid[2][2].next(null).who(), State.BADGER);
		file.delete();
		writer.close();

		test = "B0 G  R0 \n" +
				"B0 F2 G  \n" +
				"R1 B0 E  \n";

		file = new File("testString.txt");
		writer = new FileWriter(file);
		writer.write(test);

		assertEquals(world.grid[2][2].next(null).who(), State.BADGER);
		file.delete();
		writer.close();
		
		test = "B0 G  R0 \n" +
				"F0 F2 G  \n" +
				"R1 B0 E  \n";

		file = new File("testString.txt");
		writer = new FileWriter(file);
		writer.write(test);

		assertEquals(world.grid[2][2].next(null).who(), State.EMPTY);
		file.delete();
		writer.close();
	}
}

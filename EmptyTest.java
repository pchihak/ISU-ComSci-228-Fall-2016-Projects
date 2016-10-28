package edu.iastate.cs228.hw1;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class EmptyTest {
	
	private World world;
	private String testString = "E  G  R0 \n" +
 								"B0 B2 G  \n" +
 								"R1 F0 E  \n";
	
	@Test
	public void emptyTest() throws IOException{
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);
		writer.write(testString);
		assertEquals(testString, world.toString()); //Constructor test
		assertEquals(State.EMPTY, world.grid[0][0].who()); //State test
		writer.close();

		String test = "E  R0 \n" +
				"E  E  \n";
		file = new File("test.txt");
		writer = new FileWriter(file);
		writer.write(test);

		assertEquals(world.grid[0][0].next(null).who(), State.RABBIT);
		file.delete();
		writer.close();

		test = "E  E  \n" +
				"E  E  \n";
		file = new File("test.txt");
		writer = new FileWriter(file);
		writer.write(test);

		assertEquals(world.grid[0][0].next(null).who(), State.EMPTY);
		file.delete();
		writer.close();
		
		test = "E  E  \n" +
				"B0 E  \n";
		file = new File("test.txt");
		writer = new FileWriter(file);
		writer.write(test);

		assertEquals(world.grid[0][0].next(null).who(), State.BADGER);
		file.delete();
		writer.close();
		
		test = "E  E  \n" +
				"G  E  \n";
		file = new File("test.txt");
		writer = new FileWriter(file);
		writer.write(test);

		assertEquals(world.grid[0][0].next(null).who(), State.GRASS);
		file.delete();
		writer.close();

	}
}

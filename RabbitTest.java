package edu.iastate.cs228.hw1;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class RabbitTest {
	
	private World world;
	private String testString = "R0 G  R0 \n" +
 								"B0 B2 G  \n" +
 								"R1 F0 E  \n";
	
	@Test
	public void constructorStateTest() throws IOException{
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);
		writer.write(testString);
		assertEquals(testString, world.toString()); //Constructor test
		assertEquals(State.RABBIT, world.grid[0][0].who()); //State test
		file.delete();
		writer.close();
	}
	
	@Test
	public void rabbitNextTest() throws IOException{ 
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);
		writer.write(testString);
		world = new World("testString.txt");
		World wNew = world;
		world.grid[0][0].next(wNew);
		assertEquals(State.BADGER, world.grid[0][0].who());
		assertEquals(2, ((Animal) world.grid[0][0]).myAge());
		writer.close();
	}
}

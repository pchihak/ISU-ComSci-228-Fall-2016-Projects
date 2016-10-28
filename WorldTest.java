package edu.iastate.cs228.hw1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class WorldTest {
	
	private World world;
	private String testString = "R0 G  R0 \n" +
 								"B0 B2 G  \n" +
 								"R1 F0 E  \n";
	
	@Test
	public void toStringtest() throws IOException{
		File file = new File("testFileInput.txt");
		FileWriter writer = new FileWriter(file);
		
		writer.write(testString);
		writer.close();
		
		
		World inputWorld = new World(file.getName());
		assertEquals(testString, inputWorld.toString());
		file.delete();
	}
	
	@Test
	public void writeTest() throws FileNotFoundException{
		world = new World(testString);
		world.write("testFileInput.txt");
		Scanner scanner = new Scanner("testFileInput.txt");
		
		assertEquals(testString, scanner.toString());
		scanner.close();
	}
	
	@Test
	public void testGridWidth() throws FileNotFoundException{
		world = new World(testString);
		assertEquals(3, world.getWidth());
	}
	
	@Test
	public void worldConstructorTest() throws FileNotFoundException{
		world = new World(3);
		assertEquals(3, world.getWidth());
		world.write("testString.txt");
		world = new World("testString.txt");
		
		assertEquals(testString, world.toString());
	}
}

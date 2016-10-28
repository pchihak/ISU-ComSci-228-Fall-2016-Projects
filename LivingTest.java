package edu.iastate.cs228.hw1;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class LivingTest {

	private World world;
	private String testString = "R0 R0 B0 \n" +
 								"F0 G  E  \n" +
 								"G  E  G  \n";
	
	private String testResult = "R1 R1 B1 \n" +
								"G  G  G  \n" +
								"G  G  G \n";
	
	@Test
	public void censusTest() throws IOException{
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);
		int [] population = new int [5];
		writer.write(testString);
		world = new World("testString.txt");
		
		world.grid[1][1].census(population);
		assertEquals(population[4], 2);
		assertEquals(population[3], 3);
		assertEquals(population[2], 1);
		assertEquals(population[1], 2);
		assertEquals(population[0], 1);
	}
}

package edu.iastate.cs228.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PredatorPreyTest {
	
	private World world;
	private String testString = "R0 R0 B0 \n" +
 								"G  G  E  \n" +
 								"G  E  G  \n";
	
	private String testResult = "R1 R1 B1 \n" +
								"G  G  G  \n" +
								"G  G  G \n";
	
	@Test
	public void updateWorldTest() throws IOException{
		File file = new File("testString.txt");
		FileWriter writer = new FileWriter(file);

		writer.write(testString);
		
		world = new World("testString.txt");
		World wNew = world;
		PredatorPrey.updateWorld(world, wNew);
		
		assertEquals(wNew.toString(), testResult);
		
	}
}

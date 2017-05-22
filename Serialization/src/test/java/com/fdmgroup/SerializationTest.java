package com.fdmgroup;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.Power;
import com.fdmgroup.Shield;
import com.fdmgroup.Wizard;
import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.Board;
import com.fdmgroup.serialization.game.HealthPack;

public class SerializationTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
			
		Board board = new Board();
		
		Wizard brian = new Wizard();
		Wizard george = new Wizard();
		Wizard newGeorge = null;
		Wizard newBrian = null;
 		
		brian.setName("Brian");
		george.setName("George");
		brian.setHealthPoints(100);
		george.setHealthPoints(100);
		
		board.attack(brian, george);
		board.defend(george, brian);
		board.loseHealthPoint(george);
		board.loseHealthPoint(george);
		board.loseHealthPoint(george);
		board.loseHealthPoint(george);
		board.loseHealthPoint(george);
		
		HealthPack hp1 = new HealthPack(10);
		HealthPack hp2 = new HealthPack(20);
		george.getBackpack().addHealthPack(hp1);
		george.getBackpack().addHealthPack(hp2);
		brian.getBackpack().addHealthPack(hp2);
		
		Shield recover = new Shield("Recover", 5, 0, 0, 0);
		Power fast = new Power("Speed", 0, 0, 0, 0);
		Power invisible = new Power("Invisible", 0, 0, 0, 0);
		
		george.addShield(recover);
		george.addPower(fast);
		brian.addPower(invisible);
		
		try
		{
			// Serialize object
			FileOutputStream fs = new FileOutputStream("wizard.txt"); //give file name
			ObjectOutputStream os = new ObjectOutputStream(fs); //make objectoutputstream using your fileoutputstream			
			os.writeObject(george);	
			os.writeObject(brian);	
			os.close(); //always close stream when finished
			
			FileInputStream fis = new FileInputStream("wizard.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			newGeorge = (Wizard) ois.readObject(); //it returns object, so you must cast it
			newBrian = (Wizard) ois.readObject(); //it returns object, so you must cast it
			ois.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			fail();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} 
		
		
		assertEquals(brian.getName(), newBrian.getName());	
		assertEquals(brian.getHealthPoints(), newBrian.getHealthPoints());	
		assertEquals(brian.getPowers().toString(), newBrian.getPowers().toString());	
		assertEquals(brian.getShields().toString(), newBrian.getShields().toString());	
		assertEquals(20, newBrian.getBackpack().useHealthPack().getHealthPoints());

		assertEquals(george.getName(), newGeorge.getName());	
		assertEquals(george.getHealthPoints(), newGeorge.getHealthPoints());	
		assertEquals(george.getPowers().toString(), newGeorge.getPowers().toString());	
		assertEquals(george.getShields().toString(), newGeorge.getShields().toString());
		assertEquals(10, newGeorge.getBackpack().useHealthPack().getHealthPoints());
		assertEquals(20, newGeorge.getBackpack().useHealthPack().getHealthPoints());
		
	}
		
}	
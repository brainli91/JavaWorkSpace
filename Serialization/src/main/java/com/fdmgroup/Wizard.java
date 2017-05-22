package com.fdmgroup;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.Board;
import com.fdmgroup.serialization.game.HealthPack;
import com.fdmgroup.serialization.game.Player;

public class Wizard extends Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private transient Backpack backpack = new Backpack();
	private List<Shield> shields = new ArrayList<Shield>();
	private List<Power> powers = new ArrayList<Power>();
	
	public Backpack getBackpack() {
		return backpack;
	}

	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}

	public List<Shield> getShields() {
		return shields;
	}

	public void setShields(List<Shield> shields) {
		this.shields = shields;
	}

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	public void addPower(Power power) {
		this.getPowers().add(power);
	}
	
	public void addShield(Shield shield) {
		this.getShields().add(shield);
	}
	
	
	private void writeObject(ObjectOutputStream os)
	{
		try
		{
			os.defaultWriteObject();		//request JVM to do normal serialization process
			os.writeUTF(this.getName()); 
			os.writeInt(this.getHealthPoints());	
			
			int count = backpack.getNumPacks();
			os.writeInt(count);

			for (int i = 0; i < count; i++ ){
				int num = this.getBackpack().useHealthPack().getHealthPoints();
				os.writeInt(num);
			}		
			
		}								   //need to recreate the Home object
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream is)
	{
		try
		{
			is.defaultReadObject();
			setName(is.readUTF());		//do the normal deserialization process
			setHealthPoints(is.readInt());
			
			int count = is.readInt();
			backpack = new Backpack();
			
			for (int i = 0; i < count; i ++){
			getBackpack().addHealthPack(new HealthPack(is.readInt()));
			}
			
		}								//will need to recreate the Home Object.  
		catch(IOException e)				//Then make a new home object
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
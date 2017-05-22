package com.fdm.tp.model.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Map;




import com.fdm.tp.model.storable.User;


public class LoadUsersData {
	/**
	 * deserialize reads bytes from an existing file and writes them into a Map
	 * @param filename the file location to be read from
	 * @return Map<String, User> if file existed, null if any error occurs whilst trying to create the data
	 */
	public Map<String, User> deserializeUsersMap(String filename){
		ObjectInput input  = null;
		
		try {
			input = getObjectInput(filename); 
			
			Map<String, User> map = (Map<String, User>) input.readObject(); 
			return map;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} finally {
			if(input != null){
			closeObjectInput(input);
			}
		}
		
		return null;
	}

	/**
	 * Closes the object input stream
	 * @param input the object to be closed
	 */
	protected void closeObjectInput(ObjectInput input)  {
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * A method to create a new ObjectInputStream for a given location
	 * @param filename the location of the file to be read
	 * @return a new input stream to read bytes from
	 * @throws FileNotFoundException if the filename is not a valid path
	 * @throws IOException @see {@link java.io.IOException}
	 */
	public ObjectInput getObjectInput(String filename) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return new ObjectInputStream(new FileInputStream(filename));
	}
}

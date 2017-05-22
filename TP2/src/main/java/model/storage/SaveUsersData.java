package com.fdm.tp.model.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.fdm.tp.model.storable.User;

public class SaveUsersData {

	public boolean serializeUsersMap(Map<String, User> map, String filename) {
		ObjectOutput output = null;
		try {
			output = getObjectOutput(filename);
			output.writeObject(map);
			output.flush();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				closeOutput(output);
			}
		}

		return false;
	}

	public void closeOutput(ObjectOutput output) {
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObjectOutput getObjectOutput(String filename) throws FileNotFoundException, IOException {
		return new ObjectOutputStream(new FileOutputStream(filename));
	}

}

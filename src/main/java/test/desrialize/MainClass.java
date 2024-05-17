package test.desrialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		User user = new User();
		user.setId(12);
		user.setName("Jack");

		String filePath = "src/test/resources/protocols/user.tx";
		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(user);
		
		objectOutputStream.close();
		
		FileInputStream fis = new FileInputStream(new File(filePath));
		ObjectInputStream ois = new ObjectInputStream(fis);
		User desrializedUser = (User)ois.readObject();
		System.out.println("getId: "+desrializedUser.getId());
		System.out.println("getName: "+desrializedUser.getName());

	}

}

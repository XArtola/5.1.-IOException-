package com.zubiri.user;

import java.io.*;
import java.util.Scanner;

public class Users {
	private File users = new File("src/usersData.txt");

	/**
	 * <p>
	 * When you create a User object, if there's no 'userData.txt' in 'src' folder,
	 * it will create one
	 * </p>
	 */
	public Users() throws IOException {
		//Possible IOException
		if (!users.exists()) {

			users.createNewFile();
		}
	}

	public void setUsers(File users) {
		this.users = users;
	}

	public File getUsers() {
		return this.users;
	}

	/**
	 * @author Koldo
	 * @param User class object which you want to save in a file named
	 *             'userData.txt' in 'src' folder
	 * @throws IOException
	 */
	public void setUser(User user) throws IOException {
		//Possible IOException in each line where FileWriter is used
		FileWriter fw = new FileWriter(users, true);
		fw.write(user.getName() + "::" + user.getPassword());
		fw.write(System.getProperty("line.separator"));
		fw.close();

	}

	/**
	 * @author Koldo
	 * @param username you want to find in the file of created users
	 * @return User object with the name you enter
	 */
	public User getUser(String username) throws FileNotFoundException {

		User user = new User();
		// Possible FileNotFoundException
		Scanner sc = new Scanner(users);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] words = line.split("::");
			if (username.equals(words[0])) {
				user.setName(words[0]);
				user.setPassword(words[1]);
			}
		}
		sc.close();

		return user;
	}

	/**
	 * @author Koldo
	 * @return true if there's any User already added to the file, else, it returns
	 *         false
	 */
	public boolean hasUser() throws FileNotFoundException {
		boolean hasUser = false;
		//Possible FileNotFoundException
		Scanner sc = new Scanner(users);
		if (sc.hasNext())
			hasUser = true;
		sc.close();

		return hasUser;
	}

}

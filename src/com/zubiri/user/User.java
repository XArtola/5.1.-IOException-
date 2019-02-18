package com.zubiri.user;
import java.io.IOException;
import java.util.Scanner;

public class User {
	private String name = "null";
	private String password = "null";

	/**
	 * @author Koldo
	 * @param name you want to set
	 * @return true if it has to be an only
	 *         word of only letters
	 */
	public boolean setName(String name) {
		boolean fine = false;
		if (checkName(name)) {
			this.name = name;
			fine = true;
		} else
			nullUser();
		return fine;
	}

	public String getName() {
		return this.name;
	}
	
	/**
	 * <p>This sets to the user 'null' value in name and in password</p>
	 */
	public void nullUser() {
		name = "null";
		password = "null";
	}

	/**
	 * @author Koldo
	 * @param password you want to set
	 * @return true if it fulfill the demanded requirements (have a letter, a
	 *         number, a symbol and if it has more than 8 characters)
	 */
	public boolean setPassword(String password) {
		boolean fine = false;
		if (checkPassword(password)) {
			this.password = password;
			fine = true;
		} else
			nullUser();
		return fine;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * @author Koldo
	 * @param password you want to check in String type
	 * @return true if it has at least a letter, a number, a symbol and if its
	 *         length if of 8 or more characters; else, it returns
	 *         <strong>false</strong>
	 */
	public boolean checkPassword(String password) {
		boolean fine = false;
		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				if (Character.isLetter(password.charAt(i))) {
					for (int j = 0; j < password.length(); j++) {
						if (Character.isDigit(password.charAt(j))) {
							for (int x = 0; x < password.length(); x++) {
								if (!Character.isAlphabetic(password.charAt(x))) {
									fine = true;
									break;
								}
							}
							break;
						}
					}
					break;
				}
			}
		}
		return fine;
	}

	/**
	 * @author Koldo
	 * @param name you want to check
	 * @return true if the name is all letters (one word with no symbols or
	 *         numbers), else it returns false;
	 */
	public boolean checkName(String name) {
		boolean fine = false;
		String[] words = name.split(" ");
		if (words.length == 1) {
			int counter = 0;
			for (int i = 0; i < name.length(); i++)
				if (Character.isLetter(name.charAt(i)))
					counter++;
			if (counter == name.length())
				fine = true;
		}
		return fine;
	}
	
	
}

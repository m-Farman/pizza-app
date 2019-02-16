package com.app.pizza.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class InputOutputUtil {

	public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static Integer readInteger() throws NumberFormatException, IOException {
		return Integer.parseInt(bufferedReader.readLine());
	}

	public static String readString() throws NumberFormatException, IOException {
		return bufferedReader.readLine();
	}

	public static Double readDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(bufferedReader.readLine());
	}

	public static void wrongInputMsg() {
		System.out.println("Wrong Input from user");
	}
	public static void wrongInputMsg(String msg) {
		System.out.println("Wrong Input :"+msg);
	}
	public static void print(String msg) {
		System.out.println(msg);
	}
	public static void closeIO() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

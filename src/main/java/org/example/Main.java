package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();

//		if (input.equalsIgnoreCase("add")) {
			File file = createFile("src/main/java/org/example/list.json");

			writeToFile(file, true);
//		}

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void writeToFile(File file, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println("test");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

	private static File createFile(String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			return file;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new IllegalStateException(e);
		}
	}
}
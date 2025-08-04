package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		String input = scannerInput.nextLine();

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		File file = createFile("src/main/java/org/example/list.json");

		if (input.startsWith("add")) {
			String substring = input.substring(4);
			Task task = new Task(
					1,
					substring,
					"todo",
					localDateTime
//					null
			);
			writeToFile(file, task, true);
		}

		if (input.startsWith("update")) {}
		if (input.startsWith("delete")) {}
		if (input.startsWith("mark-in-progress")) {}
		if (input.startsWith("mark-done")) {}

		if (input.startsWith("list")) {
			if (input.equalsIgnoreCase("list todo")) {
				try {
					Scanner scanner = new Scanner(file);
//						Stream<MatchResult> status = scanner.findAll("status");
					String status = scanner.nextLine();

					while (!status.isEmpty())
					{

					}
//					System.out.println(status);
//						if (status.equals("todo")) {
					if (status.contains("status")) {
						System.out.println(scanner.nextLine());
					}
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			} else {
				try {
					Scanner scanner = new Scanner(file);
					while (scanner.hasNext()) {
						System.out.println(scanner.nextLine());
					}
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}


		}
	}

	private static void writeToFile(File file, Task task, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            PrintWriter writer = new PrintWriter(fileWriter);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(task);
            writer.println(json);
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
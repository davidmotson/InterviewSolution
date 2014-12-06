package com.davidm.thoughtworkschallenge;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> inputFile = Files.readAllLines(FileSystems.getDefault().getPath("input.txt"));
		MarsArea marsPlateau = MarsArea.generateArea(inputFile);
		marsPlateau.resolveDirections();
		List<String> output = marsPlateau.getRoverInfo();
		output.stream().forEach(System.out::println);
	}

}

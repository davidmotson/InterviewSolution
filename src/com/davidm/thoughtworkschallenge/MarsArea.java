package com.davidm.thoughtworkschallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarsArea {
	int sizeX;
	int sizeY;
	List<Rover> rovers;
	
	private MarsArea(int x, int y, List<Rover> r){
		sizeX = x;
		sizeY = y;
		rovers = r;
	}
	
	public static MarsArea generateArea(List<String> instructions){
		String[] xySize = instructions.get(0).split(" ");
		int xSize = Integer.parseInt(xySize[0]);
		int ySize = Integer.parseInt(xySize[1]);
		List<Rover> rovers = new ArrayList<Rover>();
		for(int i = 1; i< instructions.size(); i+=2){
			rovers.add(Rover.generateRover(instructions.subList(i, i + 2)));
		}
		return new MarsArea(xSize, ySize, rovers);
	}

	public void resolveDirections() {
		rovers.forEach(Rover::resolveDirections);
	}

	public List<String> getRoverInfo() {
		return rovers.stream().map(Rover::toString).collect(Collectors.toList());
	}

}

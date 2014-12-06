package com.davidm.thoughtworkschallenge;

import java.util.ArrayList;
import java.util.List;
import static com.davidm.thoughtworkschallenge.CardinalDirection.*;

public class Rover {
	int xPosition;
	int yPosition;
	List<RoverInstruction> instructions;
	CardinalDirection heading;
	
	
	
	public Rover(int xPosition, int yPosition,
			List<RoverInstruction> instructions, CardinalDirection heading) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.instructions = instructions;
		this.heading = heading;
	}
	
	public void resolveDirections(){
		instructions.stream().forEach(this::applyInstruction);
	}
	
	private void applyInstruction(RoverInstruction instruction){
		switch (instruction){
		case ROTATE_LEFT:
			heading = heading.getLeft();
			break;
		case ROTATE_RIGHT:
			heading = heading.getRight();
			break;
		case PROCEED:
			switch (heading){
			case NORTH:
				yPosition++;
				break;
			case SOUTH:
				yPosition--;
				break;
			case EAST:
				xPosition++;
				break;
			case WEST:
				xPosition--;
				break;
			}
		}
	}


	public static Rover generateRover(List<String> input) {
		String[] currentState = input.get(0).split(" ");
		int xPos = Integer.parseInt(currentState[0]);
		int yPos = Integer.parseInt(currentState[1]);
		char heading = currentState[2].charAt(0);
		List<RoverInstruction> instructions = new ArrayList<RoverInstruction>();
		for(char x : input.get(1).toCharArray()){
			instructions.add(RoverInstruction.parseChar(x));
		}
		return new Rover(xPos, yPos, instructions, CardinalDirection.parseChar(heading));
	}
	
	@Override
	public String toString(){
		return xPosition + " " + yPosition + " " + heading.toString();
	}

}

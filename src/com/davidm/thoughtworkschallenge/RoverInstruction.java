package com.davidm.thoughtworkschallenge;

public enum RoverInstruction {
	ROTATE_LEFT, ROTATE_RIGHT, PROCEED;

	public static RoverInstruction parseChar(char x) {
		switch (x) {
		case 'l':
		case 'L':
			return ROTATE_LEFT;
		case 'r':
		case 'R':
			return ROTATE_RIGHT;
		case 'm':
		case 'M':
			return PROCEED;
		default:
			throw new RuntimeException("Error parsing input");
		}
	}
}

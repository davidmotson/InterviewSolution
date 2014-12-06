package com.davidm.thoughtworkschallenge;

public enum CardinalDirection {
	NORTH, EAST, SOUTH, WEST;

	public CardinalDirection getLeft() {
		switch (this) {
		case NORTH:
			return WEST;
		case EAST:
			return NORTH;
		case SOUTH:
			return EAST;
		case WEST:
			return SOUTH;
		default:
			throw new RuntimeException("wtf");
		}
	}

	public CardinalDirection getRight() {
		switch (this) {
		case WEST:
			return NORTH;
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		case SOUTH:
			return WEST;
		default:
			throw new RuntimeException("wtf");
		}
	}

	public static CardinalDirection parseChar(char heading) {
		switch (heading) {
		case 'n':
		case 'N':
			return NORTH;
		case 'e':
		case 'E':
			return EAST;
		case 'w':
		case 'W':
			return WEST;
		case 's':
		case 'S':
			return SOUTH;
		default:
			throw new RuntimeException("Error Parsing input");
		}
	}
	
	public String toString(){
		switch (this) {
		case NORTH:
			return "N";
		case EAST:
			return "E";
		case SOUTH:
			return "S";
		case WEST:
			return "W";
		default:
			throw new RuntimeException("wtf");
		}
	}
}

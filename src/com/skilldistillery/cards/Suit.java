package com.skilldistillery.cards;

public enum Suit {
	
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	final private String name;
	
	Suit(String s) {
		name = s;
	}

	@Override
	public String toString() {
		return name;
	}


}

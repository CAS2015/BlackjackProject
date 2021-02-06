package com.skilldistillery.cardGameSetting;

import com.skilldistillery.cards.Deck;

public class BlackjackPlayer extends Person {

	public BlackjackPlayer(String name) {
		super(name);
	}

	@Override
	public void playHand(Deck deck) {
		this.addCardToHand(deck.dealCard());
	}
	


}

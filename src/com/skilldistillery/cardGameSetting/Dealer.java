package com.skilldistillery.cardGameSetting;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public abstract class Dealer extends Person {

	public Dealer(String name) {
		super(name);
	}

	public void deal(Deck deck, Person person, int numOfCards) {

		for (int i = 0; i < numOfCards; i++) {
			Card c = deck.dealCard();
			person.addCardToHand(c);
		}
	}
}

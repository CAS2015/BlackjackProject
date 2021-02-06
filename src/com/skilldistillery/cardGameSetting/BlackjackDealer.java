package com.skilldistillery.cardGameSetting;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackDealer extends Person {

	public BlackjackDealer(String name) {
		super(name);
	}

	@Override
	public void playHand(Deck deck) {
		int score = this.getHandValue();
		int i = 0;
		while (score < 17) {
			this.addCardToHand(deck.dealCard());
			score = this.getHandValue();
			i++;
		}
		
		switch (i) {
		case 0:
			System.out.println(this.getName() + " stayed.");
			break;
		case 1:
			System.out.println(this.getName() + " hits once.");
			break;
		default:
			System.out.println(this.getName() + " hits " + i + " times.");
		}
	}

	public void deal(Deck deck, Person person, int numOfCards) {

		for (int i = 0; i < numOfCards; i++) {
			Card c = deck.dealCard();
			person.addCardToHand(c);
		}
	}

}

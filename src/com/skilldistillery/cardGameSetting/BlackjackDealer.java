package com.skilldistillery.cardGameSetting;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackDealer extends Dealer {

	public BlackjackDealer(String name) {
		super(name);
	}

	@Override
	public void playHand(Deck deck) {
		int score = this.checkSoftAceScore();
		int i = 0;
		boolean ace;
		
		while (score <= 17) {
			
			if(score < 17) {
			this.addCardToHand(deck.dealCard());
			score = this.checkSoftAceScore();
			i++;
			}
			
			ace = hasSoftAce();
			
			if(ace == true) {
				score -= 10;
			}
			
			else if (score == 17 && ace == false) {
				break;
			}
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
	
	private boolean hasSoftAce() {
		List<Card> hand = this.getHand();
		int score = 0;
		boolean ace = false;
		
		for (Card card : hand) {
			if(card.getValue() == 11) {
				ace = true;
				continue;
			}
			else {
				score += card.getValue();
			}
		}
		
		
		if (ace == true && score == 6) {
			return true;
		}
		return false;	
	}

}

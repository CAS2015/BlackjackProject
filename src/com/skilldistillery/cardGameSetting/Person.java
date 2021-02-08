package com.skilldistillery.cardGameSetting;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public abstract class Person {
	private String name;
	private List<Card> hand;
	
	public Person(String name) {
		super();
		this.name = name;
		hand = new ArrayList<>();
	}
	
	public void addCardToHand(Card c) {
		hand.add(c);
	}
	
	public abstract void playHand(Deck deck);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getHand() {
		List<Card> copyHand = new ArrayList<>();
		copyHand.addAll(hand);
		return copyHand;
	}
	
	public int getHandValue() {
		int value = 0;
		for (Card card : this.getHand()) {
			value += card.getValue();
		}
		return value;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void printHand() {
		System.out.println(this + "\nScore: " + this.checkSoftAceScore());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append("'s hand: ").append(this.getHand());
		return builder.toString();
	}
	
	public int checkSoftAceScore() {
		List<Card> hand = this.getHand();
		int adjustment = 10;
		int score = this.getHandValue();
		
		for (Card card : hand) {
			if(card.getValue() == 11 && checkBust(this.getHandValue()) == false) {
				score -= adjustment;
				if (checkBust(score)) {
					break;
				}
			}
		}
		
		return score;
	}
	
	public boolean checkBust(int score) {
		int blackjack = 21;
		if (score > blackjack) {
			return false;
		}
		else {
			return true;
		}
	}
}

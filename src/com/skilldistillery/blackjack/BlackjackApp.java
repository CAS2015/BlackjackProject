package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp dealing = new BlackjackApp();
		dealing.run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		Deck deck = new Deck();
		
		int userSelection = getUserInput(sc, deck.checkDeckSize());
		
		deck.shuffle();
		
		List<Card> hand = dealCards(userSelection, deck);
		
		printHand(hand);
		
		getHandValue(hand);
		
		
	}

	private void getHandValue(List<Card> hand) {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		System.out.println("Total value of hand: " + value);		
	}

	private void printHand(List<Card> hand) {
		for (Card card : hand) {
			System.out.println(card);	
		}
		
	}

	private List<Card> dealCards(int userSelection, Deck deck) {
		List<Card> hand = new ArrayList<>();
		for (int i = 0; i < userSelection; i++) {
			Card c = deck.dealCard();
			hand.add(c);
		}
		return hand;
	}

	private int getUserInput(Scanner sc, int deckSize) {
		System.out.print("How many cards would you like: ");
		int selection = 0;
		try {
			selection = Integer.parseInt(sc.nextLine());
			
			if(selection < 1 || selection >= deckSize) {
				throw new Exception();
			}	
		} catch (Exception e) {
			System.out.println("Invalid Entry! Select a number 1 - " + deckSize);
			selection = getUserInput(sc, deckSize);
		}
		
		return selection;
	}

}

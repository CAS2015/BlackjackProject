package com.skilldistillery.cardGameSetting;

import java.util.Scanner;

import com.skilldistillery.cards.Deck;

public class BlackjackPlayer extends Person {
	Scanner sc = new Scanner(System.in);
	
	public BlackjackPlayer(String name) {
		super(name);
	}
	
	public BlackjackPlayer() {
		super("");
		System.out.print("What's your name? ");
		this.setName(sc.nextLine());;
	}

	@Override
	public void playHand(Deck deck) {
		int numOfChoices = 2;
		int playerScore = this.getHandValue();
		int choice;
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println();
			System.out.println("What would you like to do? ");
			System.out.println("1) Hit");
			System.out.println("2) Stay");

			choice = getUserInput(numOfChoices);
			System.out.println();
			switch (choice) {
			case 1:
				System.out.println("You hit once.");
				this.addCardToHand(deck.dealCard());
				playerScore = this.checkSoftAceScore();
				this.printHand();
				keepGoing = this.checkBust(playerScore);
				break;
			case 2:
				System.out.println("You stayed.");
				System.out.println(this);
				System.out.println();
				keepGoing = false;
				break;
			}
		}
		
	}

	public int getUserInput(int length) {
		int selection = 0;
		try {
			selection = Integer.parseInt(sc.nextLine());

			if (selection < 1 || selection > length) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Entry! Select a number 1 - " + length);
			selection = getUserInput(length);
		}

		return selection;
	}

}

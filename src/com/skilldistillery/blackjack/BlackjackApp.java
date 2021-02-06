package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.cardGameSetting.BlackjackDealer;
import com.skilldistillery.cardGameSetting.BlackjackPlayer;
import com.skilldistillery.cardGameSetting.Person;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp dealing = new BlackjackApp();
		dealing.run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = true;
		System.out.println("Welcome to Blackjack!");
		
		BlackjackDealer dealer = new BlackjackDealer("Dealer Dan");
		Person player = createPlayer(sc);

		// Initialize the game by creating all of the objects needed for the game

		while (keepGoing) {
			Deck deck = new Deck();
			playGame(deck, dealer, player, sc);
			System.out.print("\nWould you like to play again? Y/N ");
			String choice = sc.nextLine();

			if (!choice.toUpperCase().contains("Y")) {
				keepGoing = false;
				System.out.println("Thanks for playing! Goodbye.");
			}
			else {
				player.setHand(new ArrayList<Card>());
				dealer.setHand(new ArrayList<Card>());
			}

		}
	}

	private void playGame(Deck deck, BlackjackDealer dealer, Person player, Scanner sc) {
		deck.shuffle();
		int numOfCards = 2;
		boolean keepGoing = true;
		dealer.deal(deck, player, numOfCards);
		dealer.deal(deck, dealer, numOfCards);

		System.out.println();
		int dealerScore = dealer.getHandValue();
		printHand(dealer, dealerScore);

		System.out.println();
		int playerScore = player.getHandValue();
		printHand(player, playerScore);
		
		keepGoing = checkWinLose(playerScore, dealerScore, keepGoing);

		if (keepGoing) {
			playPlayerRound(player, deck, sc);
			playerScore = player.getHandValue();

			keepGoing = checkBust(playerScore);
			if(!keepGoing) {
				System.out.println("\nBust! You lose.");
			}
			else {
				dealer.playHand(deck);
				dealerScore = dealer.getHandValue();
				printHand(dealer, dealerScore);

				keepGoing = checkBust(dealerScore);
				if(!keepGoing) {
					System.out.println("\nDealer busts! You win.");
				}
				else {
					checkWinLose(playerScore, dealerScore);
				}
			}
		}
	}

	private void playPlayerRound(Person player, Deck deck, Scanner sc) {
		int numOfChoices = 2;
		int playerScore = player.getHandValue();
		int choice;
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println();
			System.out.println("What would you like to do? ");
			System.out.println("1) Hit");
			System.out.println("2) Stay");

			choice = getUserInput(sc, numOfChoices);
			System.out.println();
			switch (choice) {
			case 1:
				System.out.println("You hit once.");
				player.playHand(deck);
				playerScore = player.getHandValue();
				printHand(player, playerScore);
				keepGoing = checkBust(playerScore);
				break;
			case 2:
				System.out.println("You stayed.");
				printHand(player, playerScore);
				System.out.println();
				keepGoing = false;
				break;
			}
		}

	}

	private boolean checkWinLose(int playerScore, int dealerScore, boolean keepGoing) {
		int blackjack = 21;

		if (dealerScore == blackjack) {
			System.out.println("\nDealer wins.");
			keepGoing = false;
		} else if (playerScore == blackjack) {
			System.out.println("\nBlackjack! You win.");
			keepGoing = false;
		} else {
		}
		return keepGoing;
	}

	private boolean checkWinLose(int playerScore, int dealerScore) {
		if (playerScore > dealerScore) {
			System.out.println("\nYou win.");
		} else {
			System.out.println("\nYou lose.");
		}
		return false;
	}

	private boolean checkBust(int score) {
		int blackjack = 21;
		if (score > blackjack) {
			return false;
		}
		else {
			return true;
		}
	}

	private Person createPlayer(Scanner sc) {
		System.out.print("What's your name? ");
		Person player = new BlackjackPlayer(sc.nextLine());
		return player;
	}

	private void printHand(Person person, int score) {
		System.out.println(person);
		System.out.println("Score: " + score);

	}

	private int getUserInput(Scanner sc, int length) {
		int selection = 0;
		try {
			selection = Integer.parseInt(sc.nextLine());

			if (selection < 1 || selection > length) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Entry! Select a number 1 - " + length);
			selection = getUserInput(sc, length);
		}

		return selection;
	}

}

package com.skilldistillery.blackjack;

import java.util.ArrayList;

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
		boolean keepGoing = true;
		System.out.println("Welcome to Blackjack!");
		
		BlackjackDealer dealer = new BlackjackDealer("Dealer Dan");
		BlackjackPlayer player = new BlackjackPlayer();

		// Initialize the game by creating all of the objects needed for the game

		while (keepGoing) {
			Deck deck = new Deck();
			playGame(deck, dealer, player);
			int numOfChoices = 2;
			System.out.println("\nWould you like to play again? \n1) Yes \n2) No ");
			int choice = player.getUserInput(numOfChoices);

			if (choice == 2) {
				keepGoing = false;
				System.out.println("Thanks for playing! Goodbye.");
			}
			else {
				player.setHand(new ArrayList<Card>());
				dealer.setHand(new ArrayList<Card>());
			}
		}
	}

	private void playGame(Deck deck, BlackjackDealer dealer, Person player) {
		deck.shuffle();
		int numOfCards = 2;
		boolean keepGoing = true;
		dealer.deal(deck, player, numOfCards);
		dealer.deal(deck, dealer, numOfCards);

		System.out.println();
		int dealerScore = dealer.checkSoftAceScore();
		dealer.printHand();

		System.out.println();
		int playerScore = player.checkSoftAceScore();
		player.printHand();
		
		keepGoing = checkWinLose(playerScore, dealerScore, keepGoing);

		if (keepGoing) {
			player.playHand(deck);
			playerScore = player.checkSoftAceScore();

			keepGoing = player.checkBust(playerScore);
			if(!keepGoing) {
				System.out.println("\nBust! You lose.");
			}
			else {
				dealer.playHand(deck);
				dealerScore = dealer.checkSoftAceScore();
				dealer.printHand();

				keepGoing = dealer.checkBust(dealerScore);
				if(!keepGoing) {
					System.out.println("\nDealer busts! You win.");
				}
				else {
					checkWinLose(playerScore, dealerScore);
				}
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

	

	
	

}

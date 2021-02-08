## Blackjack Project

### Description

This project models a game of blackjack where a player can play against a dealer
who will automatically play up until a score of seventeen or higher. Aces start
out with a value of eleven but can be turned to "soft aces" in order to prevent
a bust.


### Technologies

Technologies used in this program:
* Abstract classes and methods
* Class Hierarchies
* Enumeration
* Collections (lists and arrays)
* Try/catches and error handling


### How to Run

Run the application. It will ask you to enter in your name in order to create
a player. Then if neither you nor the dealer were dealt a blackjack, you will
be asked whether you want to hit or stay. You can hit as many times as you want
but if you go over 21 points you will bust and the game is over. Once you are
happy with your score, you can choose to stay in which case the dealer will
take their turn, automatically hitting until they get a score of seventeen or
above. The game will announce a winner if either person busts or who has the
higher score at the end (ties go to the dealer).


### Lessons Learned

For this project I tried to focus on encapsulation and getting the appropriate
methods in the correct classes. I spent extra time playing with shifting the
methods around to various classes to see how that would change the code base.
I also had fun looking into edge cases when I was coding the "soft ace" part
of the program. I originally didn't account for getting a score of seventeen
after making an ace soft which threw my program into an infinite loop. This
definitely shows why having jUnit tests are important and that I should start
incorporating them into my process to do TDD.


# Mastermind Game  

Copyright (c) | Fall 2014 | Shuang Wu | University of Rochester 

Description:

I used AI to let the computer play mastermind. User sets the colors and the pegs, and the computer makes guesses, the user gives feedback and computer uses its logic to get the right answer eventually. My logic is some how like the 5-step algorithm on wikipedia but a little bit different: So for example, for n colors and a positions, I generaye an n^a length arraylist containing all the possible combinations. For example, the right answer is RRR, and I just random generate an guess from my arraylist and show the user(ie.BBB), the user tells me how many black and white pegs(ie.0,0), and I use my guess and comapre them with all the other possible answers from the arraylist, if they don't have the same black and whites(such as ABA,it will be 1 black), they will all be removed from the arraylist. Then from that smaller range of possibilities, I generate another answer and repeat my steps until the last one left in the arraylist is the true answer itself. 

Included Files:
1) This README

2)SAMPLEOUTPUT.txt containing the sample output of this program.

3) mastermind.java:  The interface that will be implemented by algorithm.java

4) algorithm.java:  implements interface mastermind, and contains all the methods (main method) to run this game.


Compilation Instructions: 

Go to terminal

cd Desktop

javac algorithm.java
java algorithm


DO NOT COPY OR USE OUR CODE. THANK YOU.


----------------------------
Sample Output:


Hello, My name is Bonnie and I am going to play Mastermind with you. 
What's your name?
Sabrina
Sabrina, How many colors do you want me to play with? 
Choose a integer between 2 and 6:
4
Sabrina, How many spots do you want?
choose a integer between 2 and 5
4
Color choices for you will be: 
Red Blue Yellow Green 
Sabrina's Choice: 4 colors and 4 spots.

I am not that smart so try not to give me wrong feedback! Thank you!

Wait....


Ready for one game?(input Y or y for yes): 
Y

My guess is:  Green Yellow Green Green 
Hints: Black for right position right color, White for right color wrong position. 
So,How many Black?
3
How many White?
0
0 whites and 3 blacks!

My guess is:  Green Yellow Green Red 
Hints: Black for right position right color, White for right color wrong position. 
So,How many Black?
2
How many White?
0
0 whites and 2 blacks!

My guess is:  Green Blue Green Green 
Hints: Black for right position right color, White for right color wrong position. 
So,How many Black?
3
How many White?
0
0 whites and 3 blacks!

My guess is:  Green Green Green Green 
Hints: Black for right position right color, White for right color wrong position. 
So,How many Black?
4
How many White?
0
I GOT ITTTTTT! YEAH!!!!!
I already won! so no more guesses!
Ready for one game?(input Y or y for yes): 
y

My guess is:  Blue Yellow Red Blue 
Hints: Black for right position right color, White for right color wrong position. 
So,How many Black?
4
How many White?
0
I GOT ITTTTTT! YEAH!!!!!
I already won! so no more guesses!
Ready for one game?(input Y or y for yes): 
n

OK, BYE, Sabrina !!!!

------------------------------
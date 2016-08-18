import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*Name:Shuang Wu
algorithm.java:  implements interface mastermind, and contains all the methods (main method) to run this game.
09/26/2014
 */

public class algorithm implements mastermind {
	public int C;
	public static int P;
	public static int Black;
	public static int White;
	public static ArrayList<String[]> l;
	public static ArrayList<String[]> j;
	public String[] choose;
	public String[] first;
	public String[] second;
	public static ArrayList<String[]> arr;

	public algorithm(String[] c, int p)// constructor takes in one string[] and
										// one int.
	{
		C = c.length;
		P = p;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out
				.println("Hello, My name is Bonnie and I am going to play Mastermind with you. \nWhat's your name?");
		String name = input.nextLine();
		// here I set the limit for my color choice, 2 to 6, while loop that
		// will keep running until user get the correct number in the range.
		System.out
				.println(name
						+ ", How many colors do you want me to play with? \nChoose a integer between 2 and 6:");
		int color = input.nextInt();
		while (color < 2 || color > 6) {
			System.out.print("\nInvalid input(2<=input<=5),input again: ");
			color = input.nextInt();
		}
		// here I set the limit for my # spots choice, 2 to 5, while loop that
		// will keep running until user get the correct number in the range.
		System.out
				.println(name
						+ ", How many spots do you want?\nchoose a integer between 2 and 5");
		int position = input.nextInt();
		while (position < 2 || position > 5) {
			System.out.print("\nInvalid input(2<=input<=5),input again: ");
			position = input.nextInt();
		}
		String[] colorchoice = { "Red", "Blue", "Yellow", "Green", "Orange",
				"Pink" };
		String[] finalcolorchoice = new String[color];
		System.out.println("Color choices for you will be: ");
		for (int b = 0; b < color; b++)// print out the choices for user
		{
			finalcolorchoice[b] = colorchoice[b];
			System.out.print(colorchoice[b] + " ");
		}
		algorithm sm = new algorithm(finalcolorchoice, position);// call the
																	// constructor,
																	// create an
																	// class
																	// object
																	// takin in
																	// the array
																	// and the
																	// int.
 		System.out.println("\n" + name + "'s Choice: " + color + " colors and "
				+ position + " spots.");// remind the user his choice.

		System.out
				.println("\nI am not that smart so try not to give me wrong feedback! Thank you!\n\nWait....\n\n");// remind
																													// the
																													// user
																													// not
																													// to
																													// give
																													// wrong
																													// feedback.

		boolean again = true;
		Scanner input4 = new Scanner(System.in);
		do {// keep this part running until user refuses to restart the game
			int possible = (int) Math.pow(color, position);
			arr = new ArrayList<String[]>(possible);

			String seq = "";
			int count = 0;
			while (count < possible) {
				String[] rands = sm.generateCheckCode(color, position);

				String s = Arrays.toString(rands);
				if (seq.indexOf(s) >= 0) {
					continue;
				}
				arr.add(rands);
				count++;
				seq = seq + s + ",";
			}
			l = new ArrayList<String[]>(possible);
			l = arr;

			Black = 0;// reset black and white
			White = 0;
			System.out.println("Ready for one game?(input Y or y for yes): ");

			String playagain = input4.next();
			int compare = playagain.compareToIgnoreCase("Y");// if user say yes
																// and the black
																// spots is not
																// equal to pegs
																// then start a
																// new game
			if (compare == 0 && (Black != P)) {

				again = true;
				sm.newGame();
			} else {
				again = false;// if user say no, then goodbye, exit
				System.out.println("\nOK, BYE, " + name + " !!!!");
				System.exit(0);
			}
		} while (again != false);
	}

	public String[] generateCheckCode(int c, int p) {// random generate string
														// array, possible
														// combination

		String chars = "";
		for (int a = 1; a <= c; a++) {
			chars = chars + a + "";
		}
		char[] rands = new char[p];
		for (int i = 0; i < p; i++) {
			int rand = (int) (Math.random() * c);
			rands[i] = chars.charAt(rand);
		}
		String[] stringreturn = new String[p];
		for (int i = 0; i < p; i++) {
			stringreturn[i] = rands[i] + "";
		}
		return stringreturn;
	}

	public void response(int cOpW, int cOpO)// takes users feedback and assign
											// them to public instance variables
											// white and black.
	{

		White = cOpW;
		Black = cOpO;
		System.out.println(cOpW + " whites and " + cOpO + " blacks!");
	}

	public void newGame()// without constructing another class object, start a
							// new game.
	{
		l = arr;
		while (Black != P) {
			delete(nextMove());

			if ((Black == P) || (l.size() == 0)) {
				if (Black == P) {
					System.out.println("I already won! so no more guesses!");
					// if I win, I tell them I win.
				} else {

					// if all my possible answers are not working because the
					// user gives me wrong feedback, system exit, game over.
					System.out
							.println("\nNo more guesses(you gave me wrong feedback)!\n BYE!");
					System.exit(0);
				}
			}
		}
	}

	public String[] nextMove() {

		Random rand = new Random();
		int random = rand.nextInt(l.size());// random generate a guess to tell
											// the user
		choose = l.get(random);
		System.out.print("\nMy guess is:  ");
		for (int i = 0; i < P; i++) {
			if (choose[i].equals("1"))// since I store all numbers in my
										// arraylist string array, I have to
										// turn them into colors while printing
										// out.
			{
				System.out.print("Red ");
			}
			if (choose[i].equals("2")) {
				System.out.print("Blue ");
			}
			if (choose[i].equals("3")) {
				System.out.print("Yellow ");
			}
			if (choose[i].equals("4")) {
				System.out.print("Green ");
			}
			if (choose[i].equals("5")) {
				System.out.print("Orange ");
			}
			if (choose[i].equals("6")) {
				System.out.print("Pink ");
			}

		}
		Scanner input2 = new Scanner(System.in);
		System.out
				.println("\nHints: Black for right position right color, White for right color wrong position. \nSo,How many Black?");
		int bb = input2.nextInt();// ask the user for feedback
		System.out.println("How many White?");
		int ww = input2.nextInt();
		if (bb != P) {
			response(ww, bb);// call response method here.
		} else {
			Black = P;
			System.out.println("I GOT ITTTTTT! YEAH!!!!!");// if I get all of
															// the black, I win.
		}
		return choose;// return your guess as a string array

	}

	public void delete(String[] choice)
	// check all of the items from the combination arraylist to your guess, if
	// they get different blacks and whites than what you get from user,then
	// remove them
	{
		for (int e = 0; e < l.size(); e++) {
			if ((checkBlack(l.get(e), choice) != Black || checkWhite(l.get(e),
					choice) != White)) {
				l.set(e, null);
			}
		}
		while (l.remove(null)) {
			l.remove(null);
		}
	}

	public int checkBlack(String[] a, String[] b)// helper method to check how
													// many blacks comparing two
													// string[]
	{
		first = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			first[i] = a[i];
		}
		second = new String[b.length];
		for (int c = 0; c < b.length; c++) {
			second[c] = b[c];
		}

		int countblack = 0;
		for (int i = 0; i < a.length; i++) {
			if (first[i].equals(second[i])) {
				countblack++;
				first[i] = "c";
				second[i] = "d";

			}
		}
		return countblack;
	}

	public int checkWhite(String[] a, String[] b)// helper method counting how
													// many whites comparing two
													// string[]
	{

		int countwhite = 0;
		for (int i = 0; i < a.length; i++) {
			for (int c = 0; c < a.length; c++) {
				if ((first[i].equals(second[c])) && (i != c)) {
					countwhite++;
					first[i] = "a";
					second[c] = "b";

				}
			}
		}
		return countwhite++;
	}

}
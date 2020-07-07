// -------------------------------------------------------
// Assignment 2
// Written by: Lucas catchlove 27145640
// For COMP 248 Section (section U) – Winter 2020
// --------------------------------------------------------
/* This program receives an integer from the user, calculates 
 * its "length" (the number of digits that form the integer) using integer division, 
 * and then prints out a reversed version of the integer using the modulus operator. 
 * Once the reversing process is completed, the user is given the option to quit 
 * the program or enter another integer. 
 */

import java.util.Scanner;

public class IntegerReverser {

	public static void main(String[] args) {
		
		//declaration of variables
		long inputInt, quotient;
		int divisor, intLength;
		boolean exitProgram;
		String exitPrompt;
		
		//initialization of variables
		inputInt=0;
		quotient=0;
		divisor=1000000000;
		intLength=10;
		exitProgram = false; 
		exitPrompt="";
		Scanner keyIn = new Scanner(System.in);
		
		//welcome message :)
		System.out.println("*****************************************\n" +
				"           Integer Reverser           \n" + 
				"*****************************************\n"); 
		
		//a loop that allows for the user to input another integer or exit
		while(exitProgram==false) {

			System.out.print("\nenter integer of length <= 10: ");
			inputInt = keyIn.nextLong();

			//calculates the number of digits in the integer
			while(quotient == 0) {
				quotient = inputInt/divisor;
				
				if(quotient < 1) {
					divisor/=10; 
					--intLength; 
				}
			}

			//prints out the reversed integer
			for(int i=0;i<intLength;i++) {
				long remainder=inputInt%10;
				inputInt-=remainder; 
				inputInt/=10;
				System.out.print(remainder);
			}

			//prompts the user if they would like to quit the program or enter another integer
			System.out.print("\nwould you like to enter another integer? (type \"yes\" or \"no\"): ");
			exitPrompt = keyIn.next();

			
			if(exitPrompt.equalsIgnoreCase("no")) {
				exitProgram = true; 
				System.out.print("\nThank you for using Integer Reverser! Goodbye!");
			}
			//resets variables to default values (and allows for the program to continue running)
			else if(exitPrompt.equalsIgnoreCase("yes")) {
				exitProgram = false; 
				quotient=0;
				divisor=1000000000;
				intLength=10;
			}

		}
		//closes the scanner
		keyIn.close();
	}
}



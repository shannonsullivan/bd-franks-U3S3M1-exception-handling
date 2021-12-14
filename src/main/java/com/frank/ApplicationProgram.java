package com.frank;

import com.frank.types.Bowler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ApplicationProgram {
    // data the program will use
    private static List<Bowler> theBowlers = new ArrayList();

    public static void main(String[] args) {
        System.out.println("Start of application program");

        LoadBowlers();  // call method to instantiate some test data in ArrayList

        System.out.println("-".repeat(80) + "\n--- List of Bowlers ---");
        try {
            for (Bowler aBowler : theBowlers) {
                ShowBowler(aBowler);
            }
        } catch (NullPointerException exceptionObject) {
            System.out.println("Null Pointer Encounter");
            System.out.println("The system messages says: " + exceptionObject.getMessage());
            System.out.println("How we got to the exception: ");
            System.out.println(Arrays.toString(exceptionObject.getStackTrace()));
            System.out.println("Execution continuing......");

        }

        System.out.println("-".repeat(80));
        String response = "";
        boolean shouldLoop = true;
        Scanner theKeyBoard = new Scanner(System.in);

        while (shouldLoop) {
            System.out.println("\nEnter the number of the Bowler you would like displayed");
            System.out.printf("Valid numbers are 1 thru %d\nYour choice: ", theBowlers.size());
            response = theKeyBoard.nextLine();
            if (response.toLowerCase().charAt(0) == 'e') { // any word starting with 'e' will end the program
                shouldLoop = false;
                continue;
            }
            int bowlerNumber = 0;  // define outside block since it's needed in code outside teh try block
            // throw a custom exception if the user enters non-numeric bowler number
            try {   // In case NonNumericException is thrown
                try { // in case NumberFormatException is thrown
                    bowlerNumber = Integer.parseInt(response);  // throw NumberFormatException if not numeric
                } // End of try
                catch (NumberFormatException exceptionObj) {
                    throw new NonNumericInputException("input value '" + response + "' was non-numeric");
                }
            } // end on try
            catch (NonNumericInputException anExceptionObject) {
                System.out.println("Please enter a numeric value in the range indicated");
                continue;
            }
            ShowBowler(theBowlers.get(bowlerNumber - 1));
        } // end of while()

        System.out.println("-".repeat(80));

        System.out.println("End of application program");
        return;
    }

    /**
     * Display data for a Bowler
     */
    private static void ShowBowler(Bowler aBowler) {
        System.out.print(aBowler);
        System.out.printf(" average: %.2f \n", aBowler.getAverage());
    }

    /**
     * Add test data to test program data store
     */
    // Private - Only this class can use it
    private static void LoadBowlers() {
        theBowlers.add(new Bowler("Fred Flintstone", new int[]{230, 260, 275}));
        theBowlers.add(new Bowler("Barney Rubble", new int[]{120, 140, 190}));
        theBowlers.add(new Bowler("The Dude", new int[]{260, 270, 290}));
//        theBowlers.add(new Bowler());
        theBowlers.add(new Bowler("Roy Munson", new int[]{225, 285, 252}));
    }
}

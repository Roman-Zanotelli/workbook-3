package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FamousQuotes {
    static final Scanner scan = new Scanner(System.in);
    static final String[] nietzsche_quotes = {"Without music, life would be a mistake.", "It is not a lack of love, but a lack of friendship that makes unhappy marriages.", "That which does not kill us makes us stronger", "I'm not upset that you lied to me, I'm upset that from now on I can't believe you.", "And those who were seen dancing were thought to be insane by those who could not hear the music.", "t is hard enough to remember my opinions, without also remembering my reasons for them!", "Whoever fights monsters should see to it that in the process he does not become a monster. And if you gaze long enough into an abyss, the abyss will gaze back into you.", "There is always some madness in love. But there is also always some reason in madness.", "You must have chaos within you to give birth to a dancing star.","You have your way. I have my way. As for the right way, the correct way, and the only way, it does not exist."};
    public static void main(String[] args) {
        boolean running = true;
        do {
            System.out.print("Enter a number: ");
            try {
                System.out.println(nietzsche_quotes[scan.nextInt()]);
            } catch (InputMismatchException ignored) {
                scan.nextLine();
                System.out.println("Invalid Input Please Only Enter and Int");
                System.out.print("Would you like to retry? true/false: ");
                while (!scan.hasNextBoolean()){
                    scan.nextLine();
                    System.out.print("Would you like to retry? true/false: ");
                }
                running = scan.nextBoolean();
            } catch (IndexOutOfBoundsException ignored) {
                scan.nextLine();
                System.out.println("Invalid Range Please Only Enter 0 - 9");
                System.out.print("Would you like to retry? true/false: ");
                while (!scan.hasNextBoolean()){
                    scan.nextLine();
                    System.out.print("Would you like to retry? true/false: ");
                }
                running = scan.nextBoolean();
            } catch (Exception ignored) {
                System.out.println("Unexpected Error");
                running = false;
            }
        } while(running);
    }
}

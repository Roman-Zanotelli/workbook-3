package com.pluralsight;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    static Scanner user_scanner = new Scanner(System.in);
    public static void main(String[] args) {
        File target_file;
        do {
            System.out.print("Please Enter File nName");
            String user_input = String.format("src/main/resources/DataFiles/%s",user_scanner.next());
             target_file = new File(user_input);

        }while(alertFileValidity(target_file.canRead())); //checks to make sure the fire exists

        try {
            FileInputStream fileInStream = new FileInputStream(target_file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean alertFileValidity(boolean canRead){
        return canRead;
    }
}

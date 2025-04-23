package com.pluralsight;


import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SearchEngineLogger {
    static Logger logger;
    public static void main(String[] args) {
        logger = Logger.getLogger(SearchEngineLogger.class.getName()); //gets the logger for this class
        try {
            Handler write_handler = new FileHandler("src/main/resources/logs.txt");
            write_handler.setFormatter(new MyFormatter());
            logger.addHandler(write_handler); //tries to add a file handler to write the log file
        } catch (IOException e) {
            System.out.println("Could Not Initialize File Handler! Existing Early");
            System.exit(1);
        }
        run();
        System.exit(0);
    }

    static Scanner scanner;
    private static void run(){
        logger.info("START PROGRAM");
        scanner = new Scanner(System.in);
        logger.info("Scanner Setup");
        while (true){
            System.out.print("Please Select an Option");
            String selection = scanner.nextLine();
            switch (selection){
                case "a":
                    launch();
                    break;
                case "b":
                    search();
                    break;
                case "c":
                    return;
            }
        }
    }
    private static void launch(){
        logger.info("Launch Selected");
    }
    private static void search(){
        logger.info("Search Selected");
    }
}

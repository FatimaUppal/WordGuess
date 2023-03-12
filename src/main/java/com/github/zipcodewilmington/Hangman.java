package com.github.zipcodewilmington;
//Fatima Uppal

import java.security.Key;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    public static Scanner scanner = new Scanner(System.in); // scanner ro read through user input

    static String[] word = wordGenerator(); // new string array for the current word being guessed

    static int turn = 0; // # of attempts

    static boolean run = true; // game on/off

    static String currentStatus = makeWord(word); // so suer can see which letter they have guessed




    public static void main(String[] args) {
        //turning game on
        while (run) {
            System.out.println("Guess a letter:"); // asking user for guess
            String userInput = scanner.nextLine(); // string to store user input
            turn++; // counts number of turns

            whatIsWord(word);
            checkGuess(userInput);
            System.out.println(currentStatus); // current status of board will be printed out
        }
    }

    public static void checkWinOrLose() { // checks the winning/ losing conditions
        if (!currentStatus.contains("_")) {
            System.out.println("You Win!");
            run = false;
        } else if (turn > word.length - 1) {
            System.out.println("You Lose!");
            run = false;
        }
    }

    public static void checkGuess(String guess) {
        for (int i = 0; i < word.length; i++) { // iterates through array to see if char matches user input
            if (guess.equals(word[i])) { // checks if user input matches
                if (i == 0) { // checks if first letter matches
                    currentStatus = guess.charAt(0) + currentStatus.substring(i + 1);
                } else if (i > 0 && i != word.length - 1) { //checks if middle character matches
                    currentStatus = currentStatus.substring(0, i) + guess.charAt(0) + currentStatus.substring(i + 1);
                } else if (i == word.length - 1) { // checks if last letter matches
                    currentStatus = currentStatus.substring(0, i) + guess.charAt(0);
                }
            }
        }
    }
    public static String [] wordGenerator(){ // generates words to be guesses
        String [] wordList = {"Cat", "Dog", "Fly","Bug"}; //possible words
        String word = wordList[(int)(Math.random()*wordList.length)]; // randomly selects a word from array
        String [] generatedWord= word.split("");// each word in array is converted to an array
        return generatedWord;
    }
    public static String makeWord(String[]word){ // creates new board based on the length of the word
        String newBoard="";
        for (int i = 0; i< word.length; i++){
                newBoard+= "_";
            }
            return newBoard;
        }
    public static void whatIsWord(String[]array){ // tells what the word is but doest have to be used during game
        String answer="";
        for (int i = 0; i < array.length; i++) {
            String newArray= array[i].toString();
            answer+= newArray;
        }
           System.out.println(answer);
        }
    }





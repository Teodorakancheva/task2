package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter string ");
        String text = scanner.nextLine();
        boolean exit = isValidExpression(text);

        if(exit){
            System.out.printf("Your string is valid. Result is: %b",exit);
        }else{
            System.out.printf("Sorry your string is not valid. Result is: %b",exit);
        }

    }

    private static boolean isValidExpression(String text) {

        ArrayDeque<Character> alphabetic = new ArrayDeque<>();
        boolean result = true;
        if(text.length() %2 == 1){
            result = false;
            return result;
        }else {
            for (int i = 0; i < text.length(); i++) {
                char letter = text.charAt(i);
                if (text.charAt(0) != 'A' && text.charAt(0) != 'B' && text.charAt(0) != 'C') {
                    result = false;
                    break;
                }
                switch (letter) {
                    case 'A':
                        alphabetic.push('A');
                        break;
                    case 'B':
                        alphabetic.push('B');
                        break;
                    case 'C':
                        alphabetic.push('C');
                        break;
                    case 'a':
                        result = changeLetter(alphabetic, 'a');
                        break;
                    case 'b':
                        result = changeLetter(alphabetic, 'b');
                        break;
                    case 'c':
                        result = changeLetter(alphabetic, 'c');
                        break;
                }
                if (!result) {
                    break;
                }
            }
        }
        return  result;
    }

    private static boolean changeLetter(ArrayDeque<Character> alphabetic, char letter) {
          if(!alphabetic.isEmpty()) {
              char symbol = alphabetic.peek();
              letter = Character.toUpperCase(letter);
              if (symbol == letter) {
                  alphabetic.pop();
                  return true;
              }
          }
            return false;
    }

}

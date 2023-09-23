package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameConsole {

    public static void printGameState(BaseEntity[][] board){
        String[] lines = new String[board.length];
        Arrays.fill(lines, "");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                lines[i] += board[i][j].getIcon()+ " ";
            }
        }

        printCenterAlignedLines(lines);
    }

    public static void printCenterAlignedLines(String[] lines) {
        List<String[]> wordsList = new ArrayList<>();
        int maxWords = 0;

        for (String line : lines) {
            String[] words = line.split(" ");
            wordsList.add(words);
            maxWords = Math.max(maxWords, words.length);
        }

        // Print the center-aligned lines
        for (int i = 0; i < maxWords; i++) {
            for (String[] words : wordsList) {
                if (i < words.length) {
                    int spaces = 15 - words[i].length(); // Adjust the width as needed
                    int leftSpaces = spaces / 2;
                    int rightSpaces = spaces - leftSpaces;
                    printSpaces(leftSpaces);
                    System.out.print(words[i]);
                    printSpaces(rightSpaces);
                } else {
                    printSpaces(15); // Print empty spaces if there are no more words in this column
                }
            }
            System.out.println("\n");
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void clearConsole()  {
        for (int i = 0; i < 500; i++) {
            System.out.println();
        }
    }




}

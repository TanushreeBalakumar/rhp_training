import java.util.*;

public class Longestcommonsubsequence {
    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        String firstWord = inputReader.next();
        String secondWord = inputReader.next();

        int firstLength = firstWord.length();
        int secondLength = secondWord.length();

        int[][] lcsTable = new int[firstLength + 1][secondLength + 1];

        for (int rowIndex = 1; rowIndex <= firstLength; rowIndex++) {
            for (int colIndex = 1; colIndex <= secondLength; colIndex++) {

                if (firstWord.charAt(rowIndex - 1) == secondWord.charAt(colIndex - 1)) {
                    lcsTable[rowIndex][colIndex] =
                            lcsTable[rowIndex - 1][colIndex - 1] + 1;
                } else {
                    lcsTable[rowIndex][colIndex] =
                            Math.max(lcsTable[rowIndex - 1][colIndex],
                                     lcsTable[rowIndex][colIndex - 1]);
                }
            }
        }

        System.out.println(lcsTable[firstLength][secondLength]);
    }
}
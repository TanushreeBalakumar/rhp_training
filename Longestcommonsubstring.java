import java.util.*;

public class Longestcommonsubstring {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String firstString = input.next();
        String secondString = input.next();

        int lenFirst = firstString.length();
        int lenSecond = secondString.length();

        int[][] table = new int[lenFirst + 1][lenSecond + 1];
        int longestLength = 0;

        for (int row = 1; row <= lenFirst; row++) {
            for (int col = 1; col <= lenSecond; col++) {

                if (firstString.charAt(row - 1) == secondString.charAt(col - 1)) {
                    table[row][col] = table[row - 1][col - 1] + 1;
                    longestLength = Math.max(longestLength, table[row][col]);
                } else {
                    table[row][col] = 0;
                }
            }
        }

        System.out.println(longestLength);
    }
}
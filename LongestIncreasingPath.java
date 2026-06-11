class Solution {

    final private int[][] directions = {
        {1, 0},   
        {-1, 0},  
        {0, 1},   
        {0, -1} 
    };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] memo = new int[rows][cols];
        int longest = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                longest = Math.max(longest, dfs(matrix, r, c, memo));
            }
        }

        return longest;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxLength = 1;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < matrix.length
                    && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[row][col]) {

                maxLength = Math.max(
                        maxLength,
                        1 + dfs(matrix, newRow, newCol, memo)
                );
            }
        }

        memo[row][col] = maxLength;
        return maxLength;
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                int current = matrix[top][i];
                result.add(current);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                int current = matrix[i][right];
                result.add(current);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    int current = matrix[bottom][i];
                    result.add(current);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    int current = matrix[i][left];
                    result.add(current);
                }

                left++;
            }
        }

        return result;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){return image;}
        changeColor(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void changeColor(int[][] image, int i, int j, int color, int orignal) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {return;}
        if (image[i][j] == color || image[i][j] != orignal) {return;}

        image[i][j] = color;
        changeColor(image, i + 1, j, color, orignal);
        changeColor(image, i - 1, j, color, orignal);
        changeColor(image, i, j + 1, color, orignal);
        changeColor(image, i, j - 1, color, orignal);
    }
}
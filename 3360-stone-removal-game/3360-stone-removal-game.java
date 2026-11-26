class Solution {
    public boolean canAliceWin(int n) {
        int turn = 0;
        int move = 10;

        while (n >= move) {
            n -= move;
            move--;
            turn++;
        }

        return (turn%2 != 0);
    }
}

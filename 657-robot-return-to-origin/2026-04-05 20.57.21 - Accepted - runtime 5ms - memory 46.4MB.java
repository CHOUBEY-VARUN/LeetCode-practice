class Solution {
    public boolean judgeCircle(String moves) {
        int[] position = {0,0};
        for(char c : moves.toCharArray()){
            if(c=='U'){position[0]++;}
            if(c=='D'){position[0]--;}
            if(c=='L'){position[1]++;}
            if(c=='R'){position[1]--;}
        }
        return position[0] == 0 && position[1] == 0;
    }
}
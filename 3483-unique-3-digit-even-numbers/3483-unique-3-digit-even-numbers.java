class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int digit : digits){freq[digit]++;}
        int count = 0;

        for(int digit = 0; digit<10; digit++){
            if(digit % 2 == 0){
                if(freq[digit] > 0){
                    freq[digit]--;
                    for(int i = 1; i<10; i++){
                        if(freq[i] > 0){
                            freq[i]--;
                            for(int j = 0; j<10; j++){
                                if(freq[j] > 0){
                                    count++;
                                }
                            }
                            freq[i]++;
                        }
                    }
                    freq[digit]++;
                }
            }
        }
        return count;
    }
}
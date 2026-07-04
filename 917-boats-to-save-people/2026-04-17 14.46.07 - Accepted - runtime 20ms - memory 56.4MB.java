class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length - 1;
        int count = 0;
        while(heavy >= light){
            if((people[heavy] + people[light]) <= limit){
                light++;
            }
            count++;
            heavy--;
        }
        return count;
    }
}
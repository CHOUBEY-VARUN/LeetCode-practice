class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Map<Integer,Integer> race = new HashMap<>();
        int[] result = new int[friends.length];
        for(int i = 0; i<friends.length; i++){
            int search = friends[i];
            int j = 0;
            while(order[j] != search){
                j++;
            }
            race.put(j,search);
        }
        for(int i = 0; i<result.length; i++){
            result[i] = race.get(Collections.min(race.keySet()));
            race.remove(Collections.min(race.keySet()));
        }
        return result;
    }
}
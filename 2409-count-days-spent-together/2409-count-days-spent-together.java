class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrive = getDayNum(arriveAlice);
        int aliceLeave = getDayNum(leaveAlice);
        
        int bobArrive = getDayNum(arriveBob);
        int bobLeave = getDayNum(leaveBob);

        int start = Math.max(aliceArrive,bobArrive);
        int end = Math.min(aliceLeave,bobLeave);

        if(start > end)return 0;

        return (end-start)+1;
    }

    public int getDayNum(String date){
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3,5));
        int days = 0;

        for(int i = 0; i<month-1; i++){
            days += daysInMonth[i];
        }

        return days+day;
    }
}
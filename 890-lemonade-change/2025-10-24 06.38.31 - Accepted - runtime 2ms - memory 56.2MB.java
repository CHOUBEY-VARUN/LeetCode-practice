class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        boolean res = false;
        for(int bill : bills){
            if(bill == 5){five++; res = true;}
            else if(five > 0 && bill == 10){five --; ten++; res = true;}
            else if(five > 0 && ten > 0){five--;ten--;res = true;}
            else if(five > 2 && bill == 20){five -= 3; res = true;}
            else{return false;}
        }
        return res;
    }
}
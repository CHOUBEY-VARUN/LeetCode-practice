class Solution {
    public static int sum(int num1, int num2) {
        int output = num1+num2;
        System.out.print(output);
        return output;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sum(num1,num2);
    }
}
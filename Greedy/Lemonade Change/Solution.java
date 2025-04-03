class Solution{
    public static boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fives++;
            }else if(bills[i]==10){
                if(fives==0) return false;
                else{
                    tens++;
                    fives--;
                }
            }else{
                if(tens!=0 && fives!=0){
                    tens--;
                    fives--;
                }else if(fives>=3){
                    fives-=3;
                }else return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
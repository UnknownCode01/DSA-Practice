import java.util.*;

class Pair {
    int index;
    int value;

    Pair(int i, int v) {
        this.index = i;
        this.value = v;
    }
}

class StockSpanner {
    Stack<Pair> st = new Stack<>();
    int index = -1;

    public StockSpanner() {
        st.clear();
        index = -1;
    }

    public int next(int price) {
        index++;
        while(!st.isEmpty() && st.peek().value<price){
            st.pop();
        }
        int ans = index - (st.isEmpty()?-1:st.peek().index);
        st.push(new Pair(index,price));
        return ans;
    }
}

class Solution {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.print(obj.next(100)+" ");
        System.out.print(obj.next(80)+" ");
        System.out.print(obj.next(60)+" ");
        System.out.print(obj.next(70)+" ");
        System.out.print(obj.next(60)+" ");
        System.out.print(obj.next(75)+" ");
        System.out.print(obj.next(85)+" ");
    }
}
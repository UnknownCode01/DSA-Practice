import java.util.*;
class Solution{
    static class Row implements Comparable<Row>{
        int soldier;
        int index;
        Row(int soldier, int index){
            this.soldier=soldier;
            this.index=index;
        }
        @Override
        public int compareTo(Row r){
            if(this.soldier==r.soldier){
                return this.index-r.index;
            }
            else{
                return this.soldier-r.soldier;
            }
        }
    }
    public static void main(String[] args){
        int[][] army={{1,0,0,0},
                  {1,1,1,1},
                  {1,0,0,0},
                  {1,0,0,0}};
        int k=2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int count=0;
        for(int i=0;i<army.length;i++){
            count=0;
            for(int j=0;j<army[i].length;j++){
                count+=army[i][j];
            }
            pq.add(new Row(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("r"+pq.remove().index);
        }
    }
}
import java.util.*;
class Solution{
    static class Car implements Comparable<Car>{
        String name;
        int x;
        int y;
        int disSq;
        Car(int ni, int x, int y){
            this.name = "c"+ni;
            this.x = x;
            this.y = y;
            this.disSq = x*x+y*y;
        }
        @Override
        public int compareTo(Car c){
            return this.disSq-c.disSq;
        }
    }
    public static void main(String[] args){
        int[][] pts={{1,3,3},{2,5,-1},{3,-2,4}};
        int k=2;
        PriorityQueue<Car> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            pq.add(new Car(pts[i][0],pts[i][1],pts[i][2]));
        }
        for(int i=0;i<k;i++){
            System.out.println(pq.remove().name);
        }
    }
}
import java.util.*;
class Solution{
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s){
            return this.rank-s.rank;
        }
    }
    public static void main(String[] args){
        PriorityQueue<Student> pq = new PriorityQueue<>();
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Brijit",1));
        pq.add(new Student("Samridhya",3));
        pq.add(new Student("Sayan",2));
        pq.add(new Student("Saswata",5));
        pq.add(new Student("Sandipan",4));
        // System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}   
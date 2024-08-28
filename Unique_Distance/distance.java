// In this program I am finding unique distance covered by many people


import java.util.*;
public class distance implements Comparable<distance>{
    private int d1;
    private int d2;

    public distance(int d1, int d2) {
        this.d1 = d1;
        this.d2 = d2;
    }
    public int compareTo(distance other) {
        return Integer.compare(this.d1, other.d1);
    }

  public static void main(String[] args) {
    List<distance> d = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //n->no of person
    int h = sc.nextInt(); //h->no of house every person is covering (by Default 2)
    int d11,d22;
    for(int i=0;i<n;i++){
      d11 = sc.nextInt();
      d22 = sc.nextInt();
      d.add(new distance(d11,d22));
    }
    Collections.sort(d);  //sort based upon starting position
    int ud = 0; //Unique Distance
    int t1=0; //t1,t2->temp variable to compare with previous person's ending position
    int t2=0;
    for (distance dd : d) {
      if(dd.d1<t2){ //Intersection distance covered by more than 1 person
        ud-=t2-dd.d1;
      }
        ud+=Math.max(dd.d2,t2)-dd.d1; //as 2nd distance can be a subset of first
        t1=dd.d1;
        t2=dd.d2;
    }
    System.out.print(ud);
  }
}
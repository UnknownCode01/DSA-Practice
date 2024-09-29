import java.util.*;
class Job{
    int deadLine;
    int profit;
    int id;
    Job(int id, int deadLine, int profit){
        this.id = id;
        this.profit = profit;
        this.deadLine = deadLine;
    }
}
class Solution{
    public static void main(String[] args){
        int[][] jobsInfo={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs  = new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        jobs.sort((a,b)->Double.compare(b.profit,a.profit));

        int time = 0;
        ArrayList<Integer> seq  = new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadLine>time){
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs = "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}
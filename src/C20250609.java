import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C20250609 {

    /**
     *하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 이 문제에서는 우선순위 디스크 컨트롤러라는 가상의 장치를 이용한다고 가정합니다. 우선순위 디스크 컨트롤러는 다음과 같이 동작합니다.
     *
     * 어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
     * 디스크 컨트롤러는 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
     * 하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
     * 하드디스크가 어떤 작업을 마치는 시점과 다른 작업 요청이 들어오는 시점이 겹친다면 하드디스크가 작업을 마치자마자 디스크 컨트롤러는 요청이 들어온 작업을 대기 큐에 저장한 뒤 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 또, 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작할 수 있습니다. 이 과정에서 걸리는 시간은 없다고 가정합니다.
     */


    public static void main(String[] args) {

        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {3, 5}};


        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs,Comparator.comparingInt(a->a[0]));

        PriorityQueue<Job> jobList = new PriorityQueue<>();

        int nowTime = 0;
        int count = 0;
        int jobIndex = 0;

        while(count < jobs.length){


            while(jobIndex<jobs.length && jobs[jobIndex][0]<=nowTime){
                jobList.add(new Job(jobIndex,jobs[jobIndex][0],jobs[jobIndex][1]));
                jobIndex++;
            }

            if(!jobList.isEmpty()){
                Job job = jobList.poll();

                nowTime = Math.max(nowTime,job.requestTime);
                nowTime += job.execTime;
                answer += nowTime - job.requestTime;
                count++;




            }else{
                nowTime++;
            }




        }


        return answer/jobs.length;
    }

    static class Job implements Comparable<Job> {
        int id;
        int requestTime;
        int execTime;

        public Job(int id,int requestTime, int execTime){
            this.id=id;
            this.requestTime = requestTime;
            this.execTime = execTime;
        }

        @Override
        public int compareTo(Job o) {
            if (this.execTime != o.execTime) {
                return Integer.compare(this.execTime, o.execTime);
            } else if (this.requestTime != o.requestTime) {
                return Integer.compare(this.requestTime, o.requestTime);
            } else {
                return Integer.compare(this.id, o.id);
            }
        }
    }

}

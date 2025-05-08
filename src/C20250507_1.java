import java.util.HashMap;

public class C20250507_1 {

    public static void main(String[] args) {

        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};


        System.out.println(solution(participant,completion));
    }


    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> participantList = new HashMap<>();

        for(String part : participant){
            participantList.put(part,participantList.getOrDefault(part,0)+1);
        }


        for(int i=0; i<completion.length; i++){
            Integer k = participantList.get(completion[i]);
            if(k>1){
                participantList.put(completion[i],k-1);
            }else{
                participantList.remove(completion[i]);
            }
        }

        return participantList.keySet().iterator().next();

    }

}

package practice;

import java.util.*;

public class C20250421 {
    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        solution(begin, target, words);



    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        if(!Arrays.asList(words).contains(target)){
            return 0;
        }

        Queue<HashMap<String,String>> queue = new ArrayDeque<>();
        List<String> temp = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        HashMap<String,String> startNode = new HashMap<>();
        startNode.put("depth","0");
        startNode.put("word", begin);

        queue.add(startNode);

        answer = bfs(queue, words, target, begin);

System.out.println("answer = " + ++answer);

        return answer+1;
    }

    private static boolean diffcount(String base, String target){
        int diff = 0;
        for(int i=0; i< base.length(); i++){
            if(base.charAt(i) != target.charAt(i)){
                diff++;
            }
        }
        if(diff>1){
            return false;
        }else{
            return true;
        }
    }

    private static int bfs(Queue<HashMap<String,String>> queue, String[] words, String target, String begin){

        int step = 0;
        boolean found = false;

        List<Integer> score = new ArrayList<>();

        List<String> visited = new ArrayList<>();

        while(queue.size() > 0){

            HashMap<String,String> temp = queue.poll();
            int depth = Integer.parseInt(temp.get("depth"));
            if(diffcount(temp.get("word"), target)){
                found = true;
                return Integer.parseInt(temp.get("depth"));
            }

            for(String word : words){
                if(visited.contains(word)){
                    continue;
                }
                if(diffcount(temp.get("word"), word)){
                    visited.add(word);
                    HashMap<String,String> newNode = new HashMap<>();
                    newNode.put("depth", String.valueOf(++depth));
                    newNode.put("word", word);
                    queue.add(newNode);
                }
            }
        }

        return 0;

    }

}
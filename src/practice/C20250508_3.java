package practice;

import java.util.*;
import java.util.stream.Collectors;

public class C20250508_3 {


    public static void main(String[] args) {

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        for(int i : solution(genres,plays)){
            System.out.println(i);
        }

        //System.out.println(solution(genres,plays));

    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String,Integer> musicMap = new HashMap<>();
        for(int i =0; i<genres.length; i++){
            musicMap.put(genres[i],musicMap.getOrDefault(genres[i],0)+plays[i]);
        }

        List<Map.Entry<String,Integer>> sortedMusicMap = musicMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());


        for(Map.Entry<String,Integer> music : sortedMusicMap){
            String genre = music.getKey();
            HashMap<Integer,Integer> rank = new HashMap<>();
            for(int i=0;i<genres.length;i++){

                if(genres[i].equals(genre)){

                    rank.put(i,plays[i]);


                }
            }

            List<Map.Entry<Integer,Integer>> sortRank = rank.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());

            for(int j=0; j<sortRank.size();j++){
                answer.add(sortRank.get(j).getKey());
                if(j==1){
                    break;
                }
            }

        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}

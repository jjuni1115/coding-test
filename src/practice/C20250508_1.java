package practice;

import java.util.HashSet;
import java.util.List;

public class C20250508_1 {


    public static void main(String[] args) {


        String[] phone_book = new String[]{"123", "456", "789"};
        System.out.println(solution(phone_book));

    }


    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> phoneSet = new HashSet<>(List.of(phone_book));


        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (phoneSet.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }

}

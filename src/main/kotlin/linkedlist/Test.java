package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    void solution(String digit, String num){

        int lastIndex = 0;
        int newIndex = 0;
        int time = 0;
        char[] digits = digit.toCharArray();
        for (int i = 0; i <digits.length; i ++){
            newIndex = new String(digits).indexOf(digits[i]);
            time += Math.abs(newIndex - lastIndex);
            lastIndex = newIndex;
        }
        return ;
    }


    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int ans = -1;
        while (i < j) {
            if (A[i] + A[j] >= K) {
                j--;
            } else {
                ans = Math.max(ans, A[i] + A[j]);
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Test().solution("0123456789", "210");
    }
}



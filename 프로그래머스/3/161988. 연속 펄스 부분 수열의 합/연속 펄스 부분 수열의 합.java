import java.util.*;

class Solution {
    public long solution(int[] sequence) {
         long answer = Long.MIN_VALUE; // 최소값으로 초기화
    int cnt = sequence.length;

    long s1 = 0, s2 = 0;
    long s1_min = 0, s2_min = 0;
    int p = 1;

    for (int i = 0; i < cnt; i++) {
        s1 += sequence[i] * p;
        s2 += sequence[i] * (-1 * p);

        answer = Math.max(answer, Math.max(s1 - s1_min, s2 - s2_min));

        s1_min = Math.min(s1_min, s1);
        s2_min = Math.min(s2_min, s2);

        p *= -1;
    }
    return answer;
    }
}
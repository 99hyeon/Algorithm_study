import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }

        if (wantMap.equals(windowMap)) {
            answer++;
        }

        for (int i = 1; i <= discount.length - 10; i++) {
            String removeItem = discount[i - 1];
            windowMap.put(removeItem, windowMap.get(removeItem) - 1);
            if (windowMap.get(removeItem) == 0) {
                windowMap.remove(removeItem);
            }

            String addItem = discount[i + 9];
            windowMap.put(addItem, windowMap.getOrDefault(addItem, 0) + 1);

            if (wantMap.equals(windowMap)) {
                answer++;
            }
        }

        return answer;
    }
}

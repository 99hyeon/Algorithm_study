import java.util.*;

class Solution {
	public String[] solution(String[] strings, int n) {
		// comparator : 두 요소 비교하여 1, 0, -1 반환
		Arrays.sort(strings, (s1, s2) -> {
			if (s1.charAt(n) != s2.charAt(n)) {
				return Character.compare(s1.charAt(n), s2.charAt(n));
			}
			return s1.compareTo(s2);
		});
		return strings;
	}
}
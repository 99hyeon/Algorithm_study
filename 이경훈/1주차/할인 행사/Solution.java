import java.util.*;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {

		int answer = 0;
		// 비교를 위한 want와 number 을 Map으로
		Map<String, Integer> wantMap = new HashMap<>();

		for (int i = 0; i < want.length ; i++) {
			wantMap.put(want[i], number[i]);
		}

		// 10일간의 할인 개수를 저장할 Map 생성 및 초기화
		Map<String, Integer> discountMap = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
		}

		// 비교 수행후 윈도우를 뒤로 밀어가며 다음 값 재계산
		// <= 조건으로 수행하면 추가 계산 필요 없나?
		for (int i = 10; i < discount.length; i++) {
			if (isMatch(wantMap,discountMap)){
				answer ++;
			}

			String prevItem = discount[i-10];
			discountMap.put(prevItem, discountMap.get(prevItem) - 1);

			String nextItem = discount[i];
			discountMap.put(nextItem, discountMap.getOrDefault(nextItem, 0) + 1);
		}

		// 비교 수행을 먼저 하는식으로 구현하여 마지막 10일이 반영되지 않아 추가 계산 1회
		if (isMatch(wantMap,discountMap)){
			answer ++;
		}

		return answer;
	}

	// 일치 비교 함수
	private boolean isMatch (Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
		for(String key : wantMap.keySet()) {
			if (discountMap.getOrDefault(key,0) != wantMap.get(key)){
				return false;
			}
		}
		return true;
	}
}
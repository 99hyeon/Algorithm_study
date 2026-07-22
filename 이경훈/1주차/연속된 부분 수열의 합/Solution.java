import java.util.*;

class Solution {
	public int[] solution(int[] sequence, int k) {
		int left = 0;
		int right = 0;
		int sum = sequence[0];

		int minCount = Integer.MAX_VALUE;
		int answerLeft = 0;
		int answerRight = 0;

		while (left <= right && right < sequence.length) {
			if (sum == k) { // k와 총 합이 일치하는 경우
				int curCount = right-left+1;

				// 가장 짧은 길이의 정답인지 판단 후 갱신
				if (curCount < minCount) {
					answerLeft = left;
					answerRight = right;
					minCount = curCount;
				}

				sum -= sequence[left++];
			} else if (sum < k) { // 합이 작으면 right를 증가시켜 총 합을 증가시킴
				right++;
				// right가 배열의 끝에 위치하여 범위를 초과하면 종료
				if (right < sequence.length) {
					sum += sequence[right];
				}
			} else { // 합이 크면 left를 증가시켜 총 합을 줄여서 정답에 가까워 지게 함
				sum -= sequence[left++];
			}
		}

		return new int[] {answerLeft, answerRight};
	}
}
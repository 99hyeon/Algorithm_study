import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();

		// 첫 작업 추가
		int count = 1;
		int prevProgress = (100 - progresses[0] + speeds[0] - 1) / speeds[0];

		for(int i=1;i<progresses.length;i++){
			 int currProgress = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

			 // 작업 시간이 기준일보다 적거나 같으면 함께 배포
			 if (currProgress <= prevProgress) {
				 count++;
			 } else {
			 // 작업 시간이 기준일보다 길면 다음 배포의 기준일이 됨
				 list.add(count);
				 count = 1;
				 prevProgress = currProgress;
			 }
		}

		list.add(count);

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Integer> wantHash = new HashMap<>();
		for (int i = 0; i < want.length; i++){
			wantHash.put(want[i],number[i]);
		}
		for (int j = 0; j < 10; j++){
			wantHash.computeIfPresent(discount[j], (key, value) -> value - 1);
		}
		for (int k = 0; k <= discount.length-10; k++){
			if (isZero(wantHash)){
                answer++;
			}
			if (k < discount.length-10){
				wantHash.computeIfPresent(discount[k], (key, value) -> value + 1);
                wantHash.computeIfPresent(discount[k+10], (key, value) -> value - 1);
			}
		}
		return answer;
	}
    
    public boolean isZero(Map<String, Integer> map){
        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}

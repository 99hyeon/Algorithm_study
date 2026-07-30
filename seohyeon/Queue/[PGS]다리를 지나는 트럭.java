import java.util.*;

class Solution {
  /**
   bridge_length : 다리 길이
   weight : 다리가 버틸 수 있는 무게
   truck_weights : 트럭 무게 값 배열
   */
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> queue = new LinkedList<>();

    int time = 0;
    for(int truckWeight : truck_weights){
      //트럭이 다리 위로 올라갈 때까지 무한반복
      while(true){
        if(queue.isEmpty()){
          queue.add(truckWeight);
          weight -= truckWeight;
          time++;
          break;
        } else {
          if(queue.size() == bridge_length){
            weight += queue.poll();
          }

          if(weight < truckWeight){
            queue.add(0);
            time++;
          }else{
            weight -= truckWeight;
            queue.add(truckWeight);
            time++;
            break;
          }

        }
      }
    }

    return time + bridge_length;
  }
}
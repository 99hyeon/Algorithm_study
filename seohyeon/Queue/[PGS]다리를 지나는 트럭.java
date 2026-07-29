// [PGS] 다리를 지나는 트럭 / 레벨2 / 60분 / 박서현

/**
 개요

 - 문제 : 모든 트럭이 일정한 길이의 다리를 지나는 최소 시간 구하기
 (문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java)
 - 핵심 요구사항:
 - 트럭은 1초에 한 대씩 다리에 진입 가능
 - 트럭 한 대가 다리를 완전히 걸리는 시간 = 다리 길이(bridge_length)
 - 다리 위에 올라가 있는 트럭의 무게 합은 weight 이하여야 함

 해결방식
 큐를 이용해 다리에 진입한 값을 관리한다.
 - 트럭이 진입한 경우 : 큐에 해당 트럭의 무게 저장
 - 트럭이 진입하지 못한 경우 : 큐에 0 저장
 이때 0의 값은 실제 트럭이 아닌 무게 제한으로 인해 새로운 트럭이 진입하지 못한 1초를 나타내기 위해 사용한다.

 1. 큐의 크기가 다리길이와 같으면 큐의 맨 앞의 값 제거
 2. 다음 트럭이 다리에 진입할 수 있는지 확인
 진입할 수 있는 경우
 - 큐에 트럭 무게 추가
 - 다리의 남은 허용 무게에서 트럭의 무게 제외
 - 시간 1초 증가
 진입할 수 없는 경우
 - 큐에 0 추가
 - 시간 1초 증가
 현재 트럭이 진입할 수 있을 때까지 위 과정 반복

 위 과정을 수행하면 최종 time 값에는 마지막 트럭이 다리위로 올라간 시간이 저장되어있다. 해당 트럭이 다리를 빠져나가는 시간은 다리위에 올라간 시간 + 다리길이 시간이기 때문에 최종적으로 time + 다리길이 값을 return 한다.
 */

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
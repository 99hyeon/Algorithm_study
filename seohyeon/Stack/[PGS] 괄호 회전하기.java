import java.util.*;

class Solution {
  public int solution(String s) {
    int answer = 0;

    for(int i = 0; i < s.length(); i++){
      Stack<Character> stack = new Stack<>();
      for(int j = 0; j < s.length(); j++){
        int current = (i + j) % s.length();
        char currentChar = s.charAt(current);

        if(!stack.isEmpty()){
          if(stack.peek() == '(' && currentChar ==')'){
            stack.pop();
            continue;
          }
          if(stack.peek() == '[' && currentChar ==']'){
            stack.pop();
            continue;
          }
          if(stack.peek() == '{' && currentChar =='}'){
            stack.pop();
            continue;
          }
          stack.push(currentChar);

        }else{
          stack.push(currentChar);
        }
      }

      if(stack.isEmpty()) answer++;
    }

    return answer;
  }
}
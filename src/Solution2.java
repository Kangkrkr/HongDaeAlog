import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

// 모의고사
// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
public class Solution2 {

	public static void main(String[] args) {

		int answers[] = {1, 4, 3, 1, 2, 5};
		int[] result = solution(answers);
		
		System.out.println("-------------");
		System.out.println("정답자출력");
		System.out.println("-------------");
        for(int an : result) {
        	System.out.println(an);
        }
        System.out.println("-------------");
        
	}

	public static int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        Person personA = new PersonA();
        Person personB = new PersonB();
        Person personC = new PersonC();
        
        for (int i = 0; i < answers.length; i++) {
        	int rightAnswer = answers[i];
        	
        	int answerOfA = personA.getAnswerIntoNth(i);
        	int answerOfB = personB.getAnswerIntoNth(i);
        	int answerOfC = personC.getAnswerIntoNth(i);
        	
        	if (rightAnswer == answerOfA) answer[0]++;
        	if (rightAnswer == answerOfB) answer[1]++;
        	if (rightAnswer == answerOfC) answer[2]++;
        }
        
        int max = IntStream.of(answer).max().getAsInt();
        
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= answer.length; i++) {
        	if (answer[i-1] >= max) {
        		Map<String, Object> resultMap = new HashMap<String, Object>();
            	resultMap.put("identify", i);
            	resultMap.put("answerCnt", answer[i-1]);
            	
            	resultList.add(resultMap);
        	}
        }
        
        Collections.sort(resultList, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				return (int)o2.get("answerCnt") - (int)o1.get("answerCnt");
			}
		});
        
        int[] result = resultList.stream()
        		  .map(map -> {
        			  return map;
        		  })
        		  .filter(item -> {
        			  return (int)item.get("answerCnt") > 0;
        		  })
        		  .mapToInt(filtered -> (int)filtered.get("identify"))
        		  .toArray();
        
        return result;
    }
}

// 첫번쨰 : n -> (n % 5) + 1

// [1, 3, 4, 5] : arr
// 두번쨰 : n -> n % 2 == 0 ? arr[n % arr.length] : 2

// [3, 1, 2, 4, 5] : arr
// 세번쨰 : n -> ((n / 2) % 5)
interface Person {
	int getAnswerIntoNth(int n);
}

class PersonA implements Person {

	@Override
	public int getAnswerIntoNth(int n) {
		return (n % 5) + 1;
	}
}

class PersonB implements Person {
	int[] arr = {1, 3, 4, 5};
	
	@Override
	public int getAnswerIntoNth(int n) {
		return n % 2 == 0 ? 2 : arr[(n / 2) % arr.length];
	}
}

class PersonC implements Person {
	int[] arr = {3, 1, 2, 4, 5};
	
	@Override
	public int getAnswerIntoNth(int n) {
		return arr[((n / 2) % arr.length)];
	}
}
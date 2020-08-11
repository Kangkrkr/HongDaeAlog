import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// K 번째수
// https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
class Solution {

	public static List<Integer> getSubList(List<Integer> list, int start, int end) {
		List<Integer> resultList = new ArrayList<>();
		
		for (int i=start-1; i<end; i++) {
			int item = list.get(i);
			resultList.add(item);
		}
		
		return resultList;
	}
	
    public static int[] solution(int[] array, int[][] commands) {
    	
    	int level = 0;
        int[] answer = new int[commands.length];
        
        // 배열을 ArrayList로..
        List<Integer> tempList = new ArrayList<Integer>();
        for (int item : array) {
        	tempList.add(item);
        }
        
        for (int row[] : commands) {
        	int i = row[0];
        	int j = row[1];
        	int k = row[2];

        	List<Integer> subList = getSubList(tempList, i, j);
        	Collections.sort(subList);
        	
        	int resultItem = subList.get(k - 1);
        	answer[level++] = resultItem;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int array[] = {1, 5, 2, 6, 3, 7, 4};
    	
    	int [][] commands = {
			{2, 5, 3},
			{4, 4, 1},
			{1, 7, 3}
    	};
    	
    	int[] answer = solution(array, commands);
    	
    	for (int res : answer){
    		System.out.println(res);
    	}
	}
}
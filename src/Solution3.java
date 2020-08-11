class MySolution {
    public String solution(String phone_number) {
        String answer = "";
        
        int beginIndex = phone_number.length() == 4 ? 0 : phone_number.length() - 4;
        int endIndex = phone_number.length() == 4 ? 4 : beginIndex + 4;
        String subStr = phone_number.substring(beginIndex, endIndex);
        
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<beginIndex; i++) {
        	buffer.append("*");
        }
        for(int i=0; i<subStr.length(); i++) {
        	buffer.append(subStr.charAt(i));
        }
        
        return buffer.toString();
    }
}

public class Solution3 {
	public static void main(String[] args) {
		MySolution s = new MySolution();
		
		String[] phoneNums = {"01033334444", "027778888"};
		
		for (String phone : phoneNums) {
			System.out.println(s.solution(phone));
		}
	}
}

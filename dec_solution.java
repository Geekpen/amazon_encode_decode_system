package AmazonWebServiceDecoding;
import java.util.*;

public class solution {
	
	public static String decodeString(int numberOfRows, String encodedString) {
		String result = new String();
		int rowLen = encodedString.length()/numberOfRows;
		int start = 0, end = rowLen, startIndex = 0, index = 0,loopBroken = 0;
		List<String> boken = new ArrayList<>();
		for(int i = 0; i < numberOfRows; i++) {
			boken.add(encodedString.substring(start, end));
			start = start + rowLen;
			end += encodedString.length()/numberOfRows;
		}
	
		//add chars into result
		for(int i = 0; i < encodedString.length() ; i++) {
			if(index <  rowLen ) {
				char c = boken.get(loopBroken).charAt(index) =='_'?' ':boken.get(loopBroken).charAt(index);
				result += Character.toString(c);
			}
			index++;
			loopBroken++;
			
			if((i+1)%numberOfRows == 0) {
				startIndex +=1;
				index=startIndex;
				loopBroken = 0;
			}
		}
		return result.trim();
	}

	public static void main(String[] args) {
		System.out.println(decodeString(3,"mnes__ya_____mi"));

	}

}

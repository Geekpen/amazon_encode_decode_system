package AmazonWebServiceEncoding;
//encode the string
import java.util.*;

public class solution {
	
	public static void addPrefix(int whiteSpaces, List<Character> row) {
		for(int i = 0; i < whiteSpaces; i++) {
			row.add('_');
		}
	}
	
	public static void addSuffix(int whiteSpaces, List<Character> row) {
		for(int i = 0; i < whiteSpaces; i++) {
			row.add('_');
		}
	}
	
	public static String encodeString(int numberOfRows, String encodedString) {
		int maxRow = 0;
		List<List<Character>> cipher = new ArrayList<>();
		int checkFirstTraverse = 0;
		int loopCipher = 0;
		for(int i = 0; i < encodedString.length(); i++) {
			char c = encodedString.charAt(i);
			if(Character.isSpaceChar(c)) c = '_';
			if(checkFirstTraverse < numberOfRows) {
				
				cipher.add(new ArrayList<>());
				if(checkFirstTraverse > 0) {
					addPrefix(checkFirstTraverse,cipher.get(loopCipher));
				}
				cipher.get(loopCipher).add(c);
				checkFirstTraverse++;
			}else {
				cipher.get(loopCipher).add(c);
			}
			maxRow = Math.max(maxRow, cipher.get(loopCipher).size());
			loopCipher++;
			if(loopCipher-numberOfRows ==0) loopCipher = 0;
			
		}
		String result = new String();
		for(int j = 0; j < cipher.size(); j++) {
			if(maxRow > cipher.get(j).size()) {
				addSuffix(maxRow - cipher.get(j).size(),cipher.get(j));
			}
			for(int k = 0; k < cipher.get(j).size(); k++) {
				result += cipher.get(j).get(k).toString();
			}
		}
		//System.out.println(result);
		return result;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encodeString(3,"My name is"));

	}

}

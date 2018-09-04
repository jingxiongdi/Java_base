package array;

import java.util.Arrays;

public class TestStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addString();
		
		deleteString();
	}

	public static void addString() {
		String[] myStringArray = {"111","222","333"};
		myStringArray = Arrays.copyOf(myStringArray, 4);
		myStringArray[3] = "444";
		
		for(int i = 0;i<myStringArray.length;i++) {
			System.out.println("addstring : "+myStringArray[i]);
		}
	}
	
	public static void deleteString() {
		String[] myStringArray = {"111","222","333"};
		
		myStringArray = Arrays.copyOf(myStringArray, 2);
		
		for(int i = 0;i<myStringArray.length;i++) {
			System.out.println("deleteString : "+myStringArray[i]);
		}
	}
}

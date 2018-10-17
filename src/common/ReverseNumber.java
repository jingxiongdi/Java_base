package common;

import java.util.Scanner;
public class ReverseNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			String str = Integer.toBinaryString(in.nextInt());
			int sum = 0;
			for(int i=0;i<str.length();i++) {
				if(str.substring(i, i+1).equals("1")) {
					sum++;
				}
			}
			System.out.println(sum);
	}
}

package common;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			int a = Integer.parseInt(name.split(" ")[0]);
			int b =  Integer.parseInt(name.split(" ")[1]);
			int sum = 0;
			for(int i=a;i<=b;i++){
				int oneA = i/100;
				int twoA = i/10%10;
				int threeA = i%10;
				
				if(i == (oneA*oneA*oneA+twoA*twoA*twoA+threeA*threeA*threeA)){
					sum++;
					System.out.print(i+" ");
				}
			}
			if(sum == 0){
				System.out.println("no");
			}
		}
	}

}

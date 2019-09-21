package array;

//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int n1 ,n2;
//        n1 = input.nextInt();
//        n2 = input.nextInt();
//        int rst = minCom(n1, n2);
//        System.out.println(rst);
//    }
//     
//    public static int minCom(int n1, int n2){
//        return n1 * n2 / maxCom(n1, n2);
//    }
//     
//    public static int maxCom(int n1, int n2){
//        int c = n1 % n2;
//        if(c == 0)
//            return n2;
//        return maxCom(n2, c);
//    }
//}




import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(calStringDistance(a,b));
      
    }
    
	public static int calStringDistance(String charA, String charB){
		
		return -1;
	}
    
  
}
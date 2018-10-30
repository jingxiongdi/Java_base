package common;

import java.util.Scanner;

public class SimularityNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in =new Scanner(System.in);
		 float num = in.nextFloat();
		 String str = String.valueOf(num);
		 String childStr[]  = str.split("\\.");
		 int v = Integer.parseInt(childStr[0]);
		 if(Integer.parseInt(childStr[1].substring(0, 1))<5) {
			 System.out.println(v);
		 }else {
			 System.out.println(v+1);
		 }
	}

}

/**
 * 题目描述
写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

输入描述:
输入一个正浮点数值

输出描述:
输出该数值的近似整数值

示例1
输入
5.5
输出
6
 * @param args
 */

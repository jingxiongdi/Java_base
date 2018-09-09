package common;

public class CommonBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(13>>2<<2);
	//	System.out.println(13>>2);
	//	System.out.println(13<<2);
	//	System.out.println(Integer.toBinaryString(13));//转换为二进制1101
		//移位运算符 <<向左移位， >>向右移位
		/**
		 * 13 二进制为1101
		 * 13>>2右移两位 == 11 = 1*1+1*2 = 3
		 * 13<<2左移两位 == 110100 = 1*2*2+1*2*2*2*2+1*2*2*2*2*2 = 4+16+32=52
		 * 		 
		 * */
		//System.out.println(Integer.toHexString(137));//转换为16进制
		//System.out.println(Integer.toOctalString(137));//转换为8进制
		System.out.println(Integer.parseInt("211",8));//radix进制的s，转化为十进制，返回类型为int
	}

}

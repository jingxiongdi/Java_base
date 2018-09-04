package mac;

public class SwichMacFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String mac = "1e:2d:3f:4e:5g:aw";	
			mac = mac.replace(":", "");
			System.out.println("mac : "+mac);
			//输出结果:mac : 1e2d3f4e5gaw
			
			
			String deviceID = "IOTSHMK000S00090B1B839";
			deviceID = deviceID.replace("IOTSH", "");
			System.out.println("deviceid : "+deviceID);
			//输出结果:deviceid : 1e2d3f4e5gaw
	}

}

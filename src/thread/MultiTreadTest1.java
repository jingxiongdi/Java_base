package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiTreadTest1 {
	static int i = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Executors.newSingleThreadExecutor().execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(true) {
//					try {
//						Thread.sleep(900);
//						i++;
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName()+" i = "+i);
//				}
//			
//			}
//		});
//		
//		ExecutorService ex = Executors.newSingleThreadExecutor();
//		ex.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(true) {
//					try {
//						Thread.sleep(1000);
//						System.out.println(Thread.currentThread().getName()+" i = "+i);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					Executors.newFixedThreadPool(3).execute(new Runnable() {
//						
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							try {
//								Thread.sleep(1000);
//								System.out.println(Thread.currentThread().getName()+" i = "+i);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						
//						}
//					});
//				}
//				
//			
//			}
//		});
	}

}

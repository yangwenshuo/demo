package com.interrpu;

public class Clientsleep {
	public static void main(String[] args) {
		
		//为什么sleep的时候会抛一个interrupt的异常呢
		//因为interrupt的意思就是让你停止，那么我现在正常睡觉
		//你让我停止，我可能睡很久醒不来，那我就还是没有停止
		//那么就这样，你一发消息，虽然我在睡觉，但是直接给我叫醒并抛
		//一个异常（在catch代码块里设置interrupt标志位，必须设置一下，
		//因为你把人家叫醒，人家把你的标志位清空了）
		
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true) {
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("主公有唤我,我走了");
						break;
					}
					
					System.out.println("雷霆半月斩");
					
					try {
						Thread.currentThread().sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						
						
						//要是不想看到那些异常打印信息就把这行给注释了
						e.printStackTrace();
						
						
						System.out.println("收到主公将令");
						
						//重新设置打断标志位。
						Thread.currentThread().interrupt();
					}
					
				}
			}
			
		});
		
		t.start();
		
		try {
			Thread.currentThread().sleep(2000);
			t.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

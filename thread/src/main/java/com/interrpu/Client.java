package com.interrpu;

public class Client {
	public static void main(String[] args) {

		//如果你的线程在阻塞状态,外面调用了这个线程的
		//interrupt()方法,那么你的线程就醒了,并且会有一个异常,如果
		//异常被你catch住了就会走catch里面的代码,如果没有catch住,
		//那么异常抛到了最外面线程就停止了


		
		//注意线程的停止看起来好像是用stop比较好,这个正好也是符合停止的
		//但是这种挺停止,可能会线程嘎一下就停止,不管你现在跑到了那里,破坏了
		//逻辑,可能会有很严重的后果,停止线程最好的方式是用一个线程中断
		
		
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				
				
				//看这样,我们通过在循环里增加标志位判断.
				//然后再break出去就可以.
				
				
				//或者还可以搞一个方法,控制while循环的标志位
				
				while(true) {
					System.out.println("雷霆半月斩");
					

					System.out.println("闪电旋风劈");
					
					
				
					//你看我把中断放在最后面,就不会破坏你一整个逻辑
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("主公有唤我,我走了");
						break;
					}
				}
			}
			
		});
		
		
		t.start();
		
		try {
			Thread.currentThread().sleep(2000);
			
			
			
			//调用interrupt方法来设置标志位。
			t.interrupt();
			
			
			
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

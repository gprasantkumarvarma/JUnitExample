package com.thread;

class Process extends Thread {
/*https://github.com/naftulikay/commons-daemon-example*/
	private volatile boolean running = true;

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Hello..!!");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Thread go interruped");
	}
	
	public  void shutdown() {
		running = false;
	}
}

public class SomeService {
	private static Thread t1;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Parameter::"+args[0]);
		if ("start".equals(args[0])) {
			t1 = new Process();
			t1.start();
		} else if ("stop".equals(args[0])) {
			System.out.println("shutdown...!!!");
			System.out.println("Interepted...!!!");
		}
	}

}

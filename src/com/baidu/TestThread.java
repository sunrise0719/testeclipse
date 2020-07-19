package com.baidu;

public class TestThread extends Thread {

	public String threadName;
	public TestThread() {
		
	}
	public TestThread(String str) {
		this.threadName=str;
	}
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.threadName+"  "+i);
		}
		
	}
}

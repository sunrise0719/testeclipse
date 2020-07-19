package com.baidu;

public class Testmm {
public static void main(String[] args) {
		/*
		 * TestThread thread1=new TestThread("xiancheng1"); TestThread thread2=new
		 * TestThread("xiancheng2"); thread1.start(); thread2.start();
		 */
	TestRun tRun=new TestRun();
	new Thread(tRun, "thread-1").start();
	new Thread(tRun, "thread-2").start();
}
}

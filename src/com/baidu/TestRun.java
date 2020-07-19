package com.baidu;

public class TestRun implements Runnable {

	private int i ;
    @Override
    public void run() {
        for(;i<50;i++){
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
    }
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + " -- " + i);
            if(i==20){
            	TestRun runnableTest = new TestRun() ;
                new Thread(runnableTest,"线程1").start() ;
                new Thread(runnableTest,"线程2").start() ;
            }
        }
    }
}

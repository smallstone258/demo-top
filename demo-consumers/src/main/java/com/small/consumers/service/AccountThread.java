package com.small.consumers.service;

public class AccountThread implements Runnable {

    ThreadTest  threadTest;
    public    AccountThread(ThreadTest  threadTest1){
        this.threadTest=threadTest1;
    }

    @Override
    public void run() {
        //System.out.println(threadTest.getAccount());
    }



}

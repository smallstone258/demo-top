package com.small.consumers.service;

import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class ThreadTest {


    public static int  count=0;



    public static void main(String[] args) throws InterruptedException {
        Pointcut  dd=new AspectJExpressionPointcut();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    count++;
                }
            }
        }).start();

        String name="";








    }




}

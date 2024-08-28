package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable=false;

    public void produce(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
        }catch(Exception e){
            //some exception handling code
        }
        finally {
            //NOTE: I was printing in reverse order, so I was thinking lock got acquired by Thread-1 before
            //Thread-0 released it
            System.out.println("Lock released by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}

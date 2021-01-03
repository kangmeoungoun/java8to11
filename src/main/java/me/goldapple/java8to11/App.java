package me.goldapple.java8to11;


public class App {
    public static void main(String[] args) {
        //MyThread myThread = new MyThread();
        //myThread.start();
        //리턴타입void return 메소드 종료
        /*
        Thread thread = new Thread(()->{
            while(true){
                System.out.println("Thread : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) { //자는 동안에 누가 깨우면 익셉션 발생
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread.start();
        System.out.println("Hello "+Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread.interrupt();;
        */
        Thread thread = new Thread(()->{
            System.out.println("Thread : "+Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        });
        thread.start();
        System.out.println("Hello"+Thread.currentThread().getName());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread+ " is finished");

    }
    /**/
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("Thread : "+Thread.currentThread().getName());
        }
    }

}

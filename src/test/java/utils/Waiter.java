package utils;

public class Waiter {

    public static void pause (int second){
        try{
            Thread.sleep(second * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

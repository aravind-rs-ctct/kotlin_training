package advantages;

import static java.lang.Thread.sleep;

public class HeavyThread {
    static Runnable printDotWithDelay = () -> {
        try{
            sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print('.');
    };

    public static void main(String args[]) {
        long time = System.currentTimeMillis();
        for(int i =0; i < 100000; i ++){
            new Thread( HeavyThread.printDotWithDelay).start();
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Took "+time+" ms");
    }
}

package com.smarsh;
public class Demo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called");
        super.finalize();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo = null;  // Make object eligible for GC
        System.gc();  // Request GC (not guaranteed immediately)

        // Allow some time for GC to run
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main");
    }
}

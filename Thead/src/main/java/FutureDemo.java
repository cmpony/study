import java.util.concurrent.*;

public class FutureDemo {
      public static void main(String[] args) {
//          method1();
//          method2();
          int COUNT_BITS = Integer.SIZE - 3;
          System.out.println("COUNT_BITS: " + COUNT_BITS);
          System.out.println(Integer.toBinaryString(-1));
          System.out.println(Integer.toBinaryString(-1 << COUNT_BITS));
          System.out.println(-1 << COUNT_BITS);
     }

     private static void method1() {
         ExecutorService executorService = Executors.newCachedThreadPool();
         Future future = executorService.submit(new Callable<Object>() {
             @Override
             public Object call() throws Exception {
                 Long start = System.currentTimeMillis();
                 while (true) {
                     Long current = System.currentTimeMillis();
                     if ((current - start) > 1000) {
                         return 1;
                     }
                 }
             }
         });

         try {
             Integer result = (Integer)future.get();
             System.out.println(result);
         }catch (Exception e){
             e.printStackTrace();
         }
     }

     private static void method2() {
          try {
              FutureTask<String> stringFutureTask = new FutureTask<>(() -> "callable");
              new Thread(stringFutureTask).start();
              System.out.println(stringFutureTask.get());
          } catch (Exception e) {
              e.printStackTrace();
          }
     }
}
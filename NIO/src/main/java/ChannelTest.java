import java.nio.channels.FileChannel;
import java.util.Hashtable;
import java.util.concurrent.*;

public class ChannelTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1
        new RunnableTest().run();
        // 2
        new TheadTest().start();
        // 3
        CallableTest callableTest = new CallableTest();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableTest);
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
        // 4
        ExecutorService executorService = Executors.newCachedThreadPool();

    }


    static class RunnableTest implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable ...");
        }
    }

    static class TheadTest extends  Thread {

//        @Override
//        public void run() {
//            System.out.println("Thead ....");
//        }
    }

    static class CallableTest implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "callable 接口";
        }
    }
}

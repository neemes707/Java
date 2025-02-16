import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private final ThreadPoolExecutor threadPoolExecutor;

    ThreadPoolExecutorDemo(int corePoolSize,int maxPoolSize,int blockingQueueSize){
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(blockingQueueSize),new CustomThreadFactory(),new CustomRejectExecutionHandler());
    }

    void produceTasks(){
        /*TODO - initial pool size is corePool size , new thread will only be created
        *  when blocking queue is also filled and all threads in threadPool are busy &
        *   and maxPoolSize is not reached*/
        for(int i = 1;i<=8;i++){
            threadPoolExecutor.submit(()->{
                System.out.println("Task started executing by "+Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task completed");
            });
        }
        threadPoolExecutor.shutdown();
    }


}

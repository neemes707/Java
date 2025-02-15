import java.util.concurrent.ArrayBlockingQueue;

public class SharedResource {

     private int queueSize;
     private ArrayBlockingQueue<Integer> queue;
     SharedResource(int queueSize){
         this.queueSize = queueSize;
         queue = new ArrayBlockingQueue<>(queueSize);
     }

    //synchronized used as it requires monitor lock on shared resource
     public synchronized void produceElement(){
         try {
             while(queue.size() == queueSize){
                 System.out.println("Queue size if full so waiting");
                 wait(); // this will release all the monitor locks on this object
             }
             Thread.sleep(5000); // specifically telling thread to sleep for 5 sec
             queue.put(1);
             notifyAll(); // this will notify all the thread waiting
             System.out.println("Added element in queue with size "+queue.size());
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }

     public synchronized void consumeElement(){
         try {
             while(queue.isEmpty()){
                 System.out.println("Queue is empty so waiting");
                 wait();  // this will release all the monitor locks on this object
             }
             queue.take();
             System.out.println("Removed element from the queue");
             notifyAll();
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
}

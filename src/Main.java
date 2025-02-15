//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*TODO :- Designed a producer consumer application which adds and removes
        *  elements in a queue and this operation should be such that the queue should
        *  wait if no element is there is removing and if queue is full then wait before adding
        * */
        System.out.println("Hello World");
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(()->{
            System.out.println("Inside producer thread");
            sharedResource.produceElement();
        });

        Thread consumeThread = new Thread(()->{
            System.out.println("Inside consumer thread");
            sharedResource.consumeElement();
        });

        consumeThread.start();
        producerThread.start();
    }
}
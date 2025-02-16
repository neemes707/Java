import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        //thread.setName("Demo thread"); we can set thread name , demon thread here
        return new Thread(r);
    }
}

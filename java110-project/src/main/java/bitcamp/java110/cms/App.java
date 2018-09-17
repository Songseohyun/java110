package bitcamp.java110.cms;

public class App {
    
    public static void main(String[] args) throws Exception {
        Thread main = Thread.currentThread();
        System.out.println(main.getName());
        
        ThreadGroup mainGroup = main.getThreadGroup();
        System.out.println(mainGroup.getName());
        
        ThreadGroup systemGroup = mainGroup.getParent();
        System.out.println(systemGroup.getName());
        
        Thread[] threads = new Thread[20];
        int count = systemGroup.enumerate(threads, false);
        for(int i = 0; i<count; i++) {
            System.out.println(threads[i].getName());
        }
        Thread[] tgs = new Thread[20];
        count = mainGroup.enumerate(tgs, false);
        
        for(int i = 0; i<count; i++) {
            System.out.println(tgs[i].getName());
        }
        
    }
}























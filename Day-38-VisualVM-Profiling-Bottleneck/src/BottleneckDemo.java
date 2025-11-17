public class BottleneckDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ứng dụng đã khởi động. Hãy kết nối VisualVM...");
        System.out.println("PID: " + ProcessHandle.current().pid());

        while (true) {
            fastMethod();
            slowMethod();
            Thread.sleep(50);
        }
    }

    public static void fastMethod() {
        double result = 0;
        for (int i = 0; i < 1000; i++) {
            result += Math.random();
        }
    }

    public static void slowMethod() {
        try {
            Thread.sleep(200); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
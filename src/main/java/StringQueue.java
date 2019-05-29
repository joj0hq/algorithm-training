public class StringQueue {
    public static void main(String[] args) {
        StringQueue.enqueue("hello");
        StringQueue.enqueue("world");
        StringQueue.enqueue("jojo");

        for (int i = 0; i < size(); ++i) {
            System.out.println(arr[i]);
        }

        System.out.println("size: " + size());

        System.out.println("Peek is: " + peek());

        System.out.println("empty is: " + empty());

        dequeue();
        dequeue();

        for (int i = 0; i < size(); ++i) {
            System.out.println(arr[i]);
        }
    }


    private static String[] arr = new String[100];
    private static int tail = -1;

//    public StringQueue() {
//        arr = new String[100];
//    }

    private static void enqueue(String item) {
        // error hadnling if over 100
        tail++;
        arr[tail] = item;
    }
    private static String peek() {
        return (String) arr[0];
    }
    private static String dequeue() {
        // error handling if over 100

        String returnNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = "";

        tail--;
        return returnNum;
    }
    private static boolean empty() {
        return arr[0].equals("") ? true : false;
    }
    private static int size() {
        return tail + 1;
    }
}
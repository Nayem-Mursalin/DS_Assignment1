import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriterThread implements Runnable{

    private ObjectOutputStream oos;
    private String Name;

    WriterThread(ObjectOutputStream oos, String Name){
        this.oos = oos;
        this.Name = Name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        while (true){
            String message = input.nextLine();
            try {
                oos.writeObject((String)message);
                System.out.println("Message Sent...");
            } catch (IOException e) {
               // throw new RuntimeException(e);
            }
        }
    }
}

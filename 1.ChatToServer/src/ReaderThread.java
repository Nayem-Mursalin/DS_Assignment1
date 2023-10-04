import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements Runnable{
        ObjectInputStream ois;
        String Name;

        ReaderThread(ObjectInputStream ois, String Name){
            this.ois = ois;
            this.Name = Name;
            new Thread(this).start();
        }



    @Override
    public void run() {
            while (true){
                try {
                    Object recieved = ois.readObject();
                    System.out.println(Name+"'s Recieved Message: "+ (String) recieved);
                } catch (ClassNotFoundException | IOException e) {
                    //e.printStackTrace();
                }
            }

    }
}

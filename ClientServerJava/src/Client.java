import java.net.*;  //for work with network
import java.io.*;   //for input output


public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1",8000);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        String message = reader.readLine();
        System.out.println(message);

        clientSocket.close();

    }
}

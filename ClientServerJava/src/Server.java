import java.net.*;  //for work with network
import java.io.*;   //for input output


public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000); //Prepare port
        int count = 0;
        while (true) {
            Socket clientSocket = serverSocket.accept();  //Get connection with Client  Open clientSocket  Listener to port
            
            System.out.println("Client accepted " + (++count));

            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        clientSocket.getOutputStream()));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String request = reader.readLine(); // Reading before line end
            String response = "#" + count + ", your message length is " + request.length();

            response += "\nHTTP/1.0 200 OK\n" +
                            "Content-type: text/html\n" +
                            "\n" +
                            "<h1>Hello #" + count + "/h1>\n";


            writer.write(response);
            writer.newLine();
            writer.flush();     //Guarantees sending
            writer.close();     //Close writer

            clientSocket.close();   //Close clientSocket
        }
        //serverSocket.close();   //Close connection with Client
    }
}

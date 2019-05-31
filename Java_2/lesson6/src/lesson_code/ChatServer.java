package lesson_code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("server started");
            Socket socket = ss.accept();
            System.out.println("client connected" + socket);

            try (DataInputStream is = new DataInputStream(socket.getInputStream());
                 DataOutputStream os = new DataOutputStream(socket.getOutputStream())) {

                Thread thread = new Thread(() -> {
                    while (true) {
                        try {
                            String echoMessage = is.readUTF();
                            System.out.println(echoMessage);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });


//                while (true) {
//                    String message = is.readUTF();
//                    System.out.println("received message: " + message);
//                    os.writeUTF("fromServer:" + message);
//                }
            }
        }
    }
}

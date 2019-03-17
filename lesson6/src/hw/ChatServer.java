package hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class ChatServer {
    Socket socket;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException { new ChatServer(); }

    public ChatServer() {

        initConnection();
        initReceiver();

        try (DataOutputStream os = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                String messageToClient = sc.nextLine();
                os.writeUTF("fromServer:" + messageToClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() {
        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("Server started");
            socket = ss.accept();
            System.out.println("Client connected: " + socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initReceiver() {
        Thread thread = new Thread(() -> {
            try (DataInputStream is = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    String messageFromClient = is.readUTF();
                    System.out.println("Received message: " + messageFromClient);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("Server receiver started");
    }
}

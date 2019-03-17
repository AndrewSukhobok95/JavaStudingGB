package hw;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Client();
    }

    public Client() {

        initConnection();
        initReceiver();

        while (true) {
            try {
                String messageToServer = sc.nextLine();
                outputStream.writeUTF(messageToServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initConnection() {
        try {
            socket = new Socket("localhost", 8080);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Connection initialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initReceiver() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String echoMessage = inputStream.readUTF();
                    System.out.println(echoMessage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("Client receiver started");
    }
}

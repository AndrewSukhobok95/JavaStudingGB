package server;

import server.model.Client;

import java.io.IOException;

public class MessageService {
    private final ClientStorage clientStorage;

    public MessageService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public synchronized void sendMessages(String message, Client clientFrom) {
        String commandSymbols = message.substring(0,2);
        if (commandSymbols.equals("/w")){
            clientStorage.getClients().forEach(client -> {
                String[] commandLoginMsgArray = extractCommandLoginMessage(message);
                String command = commandLoginMsgArray[0]; // for future improvements to add more commands
                String loginTo = commandLoginMsgArray[1];
                String msgText = clientFrom.getLogin() + ": " + commandLoginMsgArray[2];
                if(client.getLogin().equals(loginTo)) {
                    sendMessageTo(msgText, client);
                }
            });
        }else{
            clientStorage.getClients().forEach(client -> {
                sendMessageTo(message, client);
            });
        }
    }

    private void sendMessageTo(String message, Client client) {
        try {
            System.out.println(String.format("sending message '%s' to '%s'", message, client));
            client.getOs().writeUTF(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] extractCommandLoginMessage(String message) {
        String[] splittedMsg = message.split("\\s+");

        String[] msgArray = new String[splittedMsg.length-2];
        System.arraycopy(splittedMsg, 2, msgArray, 0, splittedMsg.length-2);

        String command = splittedMsg[0];
        String loginTo = splittedMsg[1];
        String msg = String.join(" ", msgArray);

        return new String[] {command, loginTo, msg};
    }
}

package chat;

import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Chat extends JFrame {
    private static final Insets insets = new Insets(0, 0, 0, 0);

    public Chat() throws HeadlessException {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600, 600, 800, 800);

        setLayout(new GridBagLayout());

        JPanel leftPanel = new JPanel();
        addComponent(this, leftPanel, 0, 0, 1, 3, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        JTextArea chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setLineWrap(true);
        chatBox.setWrapStyleWord(true);
        JScrollPane shatScroll = new JScrollPane(chatBox);
        shatScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        chatPanel.add(shatScroll);
        addComponent(this, chatPanel, 1, 0, 3, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JTextField messageBox = new JTextField();
        messageBox.addActionListener(e->{
            chatBox.append("<You> " + messageBox.getText() + "\n\n");
            messageBox.setText("");
        });
        JScrollPane messageScroll = new JScrollPane(messageBox);
        messagePanel.add(messageScroll);
        addComponent(this, messagePanel, 1, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        JButton sendMessage = new JButton("Send message");
        sendMessage.addActionListener(e->{
            chatBox.append("<You> " + messageBox.getText() + "\n\n");
            messageBox.setText("");
        });
        addComponent(this, sendMessage, 3, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);


        setVisible(true);
    }

    private static void addComponent(Container container, Component component, int gridx, int gridy,
                                     int gridwidth, int gridheight, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    public static void main(String[] args) {
        new Chat();
    }
}



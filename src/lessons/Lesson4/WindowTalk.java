package lessons.Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowTalk extends  JFrame{
    private static final Font MAIN_FONT = new Font("Arial", Font.PLAIN, 16);


    private JTextArea mainArea;
    private JTextField textField;

    public WindowTalk() {
        this.setBounds(500, 300, 400, 400);
        this.setTitle("messenger");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        mainArea = new JTextArea();
        mainArea.setFont(MAIN_FONT);
        JScrollPane scrollPane = new JScrollPane(mainArea);
        this.add(scrollPane, BorderLayout.CENTER);


        textField = new JTextField();
        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        jPanel.setBackground(Color.GRAY);
        jPanel.setPreferredSize(new Dimension(1, 24));
        this.add(jPanel, BorderLayout.SOUTH);

        jPanel.add(textField);
        jPanel.add(btnSend);




        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        this.setVisible(true);
    }

    public void sendMsg() {
        String msg = textField.getText().trim();
        if (msg.length() > 0) {
            mainArea.append(textField.getText() + "\n");
            textField.setText("");
            textField.grabFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Text field is empty");
        }
    }


    }




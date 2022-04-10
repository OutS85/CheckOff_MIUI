package outs.Lives.Belarus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyTextFrame extends JFrame {

    public JTextArea textArea;
    private JPanel textPanel;

    public MyTextFrame() throws HeadlessException {

        super("Ход выполнения программы");
        setSize(1110, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textArea = createTextArea();
        textPanel = createPanel(textArea);
        setContentPane(textPanel);
        setVisible(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                textArea.setSize(getWidth() - 10, getHeight() - 10);
                textPanel.setSize(getWidth(), getHeight());
            }
        });
    }

    private JTextArea createTextArea(){

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setSize(1100, 790);
        return textArea;
    }

    private JPanel createPanel(JTextArea textArea){

        JPanel textPanel = new JPanel(null);
        textPanel.add(textArea);
        return textPanel;
    }

}

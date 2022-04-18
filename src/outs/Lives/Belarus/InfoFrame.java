package outs.Lives.Belarus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class InfoFrame extends JFrame {

    public JTextArea textArea;
    private JPanel textPanel;
    private Dimension screenSize;

    public InfoFrame(Dimension screenSize) throws HeadlessException {

        super("Ход выполнения программы");
        setSize((int)(screenSize.width * 0.85), (int)(screenSize.height * 0.85));
        this.screenSize = screenSize;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textArea = createTextArea();
        textPanel = createPanel(textArea);
        setContentPane(textPanel);
        setLocationRelativeTo(null);
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
        textArea.setSize( screenSize.width - 10, screenSize.height - 10);
        textArea.setFont(new Font("Courier", Font.ITALIC, 11));
        return textArea;
    }

    private JPanel createPanel(JTextArea textArea){

        JPanel textPanel = new JPanel(null);
        textPanel.add(textArea);
        return textPanel;
    }

}

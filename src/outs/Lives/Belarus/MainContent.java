package outs.Lives.Belarus;


import outs.Lives.Belarus.CheckOff.CheckOffWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainContent extends JFrame implements ActionListener {

    private final Font font;
    private final Color color;
    JPanel mainPanel;
    JPanel leftPanel;
    JPanel rightPanel;
    JButton patch1, patch2, patch3, patch4, patch5, patch6, patch7;

    Dimension screenSize;

    public MainContent(Dimension screenSize) throws HeadlessException, IOException {

        this.screenSize = screenSize;
        font = new Font("Monospaced", Font.ITALIC, 18);
        color = new Color(243,120,204);
        setTitle("MIUI Patcher by OutS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1200, 500);
        setLocationRelativeTo(null);
        createBtn();
        createPanels();
        setVisible(true);
    }

    private void createBtn(){

        patch1 = new JButton();
        patch1.setLayout(new BorderLayout());
        JLabel label1 = new JLabel(); JLabel label2 = new JLabel();
        label1.setText("Отключение проверок");
        label1.setFont(font);
        label1.setForeground(color);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setText("целостности и подписи Андройд");
        label2.setFont(font);
        label2.setForeground(color);
        label2.setHorizontalAlignment(JLabel.CENTER);
        patch1.add(BorderLayout.NORTH, label1);
        patch1.add(BorderLayout.SOUTH, label2);
        patch2 = new JButton("Добавление XMiuiPreferense от Папы");
        patch3 = new JButton("Автозакрытие открытой папки в лаунчере");
        patch4 = new JButton("Изменить интервал обновления скорости сети");
        patch5 = new JButton("Сказать спасибо автору ;)");
        patch6 = new JButton("Patch 6");
        patch7 = new JButton("Patch 7");
    }

    private void createPanels() throws IOException {

        mainPanel = (JPanel) getContentPane();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setSize(getWidth(), getHeight());
        leftPanel = new JPanel(null);
        rightPanel = new JPanel(null);
        setLeftPanel();
        setRightPanel();
        setMainPanel();
    }

    private void setLeftPanel(){

        leftPanel.setPreferredSize(new Dimension(mainPanel.getWidth()/2 - 10, mainPanel.getHeight()));
        leftPanel.add(patch1);
        leftPanel.add(patch2);
        leftPanel.add(patch3);
        leftPanel.add(patch4);
        leftPanel.add(patch5);
        int btnWidth = (int)leftPanel.getPreferredSize().getWidth() - 20;
        int btnHeight = (int)leftPanel.getPreferredSize().getHeight()/5 - 25;
        int startPointX = 10;
        int startPointY = 10;
        patch1.setBounds(startPointX, startPointY, btnWidth, btnHeight);
        patch2.setBounds(startPointX, startPointY + btnHeight + 10, btnWidth, btnHeight);
        patch3.setBounds(startPointX, patch2.getY() + btnHeight + 10, btnWidth, btnHeight);
        patch4.setBounds(startPointX, patch3.getY() + btnHeight + 10, btnWidth, btnHeight);
        patch5.setBounds(startPointX, patch4.getY() + btnHeight + 10, btnWidth, btnHeight);
        Component[] leftPanelComponents = leftPanel.getComponents();
        for (int i = 0; i < leftPanelComponents.length; i++){
            leftPanelComponents[i].setFont(font);
            leftPanelComponents[i].setForeground(color);
            addBtnListeners(leftPanelComponents[i]);
        }
    }

    private void addBtnListeners(Component component){

        ((JButton) component).addActionListener(this);
    }

    private void setRightPanel() throws IOException {

        rightPanel.setPreferredSize(new Dimension(mainPanel.getWidth()/2 - 10, mainPanel.getHeight()));
        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("src/resources/icon.png"))));
        rightPanel.add(label);
        label.setBounds(0, -70, 600, 600);
    }

    private void setMainPanel(){

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == patch1){
            new CheckOffWindow(screenSize);
        }else if (e.getSource() == patch5){
            try {
                Desktop.getDesktop().browse(new URL("https://4pda.ru/forum/index.php?showuser=2409458").toURI());
            }catch (Exception ignored){ }
        }

    }
}

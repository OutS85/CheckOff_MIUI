package outs.Lives.Belarus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FileChooser extends JFrame implements ActionListener
{
    private  JButton  btnOpenDir;
    private  JButton  btnThanks;
    private  JButton btnAndroidVersion;
    private  JButton btnStart;
    private JButton btnOk;
    private JRadioButton andr9;
    private JRadioButton andr10;
    private JRadioButton andr11;
    private JRadioButton andr12;
    private ButtonGroup btngroup;

    private final FileChooser fc;
    private JFileChooser fileChooser;
    private JFrame androVerFrame;
    private JPanel androVerContent;
    private JPanel mainContent;
    private JLabel labelDir;
    private JLabel labelAndroVer;

    private final Dimension screenSize;
    private final Font font;

    private String WorkDir = null;
    private int androidVersion = 0;

    private final String[] androVer = {"Не выбрано", "9", "10", "11"};
    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};

    public FileChooser() {
        super("Отключение проверок Android 10+");
        fc = this;
        Toolkit kit = Toolkit.getDefaultToolkit();
        screenSize = kit.getScreenSize();
        font = new Font("Courier", Font.BOLD, 12);
        createMainElements();
        addListeners();
        createMainContent();
    }

    private void createMainElements(){

        fileChooser = new JFileChooser();
        mainContent = new JPanel();
        androVerFrame = new JFrame();
        androVerContent = new JPanel();
        labelDir = new JLabel("Директория не указана!");
        labelDir.setForeground(Color.RED);
        labelAndroVer = new JLabel("Версия Android не указана!i");
        labelAndroVer.setForeground(Color.RED);
        createMainBtns();
        createAndroVerRadioBtns();
        createAndroVerPanel();
    }

    private void createAndroVerPanel() {

    androVerFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    androVerFrame.setTitle("Выберите версию Android");
    androVerContent.setLayout(new GridLayout(5, 1, 0, 0));
    androVerContent.add(andr9);
    andr9.setHorizontalAlignment(JRadioButton.CENTER);
    androVerContent.add(andr10);
    andr10.setHorizontalAlignment(JRadioButton.CENTER);
    androVerContent.add(andr11);
    andr11.setHorizontalAlignment(JRadioButton.CENTER);
    androVerContent.add(andr12);
    andr12.setHorizontalAlignment(JRadioButton.CENTER);
    androVerContent.add(btnOk);
    btnOk.setHorizontalAlignment(JButton.CENTER);
    btnOk.setSize(40, 20);
    }

    private void createMainContent(){

        //Свойства окна
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocation(screenSize.width/2-200, screenSize.height/2-40);
        setSize(700, 200);
        mainContent.setLayout(new GridLayout(3, 2, 20, 20));
        mainContent.add(btnOpenDir);
        mainContent.add(labelDir);
        mainContent.add(btnAndroidVersion);
        mainContent.add(labelAndroVer);
        mainContent.add(btnStart);
        mainContent.add(btnThanks);
        setContentPane(mainContent);
    }

    private void createMainBtns(){
        btnOpenDir = new JButton("Открыть директорию");
        btnOpenDir.setFont(font);
        btnThanks = new JButton("Сказать спасибо автору ;)");
        btnAndroidVersion = new JButton("Версия Android");
        btnAndroidVersion.setFont(font);
        btnStart = new JButton("Пропатчить");
        btnStart.setFont(font);
        btnOk = new JButton("Ok");
        btnOk.setFont(font);
        btnStart.setEnabled(false);
    }

    private void createAndroVerRadioBtns(){

        andr9 = new JRadioButton("Андройд 9");
        andr9.setFont(font);
        andr10 = new JRadioButton("Андройд 10");
        andr10.setFont(font);
        andr11 = new JRadioButton("Андройд 11");
        andr11.setFont(font);
        andr12 = new JRadioButton("Андройд 12");
        andr12.setFont(font);
        btngroup = new ButtonGroup();
        btngroup.add(andr9);
        btngroup.add(andr10);
        btngroup.add(andr11);
        btngroup.add(andr12);
    }

    private void addListeners() {

        btnOpenDir.addActionListener(this);
        btnThanks.addActionListener(this);
        btnAndroidVersion.addActionListener(this);
        btnStart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnOpenDir){
            fileChooser.setDialogTitle("Выбор директории");
            // Определение режима - только каталог
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(FileChooser.this);
            if (result == JFileChooser.APPROVE_OPTION ){
                WorkDir = fileChooser.getSelectedFile().getAbsolutePath();
            }else if (WorkDir == null){
                System.out.println("Выбор папки отменён. Что-то не устраивает? Да подвязывайте, выбирайте смело ;).");
                return;
            }
            labelDir.setText(WorkDir);
            labelDir.setForeground(Color.GREEN);
//            try {
//                new CheckOff(WorkDir, fc, androidVersion);
//            }catch (Exception ignored){}
        }else if (e.getSource() == btnThanks){
            try {
                Desktop.getDesktop().browse(new URL("https://4pda.ru/forum/index.php?showuser=2409458").toURI());
            }catch (Exception ignored){ }
        }else if (e.getSource() == btnAndroidVersion){
            androVerFrame.setContentPane(androVerContent);
            androVerFrame.setLocation(screenSize.width/2-200, screenSize.height/2-40);
            androVerFrame.setSize(400, 200);
            androVerFrame.setVisible(true);
        }else if (e.getSource() == btnStart) {
            if (andr9.isSelected()) {
                System.out.println("Android 9");
            } else if (andr10.isSelected()) {
                System.out.println("Android 10");
            } else if (andr11.isSelected()) {
                System.out.println("Android 11");
            } else if (andr11.isSelected()) {
                System.out.println("Android 12");
            }
        }
    }

    private void close(){
        dispose();
    }
}


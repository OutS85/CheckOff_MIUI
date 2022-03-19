package outs.Lives.Belarus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class FileChooser extends JFrame
{
    private  JButton  btnOpenDir;
    private  JButton  btnThanks;
    private  JButton btnAndroidVersion;
    private JComboBox comboBox;
    private final FileChooser fc;
    private final JFileChooser fileChooser;
    private final JFrame androVerFrame;
    private final JPanel androVerContent;
    private final JPanel mainContent;

    private final Dimension screenSize;
    private final Font font;

    private String WorkDir = null;
    private int androidVersion = 0;

    private final String[] androVer = {"Не выбрано", "9", "10", "11"};
    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};

    public FileChooser() {
        super("Отключение проверок Android 10+");
        Toolkit kit = Toolkit.getDefaultToolkit();
        screenSize = kit.getScreenSize();
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        fileChooser = new JFileChooser();
        mainContent = new JPanel();
        androVerFrame = new JFrame();
        androVerContent = new JPanel();
        fc = this;
        font = new Font("Courier", Font.BOLD, 12);
        createAnroVerComboBox();
        createAndroVerFrame();
        createBtnOpenDir();
        createBtnThanks();
        createBtnAndroVer();
        addListeners();
        createMainContent();
    }

    private void addListeners() {

        btnOpenDir.addActionListener(e -> {
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
            try {
                new CheckOff(WorkDir, fc, androidVersion);
            }catch (Exception ignored){}
        });
        btnThanks.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URL("https://4pda.ru/forum/index.php?showuser=2409458").toURI());
            }catch (Exception ignored){ }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedIndex());
            }
        });
        btnAndroidVersion.addActionListener(e -> {
            androVerFrame.setContentPane(androVerContent);
            androVerFrame.setLocation(screenSize.width/2-200, screenSize.height/2-40);
            androVerFrame.setSize(400, 80);
            androVerFrame.setVisible(true);
        });
    }

    private void createAndroVerFrame() {

    androVerFrame.setResizable(false);
    androVerFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    androVerFrame.setTitle("Выберите версию Android");
    androVerContent.add(comboBox);
    }

    private void createMainContent(){

        // Размещение кнопок в интерфейсе
        mainContent.add(btnOpenDir);
        mainContent.add(btnAndroidVersion);
        mainContent.add(btnThanks);
//        contents.add(btnSaveFile  );
//        contents.add(btnFileFilter);
        setContentPane(mainContent);
        // Вывод окна на экран
        setLocation(screenSize.width/2-200, screenSize.height/2-40);
        setSize(400, 120);
        setVisible(true);
    }

    private void createBtnOpenDir(){
        // Кнопка создания диалогового окна для выбора директории
        btnOpenDir = new JButton("Открыть директорию");
        btnOpenDir.setFont(font);
    }

    private void createBtnThanks(){
        // Кнопка для спасиб
        btnThanks = new JButton("Сказать спасибо автору ;)");
    }

    private void createBtnAndroVer(){
        // Кнопка для выбора версии Android
        btnAndroidVersion = new JButton("Версия Android");
        btnAndroidVersion.setFont(font);
    }

    private void createAnroVerComboBox(){

        comboBox = new JComboBox(androVer);
        comboBox.setFont(font);
    }

    private void close(){
        dispose();
    }
}


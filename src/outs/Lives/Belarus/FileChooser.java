package outs.Lives.Belarus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FileChooser extends JFrame
{
    private  JButton  btnOpenDir;
    private  JButton  btnThanks;
    private  JButton btnAndroidVersion;
    private JComboBox comboBox;
    private FileChooser fc;
    private  JFileChooser fileChooser;
    private JFrame androVerFrame;
    private JPanel androVerContent;

    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize;

    private String WorkDir = null;
    private int androidVersion = 0;

    private final String[] androVer = {"Не выбрано", "9", "10", "11"};
    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};

    public FileChooser() {
        super("Отключение проверок Android 10+");
        screenSize = kit.getScreenSize();
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        fc = this;
        createAndroVerFrame();
        // Кнопка создания диалогового окна для выбора директории
        Font font = new Font("Courier", Font.BOLD, 12);
        btnOpenDir = new JButton("Открыть директорию");
        btnOpenDir.setFont(font);
        // Кнопка для спасиб
        btnThanks = new JButton("Сказать спасибо автору ;)");
//        // Кнопка для выбора версии Android
        btnAndroidVersion = new JButton("Версия Android");
        btnAndroidVersion.setFont(font);

        // Создание экземпляра JFileChooser
        fileChooser = new JFileChooser();
        // Подключение слушателей к кнопкам
        addListeners();

        // Размещение кнопок в интерфейсе
        JPanel contents = new JPanel();
        contents.add(btnOpenDir);
        contents.add(btnAndroidVersion);
        contents.add(btnThanks);
//        contents.add(btnSaveFile  );
//        contents.add(btnFileFilter);
        setContentPane(contents);
        // Вывод окна на экран
        setLocation(screenSize.width/2-200, screenSize.height/2-40);
        setSize(400, 120);
        setVisible(true);
    }

    private void addListeners() {

        btnOpenDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                }catch (Exception e1){}
            }
        });
        btnThanks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://4pda.ru/forum/index.php?showuser=2409458").toURI());
                }catch (Exception ex){ }
            }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedIndex());
            }
        });
        btnAndroidVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                androVerFrame.setContentPane(androVerContent);
                androVerFrame.setLocation(screenSize.width/2-200, screenSize.height/2-40);
                androVerFrame.setSize(400, 80);
                androVerFrame.setVisible(true);
            }
        });
    }

    private void createAndroVerFrame() {

    androVerFrame = new JFrame();
    androVerFrame.setResizable(false);
    androVerFrame.setTitle("Выберите версию Android");
    androVerContent = new JPanel();
    comboBox = new JComboBox(androVer);
    androVerContent.add(comboBox);
}

     private void close(){
        dispose();
    }
}


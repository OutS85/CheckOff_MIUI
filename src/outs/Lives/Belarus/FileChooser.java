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
    private JLabel label;
    private  JButton btnAndroidVersion;
    private JComboBox comboBox;
    private final FileChooser fc;
    private final JFileChooser fileChooser;
    private final JFrame androVerFrame;
    private final JPanel androVerContent;
    private final JPanel mainContent;
    private final JPanel radioButtonGroup;

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
        fileChooser = new JFileChooser();
        mainContent = new JPanel(new GridLayout(3, 2, 5, 5));
        androVerFrame = new JFrame();
        androVerContent = new JPanel();
        radioButtonGroup = new JPanel();
        fc = this;
        font = new Font("Courier", Font.BOLD, 12);
        createAnroVerComboBox();
        createRadioButtonGroup();
        createAndroVerFrame();
        createElements();
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

        // Размещение элементов в интерфейсе
        mainContent.add(btnOpenDir);
        mainContent.add(label);
        mainContent.add(btnAndroidVersion);
        mainContent.add(radioButtonGroup);
        mainContent.add(btnThanks);
        JButton ffff = new JButton("fdf");
        mainContent.add(ffff);
        // Вывод окна на экран и задание его свойств
        setContentPane(mainContent);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
        setLocation(screenSize.width/2-200, screenSize.height/2-40);
        setSize(500, 300);
        setVisible(true);
    }

    private void createElements(){
        // Кнопка создания диалогового окна для выбора директории
        btnOpenDir = new JButton("Указать директорию");
        btnOpenDir.setFont(font);
        // Кнопка для спасиб
        btnThanks = new JButton("Сказать спасибо автору ;)");
        btnThanks.setFont(font);
        // Кнопка для выбора версии Android
        btnAndroidVersion = new JButton("Версия Android");
        btnAndroidVersion.setFont(font);
        label = new JLabel("Директория не указана");
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    private void createAnroVerComboBox(){

        comboBox = new JComboBox(androVer);
        comboBox.setFont(font);
    }

    private void createRadioButtonGroup(){

        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("1");
        JRadioButton radioButton3 = new JRadioButton("1");
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);
        radioButtonGroup.setLayout(new GroupLayout(radioButtonGroup));
        radioButtonGroup.setVisible(true);
    }

    private void close(){
        dispose();
    }
}


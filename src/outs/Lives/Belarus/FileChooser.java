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

    private final FileChooser fc;
    private JFileChooser fileChooser;
    private JPanel androVerContent;
    private JPanel mainContent;
    private JLabel labelDir;
    private JLabel labelAndroVer;
    private JDialog dialog;

    private final Dimension screenSize;
    private final Font font;

    private String WorkDir = null;
    private int androidVersion = 0;
    private boolean condDir = false;
    private boolean condVer = false;

//    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
//            {"pdf" , "Adobe Reader(*.pdf)"}};

    public FileChooser()
    {
        super("Отключение проверок подписи и целостности MIUI");
        fc = this;
        Toolkit kit = Toolkit.getDefaultToolkit();
        screenSize = kit.getScreenSize();
        font = new Font("Courier", Font.BOLD, 14);
        createMainElements();
        addListeners();
        createMainContent();
    }

    private void createMainElements()
    {
        fileChooser = new JFileChooser();
        mainContent = new JPanel();
        androVerContent = new JPanel();
        labelDir = new JLabel("Директория не указана!");
        labelDir.setForeground(Color.RED);
        labelAndroVer = new JLabel("Версия Android не указана!");
        labelAndroVer.setForeground(Color.RED);
        dialog = new JDialog(this, "Выберите версию Андройд", true);
        createMainBtns();
        createAndroVerRadioBtns();
        createAndroVerPanel();
    }

    private void createMainContent()
    {
        //Свойства окна
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(screenSize.width/2-200, screenSize.height/2-40);
        setSize(700, 200);
        mainContent.setLayout(new GridLayout(3, 2, 20, 20));
//        mainContent.setBackground(Color.gray);
        mainContent.add(btnOpenDir);
        mainContent.add(labelDir);
        mainContent.add(btnAndroidVersion);
        mainContent.add(labelAndroVer);
        mainContent.add(btnStart);
        mainContent.add(btnThanks);
        setContentPane(mainContent);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
    }

    private void createAndroVerPanel()
    {
        androVerContent.setLayout(new BoxLayout(androVerContent, BoxLayout.Y_AXIS));
        androVerContent.add(andr9);
        andr9.setAlignmentX(Container.CENTER_ALIGNMENT);
        androVerContent.add(andr10);
        andr10.setAlignmentX(Container.CENTER_ALIGNMENT);
        androVerContent.add(andr11);
        andr11.setAlignmentX(Container.CENTER_ALIGNMENT);
        androVerContent.add(andr12);
        andr12.setAlignmentX(Container.CENTER_ALIGNMENT);
        androVerContent.add(btnOk);
        btnOk.setAlignmentX(Container.CENTER_ALIGNMENT);
        btnOk.setSize(90, 45);
    }

    private void createMainBtns()
    {
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

    private void createAndroVerRadioBtns()
    {
        andr9 = new JRadioButton("Андройд 9");
        andr9.setFont(font);
        andr10 = new JRadioButton("Андройд 10");
        andr10.setFont(font);
        andr11 = new JRadioButton("Андройд 11");
        andr11.setFont(font);
        andr12 = new JRadioButton("Андройд 12");
        andr12.setFont(font);
        ButtonGroup btngroup = new ButtonGroup();
        btngroup.add(andr9);
        btngroup.add(andr10);
        btngroup.add(andr11);
        btngroup.add(andr12);
    }

    private void addListeners()
    {
        btnOpenDir.addActionListener(this);
        btnThanks.addActionListener(this);
        btnAndroidVersion.addActionListener(this);
        btnStart.addActionListener(this);
        btnOk.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
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
            condDir = true;
            if (condVer){
                btnStart.setEnabled(true);
                btnStart.setBackground(Color.GREEN);
            }
        }else if (e.getSource() == btnThanks){
            try {
                Desktop.getDesktop().browse(new URL("https://4pda.ru/forum/index.php?showuser=2409458").toURI());
            }catch (Exception ignored){ }
        }else if (e.getSource() == btnAndroidVersion){
            dialog.setLocation(screenSize.width/2-200, screenSize.height/2-40);
            dialog.setSize(400, 200);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.setContentPane(androVerContent);
            dialog.setVisible(true);
        }else if (e.getSource() == btnStart) {
            try {
                new CheckOff(WorkDir, fc, androidVersion);
            }catch (Exception ignored){}
        }else if (e.getSource() == btnOk){
            if (andr9.isSelected()) {
                androidVersion = 9;
                labelAndroVer.setText("Android 9");
                labelAndroVer.setFont(font);
                labelAndroVer.setForeground(Color.GREEN);
                condVer = true;
            } else if (andr10.isSelected()) {
                androidVersion = 10;
                labelAndroVer.setText("Android 10");
                labelAndroVer.setFont(font);
                labelAndroVer.setForeground(Color.GREEN);
                condVer = true;
            } else if (andr11.isSelected()) {
                androidVersion = 11;
                labelAndroVer.setText("Android 11");
                labelAndroVer.setFont(font);
                labelAndroVer.setForeground(Color.GREEN);
                condVer = true;
            } else if (andr12.isSelected()) {
                androidVersion = 12;
                labelAndroVer.setText("Android 12");
                labelAndroVer.setFont(font);
                labelAndroVer.setForeground(Color.GREEN);
                condVer = true;
            }
            if (condVer && condDir){
                btnStart.setEnabled(true);
                btnStart.setBackground(Color.GREEN);
            }
            dialog.dispose();
        }
    }

}


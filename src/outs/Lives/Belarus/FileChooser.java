package outs.Lives.Belarus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FileChooser extends JFrame
{
    private  JButton  btnOpenDir    = null;
    private  JButton  btnThanks   = null;
    private  JButton btnAndroidVersion = null;
    public   String   WorkDir = null;
    public FileChooser fc;
    private  JFileChooser fileChooser = null;

    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};
    public FileChooser() {
        super("Отключение проверок Android 10+");
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        fc = this;
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
        addFileChooserListeners();

        // Размещение кнопок в интерфейсе
        JPanel contents = new JPanel();
        contents.add(btnOpenDir);
        contents.add(btnAndroidVersion);
        contents.add(btnThanks);
//        contents.add(btnSaveFile  );
//        contents.add(btnFileFilter);
        setContentPane(contents);
        // Вывод окна на экран
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation(screenWidth/2-200, screenHeight/2-40);
        setSize(400, 120);
        setVisible(true);
    }

    private void addFileChooserListeners() {
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
                    new CheckOff(WorkDir, fc);
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
    }

     private void close(){
        dispose();
    }
}


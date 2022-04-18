package outs.Lives.Belarus;

import de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel;
import outs.Lives.Belarus.CheckOff.CheckOffWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        try {
            UIManager.setLookAndFeel(new SyntheticaDarkLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        new MainContent(screenSize);
    }
}

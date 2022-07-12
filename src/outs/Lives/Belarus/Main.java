package outs.Lives.Belarus;

import de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel;
import outs.Lives.Belarus.CheckOff.CheckOffWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    private static final String MetalLookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String TinyLookAndFeel = "de.muntjak.tinylookandfeel.TinyLookAndFeel";
    private static final String SyntheticaDarkLookAndFeel = "de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel";

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

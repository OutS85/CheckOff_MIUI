package outs.Lives.Belarus;

import de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel;
import outs.Lives.Belarus.CheckOff.CheckOffWindow;

import javax.swing.*;
import java.text.ParseException;

public class Main {

    private static final String MetalLookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String TinyLookAndFeel = "de.muntjak.tinylookandfeel.TinyLookAndFeel";
    private static final String SyntheticaDarkLookAndFeel = "de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel";

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(new SyntheticaDarkLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MyTextFrame myTextFrame = new MyTextFrame();
        new CheckOffWindow(myTextFrame.textArea);
    }
}

package outs.Lives.Belarus;

import outs.Lives.Belarus.CheckOff.CheckOffWindow;

import javax.swing.*;

public class Main {

    private static final String MetalLookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String TinyLookAndFeel = "de.muntjak.tinylookandfeel.TinyLookAndFeel";


    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(MetalLookAndFeel);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        new CheckOffWindow();
    }
}

package outs.Lives.Belarus;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditMiuiFrameworkThread extends Thread{

    private Pattern pattern;
    private Matcher matcher;

    private static String workspace;

    public EditMiuiFrameworkThread(String path) { workspace = path; }

    @Override
    public void run() {
        try {
            editFilesMiuiFramework(workspace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFilesMiuiFramework(String path) throws IOException {

    }
}


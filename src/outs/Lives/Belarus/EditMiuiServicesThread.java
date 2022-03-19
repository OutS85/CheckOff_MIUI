package outs.Lives.Belarus;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditMiuiServicesThread extends Thread {

    private Pattern pattern;
    private Matcher matcher;

    private static String workspace;

    public EditMiuiServicesThread(String path) { workspace = path; }

    @Override
    public void run() {

        try {
            editFilesMiuiServices(workspace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFilesMiuiServices(String path) throws IOException {


    }
}

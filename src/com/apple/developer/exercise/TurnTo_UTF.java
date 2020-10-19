package com.apple.developer.exercise;

import java.io.*;

@SuppressWarnings("all")
public class TurnTo_UTF  {
    public void turnTo(File file) {
        WriteExceptionToLog weto = new WriteExceptionToLog();
        InputStream is = null;
        InputStreamReader isr = null;
        OutputStream os = null;
        OutputStreamWriter osw = null;
        try {
            is = new FileInputStream(file);
            isr = new InputStreamReader(is);
            os = new FileOutputStream(new File("src/turnto.txt"));
            osw = new OutputStreamWriter(os, "UTF-8");

            int n = -1;
            while (-1 != (n = isr.read())) {
                osw.write(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            weto.exceptionToLog(e.getStackTrace(), e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            weto.exceptionToLog(e.getStackTrace(), e.toString());
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    weto.exceptionToLog(e.getStackTrace(), e.toString());
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    weto.exceptionToLog(e.getStackTrace(), e.toString());
                }
            }
        }
    }
}

class WriteExceptionToLog {
    public void exceptionToLog(StackTraceElement[] stackTraceElements, String str) {
        File file = new File("src/exception.log");
        OutputStream os = null;
        OutputStreamWriter osw = null;
        try {
            os = new FileOutputStream(file,true);
            osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(str + "\n");
            for (StackTraceElement ste : stackTraceElements) {
                osw.write(ste.toString() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        new TurnTo_UTF().turnTo(new File("src/exception1.log"));
    }
}

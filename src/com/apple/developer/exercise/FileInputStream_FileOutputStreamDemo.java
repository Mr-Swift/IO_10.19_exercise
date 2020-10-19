package com.apple.developer.exercise;

import java.io.*;

@SuppressWarnings("all")
public class FileInputStream_FileOutputStreamDemo {
    public static void main(String[] args) {
        File f = new File("src/test.txt");
        OutputStream os = null;
        if (!f.exists()) {
            try {
                os = new FileOutputStream(f, false);
                os.write("HelloWorld".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            try {
                os = new FileOutputStream(f, true);
                os.write("HelloWorld".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        InputStream is = null;
        try {
            is = new FileInputStream(f);
            int n = 0;
            while (-1 != (n = is.read())) {
                System.out.print((char) n);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

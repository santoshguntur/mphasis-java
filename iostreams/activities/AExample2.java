package com.company.iostreams.activities;

import java.io.File;
import java.io.FilenameFilter;

public class AExample2 {
    public static void main(String args[]) {
        String dirname = "D:\\git\\Collections\\activities";
        File f1 = new File(dirname);
        FilenameFilter only = ( dir,  name) ->
                 name.toLowerCase().endsWith("txt");

        String s[] = f1.list(only);

        for (int i=0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}

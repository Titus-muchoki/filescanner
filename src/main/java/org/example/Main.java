package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Main aFileScanner = new Main();
        aFileScanner.runFileScanner("in.txt");
    }

    private void runFileScanner(String filePath)
    {
        //Scanner file = null;
        try {
            Scanner file = new Scanner(new File(getClass().getResource(filePath).getPath().replaceFirst("/", "")));

            int num1 = 0;
            if (file.hasNextInt()) {
                num1 = file.nextInt();
            }

            double num2 = 0.0;
            if (file.hasNextDouble()) {
                num2 = file.nextDouble();
            }

            String name = "";
            if (file.hasNext()) {
                name = file.next();
            }

            System.out.printf("The integer read is %1$d \n", num1);
            System.out.printf("The floating point number read is %1$.3f \n", num2);
            System.out.printf("The String read is \"%1$s\" \n", name);
            System.out.printf("Hi! %1$s, the sum of %2$d and %3$.3f is %4$.3f \n"
                    , name, num1, num2, (num1 + num2));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
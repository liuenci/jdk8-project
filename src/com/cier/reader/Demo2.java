package com.cier.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) throws IOException {

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();

        System.out.println(line);


        bufferedReader.close();*/


        Scanner scanner = new Scanner(new FileInputStream("a.txt"));
        String line = scanner.nextLine();
        System.out.println(line);
        scanner.close();
    }
}

package com.Ochoa_PA4;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DuplicateRemover {

    private Set<String> uniqueWords;

    public DuplicateRemover(){
      uniqueWords  = new HashSet<>();
    }
    public void remove(String dataFile) throws IOException{

        try {

            System.out.println(dataFile);
            FileInputStream fileByteStream = null;
            Scanner inFS = null;
            fileByteStream = new FileInputStream(dataFile);
            inFS = new Scanner(fileByteStream);


            System.out.println("Reading words");

            while (inFS.hasNext()) {
                uniqueWords.add(inFS.next());
            }
            inFS.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found Exception 1");
        }
    }

    public void write(String outputFile) throws IOException {
        try{

            FileOutputStream fileByteStr = null;
            PrintWriter outFS = null;
            fileByteStr = new FileOutputStream(outputFile);
            outFS = new PrintWriter(fileByteStr);

            System.out.println("Printing words");

            for(String i: uniqueWords){
              outFS.println(i);
            }
                outFS.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found Exception 2");
        }
    }
}

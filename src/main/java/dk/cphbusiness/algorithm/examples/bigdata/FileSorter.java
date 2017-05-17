package dk.cphbusiness.algorithm.examples.bigdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileSorter {
  public static final long LIMIT = 1_000_000; 
  //public static final long LIMIT = 1_000; 

  public static String sortFile(String inFileName, long count) throws FileNotFoundException, IOException {
    try (BufferedReader inFile = new BufferedReader(new FileReader(inFileName))) {
      return sortFile(inFile, count).getName();
      }
    }
  
  private static File sortFile(BufferedReader inFile, long count) throws IOException {
    System.out.println("Sorting "+count+" lines");
    if (count > LIMIT) {
      File firstFile = sortFile(inFile, count/2);
      File secondFile = sortFile(inFile, count - count/2);
      return mergeFiles(firstFile, secondFile);
      }
    else {
      return sortInMemory(inFile, (int)count);
      }
    }  

  private static File sortInMemory(BufferedReader inFile, int count) throws IOException {
    System.out.println("Sorting "+count+" lines in  memory");
    String[] data = new String[count];
    for (int index = 0; index < count; index++) data[index] = inFile.readLine();
    
    Arrays.sort(data);

    File outFile = File.createTempFile("bigdata", ".txt", new File("/Users/AKA/tmp"));
    try (PrintWriter out = new PrintWriter(outFile)) {
      for (int index = 0; index < count; index++) out.println(data[index]);
      }
    return outFile;
    }
  
  private static File mergeFiles(File firstFile, File secondFile) throws IOException {
    System.out.println("merging ...");
    File outFile = File.createTempFile("bigdata", ".txt", new File("/Users/AKA/tmp"));
    try (BufferedReader inFirst = new BufferedReader(new FileReader(firstFile))) {
      try (BufferedReader inSecond = new BufferedReader(new FileReader(secondFile))) {
        try (PrintWriter out = new PrintWriter(outFile)) {
          String lineFirst = inFirst.readLine();
          String lineSecond = inSecond.readLine();
          while (lineFirst != null && lineSecond != null) {
            int comp = lineFirst.compareTo(lineSecond);
            if (comp <= 0) {
              out.println(lineFirst);
              lineFirst = inFirst.readLine();
              }
            if (comp >= 0) {
              out.println(lineSecond);
              lineSecond = inSecond.readLine();
              }
            }
          while (lineFirst != null) {
            out.println(lineFirst);
            lineFirst = inFirst.readLine();
            }
          while (lineSecond != null) {
            out.println(lineSecond);
            lineSecond = inSecond.readLine();
            }
          }
        }
      }
    firstFile.delete();
    secondFile.delete();
    return outFile;
    }
  
  
  public static void main(String[] args) throws IOException {
    String result = sortFile("/Users/AKA/tmp/bigdata.txt", 500_000_000);
    System.out.println(result);
    }

  }

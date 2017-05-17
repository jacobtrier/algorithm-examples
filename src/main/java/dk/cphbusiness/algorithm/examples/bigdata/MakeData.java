package dk.cphbusiness.algorithm.examples.bigdata;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;



public class MakeData {
  
  public static void main(String[] args) throws Exception {
    Random randomizer = new Random(4711);
    final long size = 500_000_000;
    final long chunk = 1_000_000;
    File file = new File("/Users/AKA/tmp/bigdata.txt");
    for (long index = 0; index < size; index += chunk) {
      try (FileWriter out = new FileWriter(file, true)) {
        for (long l = 0; l < chunk; l++) {
          out.write(""+randomizer.nextDouble()+"\n");
          }
        System.out.println("Index "+index+" reached");
        }
      }
    }

  }

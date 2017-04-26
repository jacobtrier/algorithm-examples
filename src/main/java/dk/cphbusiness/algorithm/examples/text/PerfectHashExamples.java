package dk.cphbusiness.algorithm.examples.text;

public class PerfectHashExamples {

  /**
   * 
   * @param digit should be between 0 and 9 inclusive
   * @return the index
   */
  public static int indexOf(int digit) {
    return digit;
    }
  
  
  /**
   * 
   * @param letter should be between A and Z inclusive
   * @return the index of the letter
   */
  public static int indexOf(char letter) {
    return (int)(letter - 'A');
    }
  
  public static int indexOf(String colour) {
    switch (colour) {
      case "red": return 0;
      case "yellow": return 1;
      case "green": return 2;
      }
    throw new IllegalArgumentException(colour+" is not a colour");
    }
  
  }

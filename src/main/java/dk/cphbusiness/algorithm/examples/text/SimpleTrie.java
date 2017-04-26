package dk.cphbusiness.algorithm.examples.text;

import java.io.PrintStream;

public class SimpleTrie {
  public static int SIZE = indexOf('Z') + 1;

  private String data = null;
  private SimpleTrie[] tries = null; 
  
  private static int indexOf(char letter) { 
    return (int)(letter - 'A');
    }
  
  public void put(String word, String data) {
    if (word.isEmpty()) {
      this.data = data;
      }
    else {
      char letter = word.charAt(0);
      int index = indexOf(letter);
      if (tries == null) tries = new SimpleTrie[SIZE];
      if (tries[index] == null) tries[index] = new SimpleTrie();
      SimpleTrie trie = tries[index];
      trie.put(word.substring(1), data);
      }
    }
  
  public String get(String word) {
    if (word.isEmpty()) return data;
    if (tries == null) return null;
    char letter = word.charAt(0);
    int index = indexOf(letter);
    SimpleTrie trie = tries[index];
    if (trie == null) return null;
    return trie.get(word.substring(1));
    }
  
  public void print(PrintStream out) {
    if (data != null) out.println(data);
    if (tries != null) {
      for (SimpleTrie trie : tries) {
        if (trie == null) continue;
        trie.print(out);
        }
      }
    }

  public static void main(String[] args) {
    SimpleTrie trie = new SimpleTrie();
    trie.put("ANNA", "Anna");
    trie.put("AND", "And");
    trie.put("ANDERS", "Anders");
    
    System.out.println(trie.get("ANNA"));
    System.out.println(trie.get("ANDERS"));
    System.out.println(trie.get("ANDERSINE"));
    
    trie.print(System.out);
    }

  
  }

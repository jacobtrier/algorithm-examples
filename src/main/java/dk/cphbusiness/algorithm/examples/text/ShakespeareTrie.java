package dk.cphbusiness.algorithm.examples.text;

import java.io.PrintStream;

public class ShakespeareTrie {
  
  public class WordCounter {
    String word;
    int count = 1;
    
    public WordCounter(String word) { this.word = word; }

    @Override
    public String toString() {
      return word+" #"+count;
      }
    
    }  
  
  public static int SIZE = indexOf('Z') + 1;

  private WordCounter data = null;
  private ShakespeareTrie[] tries = null; 
  
  private static int indexOf(char letter) { 
    return (int)(letter - 'A');
    }
  
  public void put(String word, String data) {
    if (word.isEmpty()) {
      if (this.data == null) this.data = new WordCounter(data);
      else this.data.count++;
      }
    else {
      char letter = word.charAt(0);
      int index = indexOf(letter);
      if (tries == null) tries = new ShakespeareTrie[SIZE];
      if (tries[index] == null) tries[index] = new ShakespeareTrie();
      ShakespeareTrie trie = tries[index];
      trie.put(word.substring(1), data);
      }
    }
  
  public String get(String word) {
    if (word.isEmpty()) return data.toString();
    if (tries == null) return null;
    char letter = word.charAt(0);
    int index = indexOf(letter);
    ShakespeareTrie trie = tries[index];
    if (trie == null) return null;
    return trie.get(word.substring(1));
    }
  
  public void print(PrintStream out) {
    if (data != null) out.println(data);
    if (tries != null) {
      for (ShakespeareTrie trie : tries) {
        if (trie == null) continue;
        trie.print(out);
        }
      }
    }

  public static void main(String[] args) {
    ShakespeareTrie trie = new ShakespeareTrie();
    trie.put("ANNA", "Anna");
    trie.put("ANNA", "Anna");
    trie.put("AND", "And");
    trie.put("ANDERS", "Anders");
    
    System.out.println(trie.get("ANNA"));
    System.out.println(trie.get("ANDERS"));
    System.out.println(trie.get("ANDERSINE"));
    
    trie.print(System.out);
    }

  
  }

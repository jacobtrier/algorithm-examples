package dk.cphbusiness.algorithm.examples.queues;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> implements PriorityQueue<T> {
  private final T[] data;
  private int size = 0;

//  Does not work - use:  new Heap<String>(new String[capacity])  
//  public Heap(int capacity) {
//    data = (T[])new Object[capacity + 1];
//    }
  
  public Heap(T[] data) {
    this.data = data;
    }
  
  private static int parentOf(int n) { return n/2; }
  
  private static int leftOf(int n) { return 2*n; }
  
  private static int rightOf(int n) { return 2*n + 1; }
  
  private void swap(int n, int m) {
    data[0] = data[n];
    data[n] = data[m];
    data[m] = data[0];
    }
  
  @Override
  public void enqueue(T item) {
    int n = ++size;
    data[n] = item;
    do {
      int p = parentOf(n);
      if (p == 0 || item.compareTo(data[p]) > 0) return; 
      swap(n, p);
      n = p;
      }
    while (true);
    }

  @Override
  public T peek() {
    if (size == 0) throw new NoSuchElementException();
    return data[1];
    }
  
  @Override
  public T dequeue() {
    if (size == 0) throw new NoSuchElementException();
    T result = data[1];
    swap(1, size--);
    
    int n = 1;
    int c = 0;

    do {
      int l = leftOf(n);
      int r = rightOf(n);
      if (l > size) return result;

      if (r > size) c = l;
      else if (data[l].compareTo(data[r]) < 0) c = l;
      else c = r;

      if (data[n].compareTo(data[c]) > 0) {
        swap(n, c);
        n = c;
        }
      else return result;
      }
    while (true);
    }
  
  @Override
  public int size() { return size; }
  
  
  private void print(PrintStream out, int n, String indent) {
    if (n > size) return;
    print(out, rightOf(n), indent+"    ");
    out.println(indent+"("+data[n]+") - "+n);
    print(out, leftOf(n), indent+"    ");
    }
  
  public void print() {
    print(System.out, 1, "");
    }
  
  }

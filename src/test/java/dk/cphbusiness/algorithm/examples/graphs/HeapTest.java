package dk.cphbusiness.algorithm.examples.graphs;

import dk.cphbusiness.algorithm.examples.queues.Heap;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueue;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {
  
  @Test
  public void testSimpleHeap() {
    PriorityQueue<String> heap = new Heap<>(new String[10]);
    heap.enqueue("Bente");
    heap.enqueue("Anders");
    heap.enqueue("Dorte");
    heap.enqueue("Erik");
    heap.enqueue("Christine");
    assertThat(heap.dequeue(), is("Anders"));
    assertThat(heap.dequeue(), is("Bente"));
    assertThat(heap.dequeue(), is("Christine"));
    assertThat(heap.dequeue(), is("Dorte"));
    assertThat(heap.dequeue(), is("Erik"));
    }

  }

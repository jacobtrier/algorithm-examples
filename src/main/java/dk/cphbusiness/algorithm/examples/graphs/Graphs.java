package dk.cphbusiness.algorithm.examples.graphs;

import dk.cphbusiness.algorithm.examples.graphs.Graph.Vertex;
import dk.cphbusiness.algorithm.examples.queues.LinkedQueue;
import dk.cphbusiness.algorithm.examples.queues.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Utility class for graph related functions.
 */
public class Graphs {
  
  public static <D,W> RootedTree<D,W> depthFirst(Graph<D,W> graph, Vertex<D,W> root) {
    Map<Vertex<D,W>,Vertex<D,W>> edgesTo = new HashMap<>();
    
    // TODO: implement
    
    // return YourImplementationOfARootedTree
    throw new UnsupportedOperationException("No support");
    }
  
  public static <D,W> RootedTree<D,W> breadthFirst(Graph<D,W> graph, Vertex<D,W> root) {
    Set<Vertex<D,W>> marks = new HashSet<>();
    Map<Vertex<D,W>,Vertex<D,W>> edgesTo = new HashMap<>();
    Queue<Vertex<D,W>> queue = new LinkedQueue<>();
    
    // TODO: implement
    
    // return YourImplementationOfARootedTree
    throw new UnsupportedOperationException("No support");
    }

  }

package dk.cphbusiness.algorithm.examples.graphs;

import dk.cphbusiness.algorithm.examples.graphs.Graph.Edge;
import dk.cphbusiness.algorithm.examples.graphs.Graph.Vertex;
import dk.cphbusiness.algorithm.examples.queues.LinkedQueue;
import dk.cphbusiness.algorithm.examples.queues.Queue;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for graph related functions.
 */
public class Graphs {
  
  public static <D,W> RootedTree<D,W> depthFirst(Graph<D,W> graph, Vertex<D,W> root) {
    Set<Vertex<D,W>> marked = new HashSet<>();
    RootedTree<D,W> edgesTo = new SimpleRootedTree<>(graph, root);
    
    // TODO: implement
    
    return edgesTo;
    }
  
  public static <D,W> RootedTree<D,W> breadthFirst(Graph<D,W> graph, Vertex<D,W> root) {
    Set<Vertex<D,W>> marked = new HashSet<>();
    Queue<Vertex<D,W>> queue = new LinkedQueue<>();
    RootedTree<D,W> edgesTo = new SimpleRootedTree<>(graph, root);
    
    // TODO: implement

    return edgesTo;
    }

  }

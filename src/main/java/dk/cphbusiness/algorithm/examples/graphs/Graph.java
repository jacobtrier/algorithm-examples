package dk.cphbusiness.algorithm.examples.graphs;

import java.io.PrintStream;
import java.util.Collection;

public interface Graph<D,W> {
  void addVertex(D... data);
  void addEdge(W weight, Vertex<D,W> tail, Vertex<D,W> head, boolean directed);
  
  default void addEdge(W weight, D tailData, D headData, boolean directed) {
    addEdge(weight, vertexOf(tailData), vertexOf(headData), directed);
    }
  
  Vertex<D, W> vertexOf(D data);
  
  Collection<Vertex<D,W>> getVertices();
  Collection<Edge<D,W>> getEdges();
  
  void print(PrintStream out);
  
  interface Vertex<D,W> {
    D getData();
    Collection<Edge<D,W>> getAdjacentEdges();
    }
  
  interface Edge<D,W> {
    W getWeight();
    Vertex<D,W> getHeadVertex();
    }
  
  }

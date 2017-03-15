package dk.cphbusiness.algorithm.examples.graphs;

import java.util.Collection;

public interface Graph<D,W> {
  void addVertex(D... data);
  void addEdge(W weight, Vertex<D,W> tail, Vertex<D,W> head, boolean directed);
  
  Collection<Vertex<D,W>> getVertices();
  Collection<Edge<D,W>> getEdges();
  
  public interface Vertex<D,W> {
    D getData();
    Collection<Edge<D,W>> getAdjacentEdges();
    }
  
  public interface Edge<D,W> {
    W getWeight();
    Vertex<D,W> getHeadVertex();
    }
  
  }

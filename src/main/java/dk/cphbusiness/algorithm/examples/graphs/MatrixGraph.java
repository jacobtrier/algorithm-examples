package dk.cphbusiness.algorithm.examples.graphs;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;

public class MatrixGraph<D, W> implements Graph<D, W> {
  private W[][] weights = (W[][]) new Object[0][0];
  private D[] data = (D[]) new Object[0];

  public MatrixGraph(D... data) {
    addVertex(data);
    }
  
  @Override
  public void print(PrintStream out) {
    out.print("\nVertices          Edges ");
    for (int j = 0; j < data.length; j++) out.printf("%4d", j);
    out.print("\n----------------  ----------------------------------------------------------------");
    for (int i = 0; i < data.length; i++) {
      out.printf("\n%3d | %-8s    %3d | ", i, data[i], i);
      for (int j = 0; j < data.length; j++) out.printf("%4s", weights[i][j] == null ? "." : weights[i][j]);
      }
    out.println();
    out.println();
    }
  
  @Override
  public final void addVertex(D... newData) {
    int newSize = newData.length + data.length;
    D[] tempData = (D[]) new Object[newSize];
    W[][] tempWeights = (W[][]) new Object[newSize][newSize];
    for (int i = 0; i < newSize; i++) {
      if (i < data.length) {
        tempData[i] = data[i];
        for (int j = 0; j < data.length; j++)
            tempWeights[i][j] = weights[i][j];
        }
      else tempData[i] = newData[i - data.length];
      }
    this.data = tempData;
    this.weights = tempWeights;
    }

  @Override
  public Vertex<D, W> vertexOf(D data) {
    for (int i = 0; i < this.data.length; i++)
        if (this.data[i].equals(data)) return new MatrixVertex(i);
    return null;
    }
  
  @Override
  public void addEdge(W weight, Vertex<D, W> tail, Vertex<D, W> head, boolean undirected) {
    MatrixVertex t = (MatrixVertex)tail;
    MatrixVertex h = (MatrixVertex)head;
    weights[t.i][h.i] = weight;
    if (undirected) weights[h.i][t.i] = weight;
    }

  @Override
  public Collection<Vertex<D, W>> getVertices() {
    Collection<Vertex<D, W>> result = new HashSet<>();
    for (int i = 0; i < data.length; i++) result.add(new MatrixVertex(i));
    return result;
    }

  @Override
  public Collection<Edge<D, W>> getEdges() {
    Collection<Edge<D, W>> result = new HashSet<>();
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data.length; j++) {
        if (weights[i][j] == null) continue;
        result.add(new MatrixEdge(i, j));
        }
      }
    return result;
    }

  @Override
  public Collection<Edge<D, W>> getEdgesFrom(Vertex<D, W> vertex) {
    int i = ((MatrixVertex)vertex).i;
    // Code moved from MatrixVertex.getAdjacentEdges()
    Collection<Edge<D,W>> result = new HashSet<>();
    for (int j = 0; j < data.length; j++) {
      if (weights[i][j] == null) continue;
      result.add(new MatrixEdge(i, j));
      }
    return result;
    }
  
  private class MatrixVertex implements Vertex<D, W> {
    private final int i;

    public MatrixVertex(int i) {
      this.i = i;
      }
    
    @Override
    public D getData() {
      return data[i];
      }

    @Override
    public Collection<Edge<D, W>> getAdjacentEdges() {
// DONE: Code moved to MatrixGraph class
// -------------------------------------
//      Collection<Edge<D,W>> result = new HashSet<>();
//      for (int j = 0; j < data.length; j++) {
//        if (weights[i][j] == null) continue;
//        result.add(new MatrixEdge(i, j));
//        }
//      return result;
      return getEdgesFrom(this);
      }

    @Override
    public String toString() {
      return "["+i+"] "+getData();
      }

    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (!(other instanceof MatrixGraph.MatrixVertex)) return false;
      return i == ((MatrixVertex)other).i;
      }

    @Override
    public int hashCode() {
      return toString().hashCode();
      }
    
    }
  
  private class MatrixEdge implements Edge<D, W> {
    private final int i;
    private final int j;

    public MatrixEdge(int i, int j) {
      this.i = i;
      this.j = j;
      }
    
    @Override
    public W getWeight() {
      return weights[i][j];
      }

    @Override
    public Vertex<D, W> getHeadVertex() {
      return new MatrixVertex(j);
      }

    @Override
    public String toString() {
      return "["+i+"] "+data[i]+" --("+weights[i][j]+")-> ["+j+"] "+data[j];
      }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!(obj instanceof MatrixGraph.MatrixEdge)) return false;
      MatrixEdge other = (MatrixEdge)obj;
      return i == other.i && j == other.j;
      }

    @Override
    public int hashCode() {
      return toString().hashCode();
      }
    
    }

  }

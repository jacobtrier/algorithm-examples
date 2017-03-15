package dk.cphbusiness.algorithm.examples.graph;

import dk.cphbusiness.algorithm.examples.graphs.Graph;
import dk.cphbusiness.algorithm.examples.graphs.MatrixGraph;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixGraphTest {
  
  @Test
  public void testCreateEmptyGraph() {
    Graph<String,Integer> graph = new MatrixGraph<>();
    assertTrue(graph.getEdges().isEmpty());
    assertTrue(graph.getVertices().isEmpty());
    }
  
  @Test
  public void testCreateSimpleGraph() {
    Graph<String,Integer> graph = new MatrixGraph<>("Anders", "Bente");
    assertThat(graph.getEdges().size(), is(0));
    assertThat(graph.getVertices().size(), is(2));
    }
  
  @Test
  public void testCreateSimpleConnectedGraph() {
    Graph<String,Integer> graph = new MatrixGraph<>("Anders", "Bente");
    Graph.Vertex<String,Integer> tail = graph.vertexOf("Anders");
    Graph.Vertex<String,Integer> head = graph.vertexOf("Bente");
    graph.addEdge(1, tail, head, true);
    assertThat(graph.getEdges().size(), is(2));
    assertThat(graph.getVertices().size(), is(2));
    }
  
  }

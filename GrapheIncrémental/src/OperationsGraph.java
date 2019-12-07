import java.io.IOException;

import parser.Parser;

public class OperationsGraph {

	////////////////////////////// Methods///////////////////////////////////
	public void constructRNG(Graph graph) {
		double[][] arrayDist = new double[graph.getNbVertices()][graph.getNbVertices()];
		for (int vertexIndex1 = 0; vertexIndex1 < graph.getNbVertices(); vertexIndex1++) {
			for (int vertexIndex2 = vertexIndex1 + 1; vertexIndex2 < graph.getNbVertices(); vertexIndex2++) {
				arrayDist[vertexIndex1][vertexIndex2] = calculDist(graph.getVertexFromList(vertexIndex1),
						graph.getVertexFromList(vertexIndex2));
			}
		}
		// TODO : choose the edge to draw ...
	}

	public Vertex findNearest(Vertex vertex, Graph graph) {
		return vertex;
	}

	/**
	 * Calculate the distance between 2 vertices
	 * 
	 * @param vertex1
	 * @param vertex2
	 * @return the distance
	 */
	public double calculDist(Vertex vertex1, Vertex vertex2) {
		double distance, somme = 0;
		for (int i = 0; i < vertex1.getSizeList(); i++) {
			somme += Math.pow((vertex1.getData(i) - vertex2.getData(i)), 2);
		}
		distance = Math.sqrt(somme);
		return distance;
	}

	public void extractSubgrah(Graph graph, Vertex nearestVertex) {

	}

	public void mergeSubgraph(Graph mainGraph, Graph subGraph) {
		// TODO
	}

	/**
	 * read a new vertex in the file
	 * @param parser the parser who is use to read the file
	 * @param idVertex the id of he new vertex
	 * @return the new vertex
	 */
	public Vertex readNewVertex(Parser parser, Integer idVertex) {
		try {
			Vertex vertex = new Vertex(idVertex);
			if(parser.readLigne() == null) {
				return null;
			}
			for (int i = 0; i < 4; ++i) {
				vertex.addData(parser.parserFloat());
				parser.parserNext();
			}
			vertex.setCategory(parser.parserString());
			return vertex;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

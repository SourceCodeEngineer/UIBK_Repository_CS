package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Digraph {

	public static final class Edge {
		public final int src, tgt, weight;

		public Edge(int src, int weight, int tgt) {
			this.src = src;
			this.tgt = tgt;
			this.weight = weight;
		}

		@Override
		public int hashCode() {
			return Objects.hash(src, tgt, weight);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			return src == other.src && tgt == other.tgt && weight == other.weight;
		}

	}

	private int nNodes;
	
	private Set<Edge> edges = new HashSet<>();
	
	public Digraph(int nNodes, Iterable<Edge> edges) {
		this.nNodes = nNodes;
		for (Edge e : edges)
			this.edges.add(e);
	}
	
	Integer[][] floyd() {
		Integer[][] m = new Integer[nNodes][nNodes];
		
		// Initialisation phase
		for (int i = 0; i < nNodes; i++)
			m[i][i] = 0;
		for (Edge e : edges) {
			Integer tmp = m[e.src - 1][e.tgt - 1];
			if (tmp == null || e.weight < tmp)
				m[e.src - 1][e.tgt - 1] = e.weight;
		}

		for (int r = 0; r < nNodes; r++)
			for (int i = 0; i < nNodes; i++)
				for (int j = 0; j < nNodes; j++)
					if (m[i][r] != null && m[r][j] != null && 
							(m[i][j] == null || m[i][j] > m[i][r] + m[r][j]))
						m[i][j] = m[i][r] + m[r][j];

		return m;
	}
	
 	public static void printDistanceMatrix(Integer[][] m) {
		for (int i = 0; i < m.length; i++) {
			int l = m[i].length;
			for (int j = 0; j < l; j++) {
				System.out.print((m[i][j] == null) ? "∞" : m[i][j]);
				if (j == l - 1)
					System.out.println();
				else
					System.out.print("\t");
			}
		}
	}
	
	public static void main(String[] args) {
		Digraph exampleGraph = 
				new Digraph(4, List.of(new Edge(1, 1, 1), new Edge(1, 1, 2), new Edge(2, 1, 3), new Edge(2, 1, 4), 
						new Edge(3, 1, 3), new Edge(3, 1, 4), new Edge(4, 1, 1)));
		Digraph homeworkGraph1 = new Digraph(4, List.of(new Edge(2, 5, 4), new Edge(2, 1, 2), new Edge(2, 4, 1), 
				new Edge(3, 6, 1), new Edge(3, 1, 2), new Edge(4, 3, 3), new Edge(4, 7, 4)));
		Digraph homeworkGraph2 = new Digraph(4, List.of(new Edge(2, -3, 4), new Edge(2, 1, 2), new Edge(2, 4, 1), 
				new Edge(3, 6, 1), new Edge(3, 1, 2), new Edge(4, 3, 3), new Edge(4, 7, 4)));
		Digraph homeworkGraph3 = new Digraph(4, List.of(new Edge(2, -5, 4), new Edge(2, 1, 2), new Edge(2, 4, 1), 
				new Edge(3, 6, 1), new Edge(3, 1, 2), new Edge(4, 3, 3), new Edge(4, 7, 4)));
		
		printDistanceMatrix(exampleGraph.floyd());
		System.out.println();
		
		printDistanceMatrix(homeworkGraph1.floyd());
		System.out.println();
		
		printDistanceMatrix(homeworkGraph2.floyd());
		System.out.println();
		
		printDistanceMatrix(homeworkGraph3.floyd());
		System.out.println();
	}
	
}

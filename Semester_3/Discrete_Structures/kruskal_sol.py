from partition import Partition
from collections import namedtuple

"""
An edge e is a named triple. Access the components like this: e.node1, e.node2, e.weight
"""
Edge = namedtuple('Edge', 'node1 node2 weight')

"""
A graph is simply a (named) pair whose components are a list of its nodes and a list of its edges.
Edges that occur multiple times are to be treated as parallel edges. Whether a node is "node1" or
"node2" has no significance. Loops are edges with node1 == node2.
"""
WeightedGraph = namedtuple('WeightedGraph', 'nodes edges')

"""
The graph from the lecture (slide 26)
Since this was an unweighted graph, we simply set the weight of the edge e_i to i for this example.
"""
lecture_graph = \
    WeightedGraph(
      nodes = list(range(1, 8)),
      edges = [Edge(2, 5, weight=1), Edge(5, 6, weight=2), Edge(3, 4, weight=3), Edge(1, 2, weight=4), 
               Edge(2, 6, weight=5), Edge(4, 7, weight=6), Edge(1, 5, weight=7), Edge(3, 7, weight=8)]
    )

"""
The graph from Homework Sheet 8.
Weights added as for the last graph.
"""
homework_graph = \
    WeightedGraph(
      nodes = list(range(0, 7)),
      edges = [Edge(2, 3, weight=1), Edge(1, 3, weight=2), Edge(5, 6, weight=3), Edge(1, 1, weight=4), 
               Edge(1, 2, weight=5), Edge(0, 1, weight=6), Edge(2, 4, weight=7), Edge(0, 2, weight=8), 
               Edge(4, 2, weight=9)]
    )

def kruskal(graph):
    es = sorted(graph.edges, key = lambda e: e.weight)
    forest = list()
    components = Partition(domain = graph.nodes)
    for e in es:
        if components.find(e.node1) != components.find(e.node2):
            forest.append(e)
            components.union(e.node1, e.node2)
    return forest


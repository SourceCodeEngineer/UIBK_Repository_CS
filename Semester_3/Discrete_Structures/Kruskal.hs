module Kruskal where

import qualified Partition as P
import Data.List (sortOn)

type Node = Int
type Weight = Int
type Edge = (Node, Weight, Node)

{- |
  A weighted undirected graph with a given set of nodes and edges. Note that:
  – The triple (1, 2, 3) models an edge between nodes 1 and 3 with weight 2.
  – The triple (3, 2, 1) has the exact same meaning.
  – If an edge occurs in the list multiple times, each occurrence is to be interpreted
    as a separate edge (i.e. parallel edges are allowed).
  – "Loop" edges like (1, 2, 1) are also allowed.
-}
data WeightedGraph = WeightedGraph {
  nodes :: [Node],
  edges :: [Edge]
}

kruskal :: WeightedGraph -> [Edge]
kruskal (WeightedGraph ns es) = reverse (snd (foldl handleEdge (P.discrete ns, []) es'))
  where es' = sortOn (\(_, wt, _) -> wt) es
        handleEdge (components, forest) e@(u, _, v)
          | P.find u components == P.find v components = (components, forest)
          | otherwise = (P.union u v components, e : forest)

-- The example graph from the lecture (week 7 slides, slide 26)
-- Since this was an unweighted graph, we simply set the weight of the edge e_i to i for this example.
lectureGraph :: WeightedGraph
lectureGraph =
  WeightedGraph [1..7] [(2, 1, 5), (5, 2, 6), (3, 3, 4), (1, 4, 2), (2, 5, 6), (4, 6, 7), (1, 7, 5), (3, 8, 7)]

-- The graph from Homework Sheet 8. Again, weights were added in the same manner as before.
homeworkGraph :: WeightedGraph
homeworkGraph =
  WeightedGraph [0..6] [(2, 1, 3), (1, 2, 3), (5, 3, 6), (1, 4, 1), (1, 5, 2), (0, 6, 1), (2, 7, 4), (0, 8, 2), (4, 9, 2)]


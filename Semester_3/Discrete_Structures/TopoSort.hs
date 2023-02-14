module TopoSort where

import Data.Map (Map)
import qualified Data.Map as Map
import Data.Set (Set)
import qualified Data.Set as Set

type Node = Int
type Edge = (Node, Node)


data DAG = DAG {
  nodes :: [Node],
  edges :: [Edge]
}

{-
    To avoid unnecessary work, we build a lookup table (a map) that maps every node to a set of its 
    immediate successors (resp. predessors). We also maintain a list of currently minimal elements.
    The predecessor sets are updated whenever we delete an element; for the successor sets this is
    not necessary.
-}
topoSort :: DAG -> [Node]
topoSort (DAG ns es) = go predecessorMap initialMinima
  where -- maps that map any node to a set of its immediate successors (resp. predecessors)
        successorMap = Map.fromListWith Set.union [(u, Set.singleton v) | (u, v) <- es]
        succs v = Map.findWithDefault Set.empty v successorMap
        
        predecessorMap = Map.fromListWith Set.union [(v, Set.singleton u) | (u, v) <- es]
        preds v = Map.findWithDefault Set.empty v predecessorMap
        
        -- All nodes that have no predecessors are minimal.
        initialMinima = Set.fromList [v | v <- ns, Set.null (preds v)]
        
        -- We now pick a minimal node, add it to our result, delete it from the graph,
        -- update our list of minima with any new minimal nodes created by this deletion, and
        -- repeat that process until no nodes are left.
        go predecessorMap minima =
          case Set.minView minima of
            Nothing -> []
            Just (u, minima') -> 
              let -- delete u from the predecessor set of all its successors
                  predecessorMap' = foldr (\v m -> Map.adjust (Set.delete u) v m) predecessorMap (succs u)
                  -- all successors of u that now have no predecessor anymore are minimal
                  newMinima = Set.filter (\v -> null (Map.findWithDefault Set.empty v predecessorMap')) (succs u)
              in  u : go predecessorMap' (Set.delete u (Set.union minima newMinima))
              
exampleDag :: DAG
exampleDag = DAG [0..4] [(0, 1), (0, 2), (0, 3), (1, 4), (2, 4), (3, 4)]

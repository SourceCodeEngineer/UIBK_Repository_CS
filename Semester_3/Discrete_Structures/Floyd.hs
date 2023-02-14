import qualified Data.Array as A
import Data.List

type Node = Int
type Weight = Int
data Dist = Finite Int | Infinity
  deriving (Eq, Ord)
  
instance Show Dist where
  show (Finite x) = show x
  show Infinity   = "∞"

instance Num Dist where
  Infinity + _ = Infinity
  _ + Infinity = Infinity
  Finite x + Finite y = Finite (x + y)
  fromInteger = Finite . fromInteger



data WeightedGraph = WeightedGraph {
  nNodes :: Int,
  edges :: [(Node, Weight, Node)]
}


newtype DistMatrix = DistMatrix (A.Array (Node, Node) Dist)

size :: DistMatrix -> Int
size (DistMatrix a) = fst (snd (A.bounds a))

instance Show DistMatrix where
  show mat = unlines [intercalate "\t" [show (mat ! (i, j)) | j <- [1..size mat]] | i <- [1..size mat]]

mkMatrix :: Int -> (Int -> Int -> Dist) -> DistMatrix
mkMatrix n f = DistMatrix $ A.array ((1, 1), (n, n)) [((i, j), f i j) | i <- [1..n], j <- [1..n]]

(!) :: DistMatrix -> (Int, Int) -> Dist
mat ! (i, j) = case mat of DistMatrix a -> a A.! (i, j)


minimum' :: [Int] -> Dist
minimum' xs = if null xs then Infinity else Finite (minimum xs)

{-
  Note: the initialisation step is not particularly efficient.
-}
floyd :: WeightedGraph -> DistMatrix
floyd graph = go 1 initMatrix
  where n = nNodes graph
  
        initDist i j
          | i == j    = 0
          | otherwise = minimum' [w | (u, w, v) <- edges graph, u == i, v == j]
        initMatrix = mkMatrix n initDist
        
        go r matrix
          | r > n     = matrix
          | otherwise = go (r + 1) $ mkMatrix n (\i j -> min (matrix ! (i, j)) (matrix ! (i, r) + matrix ! (r, j)))
          
exampleGraph = WeightedGraph 4 [(1, 1, 1), (1, 1, 2), (2, 1, 3), (2, 1, 4), (3, 1, 3), (3, 1, 4), (4, 1, 1)]


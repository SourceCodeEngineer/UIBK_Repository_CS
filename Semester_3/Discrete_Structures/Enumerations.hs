{-
  This file implements some of the constructions for countably infinite sets from the lecture.
-}
import Data.List
import Data.Ratio

-- We model an enumeration as an infinite list with no repeated elements. These two facts are an
-- implicit invariant that we always have to preserve.
type Enumeration a = [a]

-- An enumeration of the natural numbers
nats :: Enumeration Integer
nats = [0..]

-- An enumeration of the union of two disjoint sets. We simply alternate between the two enumerations.
disjUnion :: Enumeration a -> Enumeration a -> Enumeration a
disjUnion (x : xs) (y : ys) = x : y : disjUnion xs ys

-- An enumeration of the integers. We can handle the image operation with a simple "map"
-- (i.e. apply the function to each value in the enumeration) because it is injective,
-- so we introduce no duplicates this way.
ints :: Enumeration Integer
ints = disjUnion nats (map (\n -> -n - 1) nats)

-- An enumeration of the image of a countably infinite set under a (not necessarily injective) function
-- If f is not injective, we only keep the value that occurs first and skip all others.
image :: Eq b => (a -> b) -> Enumeration a -> Enumeration b
image f xs = nub (map f xs)

-- Given enumerations of two countably infinite sets, compute an enumeration of their cartesian product
-- in exactly the way presented on the lecture slides
pairs :: Enumeration a -> Enumeration b -> Enumeration (a, b)
pairs xs ys = go 1
  where -- the 0-th diagonal contains the values (x_0, y_n), (x_1, y_{n-1}), ..., (x_n-1, y_1), (x_n, y_0).
        go n = zip (take n xs) (reverse (take n ys)) ++ go (n + 1)

-- An enumeration of the rationals. We start with pairs of integers and then skip all the pairs that have 
-- a 0 in the second component and then we take the image under the function that maps the pair (a,b) to
-- the rational number a / b. This is not an injective function, so we have to skip over duplicates this time.
rats :: Enumeration Rational
rats = image (\(a,b) -> a % b) (filter (\(a,b) -> b /= 0) (pairs ints ints))

-- To experiment with this, just do e.g. "take 10 (pairs ints ints)".

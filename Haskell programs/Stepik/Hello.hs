module Demo where

seqA :: Integer -> Integer
seqA n | n == 0 = 1
       | n == 1 = 2
       | n == 2 = 3
       | n >= 3 = let
            helper counter k2 k1 k | counter == n = k2 
                                   | otherwise = helper (counter + 1) (k2 + k1 - 2 * k) k2 k1
        in helper 2 3 2 1
       | otherwise = error "args must be >= 0"

fibonacci :: Integer -> Integer
fibonacci n | n == 0 = 0
            | n >= 1 = let 
                helper 0 k1 k2 = k1
                helper n k1 k2 = helper (n - 1) (k1 + k2) k1
            in helper (n - 1) 1 0
            | otherwise = let
                helper 0 k1 k2 = k1
                helper n k1 k2 = helper (n + 1) (k2 - k1) k1
            in helper n 0 1


sum'n'count :: Integer -> (Integer, Integer)
sum'n'count x | x == 0 = (0, 1) 
              | otherwise = helper 0 0 x where 
    helper sum count 0 = (sum, count)
    helper sum count x = helper (sum + abs (x `rem` 10)) (count + 1)  (x `quot` 10)
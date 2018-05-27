

# Purity project 

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7b1a99f92fb34e7487bdaa1a145e3bc8)](https://app.codacy.com/app/ditekunov/Purity-Project?utm_source=github.com&utm_medium=referral&utm_content=ditekunov/Purity-Project&utm_campaign=badger)

This project contains realisations of common-used math functions and classical algorithms, written in Scala's pure-functional style.

Some of them are a new sight at Scala's standard library, some are persistent data structures, some are completely new functions.

The main purpose of this library is to spread ideas of a functional programming in Scala and to challenge yourself by creating classical imperative algorithms in a new way.

Would be great, if you contribute, in case that presented algorithms are not as effective as they can be, and you know how to fix this, or if you have ideas, that can be added in the future.

# Current list of supported algorithms:

### Sorting algorithms:
1) Quick sort [`sortingAlgorithms/QuickSort`](src/main/scala/sortingAlgorithms/QuickSort.scala)

2) Bogosort [`sortingAlgorithms/unseriousAlgorithms/Bogosort`](src/main/scala/sortingAlgorithms/unseriousAlgorithms/Bogosort.scala)

3) Sleep sort [`sortingAlgorithms/unseriousAlgorithms/SleepSort`](src/main/scala/sortingAlgorithms/unseriousAlgorithms/SleepSort.scala)

4) Bubble sort [`sortingAlgorithms/BubbleSort`](src/main/scala/sortingAlgorithms/BubbleSort.scala)

5) Merge sort [`sortingAlgorithms/MergeSort`](src/main/scala/sortingAlgorithms/MergeSort.scala)

6) Insertion sort [`sortingAlgorithms/InsertionSort`](src/main/scala/sortingAlgorithms/InsertionSort.scala)

7) Selection sort [`sortingAlgorithms.SelectionSort`](src/main/scala/sortingAlgorithms/SelectionSort.scala)

8) Heap sort [`sortingAlgorithms.HeapSort`](src/main/scala/sortingAlgorithms/HeapSort.scala)

### Persistent data structures:
1) LinkedList [`dataStructures.LinkedList`](src/main/scala/dataStructures/LinkedList.scala)

2) Queue [`dataStructures.Queue`](src/main/scala/dataStructures/Queue.scala)

3) Stack [`dataStructures.Stack`](src/main/scala/dataStructures/Stack.scala)

4) Set [`dataStructures.Set`](src/main/scala/dataStructures/Set.scala)

5) Binary tree [`dataStructures.BinaryTree`](src/main/scala/dataStructures/BinaryTree.scala)

6) Heap [`dataStructures.Heap`](src/main/scala/dataStructures/Heap.scala)

7) Red-Black Tree [`dataStructures.RedBlackTree`](src/main/scala/dataStructures/RedBlackTree.scala)

### Integer operations:
[`integerOperations.IntegerProperties`](src/main/scala/integerOperations/IntegerProperties.scala)
1) .isOdd 

2) .isEven

3) .isSquared

4) .sumOfDigits

5) .compositionOfDigits

6) .numOfDigits

7) .divisors

10) .nthGreatestDivisor(n)

11) .numOfDivisors

12) .sumOfDivisors

13) .isPrime, works with O(sqrt(n)) speed

14) .isPrimeFermat(). works with O(log(n)) speed

15) .sqr

16) .powN()

17) .gcdWith(secondInt)

18) .isPrimeFermatStrict (does not fail on Carmichael numbers, works slowly)

19) .isPrimeFermatFast (does not fail on Carmichael numbers, works fast, only with Ints)

20) .lcmWith(secondInt)

21) factorial (!)

### Additional Integers math:
[`integerOperations.IntegerMath`](src/main/scala/integerOperations/IntegerMath.scala)
1) .isFreeOfSquares

2) .isCarmichael

3) .isLuc_Carmichael

4) .isFibonacci

5) .nthCatalan

6) .binaryPower(), works with O(log(n)) speed

7) .isZuckerman

8) .isHarshad

9) .gcdExtendedWith()


### Integer lists generators:
[`integerOperations.IntegerGenerators`](src/main/scala/integerOperations/IntegerGenerators.scala)
1) Arithmetic regression

2) Arithmetic progression

3) Squares until N

4) Divisors of N

5) Binary divisors of N

6) Divisors, multiple by N

7) Prime divisors

8) Carmichael numbers

9) Luc-Carmichael numbers

10) Fibonacci numbers

11) Random ints

12) Catalan numbers

### Additional math generators:
[`integerOperations.IntegerGeneratorsMath`](src/main/scala/integerOperations/IntegerGeneratorsMath.scala)
1) Fermat numbers

2) Eratosthenes primes sieve O(log(log(n)))

### Char operations:
[`charOperations.CharProperties`](src/main/scala/charOperations/CharProperties.scala)
1) .isVowel

2) .isConsonant

### Double operations:
[`doubleOperations.DoubleProperties`](src/main/scala/doubleOperations/DoubleProperties.scala)
1) .inverse

2) .sqrDouble

3) .abs

4) .toDegrees

5) .incDouble

### List/values operations:
[`listOperations`](src/main/scala/listOperations)
1) get(List[A], index)

2) isPalindrome(List[A])

3) isPalindrome([A])

3) Counter for the number of sign changes in a list of integers

4) Counter for the number of letter changes from vowel to consonant in a list of integers

5) .isSorted

6) binary search in a list

7) linear search in a list

8) permutations(List[A], len)

### Basic combinatorics:
[`combinatorics`](src/main/scala/combinatorics)
1) permutationsCount

2) accomodations

3) combinations

### Encoders:
1) RLE [`cryptographyOperations.encoders.RLE_Encoder`](src/main/scala/cryptographyOperations/encoders/RLE_Encoder.scala)

2) Huffman [`cryptographyOperations.encoders.HuffmanEncoder`](src/main/scala/cryptographyOperations/encoders/HuffmanEncoder.scala)

3) Gray [`cryptographyOperations.encoders.GrayEncoder`](src/main/scala/cryptographyOperations/encoders/GrayEncoder.scala)

4) Morse [`cryptographyOperations.encoders.MorseEncoder`](src/main/scala/cryptographyOperations/encoders/MorseEncoder.scala)

### Decoders:
1) RLE [`functionalAlgorithms.decoders.RLE_Decoder`](src/main/scala/cryptographyOperations/decoders/RLE_Decoder.scala)

2) Huffman [`functionalAlgorithms.decoders.HuffmanDecoder`](src/main/scala/cryptographyOperations/decoders/HuffmanDecoder.scala)

3) Gray [`functionalAlgorithms.decoders.GrayDecoder`](src/main/scala/cryptographyOperations/decoders/GrayDecoder.scala)

4) Morse [`functionalAlgorithms.decoders.MorseDecoder`](src/main/scala/cryptographyOperations/decoders/MorseDecoder.scala)

### Additional arithmetics:
1) Rational numbers [`rationalOperations.Rational`](src/main/scala/rationalOperations/Rational.scala)

2) Complex numbers [`complexOperations.Complex`](src/main/scala/complexOperations/Complex.scala)

### Math constants: 
[`MathConstants`](src/main/scala/utils/MathConstants.scala)
1) Pi

2) Tau

3) E

4) Pythagoras constant

5) Theodorus constant

6) Gamma

7) Phi

8) Plastic number

##### Planned:
1) Operations with double

# Some sources, that were used via development:

0) Martin Odersky's "Functional Programming in Scala Specialization "https://www.coursera.org/specializations/scala"

1) Chris Okasaki's "Purely Functional Data Structures" (English)

2) Richard Bird's "Pearls of Functional Algorithm Design" (English)

3) Denis Shevchenko's "About Haskell in a human way": https://www.ohaskell.guide (Russian)

4) Louis Botterill's mostly software and techy Blog: http://louisbotterill.blogspot.ru (English)

5) Alvin Alexander's scala blog: https://alvinalexander.com (English)

6) Richard G.E. Pinch "The Carmichael numbers up to 10^18" https://arxiv.org/pdf/math/0604376v1.pdf

7) Site about algorithms http://e-maxx.ru (Russian/English)

8) "Rosetta code" website about algorithms: https://rosettacode.org/wiki/Rosetta_Code (English)

9) Vladimir Kostykov's Scala algorithms library: https://github.com/vkostyukov/scalacaster


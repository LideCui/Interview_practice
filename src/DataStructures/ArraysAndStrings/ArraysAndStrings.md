 ### Hash Tables
 implementation:
 1. Compute key's hash code. Different keys may have the same hash code.
 2. Map hash code to an index on an array. Different code may have the same index.
 3. At this index, there is a linked list of keys and values.
 
 The worst lookup time is O(N), good implementation is almost O(1). We could also 
 implement with a balanced binary search tree, which gives O(log N).
 
 \* hash table collision resolution p636
 
 ### ArrayList
 Why amortized insertion runtime O(1)?
 Insert N elements takes O(N) work in total. Each insertion is O(1) on average,
 even though some insertions take O(N) time in the worst case.
 
 ### String Builder
 String Buffer creates a resizable array of the strings.
 
 \* Rabin-Karp Substring search p636
 
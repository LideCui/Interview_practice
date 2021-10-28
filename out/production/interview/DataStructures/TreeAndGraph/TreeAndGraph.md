### Tree
concepts: trees, binary tree, binary search tree, balanced, unbalanced
complete binary tree, full binary tree, perfect binary tree.

traversal : in-order, pre-order, post-order

### Heap
heap is a complete binary tree. For example, in min-heap, every node is smaller 
than their children. 

Insert: start by inserting element at the bottom, then we fix the tree by swapping 
elements with its parent. Until we find appropriate spot the element. O(log N)

Extract: first, we remove the min element and swap it with last element in the heap.
Then we bubble down the element, swapping it with one of its children until the min-heap
is restored.  O(log N)

### Trie
Trie has a special kind of node, which indicate a complete word. It is useful for
quick prefix lookups. 

### Graph
Graph can be implemented by:
1. Adjacency list
2. Adjacency matrices

Graph traversal:
1. DFS, used for traversing all nodes
```java
void search(Node root){
    if (root == null) return;
    visit(root);
    root.visited = true;
    for(Node n: root.adjacencyList){
        if(n.visited == false) search(n);
    }
}
```
2. BFS, used for finding the shortest path
```java
void search(Node root){
    Queue<Node> queue = new Queue<>();
    root.marked = true;
    queue.enqueue(root);
    
    while(! queue.isEmpty()){
        Node r = queue.dequeue();
        visit(r);
        for(Node n: r.adjacencyList){
            if(n.marked == false) {
                n.marked = true;
                queue.enqueue(n);
            }
        }   
    }
}
```

additional reading: Topological Sort p632, Dijkstra's Algorithm p633, 
AVL tree p637, red-black tree p639
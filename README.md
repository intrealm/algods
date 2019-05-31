# Readme notes

##Abstract Data Types vs Data Structure
#####Abstract Data Types
    Mathematical model of how it will used
    Behaviour is Defined by set of vairables and the operations

    Assume it as interfaces
    
Eg, List, Collection, Queue
#####Data Structure 
    Are concrete represenation of the data(point of view of the implementation)
    
Eg. LinkedList, ArrayList, 


Complexity
    is based on the worst scenario, defined based on the problem.
    determined how the number of operations changes if the size of the problme increases


O1 
ON2 quadratic square - > 
ON linear

ON2+ ON ===> ON2 lower order is ignored
ON2+ 1000 ===> 1000 is ignored

# preferences on the complexicity
    O1 < ON < ON2 <ON3 < ONN
  
  
###2^K = N
    log2^K = logN
    KLog2 = logN
    since Logbase2 ^ 2 = 1
    K = logN
    
    if(evry iteration reduces the criteria to reduce iterations)
    

Stack
    push
    pop
    peek like pop but doesn't chnage a thing

Used via linkedlist    

minimum stack for minimum value at point in stack
    push togeth
    pop togeth
    
    
Queue
    lilo or fifo
    enqueue
    dequeue
    Peek
    offer - if space is available adds and returns true otherwise returns false

simple ds in this would be linkedlist with top/bottom pointer 

but better is a circular queue

Queue based on stack 
    has O(M) based on number of operations since, for enque/deuque, pop()/pop() is done more than twice
    
##Sorting
#####Measures or characteristics
    1.how does it scale as the inpur increses
    2.does it need extra space for the information during sorting
    3.is it stable?(Meaning, is the sorted sublist matched the sublist of the sorted list?)
    4.comparison and swaps performed (heavy operation)
           does it work better for nearly sorted?
    5.is it adaptive
        short circuiting ?(stop sorting if already sorted)
        
#####Selection Sort
    for each iteration step (i in N)
    sublist of till i sorted
    
######Points to know
    1.Simplest of all
    6.N Selected points
    2.O(N^2)
    3.Not a stable sort??(for the same output and a different input, you cannot assume the transition state will be same)
    3.No extra spave
    4.O(N^2) comparison
    5.Not Adaptive

#####Bubble Sort    

######Points to know
    1.Adaptive
    2.Smallest element to the correct position
    3.N Elements checked
    4.O(N^2)
    5.Stable Sort
    6.No extra space
    7.No of swaps higher then Selection sort
    
#####Insertion Sort    

######Points to know
    1.starts with Sorted sublist
    2.sorts as it grows
    3.Adaptive
    4.better average case
    5.O(N^2)
    6.No extra space
    8.No of swaps simlar to bubble sort
    7.N Elemenets Checked for each iteration
    8.Stable Sort
    
    9.Reverse list comes out as worst case


#####Insertion Sort over Buble sort(bubble sort issues)
    1.Takes additional pass
    2.Needs more comparison
    3.Sssignments are more
    
#####Shell Sort
    Clever Insertion Sort    

######Points to know    
    1.Makes use of  //since insertion sort works faster for nearly sorted
    2.Adaptive
    3.Pretty much insertion sort
    4.Complexity not sure!!
        thus it is based on the increment value
        and no science is present
    At best it lies between O(N) and O(N^2)
    5.Addaptice
    6.No extra space
    7.O(N^3/2) when for incremtns 2k-1 > 1,2,3 
        
        
#####Merge Sort
    DnC
    split-mergeSort-merge    

######Points to know  
    1.Mathematical derivation
    2.O(NLogN)
    3.Better Than all of the above
    4.Fast
    4.Not adaptive
    5.O(N extra) space
    6.Stable (Mainttain the same order when sorting is done)
    7.
    
#####Quick Sort
    DnC
    Standard libraries favourite    

######Points to know  
    1.based on Pivot, classifies into 2 partitions
    2.Pivot is sorted
    3.Start with pivot index 0 /random
    4.Stable since pivot is placed on its desired poisioint
    5. 
   
   
#####Priority Queue(ADT)
    Addition and removal of higher priority is very quick 
    DS-Heap
    
    options ?
        work to be done
        push,peek,remove with highest priority
        1.Array/List Unordered
            no sorting with priortity(depends on order of insertion)
            insetion O1
            access/remove On
        2.OrderedList
            insetion On
            access/remove O1
            TradeOff exists betwenn 1 and 2
        3.BST(based on priority)
            Insertion LogN
            Access/Remove LogN
            TradeOff still faster then 1 and 2
            while no O1 so just an improvment
        4.Even better ??????
            BINARY HEAP
            INSERTION Logn
            access  O1 
            remove logn
            better thn a BST in access
            awesome right ??
            
            
           
         
    
######Points to know
    1. Insert Elements with priority
    2. access/remove the highest priority element
    3. Properties
        Complete Binary Tree
        Minimum Heap and Maximum Heap
    4.Need operation
        getRight/Left/Parent of any node
        so traditional binary tree would now require a new parent reference
        thus making it unncesaary extra space
        Thus, Array which is capable to hold the same as a logical tree
        Pointers are taken away(save space)
    5. Array maths
        for node i
        2*i+1 = left
        2*i+2 = right
        (i-1)/2 = parent
    6.Heapify a single element
        sift down (chooose left or right Math.min(left,right)(MINHEAP))
            find smallest(left or right) and check is smallest child is smaller than the parent
        sift Up (chooose left or right Math.min(left,right)(MINHEAP))
     
    Utility methods
        getParentIndex
        getLeftIndex
        getRightIndex
        siftUp
        siftDown
    
    Insertion
        insert at leaf(last open array position)
        heapify(SIFTUP) hehe
        //
        logN
     
    Access
    
    
#####Heap Sort(ADT)
    portions of the array(check if they are satisfying the heap property)
    takes an unsorted array -> convertes to heap and then sort to an array
    Heapify
        start with last item
        check if the parent,left/reight satisify the property
        
    Sort on a heapified array
        is a valid maxHeap
        swap first with the last
        curr arr list ofheapappendedwithsoertedarray

    insertion/removeal
        logN
    sorting NlogN
    Not Adaptive
    Not stable sort(order betwenn 2 order is not maintained)
    no additional space
    
#####Maximum Element in minHeap
    brute force compare leftandright
            recursivly
    check for leaf nodes only
    
    
#####K largest elements in a stream
    use similar heap data on array of K element
    add first k elements and heapify on minHEAD,
    compare incoming elemtn which first element,
    if incoming element is larger
        swap larger element fromm the 1st element and heapify
    
    
###Graph
     Used to represent relationships between entitiees
     very wide applications
     Used to solve interesting problems
     
Vertex
    entity we are trying to model
    
    
Edge
    relationship between vertices

ProfessionalGraph - LinkedIn
people is vertex    
Profession/senior/junior is edges

SocialGraph - Facebook
people is vertex    
Sister/mother/friend is edges

LocationGraph - map (information and distance time) 
locaiton is vertex
road/rail/air is an edge

Phone network
LandLines vertex
network to carry voice is an edge
uses alogirthm to figure out fastest route

Internet (graph/hesh)
Computer
wired/wireless

####Types of Graph
    is set of vertices and edges

######Points to remember
    set of (V,E) 
        count(V)-1 = count(E) 
    1.  Graph without undirected edges
        A---B
        A,B are vertices
        --- is an edge
    2.  Directed Graph with directed edges
        A-->B
        --> single directional traversal
        A source
        B destination
    Connected Graph all nodes are joined using edges
    Acyclic graph is nothing but a (nary)tree
    
    Two sub graphs not connected are not 
    is forest/dijointed tree
    
    Directed acyclic graph
        DAG  
        
    Represent Datastructure in graphs
    1. Adjacency Matrix
        directly connects to
    2. Adjacency List
    3. Adjacency Set subset of point 2
    
    
####AdjacencyMatrix vs Adjacency List/Set
    connected graph on matrix for space overehead V^2
    space = V^2
    ispresent = 1 
    iteration of eges on a vertex = V
    
    sparse grap on list/set
    space = E+V
    ispresent = Degree of V
    iteration of edge on a vertex = Degree of V
    
    sparse grap on set
    space = E+V
    ispresent = log(Degree of V) since contains work on set faster
    iteration of edge on a vertex = Degree of V
    
####Breadth First
    recursively done
Depth First
    while loop using queue
    
    
TODO IMPLS
breadth frst and depth first
    
    
    
#####Topological
    directed acycllic graph
    a--->b ,  a comes before b
    is A tological Sort
    
    indegree must be 0 otherwise its a cycle graph, no topological sort
    
    T Sort
    O(V+E) as all of them are visited exactly once


Shorted path in unweighted graph
    using breadth first search two step process
    1.prepare a table (custom object which hold distance from source and previos vertex info)
    2.traverse from desination to source from the distancetable
    
Shorteed path in weighted graph
    Djkstra is a greedy algo
    uses the distance table
       but it also updates the distance table
       known as Relaxation
    1. shorted path on chooses the lowest edge to traveerse
    2. possible to visit more than onces, uses relaxation
    3. accunts for the weights on the edges
    
       
    
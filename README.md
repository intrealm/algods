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
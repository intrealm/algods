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
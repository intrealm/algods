# everywhere_concurrency

#Non-blocking io vs thread per client model
    Processor put some limit (100) threads per 
    processes (which has now increased)
    
    refere java.nio for non-blocking io
    


##Thread Confinement
######Accessing shared, mutable data requires using synchronization; one way to avoid this requirement is to not share. If data is  only accessed from a single thread, no synchronization is needed.This technique, thread confinement, is one of the simplest waysto achieve thread safety. When an object is confined to a thread, such usage is automatically thread-safe even if the confined object itself is not
 
##Ad hoc Thread Confinement
######Ad-hoc thread confinement describes when the responsibility for maintaining thread confinement falls entirely on the implementation. Ad-hoc thread confinement can be fragile because none of the language features, such as visibility modifiers or local variables, helps confine the object to the target thread. In fact, references to thread-confined objects such as visual components or data models in GUI applications are often held in public fields.

#Stack Confinement
####
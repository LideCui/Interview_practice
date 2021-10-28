### Thread in Java
A thread can be created by:
1. implement Runnable interface.
2. extend Thread class.

The reasons why sometimes Runnable interface is more preferable is that:
1. Java does not support multiple inheritance. Extend thread to other classes.
2. A class might not be interested in being runnable, and therefore, inheriting the 
full overhead of thread is excessive. 

### Synchronization and Locks
#### Synchronized Methods
Most commonly, we restrict access to the shared resources through the use of 
synchronized keyword. It can be applied to both methods and code blocks, and 
restricts multiple threads from executing the code simultaneously on the same
object. 

If two instances can call the same methods at the same time? if they have the same
instance of calling, then no. But they have different references then yes.

Static methods synchronize on the class lock. The two threads above could not 
simultaneously execute synchronized static methods on the same class, even if they
are calling different methods.
```java
 // when synchronized work in code block
    synchronized(this){
    }
```

#### Lock
For more granular control, we can utilize a lock. A lock or monitor is used to 
synchronize access to a shared resource. A thread gets access to a shared resource by 
first acquiring the lock associated with the resource. A common use case is that 
a resource is accessed from multiple places. But should be only accessed by one thread 
at time. 

### Deadlocks and deadlock prevention
1. mutual exclusion
2. hold and wait
3. no preemption 
4. circular wait 
#Homework 1: Problem 1 (Exercise 1.1)
## Dining Philosophers
### Approach:
The first step was to create a runnable Philosopher. This philosopher holds two objects (chopsticks). When the philosopher thinks (constant time; can be modified in the code), they do not hold any chopsticks. When they feel hungry, they pick up two chopsticks close to them one by one. This is implemented in this code by synchronising the access to the shared chopstick objects. 
### Problems and workarounds:
#### 1. Mutual Exclusion:
It needs to be made sure that two philosophers cannot hold a chopstick object at the same time. This is made sure by using synchronizing in Java.
#### 2. Deadlock
This is a case when all the philosophers hold one chopstick and wait for the other. To make sure this does not happen, the last philosopher (index wise) always picks the chopsticks in reverse order as compared to the rest of the philosophers.
#### 3. Starvation
This is the case when one of the philosophers never gets access to the chopsticks. To make sure this does not happen, each philosopher waits random time after picking up the first chopstick and takes random time to eat.

### Variables
Variable | Use | Default value | Location
 :---: | :---: | :---: | :---:
number | To set the number of philosophers | 5 | DiningTest.java
iterations | To set the number of times each philosopher tries to eat | 10 | Philosopher.java
thinking_time | To set the amount of time to think for each philosopher in (ms) | 500 | Philosopher.java
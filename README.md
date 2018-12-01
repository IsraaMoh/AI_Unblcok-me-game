# AI_Unblcok-me-game
This is my experience in programming AI unblock me Game by using A star Algorithm , DFS Algorithm and Greedy Algorithm 
# Run-programe
you should downloads netbeans with jdk 8
https://www.oracle.com/technetwork/java/javase/downloads/jdk-netbeans-jsp-3413139-esa.html

# Problem formulation
•	States Representation: Specifies the location of each rectangular in said  squire  board
•	Initial state: The agent will start in any chosen level by the user e.g. (easy, medium and hard)
•	Actions: The agent move rectangular if it horizontal move right or left, if it vertical move up or down until reach the black one to the goal, the legal set of actions that is return from ACTION(current state)). 
•	Transition model: Return the board without black rectangular and with all the rest rectangular each specified position.
•	Goal test: Agent move the black rectangular to the goal state is out of the board.
•	Path cost function: The step cost is the number of rectangles between the black rectangular and the door to out of the board, so the path cost is the sum of the rectangles.

# Algorithms to solve the problem :
The AI Techniques/Methods we decide to choose for solving “Unblock Me” game are three algorithm .

# A* Search algorithms :

      A* is informed search algorithm ,  expands the node that has the lowest cost of
f(n), where ( f(n) = h(n) + g(n) ) is the path cost from the current node to the next node it aims to find a path to the goal with the smallest cost ( least distance , shortest time )  of (n).
Specifically A* select the minimize path ( f(n) = h(n) + g(n) ) where n is the next node on the path, g(n) is the cost of the path from the start node to n, and h(n) is a heuristic function that estimates the cost of the cheapest path from n to the goal.
So,  A* terminates  when the path it chooses to extend is a path from start to goal .
We are going to implement A* method by using java and we will see later in appendix section to how implement it .

# DFS Search algorithms :

       DFS is an algorithm used for performing an uninformed search through tree or graph data structures, It is implemented in recursion with LIFO stack data structure, also DFS it does not take into account the cost of exploring a particular path or use a heuristic to guide exploration decisions, also DFS employs a strategy of exploring the deepest nodes on the fringe first, depth refers to the number of steps it takes to get from the start node to the goal node, If the nodes are all equally deep, then we will select one randomly on another hands, if we have 3 nodes, we chose to explore next, the deepest ones.
This algorithm may not terminate and go on infinitely on one path. The solution to this issue is to  choose a cut-off depth. If the ideal cut-off is d, and if chosen cut-off is lesser than d, then this algorithm may fail If chosen cut-off is more than d, then execution time increases Its complexity depends on the number of paths.
 
# Greedy Search algorithm :

       A greedy algorithm is an algorithmic strategy, expands the node that is closest to the
goal, . Greedy algorithm is implemented using priority queue. that makes the best optimal choice at each small stage with the goal leading to a quick solution and its search cost is minimal . to evaluate the next node in greedy search it uses the heuristic function 
F(n) = h(n) .
So , store the node at the frontier and choose the closet one to achieve the goal .
We are implement all three algorithms by JAVA language in the NetBeans program as we see in next section ‘’Discussion of results’’.

#  Heuristic function 

       The heuristic function is a technique used to inform the search algorithm to finding the solutions more efficient Heuristic value is an estimated cost that calculated from the state to the goal. 
There are many kinds of heuristic function used, the diction of choosing one of them depend on the problem itself.
 In our game, we decided to use A* algorithm (blocking  heuristic) The blocking heuristic which is equal to zero at any goal state, and is equal to one plus the number of rectangular blocking the path to the exit from the board .  For instance, in the state above at figure () , there are two rectangular  on the path between the black rectangular  and the exit.  Therefore, in this state, the blocking heuristic would be equal to three , Our (A* implementation)  blocking heuristic and compute how many  movement should do to reach the start state to goal state .  
Means :  in initial ,every rectangular is out of place so , the agent shift the blocks around  the way to reach the goal state and  this leads to all blocks will be in the right place.


#   Input decision :
In our problem we decide to make our input through some characters that represent the rectangle both vertical and horizontal in puzzle game, for example the letter { '  T T  '} represents the horizontal rectangle and the letter {' ZZ '} represents the vertical rectangle and the{'# #'} represents the GOAL ,.. etc. So, we shift the letters around in the way to achieve the goal for example . We move the letter  { ' T T ' } in a vertical way by more clearly in the 3th column and the 3th row we have defined the letter {'  ZZ '} and then we move it . And so on to all the other characters represented by rectangles until the {'# #'} achieve to the 7th column and the 3th row so this is the goal and solution is found .


1. You have n bottles, each of which have pills of 1 g, except 1 bottle has 1.1 g pill
find the bottle, you can only use scale once.

solution: At first, you pick 1 pill from bottle 1, 2 pills from bottle 2, etc.
In the end, put them on the scale; if you the actual weight is w.
then the bottle number is:

(w - (n * (n-1))/2) / 0.1 = target bottle

2. Game 1: shot once to make the hoop; Game 2: shot 3 times and make 2 hoops
if you have a probability to make a hoop, which game you choose?

Solution: p_1 = p, p_2 = p*p*(1-p) * 3 + P^3

solve we have: p1 if 0 < p < 0.5 || p2 if 0.5 < p < 1

3. There is 8*8 board with two diagonally corners have been cut off. 
You are given 31 dominos, each can cover 2 grids. Can you cover the board?

solution: the board has black and white grids. Each domino should cover
one black and one white exactly. However, two corners cut off
are the same color, so the condition is no longer holds. So it is
impossible to cover. 
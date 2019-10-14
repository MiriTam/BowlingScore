### BowlingScore

## Introduction

The files in this repository are my solution to the Bowling problem (description below). 
To run the program, execute the Tester class, which contains a main method.

## Problem Description

Problem Description
Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, 
produces the total score for the game. Here are some things that the program will not do:

We will not check for valid rolls.
We will not check for correct number of rolls and frames.
We will not provide scores for intermediate frames.
Depending on the application, this might or might not be a valid way to define a complete story, 
but we do it here for purposes of keeping the kata light. I think you’ll see that improvements 
like those above would go in readily if they were needed for real.

We can briefly summarize the scoring for this form of bowling:

- Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
- In each frame, the bowler gets up to two tries to knock down all the pins.
- If in two tries, she fails to knock them all down, her score for that frame is the total number of 
  pins knocked down in his two tries. 
- If in two tries she knocks them all down, this is called a “spare” and her score for the frame is 
  ten plus the number of pins knocked down on her next throw (in her next turn).
- If on her first try in the frame she knocks down all the pins, this is called a “strike”. Her turn 
  is over, and her score for the frame is ten plus the simple total of the pins knocked down in her 
  next two rolls.
- If she gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more 
  bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus 
  throws knock down all the pins, the process does not repeat: the bonus throws are only used to 
  calculate the score of the final frame.
- The game score is the total of all frame scores.

Clues
What makes this game interesting to score is the lookahead in the scoring for strike and spare. 
At the time we throw a strike or spare, we cannot calculate the frame score: we have to wait one 
or two frames to find out what the bonus is.

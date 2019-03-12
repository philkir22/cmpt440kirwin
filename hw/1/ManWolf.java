/**
 * file: ManWolf.java
 * author: Phil Kirwin
 * course: CMPT 440
 * assignment: homework 1
 * due date: March 12, 2019
 * version: 1
 *
 * This file contains the concrete class ManWolf.
 * It is made to process strings attempting to solve the Man,
 * Wolf, Goat, Cabbage problem.
 */
public class ManWolf{
  private static final int q0 = 0;
  private static final int q1 = 1;
  private static final int q2 = 2;
  private static final int q3 = 3;
  private static final int q4 = 4;
  private static final int q5 = 5;
  private static final int q6 = 6;
  private static final int q7 = 7;
  private static final int q8 = 8;
  private static final int q9 = 9;
  private static final int q10 = 10;

  private int state;

  private static int[][] delta = {
          {q10, q10,  q1, q10},
          { q2, q10, q10, q10},
          { q1,  q3, q10,  q4},
          {q10,  q2,  q5, q10},
          {q10, q10,  q6,  q2},
          {q10, q10,  q3,  q7},
          {q10,  q7,  q4, q10},
          { q8,  q6, q10,  q5},
          { q7, q10,  q9, q10},
          {q10, q10,  q8, q10},
          {q10, q10, q10, q10}
  };

  /**
   * process
   *
   * This function will traverse an input string to determine what
   * state in the DFA the string will end in.
   *
   * Parameters:
   *  in: the String to be processed.
   *
   */
  public void process(String in){
    for (int i = 0; i < in.length(); i++){
      char c = in.charAt(i);
      try {
        state = delta[state][getIndex(c)];
      }
      catch(ArrayIndexOutOfBoundsException ex){
        state = q10;
      }
    }
  }

  /**
   * accepted
   *
   * This function will determine whether the current state is
   * an accepting state.
   *
   * Return value: true if the current state is an accepting state.
   */
  public boolean accepting(){
    return state == q9;
  }

  /**
   * reset
   *
   * This function will set the current state to be the the
   * initial state, q0.
   */
  public void reset(){
    state = q0;
  }

  /**
   * getIndex
   *
   * This function will determine the index of the inner array
   * of delta that should be used to transition.
   *
   * Parameters:
   *  move: That character representing the current move.
   *
   * Return value: 0 if move == 'n',
   *               1 if move == 'w',
   *               2 if move == 'q',
   *               3 if move == 'c',
   *               -1 otherwise.
   */
  public int getIndex(char move){
    if (move == 'n'){
      return 0;
    }
    if (move == 'w'){
      return 1;
    }
    if (move == 'g'){
      return 2;
    }
    if (move == 'c'){
      return 3;
    }
    return -1;
  }
}
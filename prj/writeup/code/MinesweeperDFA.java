/**
 * file: MinesweeperDFA.java
 * author: Phil Kirwin
 * course: CMPT 440
 * assignment: demo
 * due date: May 8, 2019
 * version: 1
 *
 * This file contains the concrete class MinesweeperDFA.
 * It is made to process strings attempting to complete
 * a game of minesweeper on a 2x2 board.
 */
public class MinesweeperDFA{
  /*
  * Each state is represented by an integer, which corresponds to an
  * index of the outer array of delta.
  */
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
  private static final int q11 = 11;
  private static final int q12 = 12;
  private static final int q13 = 13;
  private static final int q14 = 14;
  private static final int q15 = 15;

  /*
   * The current state.
   */
  private int state;

  /*
   * A table-driven approach to the delta function.
   * Each "row" represents the potential transititions from
   * a given state, while the "columns" represent the potential
   * characters that can facilitate this movement:
   * 'a', 'b', 'c', and 'd' respectively.
   */
  private static int[][] delta = {
          { q1,  q2,  q3,  q4},
          { q1,  q5,  q6,  q7},
          { q5,  q2,  q8,  q9},
          { q6,  q8,  q3, q10},
          { q7,  q9, q10,  q4},
          { q5,  q5, q11, q12},
          { q6, q11,  q6, q13},
          { q7, q12, q13,  q7},
          {q11,  q8,  q8, q14},
          {q12,  q9, q14,  q9},
          {q13, q14, q10, q10},
          {q11, q11, q11, q15},
          {q12, q12, q15, q12},
          {q13, q15, q13, q13},
          {q15, q14, q14, q14},
          {q15, q15, q15, q15}
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
        state = q15;
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
    return state == q11 || state == q12 || state == q13 || state == q14;
  }

  /**
   * foundMine
   *
   * This function will determine whether or not the user has lost
   * due to selecting the tile containing the mine.
   *
   * Return value: true if the current state is the error state.
   */
  public boolean foundMine(){
    return state == q15;
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
    if (move == 'a'){
      return 0;
    }
    if (move == 'b'){
      return 1;
    }
    if (move == 'c'){
      return 2;
    }
    if (move == 'd'){
      return 3;
    }
    return -1;
  }

  /**
   * placeMine
   *
   * Selects a coordinate at random to denote the mine by
   * changing the delta table such that any transition on
   * the coordinate chosen will lead to the error state, q15.
   */
  public void placeMine() {
    int index = (int)(Math.random() * 4);

    for(int[] state : delta){
      state[index] = q15;
    }
  }

  /**
   * selectedA
   *
   * A function to determin if the coordinate (0,0) has been selected.
   *
   * Return value: true if (0,0) is selected
   */
  public boolean selectedA(){
    return state == q1 || state == q5 || state == q6 || state == q7 ||
            state == q11 || state == q12 || state == q13;
  }

  /**
   * selectedB
   *
   * A function to determin if the coordinate (0,1) has been selected.
   *
   * Return value: true if (0,1) is selected
   */
  public boolean selectedB(){
    return state == q2 || state == q5 || state == q8 || state == q9 ||
            state == q11 || state == q12 || state == q14;
  }

  /**
   * selectedC
   *
   * A function to determin if the coordinate (1,0) has been selected.
   *
   * Return value: true if (1,0) is selected
   */
  public boolean selectedC(){
    return state == q3 || state == q6 || state == q8 || state == q10 ||
            state == q11 || state == q13 || state == q14;
  }

  /**
   * selectedD
   *
   * A function to determin if the coordinate (1,1) has been selected.
   *
   * Return value: true if (1,1) is selected
   */
  public boolean selectedD(){
    return state == q4 || state == q7 || state == q9 || state == q10 ||
            state == q12 || state == q13 || state == q14;
  }
}
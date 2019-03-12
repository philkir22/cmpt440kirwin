/**
 * file: driverDFA.java
 * author: Phil Kirwin
 * course: CMPT 440
 * assignment: homework 1
 * due date: March 12, 2019
 * version: 1
 *
 * This file contains driver that will invoke
 * ManWolf.java.
 */
public class driverDFA{
  public static void main(String[] args){
    String input = args[0];
    ManWolf mw = new ManWolf();
    mw.reset();
    mw.process(input);
    if(mw.accepting()){
      System.out.println("That is a solution.");
    }
    else{
      System.out.println("That is not a solution.");
    }
  }
}
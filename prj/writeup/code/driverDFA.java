import java.util.Scanner;
/**
 * file: driverDFA.java
 * author: Phil Kirwin
 * course: CMPT 440
 * assignment: demo
 * due date: May 8, 2019
 * version: 1
 *
 * This file contains driver that will invoke
 * MinesweeperDFA.java.
 */
public class driverDFA{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.println(
            "\n"+
            "---------\n"+
            "| b | d |\n"+
            "---------\n"+
            "| a | c |\n"+
            "---------\n"
    );
    System.out.println("Plese select a series of tiles as a string "+
            "containing 'a', 'b', 'c', and 'd'.");
    String input = in.nextLine();
    MinesweeperDFA ms = new MinesweeperDFA();
    ms.reset();
    ms.placeMine();
    ms.process(input);
    /*while(!(ms.accepting()) && !(ms.foundMine())){
      System.out.println(buildGrid(ms));
      System.out.println("Game incomplete! Please select additional tiles.");
      input = in.nextLine();
      ms.process(input);
    }*/
    if(ms.accepting()){
      System.out.println("You win!");
    }
    else if(ms.foundMine()){
      System.out.println("You selected the mine! Game Over");
    }
    else{
      System.out.println("Game incomplete!");
    }
  }

  public static String buildGrid(MinesweeperDFA ms){
    String output = "\n---------\n";
    if(ms.selectedB()){
      output += "| 1 |";
    }
    else{
      output += "| b |";
    }
    if(ms.selectedD()){
      output += " 1 |\n";
    }
    else{
      output += " d |\n";
    }
    output += "---------\n";
    if(ms.selectedA()){
      output += "| 1 |";
    }
    else{
      output += "| a |";
    }
    if(ms.selectedC()){
      output += " 1 |\n";
    }
    else{
      output += " c |\n";
    }
    output += "---------\n";
    return output;
  }
}
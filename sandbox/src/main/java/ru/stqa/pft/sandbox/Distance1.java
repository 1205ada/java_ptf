package ru.stqa.pft.sandbox;

/**
 * Created by Ada on 2016-12-10.
 */
public class Distance1 {
  public static void main(String [] args){
    Point p1 = new Point (2,5);
    Point p2 = new Point (5,9);
    double distance = p1.distance(p1,p2);
    System.out.println("Odległość między punktami: ("+ p1.x + "," + p1.y + ") i (" + p2.x + "," + p2.y + ") to: " + distance);
  }
}

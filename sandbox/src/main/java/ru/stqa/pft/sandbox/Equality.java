package ru.stqa.pft.sandbox;

/**
 * Created by Ada on 2017-01-03.
 */
public class Equality {
  public static void main (String[] arg){
    String s1 = "firefox 2.0";
    String s2 = "firefox " + Math.sqrt(4.0);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}

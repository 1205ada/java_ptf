package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ada on 2017-01-06.
 */
public class Collections {

  public static void main (String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};


    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");


    for (String l : languages) {
      System.out.println("Chcę nauczyć się " + l);
    }

  }
}

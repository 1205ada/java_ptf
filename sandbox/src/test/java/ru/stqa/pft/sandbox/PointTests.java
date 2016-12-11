package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ada on 2016-12-11.
 */
public class PointTests {

  @Test
  public void testDistance1 (){
    Point p1 = new Point (5,9);
    Point p2 = new Point (1,6);
    Assert.assertEquals (p1.distance(p2), 5.0);
  }

  @Test
  public void testDistance2 (){
    Point p3 = new Point (1,2);
    Point p4 = new Point (1,1);
    Assert.assertEquals (p3.distance(p4), 1.0);
  }
  @Test
  public void testDistance3 (){
    Point p5 = new Point (-2,5);
    Point p6 = new Point (1,9);
    Assert.assertEquals (p5.distance(p6), 5.0);
  }
}

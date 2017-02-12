package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Ada on 2017-02-12.
 */
public class RegistrationTests extends TestBase{

   @Test
   public void testRegistration() {
     app.registration().start("user1", "user1@localhost.localdomain");

   }
}

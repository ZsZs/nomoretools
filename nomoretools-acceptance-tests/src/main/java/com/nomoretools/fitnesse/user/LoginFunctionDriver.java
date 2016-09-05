package com.nomoretools.fitnesse.user;

public class LoginFunctionDriver {
   private String userName;
   private String password;
   private String message;
   private int loginAttempts;

   public LoginFunctionDriver( String userName, String password ) {
      this.userName = userName;
      this.password = password;
   }

   public boolean loginWithUsernameAndPassword( String userName, String password ) {
      loginAttempts++;
      boolean result = this.userName.equals( userName ) && this.password.equals( password );
      if( result )
         message = String.format( "Welcome %s!", this.userName );
      else
         message = String.format( "%s not logged in.", this.userName );
      return result;
   }

   public String loginMessage() {
      return message;
   }

   public int numberOfLoginAttempts() {
      return loginAttempts;
   }
}

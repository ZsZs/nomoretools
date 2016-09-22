package com.nomoretools.fitnesse.database;

public class Account {
   private String name;
   private String password;
   private Long id;
   private boolean enabled;
   
   public Account( String name, String password, Long id, boolean enabled ){
      this.name = name;
      this.password = password;
      this.id = id;
      this.enabled = enabled;
   }

   // properties
   // @formatter:off
   public boolean isEnabled() { return enabled; }
   public Long getId() { return id; }   
   public String getName() { return name; }
   public String getPassword() { return password; }
   // @formatter:on
}

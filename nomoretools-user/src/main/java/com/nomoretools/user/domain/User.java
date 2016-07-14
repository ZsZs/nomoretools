package com.nomoretools.user.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {
   @CreationTimestamp private Date created;
   private String password;
   @Id @GeneratedValue(strategy=GenerationType.AUTO) private long id;
   private String name;
   
   //Constructors
   User(){}
   
   public User( String name ){
      this( name, null );
   }
   
   public User( String name, String description ){
      this.name = name;
      this.password = description;
      this.created = new Date();
   }
   
   //Public accessors and mutators
   public void rename( final String newName ){
      this.name = newName;
   }
   
   //Properties
   public Date getCreated(){ return created; }
   public String getPassword(){ return this.password; }
   public String getName(){ return this.name; }
   public void setPassword( final String description ){ this.password = description; }
}

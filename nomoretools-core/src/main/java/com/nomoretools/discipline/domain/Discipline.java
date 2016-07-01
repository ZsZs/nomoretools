package com.nomoretools.discipline.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Discipline {
   @CreationTimestamp private Date created;
   private String description;
   @Id @GeneratedValue(strategy=GenerationType.AUTO) private long id;
   private String name;
   
   //Constructors
   Discipline(){}
   
   public Discipline( String name ){
      this( name, null );
   }
   
   public Discipline( String name, String description ){
      this.name = name;
      this.description = description;
      this.created = new Date();
   }
   
   //Public accessors and mutators
   public void rename( final String newName ){
      this.name = newName;
   }
   
   //Properties
   public Date getCreated(){ return created; }
   public String getDescription(){ return this.description; }
   public String getName(){ return this.name; }
   public void setDescription( final String description ){ this.description = description; }
}

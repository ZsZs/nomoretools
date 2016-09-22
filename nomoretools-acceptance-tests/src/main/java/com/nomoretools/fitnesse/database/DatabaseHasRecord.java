package com.nomoretools.fitnesse.database;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.nomoretools.fitnesse.application.ProductionConfiguration;

@Component
public class DatabaseHasRecord  implements ApplicationContextAware{
   private ApplicationContext applicationContext;
   private CellValueMapper cellValueMapper = new CellValueMapper();
   private List<String> columnNames = Lists.newArrayList();
   @Autowired private DatabaseClient databaseClient;
   private String query;

   public DatabaseHasRecord() {}
   
   public DatabaseHasRecord( String queryString ) {
      this.query = queryString;
      databaseClient = ProductionConfiguration.getBean( DatabaseClient.class );
   }

   public List<List<List<String>>> query() {
      List<List<List<String>>> rowList = Lists.newArrayList();
      List<Map<String, Object>> queryResult = databaseClient.query( query );

      for( Map<String, Object> map : queryResult ){
         List<List<String>> row = Lists.newArrayList();
         for( Entry<String, Object> mapEntry : map.entrySet() ){
            String value = cellValueMapper.map( mapEntry.getValue() );
            row.add( asList( mapEntry.getKey(), value ));
         }
         rowList.add( row );
      }
      return rowList;
   }

   public void table( List<List<String>> table ) {
      for( List<String> row : table ){
         for( String cell : row ){
            columnNames.add( cell );
         }
      }
   }

   // properties
   // @formatter:off
   public <T> T getBean( Class<T> requiredType ){ return applicationContext.getBean( requiredType ); }
   @Override public void setApplicationContext( ApplicationContext context ) throws BeansException { applicationContext = context; }
   @Autowired public void setDatabaseClient( DatabaseClient databaseClient ){ this.databaseClient = databaseClient; }
   public void setSql( String sql ) { this.query = sql; }
   // formatter:on

   private class CellValueMapper{
      public String map( Object cellValue ){
         String returnValue;
         if( cellValue instanceof Boolean ){
            returnValue = Boolean.toString( (boolean) cellValue );
         }else {
            returnValue = (String) cellValue;
         }
         return returnValue;
      }
   }
}

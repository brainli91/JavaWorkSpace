package com.fdmgroup;

import java.util.Random;

public class Borrower implements CatalogueId<Number>{
       
       private String name;
       private Number borrowerId;

       public Borrower(String name) {
              super();
              this.name = name;
              this.borrowerId = generateId();
       }
       @Override
       public Number generateId() {
              // TODO Auto-generated method stub
              Random numberGenerator = new Random();
              Number id = numberGenerator.nextInt();
              return id;
       }
       @Override
       public Number getId() {
              // TODO Auto-generated method stub
              return borrowerId;
       }
       @Override
       public String toString() {
              return "Borrower [name=" + name + ", borrowerId=" + borrowerId + "]";
       }
       
       
       
}

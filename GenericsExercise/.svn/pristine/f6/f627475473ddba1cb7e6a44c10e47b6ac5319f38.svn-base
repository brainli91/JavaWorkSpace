package com.fdmgroup;

import java.util.Random;

public class Book implements CatalogueId<Number>{
       private String bookName;
       private Number bookId;

       public Book(String bookName) {
              super();
              this.bookName = bookName;
              bookId = generateId();
       }
       
       

       public void setBookId(Number bookId) {
              this.bookId = bookId;
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
              return bookId;
       }



       @Override
       public String toString() {
              return "Book [bookName=" + bookName + ", bookId=" + bookId + "]";
       }
       
}

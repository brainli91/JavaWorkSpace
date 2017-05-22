package com.fdmgroup;

public class MainApp {
       public static void main(String[] args){
              Book bk = new Book("Head First Java");
              Borrower br = new Borrower("Nancy");
              Catalogue<Number, CatalogueId<Number>> cat = new Catalogue<Number, CatalogueId<Number>>(bk);
              cat.addItem(bk);
              cat.addItem(br);
              System.out.println(cat.getCatalogue());
       }
}


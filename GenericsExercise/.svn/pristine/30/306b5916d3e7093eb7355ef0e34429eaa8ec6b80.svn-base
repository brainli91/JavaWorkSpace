package com.fdmgroup;

import java.util.HashMap;
import java.util.Random;

public class Catalogue<T extends Number, X extends CatalogueId<T>>{
       
       private X x;
       private HashMap<T, X> catalogue = new HashMap<T, X>();
       
       
       public HashMap<T, X> getCatalogue() {
              return catalogue;
       }

       
       public Catalogue(X x) {
              super();
              this.x = x;

       }

       
       public void addItem(X x){
              catalogue.put(x.getId(), x);
       }


       @Override
       public String toString() {
              return "Catalogue " + ", catalogue=" + catalogue + "]";
       }



       /*@Override
       public T generateId() {
              // TODO Auto-generated method stub
              Random numberGenerator = new Random();
              T id = (T)numberGenerator.nextInt();
              return id;
              
              
       }
*/


       
}


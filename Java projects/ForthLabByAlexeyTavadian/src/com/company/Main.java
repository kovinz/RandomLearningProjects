package com.company;

import com.company.DAO.MySqlDAO;
import com.company.Entity.Product;
import com.company.Entity.Store;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] argc) throws Exception {
//    Store X = new Store("Eldorado", "pox");
//    Store Y = new Store("Magnit", "poxxx");
//    Product Stol = new Product("Stol");
//    Product Milk = new Product("Milk");
//    X.addProduct(Stol, 50.0, 10);
//    Y.addProduct(Stol, 25.0, 5);
//    X.addProduct(Milk, 50.0, 50);
//    Y.addProduct(Milk, 100.0, 20);
//    //X.possiblePurchases(200.0);
//    System.out.println(X.buyCheapest());
//    templist.add("IceCream,5,10");
//    Test.insert("product",templist);
    MySqlDAO Test = new MySqlDAO();
    List<List<String>> list;
    list = Test.select("presence");
    System.out.println(list.toString());


  }
}

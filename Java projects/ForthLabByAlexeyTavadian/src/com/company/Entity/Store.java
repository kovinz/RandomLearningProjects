package com.company.Entity;

import com.company.Pair;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;


public class Store {
  private String Name;
  private String Address;
  private static Vector Stores = new Vector();
  private ArrayList<Presence> Catalog = new ArrayList<Presence>();

  public Store(String name, String address) {
    this.Address = address;
    this.Name = name;
    Stores.add(this);
  }

  public Store() {

  }

  public static Vector getStores() {
    return ((Vector) Stores.clone());
  }

  public String getName() {
    return this.Name;
  }

  public void addProduct(Product P, Double cost, Integer count) {
    Presence temp = new Presence(P, cost, count);
    for (Presence e : Catalog) {
      if (e.getProduct().equals(P)) {
        e.setQuantity((Integer) e.GetExtra() + count);
        return;
      }
    }
    this.Catalog.add(temp);
    return;
  }


  public Presence GetProduct(Product P) {
    for (Presence e : Catalog) {
      if (e.getProduct().equals(P))
        return e;
    }
    //System.out.println("Such product doesn't exists");
    return null;
  }

  public Product getProductFromName(String name) {
    Product temp;
    for (Presence e : Catalog) {
      temp = (Product) e.getProduct();
      if (temp.getName().equals(name))
        return temp;
    }
    return null;
  }

  public Store findCheapest(Product P) {
    Vector<Store> stores = getStores();
    Pair<Double, Integer> tempMin = new Pair();
    tempMin.setKey(111111111110.0);
    tempMin.setValue(0);

    for (Integer i = 0; i < stores.size(); i++) {
      if (stores.get(i).GetProduct(P) != null) {
        if ((Double) tempMin.getKey() > (Double) (stores.get(i).GetProduct(P).getPrice())) {
          tempMin.setKey((Double) stores.get(i).GetProduct(P).getPrice());
          tempMin.setValue(i);
        }
      }
    }
    return stores.get((Integer) tempMin.getValue());
  }

  public Double buy(Product P, Integer count, Double money) {
    if ((Integer) this.GetProduct(P).GetExtra() < count) {
      System.out.println("Not enough products");
      return 0.0;
    } else {
      if ((Double) this.GetProduct(P).getPrice() * count > money) {
        System.out.println("Not enough money");
        return 0.0;
      } else {
        this.GetProduct(P).setQuantity((Integer) this.GetProduct(P).GetExtra() - count);
        //System.out.println("Succesfull! "+ ((Integer)this.getProduct(P).GetExtra())+" "+P.getName()+"'s left");
        return (Double) this.GetProduct(P).getPrice() * count;
      }
    }
  }

  public Vector<Product> possiblePurchases(Double money) {
    Vector<Product> temp = new Vector();
    for (Presence pr : Catalog) {
      if ((Double) pr.getPrice() < money)
        temp.add((Product) pr.getProduct());
    }
    for (Product p : temp) {
      System.out.println("You can buy " + (int) (money / (Double) this.GetProduct(p).getPrice()) + " " + p.getName() + "'s in " + this.getName());
    }
    return temp;
  }

  public String buyCheapest() {
    Vector<Store> allStores = getStores();
    Scanner in = new Scanner(System.in);
    System.out.println("What would you buy? (Count/Name)");
    Pair<String, Integer> tempPair = new Pair();
    Vector<Pair<String, Integer>> tempV = new Vector();
    tempPair.setValue(in.nextInt());
    tempPair.setKey(in.next());
    tempV.add(tempPair);
    System.out.println("Anything else? (Yes/No)");
    while (!in.next().equals("No")) {
      Integer tmpCount = in.nextInt();
      String tmpName = in.next();
      Pair<String, Integer> ExtraPair = new Pair(tmpName, tmpCount);
      tempV.add(ExtraPair);
      System.out.println("Anything else?");
    }
    Double min = 10000000.0;
    String tempName = "Any ways was found to buy those products";
    for (Store sh : allStores) {
      Double currentPrice = 0.0;
      for (Pair par : tempV) {
        if ((Integer) sh.GetProduct(sh.getProductFromName((String) par.getKey())).GetExtra() >= (Integer) par.getValue())
          currentPrice = currentPrice + sh.buy(sh.getProductFromName((String) par.getKey()), (Integer) par.getValue(), 100000.0);
        else
          currentPrice = 100000000.0;
      }
      if (currentPrice < min) {
        min = currentPrice;
        tempName = sh.getName();
      }
    }
    return tempName;
  }


}

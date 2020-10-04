package com.company.DAO;

import java.io.*;
import java.util.*;

public class FileDAO implements DAO {
  private File shop;
  private File product;
  private File productAndshop;

  public FileDAO(String shop, String goods, String goodsinshops) throws FileNotFoundException {
    this.shop = new File(shop);
    this.product = new File(goods);
    this.productAndshop = new File(goodsinshops);

    if (!(this.shop.exists() || this.product.exists()) || this.productAndshop.exists())
      throw new FileNotFoundException();
  }

  @Override
  public ArrayList<List<String>> select(String table) throws Exception {
    ArrayList<List<String>> ans = new ArrayList<List<String>>();

    FileReader reader;

    if (table.equals("shop"))
      reader = new FileReader(shop);
    else if (table.equals("product"))
      reader = new FileReader(product);
    else if (table.equals("productAndshop"))
      reader = new FileReader(productAndshop);
    else
      throw new Exception("Wrong table name");

    Scanner sc = new Scanner(reader);

    while (sc.hasNextLine()) {
      ans.add(Arrays.asList(sc.nextLine().split(",")));
    }
    return ans;
  }

  @Override
  public void insert(String table, List<String> values) throws Exception {
    ArrayList<List<String>> tableList = this.select(table);
    String lastId = "";
    for (List<String> list : tableList) {
      lastId = list.get(0);
    }

    Integer lastID = 0;

    if (!lastId.equals("")) {
      lastID = Integer.parseInt(lastId);
    }
    String toAdd = lastID.toString();

    for (String s : values) {
      toAdd += "," + s;
    }
    FileWriter writer;

    if (table.equals("shop")) {
      writer = new FileWriter(shop);
    } else if (table.equals("product")) {
      writer = new FileWriter(product);
    } else {
      writer = new FileWriter(productAndshop);
    }
    writer.append(toAdd);
  }

  @Override
  public void update(String table, String id, List<String> newValues) throws Exception {
    ArrayList<List<String>> tableList = this.select(table);

    FileWriter writer;

    if (table.equals("shop")) writer = new FileWriter(shop);
    else if (table.equals("product")) writer = new FileWriter(product);
    else
      writer = new FileWriter(productAndshop);

    String file = "";
    for (List<String> list : tableList) {
      if (!list.get(0).equals(id)) {
        for (String s : list) {
          file += s + ",";
        }
        file = file.substring(0, file.length() - 1);
      } else {
        file += id;
        for (String s : newValues) {
          file += "," + s;
        }
      }
    }
    writer.write(file);
  }
}

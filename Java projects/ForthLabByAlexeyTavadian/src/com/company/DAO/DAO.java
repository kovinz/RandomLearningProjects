package com.company.DAO;

import java.util.ArrayList;
import java.util.List;

public interface DAO {
  public void insert(String tableToInsert, List<String> values) throws Exception;

  public void update(String table, String id, List<String> values) throws Exception;

  public List<List<String>> select(String table) throws Exception;
}

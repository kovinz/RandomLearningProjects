package com.company.Generics;

import java.util.*;

public class Generics {
  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
    List<Integer> integers = new ArrayList<>(Arrays.asList(4, 5, 6));
    List<Double> doubles = new ArrayList<>(Arrays.asList(7.7, 8.8, 9.9));

    addToEnd(numbers, integers);
    addToEndAndReturn(numbers, doubles);
    numbers.forEach(System.out::println);

    List<String> strings = new ArrayList<>();
    print(strings);
  }

  public static void print(List<? super String> list) {
    list.add("Hello World!");
    System.out.println(list.get(0));
  }

  static <T extends R, R> List<R> copy(List<? extends T> from, List<R> to){
    if(from.size() != to.size()) throw new RuntimeException("Sizes of lists are not equal!");
    for (int i = 0; i < to.size(); i++){
      to.set(i, from.get(i));
    }
    return to;
  }

  static <T> List<T> addToEndAndReturn(List<T> beginning, List<? extends T> ending){
    beginning.addAll(ending);
    return beginning;
  }

  static <T> void addToEnd(List<? super T> beginning, List<? extends T> ending){
    beginning.addAll(ending);
  }

  static <T> List<String> doSmth(List<? extends String> list){
    List<String> outList = new ArrayList<>();
    outList.addAll(list);
    return outList;
  }
}

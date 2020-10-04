package com.company;

public class Polinom extends SetOfFraction {

  Polinom(SetOfFraction initialSet) {
    for (int i = 0; i < initialSet.getSize(); i++) {
      this.addFraction(initialSet.fractions.get(i).getTop(), initialSet.fractions.get(i).getBottom());
    }
  }

  public void add(Polinom second) {
    int size;
    if (this.getSize() > second.getSize()) {
      size = second.getSize();
    } else {
      size = this.getSize();
    }
    for (int i = 0; i < size; i++) {
      this.fractions.get(i).add(second.fractions.get(i));
    }
  }

  public void simplify() {
    for (Fraction fraction : fractions) {
      fraction.simplify();
    }
  }
}
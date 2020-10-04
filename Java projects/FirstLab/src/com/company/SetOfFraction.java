package com.company;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SetOfFraction{
    protected ArrayList<Fraction> fractions;
    private Fraction maxValue;
    private Fraction minValue;
    private double cashMoreThan;
    private double cashLessThan;
    private int cashCountMore;
    private int cashCountLess;
    private boolean foundNew;
    private int cashSize;

    SetOfFraction() {
        fractions = new ArrayList<Fraction>();
        this.maxValue = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.minValue = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
        cashMoreThan = Double.MAX_VALUE;
        cashLessThan = Double.MIN_VALUE;
        foundNew = true;
    }

    public void addFraction(int top, int bottom){
        Fraction added = new Fraction(top, bottom);
        fractions.add(added);
        if (maxValue.value() < added.value()){
            maxValue = added;
        }
        if (minValue.value() > added.value()){
            minValue = added;
        }
        foundNew = true;
    }

    public String getMax(){
        if (maxValue.getTop() == Integer.MIN_VALUE && maxValue.getBottom() == Integer.MAX_VALUE){
            return "Set of fractions is empty";
        }
        return maxValue.getTop() + "/" + maxValue.getBottom();
    }

    public String getMin() {
        if (minValue.getTop() == Integer.MAX_VALUE && minValue.getBottom() == Integer.MIN_VALUE){
            return "Set of fractions is empty";
        }
        return minValue.getTop() + "/" + minValue.getBottom();
    }

    public int getSize(){
        return fractions.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Fraction fraction : fractions) {
            stringBuilder.append(fraction.getTop());
            stringBuilder.append(' ');
        }
        stringBuilder.append('\n');
        for (Fraction fraction : fractions) {
            stringBuilder.append(fraction.getBottom());
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public int moreThan(Fraction given){
        double valueOfGiven = given.value();
        int counter = 0;
        if (cashMoreThan == valueOfGiven && !foundNew){
            return cashCountMore;
        } else if (cashMoreThan == valueOfGiven){
            counter = cashCountMore;
            for (; cashSize < fractions.size(); cashSize++){
                if (fractions.get(cashSize).value() > valueOfGiven){
                    counter++;
                }
            }
            foundNew = false;
            cashCountMore = counter;
            return counter;
        }
        for (Fraction fraction : fractions) {
            if (fraction.value() > valueOfGiven) {
                counter++;
            }
        }
        cashMoreThan = given.value();
        cashCountMore = counter;
        foundNew = false;
        cashSize = fractions.size();
        return counter;
    }

    public int lessThan(Fraction given){
        double valueOfGiven = given.value();
        int counter = 0;
        if (cashLessThan == valueOfGiven && !foundNew){
            return cashCountLess;
        } else if (cashLessThan == valueOfGiven){
            counter = cashCountLess;
            for (; cashSize < fractions.size(); cashSize++){
                if (fractions.get(cashSize).value() < valueOfGiven){
                    counter++;
                }
            }
            foundNew = false;
            cashCountLess = counter;
            return counter;
        }
        for (Fraction fraction : fractions) {
            if (fraction.value() < valueOfGiven) {
                counter++;
            }
        }
        cashLessThan = given.value();
        cashCountLess = counter;
        foundNew = false;
        cashSize = fractions.size();
        return counter;
    }

    public void readFile(String FileName) {
        try { BufferedReader reader = Files.newBufferedReader(Paths.get(FileName), StandardCharsets.UTF_8);
            String m, n;
            while ((m = reader.readLine()) != null) {
                n = reader.readLine();
                this.addFraction(Integer.parseInt(m), Integer.parseInt(n));
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

}
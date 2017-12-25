package org.ntlx.service;

import java.util.Vector;

public class CalculatorInput {

  Vector<Double> inputValues = new Vector<Double>();

  public double calculateSum() {
    double result = 0;
    for (double value : inputValues) {
      result += value;
    }
    return result;
  }

}

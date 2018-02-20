package net.sjl.alg;

import java.lang.Math;

public class ZeroOneKnapsack {
  
  private int[] weights;
  private int[] values;
  private int capacity;
  private int itemsNum;
  private boolean[] choosen;
  private int[][] maxValues;

  public ZeroOneKnapsack(int[] weights, int[] values, int capacity) {
    assert(weights != null && weights.length > 0);
    assert(values != null && values.length > 0);
    assert(weights.length == values.length);
    assert(capacity >= 0);

    this.weights = weights;
    this.values = values;
    this.capacity = capacity;
    this.itemsNum = weights.length;
    choosen = new boolean[itemsNum];
    for(int i = 0; i < itemsNum; i++) {
      choosen[i] = false;
    }
    maxValues = new int[itemsNum + 1][capacity + 1];
  }

  public int resolve() {
    for(int w = 0; w <= capacity; w++) {
      maxValues[0][w] = 0;
    }

    for(int i = 0; i <= itemsNum; i++) {
      maxValues[i][0] = 0;
    }

    for(int i = 1; i <= itemsNum; i++) {
      for(int w = 0; w <= capacity; w++) {
        if(weights[i - 1] > w) {
          maxValues[i][w] = maxValues[i - 1][w];
        } else {
          if(maxValues[i-1][w] > maxValues[i-1][w-weights[i - 1]] + values[i - 1]) {
            maxValues[i][w] = maxValues[i-1][w];
          } else {
            maxValues[i][w] = maxValues[i-1][w-weights[i - 1]] + values[i - 1];
            choosen[i - 1] = true;
          }
        } 
      }
    }

    return maxValues[itemsNum][capacity];

  } 

  public void printSolution() {
    System.out.println("The capacity is " + capacity);
    for(int i = 0; i < itemsNum; i++) {
      if(choosen[i]) {
        System.out.println("The item " + i + " (" + weights[i] + ", " + values[i] + ") is choosen");
      }
    }
  }
}

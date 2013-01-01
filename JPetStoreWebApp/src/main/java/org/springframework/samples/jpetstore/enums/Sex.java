package org.springframework.samples.jpetstore.enums;

public enum Sex {
  male(1),
  female(2);
  
  
  private int value;
  public int getValue(){return this.value;}
  Sex(int value){
	  this.value = value;
  }
}

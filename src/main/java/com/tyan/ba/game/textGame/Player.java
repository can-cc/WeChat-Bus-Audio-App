package com.tyan.ba.game.textGame;

import java.io.Serializable;

public class Player implements Serializable{
  private int xPos;
  private int yPos;
  private int HP = 10;
  private int attack;
  private int defense;
  public int xSize = Map.x-1;
  public int ySize = Map.y-1;
  private int level;
  private int XP;
  private int levelStep = 15;
  private int healthMax  = 10;
  
  public Player(){
    this.xPos = 5;
    this.yPos = 5;
    this.attack = 5;
    this.level = 1;
    this.XP = 0;
    this.defense = 1;
  }
  
 private void incLevel(){
	 this.level += 1;
	 this.attack += 1;
	 this.defense =+ 1;
	 this.healthMax += 5;
	 if(this.HP<this.healthMax){
	 this.HP += 10;
	 return;
	 }
 }
 
 public void stats(){
	 System.out.println("Health: " + this.HP +"/" + this.healthMax);
	 System.out.println("Attack: " + this.attack);
	 System.out.println("Defense" + this.defense);
	 System.out.println("Level: " + this.level);
	 System.out.println("XP:" + XP + "/" + (levelStep*this.level)+"\n");
 }
 public void incXP(int points){
	 int i;
	 for(i=0;i<points;i++){
	 this.XP += 1;
	 if (XP%(this.level*levelStep)==0){
		 incLevel();
		 System.out.println("You leveled up!\nYou are now level " + this.level);
		 levelStep += levelStep/3;
	 }
	 }
 }
 
 public int getXP(){
	 return this.XP;
 }
 
 
  public int getXPos(){
    return this.xPos;
  }
  
  public int getYPos(){
    return this.yPos;
  }
  
  public int getHP(){
    return this.HP;
  }
  
  public int getAttack(){
    return this.attack;
  }
  
  public int getDefense(){
	  return this.defense;
  }
  
  public void hurt(int HP){
    this.HP -= HP;
  }
  
  public void heal(int HP){
	  if(this.HP<this.healthMax){
		  this.HP += HP;
	  }
  }
  
  public void attackIncrease(int attack){
    this.attack += attack;
  }
  
  // movement
  public int up(){
    if(yPos <= 0){
      System.err.println("Fallen off top of map!\nHolding at y=0");
      return 0;
    }
    else{
      yPos -= 1;
      return yPos;
    }
  }
  
  public int down(){
    if(yPos>=ySize){
      System.err.println("Fallen off bottom of map!\nHolding position at y="+ySize);
      return yPos;
    }
    else{
      yPos += 1;
      return yPos;
    }
  }
  
  public int left(){
    if(xPos <= 0){
      System.err.println("Fallen off top of map!\nHolding at x=0");
      return 0;
    }
    else{
      xPos -= 1;
      return xPos;
    }
  }
  
  public int right(){
    if(xPos>=xSize){
      System.err.println("Fallen off right side of of map!\nHolding position at x="+xSize);
      return xPos;
    }
    else{
      xPos += 1;
      return xPos;
    }
  }
}
package com.tyan.ba.game.textGame;

public class Dog {
	private static int attack = 5;
	private static int hp = 15;
	private static int level = (hp-5)/2;
	private static int defense = 0;
	
	Enemy dog = new Enemy(hp,3,attack,defense);
	
	public Dog(int xPos, int yPos){
		
		dog.setXPos(xPos);
		dog.setYPos(yPos);
		
		}
	
	  public Enemy build(){
		  return dog;
	  }
	  
	  public static int getLevel(){
		  return level;
	  }
	  
	  public static int getHP(){
		    return hp;
		  }
		  
		  public int getType(){
		    return dog.getType();
		  }
		  
		  public static int getAttack(){
		    return attack;
		  }
}

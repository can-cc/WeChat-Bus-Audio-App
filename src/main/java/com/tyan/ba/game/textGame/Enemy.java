package com.tyan.ba.game.textGame;
/**
 * List of enemies:
 * 1: a rat
 * 2: a warrior
 * 3: a dog
 * 4: a troll
 * 5: a giant
 */
public class Enemy {
  public int HP;
  private int type; // use to define on map
  public int attack; // how hard they hit
  private int defense; // reduction of attack
  private int xPos;
  private int yPos;

  public String name;
 
  public Enemy(int HP,int type, int attack, int defense){
    this.HP = HP;
    this.type = type;
    this.attack = attack;
    this.name = NPCName(this.type);
    this.defense = defense;   
  }
  
 // ENEMY NAMES
  
  public static String NPCName(int NPCType){
	  switch(NPCType){
	  case 0: return "nothing";
	  case 1: return "a rat";
	  case 2: return "a warrior";
	  case 3: return "a dog";
	  case 4: return "a troll";
	  case 5: return "a giant";
	  default: return "a unknown foe!";
	  }

	  }

  
  public int getXPos(){
	  return xPos;
  }
  
  public int getYPos(){
	  return yPos;
  }
  
  public void setXPos(int xPos){
	  this.xPos = xPos;
  }
  
  public void setYPos(int yPos){
	  this.yPos = yPos;
  }
  
  public int getHP(){
    return this.HP;
  }
  
  public int getType(){
    return this.type;
  }
  
  public int getAttack(){
    return this.attack;
  }
  
  public int getDefense(){
	  return this.defense;
  }
  
  public void setHP(int HP){
    this.HP = HP;
  }
  
  public void setType(int type){
      this.type = type;
      this.name = NPCName(this.type);
    }
  
    public void setAttack(int attack){
      this.attack = attack;
    }
}


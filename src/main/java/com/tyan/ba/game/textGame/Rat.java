package com.tyan.ba.game.textGame;
public class Rat {
	private static int attack = 2;
	private static int hp = 5;
	private static int level = (hp-5)/2;
	private static int defense = 0;

	Enemy rat = new Enemy(hp,1,attack,defense);

	public Rat(int xPos, int yPos){

		rat.setXPos(xPos);
		rat.setYPos(yPos);

	}

	public Enemy build(){
		return rat;
	}

	public static int getLevel(){
		return level;
	}

	public static int getHP(){
		return hp;
	}

	public int getType(){
		return rat.getType();
	}

	public static int getAttack(){
		return attack;
	}

	public static int getDefense(){
		return defense;
	}
}


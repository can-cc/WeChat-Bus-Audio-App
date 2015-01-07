package com.tyan.ba.game.textGame;

// Note for the coordinates (0,0) is the first array (x,y) note the arrays count y as down and x as 
//across but the index is [y][x] 

public class Map{
  public static int x = 35;
  public static int y = 45;
  public static int size = x*y;
  public static int[][] map = new int[y][x];
  
  public static int[][] build(){
    
    // Note, build the large squares first and finish with the paths and rivers
    // fill with mountains, 9 and region 2, no terrain
    for(int i=0; i<size;i++){
      map[i/x][i%x] = 209;
    }
    
    
    // build houses
    // will need to add in some more non combat NPCs into the world
    
    house(16,1,3,3);
    house(2,3,5,6);
    house(27,5,3,5);
    house(0,21,2,3);
    house(9,22,3,3);
    house(25,20,7,7);
    house(16,31,3,3);
    house(5,37,3,3);
    house(27,37,3,3);
    
    // add in shops
    // do we want 1### to be for shop type?
    
    
    // build woods in the form (xpos,ypos,xsize,ysize)

    woods(6,11,22,30);
    mountain(6,11,3,7);
    
    // build the paths vertical or horizontal(x1,y1,length)

    hPath(4,6,25);
    vPath(17,2,37);
    
    // last add in bridges
    
    // add in enemies


    // set up the regions
    region(15,0,5,6,3);  //Stonehaven
    region(1,2,8,9,8); //Highdale
    region(25,4,5,6,1); //Valness 
    region(0,20,3,5,9); //Havencoast
    region(8,21,5,5,6); //Magefield
    region(2,35,7,5,7); //Clearlake
    region(13,30,7,6,4); //Pinehedge
    region(24,20,9,10,5); //Valbridge
    
    
    // return the map
    
    return map;
  }
  
  
  /*************clear*tile*****************************/
  
  public static void clear(int xPos, int yPos){
	  try{
		  map[yPos][xPos] = 209;
	  }
	  catch (ArrayIndexOutOfBoundsException e){
		  System.err.println("Attempted to reset map position off of map");
		  System.err.println("Error at: (" + xPos + "," + yPos + ")");
	  }
  }
  /*************region*declaration*********************/
  public static void region(int xPosInitial, int yPosInitial, int sizeX,int sizeY, int region){
	  try{
		  map[xPosInitial+sizeX-1] = map[xPosInitial+sizeX-1]; // check within x dimentions
		  try{
			  map[yPosInitial+sizeY-1] = map[yPosInitial+sizeY-1]; // check within y dimentions
			  // build the room
			  for(int xPos=xPosInitial; xPos<xPosInitial+sizeX;xPos++){
				  for(int yPos=yPosInitial; yPos<yPosInitial+sizeY;yPos++){
					  map[yPos][xPos] = map[yPos][xPos]%100 + (region*100);
				  }
			  }
		  }
		  catch (ArrayIndexOutOfBoundsException e){
			  System.err.println("invalid y dimentions at (" + xPosInitial +"," + yPosInitial +")");
		  }
	  }
	  catch (ArrayIndexOutOfBoundsException e){
		  System.err.println("invalid x dimentions at (" + xPosInitial +"," + yPosInitial +")");
	  }
  }
  
  
  /*************terrain*types*********************/
  // woods
  public static void woods(int xPosInitial, int yPosInitial, int sizeX,int sizeY){
    try{
      map[xPosInitial+sizeX-1] = map[xPosInitial+sizeX-1]; // check within x dimentions
      
      try{
        map[yPosInitial+sizeY-1] = map[yPosInitial+sizeY-1]; // check within y dimentions
        // build the room
        for(int xPos=xPosInitial; xPos<xPosInitial+sizeX;xPos++){
          for(int yPos=yPosInitial; yPos<yPosInitial+sizeY;yPos++){
            map[yPos][xPos] = 2 + ((map[yPos][xPos])/10)*10;
          }
        }
      }
      catch (ArrayIndexOutOfBoundsException e){
        System.err.println("invalid y dimentions at (" + xPosInitial +"," + yPosInitial +")");
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.err.println("invalid x dimentions at (" + xPosInitial +"," + yPosInitial +")");
    }
  }
  
  
  // paths
  public static void hPath(int xPosInitial, int yPosInitial, int length){
    try{
      map[xPosInitial+length-1] = map[xPosInitial+length-1]; // test if hall will go out of range 
      for(int xPos=xPosInitial; xPos<xPosInitial+length;xPos++){
        map[yPosInitial][xPos] = 1 + (map[yPosInitial][xPos]/10)*10;
    }
    }

    catch (ArrayIndexOutOfBoundsException e){
      System.err.println("length too long horizontally at (" + xPosInitial +"," + yPosInitial +")");
    }
  }
  
  public static void vPath(int xPosInitial, int yPosInitial, int length){
    try{
      map[yPosInitial+length-1] =  map[yPosInitial+length-1]; // test if hall will go out of range 
      for(int yPos=yPosInitial; yPos<yPosInitial+length;yPos++){
        map[yPos][xPosInitial] = 1 + (map[yPos][xPosInitial]/10)*10;
    }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.err.println("length too long vertically at (" + xPosInitial +"," + yPosInitial +")");
  }
  }
  
  // town
  public static void town(int xPosInitial, int yPosInitial, int sizeX,int sizeY){
    try{
      map[xPosInitial+sizeX-1] = map[xPosInitial+sizeX-1]; // check within x dimentions
      
      try{
        map[yPosInitial+sizeY-1] = map[yPosInitial+sizeY-1]; // check within y dimentions
        // build the room
        for(int xPos=xPosInitial; xPos<xPosInitial+sizeX;xPos++){
          for(int yPos=yPosInitial; yPos<yPosInitial+sizeY;yPos++){
            map[yPos][xPos] = 3 + ((map[yPos][xPos])/10)*10;
          }
        }
      }
      catch (ArrayIndexOutOfBoundsException e){
        System.err.println("invalid y dimentions at (" + xPosInitial +"," + yPosInitial +")");
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.err.println("invalid x dimentions at (" + xPosInitial +"," + yPosInitial +")");
    }
  }
  
  
  // house
  public static void house(int xPosInitial, int yPosInitial, int sizeX,int sizeY){
    try{
      map[xPosInitial+sizeX-1] = map[xPosInitial+sizeX-1]; // check within x dimentions
      
      try{
        map[yPosInitial+sizeY-1] = map[yPosInitial+sizeY-1]; // check within y dimentions
        // build the room
        for(int xPos=xPosInitial; xPos<xPosInitial+sizeX;xPos++){
          for(int yPos=yPosInitial; yPos<yPosInitial+sizeY;yPos++){
            map[yPos][xPos] = 4 + ((map[yPos][xPos])/10)*10;
          }
        }
      }
      catch (ArrayIndexOutOfBoundsException e){
        System.err.println("invalid y dimentions at (" + xPosInitial +"," + yPosInitial +")");
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.err.println("invalid x dimentions at (" + xPosInitial +"," + yPosInitial +")");
    }
  }
  
  // shop
  public static void shop(int xPos, int yPos){
    try{
      map[xPos] = map[xPos]; // check within x dimentions
      
      try{
        map[yPos] = map[yPos]; // check within y dimentions
        // build the room

            map[yPos][xPos] = 5 + ((map[yPos][xPos])/10)*10;

      }
      catch (ArrayIndexOutOfBoundsException e){
        System.err.println("invalid y dimentions at (" + xPos +"," + yPos +")");
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.err.println("invalid x dimentions at (" + xPos +"," + yPos+")");
    }
  }
  
//bridge
 public static void hBridge(int xPosInitial, int yPosInitial, int length){
	    try{
	      map[xPosInitial+length-1] = map[xPosInitial+length-1]; // test if hall will go out of range 
	      for(int xPos=xPosInitial; xPos<xPosInitial+length;xPos++){
	        map[yPosInitial][xPos] = 6 + (map[yPosInitial][xPos]/10)*10;
	    }
	    }

	    catch (ArrayIndexOutOfBoundsException e){
	      System.err.println("length too long horizontally at (" + xPosInitial +"," + yPosInitial +")");
	    }
	  }
	  
	  public static void vBridge(int xPosInitial, int yPosInitial, int length){
	    try{
	      map[yPosInitial+length-1] =  map[yPosInitial+length-1]; // test if hall will go out of range 
	      for(int yPos=yPosInitial; yPos<yPosInitial+length;yPos++){
	        map[yPos][xPosInitial] = 6 + (map[yPos][xPosInitial]/10)*10;
	    }
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	      System.err.println("length too long vertically at (" + xPosInitial +"," + yPosInitial +")");
	  }
	  }
 
	  
  
  // river
  public static void hRiver(int xPosInitial, int yPosInitial, int length){
	    try{
	      map[xPosInitial+length-1] = map[xPosInitial+length-1]; // test if hall will go out of range 
	      for(int xPos=xPosInitial; xPos<xPosInitial+length;xPos++){
	        map[yPosInitial][xPos] = 7 + (map[yPosInitial][xPos]/10)*10;
	    }
	    }

	    catch (ArrayIndexOutOfBoundsException e){
	      System.err.println("length too long horizontally at (" + xPosInitial +"," + yPosInitial +")");
	    }
	  }
	  
	  public static void vRiver(int xPosInitial, int yPosInitial, int length){
	    try{
	      map[yPosInitial+length-1] =  map[yPosInitial+length-1]; // test if hall will go out of range 
	      for(int yPos=yPosInitial; yPos<yPosInitial+length;yPos++){
	        map[yPos][xPosInitial] = 7 + (map[yPos][xPosInitial]/10)*10;
	    }
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	      System.err.println("length too long vertically at (" + xPosInitial +"," + yPosInitial +")");
	  }
	  }
  
	  // lake
	  public static void lake(int xPosInitial, int yPosInitial, int sizeX,int sizeY){
	    try{
	      map[xPosInitial+sizeX-1] = map[xPosInitial+sizeX-1]; // check within x dimentions
	      
	      try{
	        map[yPosInitial+sizeY-1] = map[yPosInitial+sizeY-1]; // check within y dimentions
	        // build the room
	        for(int xPos=xPosInitial; xPos<xPosInitial+sizeX;xPos++){
	          for(int yPos=yPosInitial; yPos<yPosInitial+sizeY;yPos++){
	            map[yPos][xPos] = 8 + ((map[yPos][xPos])/10)*10;
	          }
	        }
	      }
	      catch (ArrayIndexOutOfBoundsException e){
	        System.err.println("invalid y dimentions at (" + xPosInitial +"," + yPosInitial +")");
	      }
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	      System.err.println("invalid x dimentions at (" + xPosInitial +"," + yPosInitial +")");
	    }
	  }	  
	  
	  // mountain
	  public static void mountain(int xPosInitial, int yPosInitial, int sizeX,int sizeY){
	    try{
	      map[xPosInitial+sizeX-1] = map[xPosInitial+sizeX-1]; // check within x dimentions
	      
	      try{
	        map[yPosInitial+sizeY-1] = map[yPosInitial+sizeY-1]; // check within y dimentions
	        // build the room
	        for(int xPos=xPosInitial; xPos<xPosInitial+sizeX;xPos++){
	          for(int yPos=yPosInitial; yPos<yPosInitial+sizeY;yPos++){
	            map[yPos][xPos] = 9 + ((map[yPos][xPos])/10)*10;
	          }
	        }
	      }
	      catch (ArrayIndexOutOfBoundsException e){
	        System.err.println("invalid y dimentions at (" + xPosInitial +"," + yPosInitial +")");
	      }
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	      System.err.println("invalid x dimentions at (" + xPosInitial +"," + yPosInitial +")");
	    }
	  }
  
/*************Deal*with*enemies**************/
	  
  public static void corpse(int xPos,int yPos){
	  map[yPos][xPos] = map[yPos][xPos]%10 + ((map[yPos][xPos]/100)*100); 
  }
  
  public static void addEnemy(Enemy name){
	  map[name.getYPos()][name.getXPos()] = name.getType()*10 + map[name.getYPos()][name.getXPos()];
  }
  
}
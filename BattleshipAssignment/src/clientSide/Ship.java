package clientSide;

import javax.swing.*;

public class Ship
{
	private String shipName;
	private int dir=5,
			   shipLength,				   
			   i, //iterator
			   j, //iterator				   
			   x1,
			   y1,
			   x2,
			   y2;
	private int hitsleft;
	private boolean invalid;
	
	
	/**
	 * Constructor creates the ships, with coordinates
	 * 
	 * @param sName ships name
	 * @param sDir is the ship placed horizontal or vertical
	 * @param sLength length of the ship
	 * @param xCoord x coordinate of the front of the ship
	 * @param yCoord y coordinate of the front of the ship
	 */
	public Ship(String sName, int sDir, int sLength, int xCoord, int yCoord)
	{
		shipName = sName;
		shipLength = sLength;
		dir = sDir;
		x1 = xCoord;
		y1 = yCoord;
		invalid = false;
		hitsleft = sLength;			
	}
	
	/**
	 * Constructor creates ships with first and last point of the ships position
	 * 	
	 * @param sName
	 * @param sDir
	 * @param sLength
	 * @param x ship x coordinate
	 * @param y ship y coordinate 
	 * @param ex last pixel of ship x coordinate
	 * @param ey enemy ship y coordinate
	 */
	public Ship(String sName, int sDir, int sLength, int x, int y, int ex, int ey)
	{
		shipName=sName;
		shipLength=sLength;
		dir=sDir;
		x1=x;
		y1=y;
		x2=ex;
		y2=ey;
		invalid=false;
		hitsleft=sLength;			
	}
	
	/*
	 * Getters and Setters
	 */
	public String getName()
	{
		return this.shipName;
	}		
	
	public int getLength()
	{
		return this.shipLength;
	}
	
	public int getDirect()
	{
		return this.dir;
	}
	
	public int getX()
	{
		return this.x1;
	}
	
	public int getY()
	{
		return this.y1;
	}
	
	public int getEndX()
	{
		return this.x2;
	}
	
	public int getEndY()
	{
		return this.y2;
	}

	public void setInvalid(boolean c)
	{				
		this.invalid=c;
	}
			
	public void setHitsLeft()
	{				
		this.hitsleft-=1;
	}
	
	public int getHitsLeft()
	{				
		return this.hitsleft;
	}
	
	/**
	 * Method that clears the ships from the map after a game is canceled or finished.
	 */
	public void clearship ()
	{				
		switch (this.dir)
		{
			case 0:	{													
						if  (!this.invalid)
							for (j=this.y1;j<this.y2;j++)
							{
								Battleship.getPlayers(Battleship.getYou()).setBboard(this.x1,j,null);
								Battleship.getPlayers(Battleship.getYou()).setHitOrMiss(this.x1,j,false);
								Battleship.getPlayers(Battleship.getYou()).setWhatShip(this.x1,j," ");	
							}
					}
			break;
			case 1:	{	
						if (!this.invalid)	
							for (i=this.x1;i<this.x2;i++)
							{
								Battleship.getPlayers(Battleship.getYou()).setBboard(i,this.y1,null);
								Battleship.getPlayers(Battleship.getYou()).setHitOrMiss(i,this.y1,false);
								Battleship.getPlayers(Battleship.getYou()).setWhatShip(i,this.y1," ");	
							}								
					}
			break;				
		}
	}
	
	/**
	 * Method to place the ships on the grid.
	 */
	public void placeship()
	{				
		switch (this.dir)
		{
			case 0:	{												
						if ((this.shipLength+this.y1)>10)								
						{
							JOptionPane.showMessageDialog(null,"A " + this.shipName+" placed in a "+Battleship.getDirection(this.dir) + " direction will not fit at position " + Battleship.getCletters(this.x1+1)+Battleship.getCnumbers(this.y1+1)+"." , "Invalid Placement",JOptionPane.ERROR_MESSAGE);
							this.invalid=true;
						}   								
						else
						{												
							j = 0;
							while ((j!=this.shipLength)&&(!Battleship.getPlayers(Battleship.getYou()).getHitOrMiss(this.x1,this.y1+j)))
								j++;
							if (j!=this.shipLength)
							{
								JOptionPane.showMessageDialog(null,"Position "+Battleship.getCletters(this.x1+1)+
								Battleship.getCnumbers(this.y1+j+1)+" is already occupied.",
								"Invalid Placement",JOptionPane.ERROR_MESSAGE);
								this.invalid=true;
							}
							else
							{
								this.x2 = this.x1;
								this.y2 = this.y1+this.shipLength;								
								for (j = this.y1; j < this.y2; j++)
								{
									Battleship.getPlayers(Battleship.getYou()).setBboard(this.x1,j,Battleship.getColor());
									Battleship.getPlayers(Battleship.getYou()).setHitOrMiss(this.x1,j,true);
									Battleship.getPlayers(Battleship.getYou()).setWhatShip(this.x1,j,this.shipName);										
								}
								this.invalid=false;
							}
						}
					}
			break;
			case 1:	{		
						if ((this.x1+this.shipLength) > 10)								
						{
							JOptionPane.showMessageDialog(null,"A "+
							this.shipName+" placed in a "+Battleship.getDirection(this.dir) + " direction will not fit at position " + Battleship.getCletters(this.x1+1) + Battleship.getCnumbers(this.y1+1) + ".", "Invalid Placement",JOptionPane.ERROR_MESSAGE);
							this.invalid=true;
						}
						else
						{							
							j = 0;
							while ((j != this.shipLength) && (!Battleship.getPlayers(Battleship.getYou()).getHitOrMiss(this.x1+j,this.y1)))
								j++;
							if (j != this.shipLength)
							{
								JOptionPane.showMessageDialog(null,"Position " + Battleship.getCletters(this.x1 + j +1) + Battleship.getCnumbers(this.y1+1)+" is already occupied.", "Invalid Placement",JOptionPane.ERROR_MESSAGE);
								this.invalid = true;
							}
							else
							{
								this.y2 = this.y1;
								this.x2 = this.x1 + this.shipLength;										
								for (i = this.x1; i<this.x2; i++)
								{
									Battleship.getPlayers(Battleship.getYou()).setBboard(i,this.y1,Battleship.getColor());
									Battleship.getPlayers(Battleship.getYou()).setHitOrMiss(i,this.y1,true);
									Battleship.getPlayers(Battleship.getYou()).setWhatShip(i,this.y1,this.shipName);				
								}
								this.invalid=false;
							}
						}
					}
			break;							
		}			
		if ((Battleship.getSubmarinceCheck() > 0) && (Battleship.getDestroyerCheck() > 0) && (Battleship.getPatrolBoatCheck() > 0) && (Battleship.getCarrierCheck() > 0) && (Battleship.getBattleShipCheck() > 0) && (!this.invalid))
		{
			if ((!Battleship.getPlayers(Battleship.getYou()).getBoats(0).invalid) && (!Battleship.getPlayers(Battleship.getYou()).getBoats(1).invalid) && (!Battleship.getPlayers(Battleship.getYou()).getBoats(2).invalid) && (!Battleship.getPlayers(Battleship.getYou()).getBoats(3).invalid) && (!Battleship.getPlayers(Battleship.getYou()).getBoats(4).invalid))
			{
				Battleship.setDeploy(true);
			}
			else
			{
				Battleship.setDeploy(false);
			}
		}
		else
		{
			Battleship.setDeploy(false);
		}
	}
	
	/**
	 * Method for the computer to place ships on the grid.
	 * 
	 * @param friendly 
	 * @param enemy
	 * @return boat ship object
	 */
	public Ship compinput(int friendly, int enemy)
	{			
		Ship boat;
		
		int i = 0,
			j = 0,
			x,
			y,
			shipl = 0,	
			dir;
		
		switch (friendly)
		{	
			case 0:		shipl = 5;
			break;
			case 1:		shipl = 4;
			break;
			case 2:			
			case 3:		shipl = 3;
			break;
			case 4:		shipl = 2;
			break;							
		}		
		
		do
		{
			x = (int)(Math.random()*10);
			y = (int)(Math.random()*10);				
			dir = (int)(Math.random()*2);//generates random direction within range			
			boat = new Ship(Battleship.getShips(friendly),dir,shipl,x,y);				
			switch (dir)
			{
				case 0:	
				{												
							if (((boat.getLength()+y)>10)||(x==0)||(y==0))	
							{
								boat.setInvalid(true);
							}
							else
							{												
								j=0;									
								while ((j!=boat.getLength())&&(!Battleship.getPlayers(enemy).getHitOrMiss(x,y+j)))
								{
									j++;
								}
								if (j!=boat.getLength())
								{
									boat.setInvalid(true);
								}
								else
								{
									boat.x2=x;
									boat.y2=y+boat.getLength();								
									for (j=y;j<boat.y2;j++)
									{										
										Battleship.getPlayers(enemy).setHitOrMiss(x,j,true);
										Battleship.getPlayers(enemy).setWhatShip(x,j,Battleship.getShips(friendly));				
									}
									boat.setInvalid(false);																
								}
							}
				 }
				break;
				case 1:	{		
							if (((x+boat.getLength()) > 10)||(x == 0)||(y == 0))						
								boat.setInvalid(true);							
							else
							{							
								j = 0;									
								while ((j!=boat.getLength())&&(!Battleship.getPlayers(enemy).getHitOrMiss(x+j,y)))
								{
									j++;
								}
								if (j != boat.getLength())
								{
									boat.setInvalid(true);
								}
								else
								{
									boat.y2 = y;
									boat.x2 = x+boat.getLength();										
									for (i = x; i < boat.x2; i++)
									{
										Battleship.getPlayers(enemy).setHitOrMiss(i,y,true);
										Battleship.getPlayers(enemy).setWhatShip(i,y,Battleship.getShips(friendly));			
									}
									boat.setInvalid(false);									
								}
							}
						}
				break;						
			}			
		}			
		while (boat.invalid);		
		return boat;
	}
}

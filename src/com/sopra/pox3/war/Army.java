package com.sopra.pox3.war;

import com.sopra.pox3.game.Player;
import com.sopra.pox3.game.PlayerRoundEndedException;
import com.sopra.pox3.game.RoundState;
import com.sopra.pox3.story.House;
import com.sopra.pox3.tile.Domain;
import com.sopra.pox3.tile.Tile;

public class Army implements IArmy {

	int readyTroops;
	int movedTroops = 0;
	House house;
	Domain position;
	

	public Army(int troops, House house, Domain position) {
		this.readyTroops = troops;
		this.house = house;
		this.position = position;
		
	}
	
	@Override
	public Player getPlayer(){
		return this.house.getPlayer();
	}

	@Override
	public boolean attack(IArmy ennemy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tile getPosition() {

		return this.position;
	}

	@Override
	public House getHouse() {

		return this.house;
	}

	@Override
	public ArmyState getState() {

		return ArmyState.IDLE;
	}

	@Override
	public int getTotalTroops() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMovedTroops() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReadyTroops() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move(int troops, Direction direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Direction direction) {
		this.getPlayer().decreaseMoves();

	}

}

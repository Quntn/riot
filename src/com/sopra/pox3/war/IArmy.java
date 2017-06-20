package com.sopra.pox3.war;

import com.sopra.pox3.game.Player;
import com.sopra.pox3.story.House;
import com.sopra.pox3.tile.Tile;

public interface IArmy {

	int getTotalTroops();
	int getMovedTroops();
	int getReadyTroops();

	void move(int troops, Direction direction);
	
	/**
	 * Move all the army
	 * @param domain
	 */
	void move(Direction direction);

	
	boolean attack(IArmy ennemy);


	Tile getPosition();

	House getHouse();

	ArmyState getState();
	
	Player getPlayer();

}

package com.sopra.pox3.game;

import com.sopra.pox3.got.objectives.ObjectiveCard;
import com.sopra.pox3.story.House;
import com.sopra.pox3.war.Direction;

public class Player {

	String name;
	House house;
	ObjectiveCard card;
	PlayerState state = PlayerState.PLAYING;
	RoundState roundState = RoundState.WAITING;

	// Bidirection
	Game game;
	Round currentRound;

	public int moves = 3;

	public Player(String name, House house) {
		this.name = name;
		this.house = house;
		this.house.setPlayer(this);  //bidirectional handling, but this link never moves. Not so bad..
	}

	boolean chooseName(String pName) { // pName pour ParamètreName, aide pour
										// débuter
		this.name = pName;
		return true;
	}

	boolean chooseHouse(House pHouse) {

		this.house = pHouse;
		return true;
	}

	ObjectiveCard selectCard() {
		return null;
	}

	public void decreaseMoves(){
		if(this.roundState == roundState.WAITING){
			throw new PlayerRoundEndedException();
		}
		this.moves --;
	}

	
}

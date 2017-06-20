package com.sopra.pox3.game;

import java.util.ArrayList;
import java.util.List;

import com.sopra.pox3.got.objectives.ObjectiveCard;
import com.sopra.pox3.story.House;
import com.sopra.pox3.story.HouseFactory;

/**
 * Starting class for launching game
 * 
 * @author AELION
 *
 */
public class Game {

	List<Player> players = new ArrayList<>();
	List<House> houses = new HouseFactory().getAllHouses();
	List<House> availableHouses = new HouseFactory().getAllHouses();

	List<ObjectiveCard> cards;
	List<Round> rounds = new ArrayList<>();

	public Game() {

	}

	public void init() {
		new Round();
	}

	List<House> getAvailableHouses() {
		return availableHouses;
	}

	void savePlayer(Player player) {
		this.players.add(player);
		this.availableHouses.remove(player.house);
	}

	Round getCurrentRound() {
		return this.rounds.get(this.rounds.size() - 1);
	}

	void newRound() {

		this.rounds.add(new Round());

		boolean firstNoDead = true;

		// version JAVA7
		for (Player player : this.players) {
			if (player.roundState != RoundState.DEAD) {
				player.moves = 3;
				if (firstNoDead) {
					player.roundState = RoundState.PLAYING;
					firstNoDead = false;
				} else {
					player.roundState = RoundState.WAITING;
				}
			} else {
				player.moves = 0;
			}

			// version JAVA8 maxi moche et méchante
			// this.rounds.add(new Round());
			// this.players.stream().forEach(p -> p.moves=3);
		}
	}
}

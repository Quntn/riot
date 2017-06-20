package com.sopra.pox3.story;

import java.util.List;

import com.sopra.pox3.game.Player;
import com.sopra.pox3.tile.Domain;

public class House {

	String name;
	String words;
		//bidirection (la maison et le joueur se connaissent mutuellement)
	Player player;

	public House(String pName, String pWords) {
		this.name = pName;
		this.words = pWords;
	}

	List<Domain> getDomains() {
		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean hasDragon(){
		return false;
	}
	
	public boolean hasBoat(){
		return false;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof House))
			return false;
		House other = (House) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}


package com.sopra.pox3.game;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.sopra.pox3.story.House;
import com.sopra.pox3.story.HouseFactory;
import com.sopra.pox3.tile.World;
import com.sopra.pox3.war.Army;
import com.sopra.pox3.war.Direction;
import com.sopra.pox3.war.IArmy;

public class RoundTest {

	World world;
	Game game;
	Round round;
	Player a;
	Player b;
	House stark, lannister;

	IArmy a1;
	IArmy a2;
	IArmy a3;
	IArmy b1;

	@Before
	public void setUp() throws Exception {
		world = new World();
		world.generate();
		this.game = new Game();

		HouseFactory factory = new HouseFactory();
		this.stark = factory.getStark();
		this.lannister = factory.getLannister();

		this.a = new Player("Anne", lannister);
		this.b = new Player("Nicolas", stark);
		
		game.players.add(this.a);
		game.players.add(this.b);

		a1 = new Army(2, stark, world.getWinterfell7());
		a2 = new Army(2, stark, world.getMeereen());
		a3 = new Army(2, stark, world.getThrone());

		b1 = new Army(2, stark, world.getTheErye1());

		round = new Round();
	}

	@Test(expected = PlayerRoundEndedException.class)
	public void testEndPlayer() {

		a1.move(Direction.NORTH);
		round.end(a);
		a2.move(Direction.SOUTH);

	}

	@Test
	public void testEnd() {
		fail("Not yet implemented");
	}

}

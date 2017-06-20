package com.sopra.pox3.war;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.sopra.pox3.story.House;
import com.sopra.pox3.story.HouseFactory;
import com.sopra.pox3.tile.Domain;
import com.sopra.pox3.tile.World;

public class IArmyTest {

	IArmy army;

	World world;
	Domain winterfell3,  theEyre1, winterfell7;
	HouseFactory factory = new HouseFactory();
	House stark = factory.getStark();
	House lannister = factory.getLannister();
	House arryn = factory.getArryn();
	
	IArmy smallArmy, bigArmy;

	@Before
	public void setUp() throws Exception {

		HouseFactory factory = new HouseFactory();
		House stark, lannister;
		stark = factory.getStark();
		lannister = factory.getLannister();

		world = new World();
		world.generate();
		winterfell3 = (Domain) world.get(3, 2); // No soucy to cast in
												// test

		army = new Army(3, stark, winterfell3);
		winterfell3.setArmy(army);

		theEyre1 = (Domain) world.get(3, 4);
		smallArmy = new Army(10, arryn, theEyre1);
		theEyre1.setArmy(army);

		winterfell7 = (Domain) world.get(3, 3);
		bigArmy = new Army(1, stark, winterfell7);
		winterfell7.setArmy(army);
	}

	@Test
	public void testGetTroops() {
		assertEquals(3, army.getTotalTroops());
		assertEquals(3, army.getMovedTroops());
		assertEquals(3, army.getReadyTroops());
	}

	@Test
	public void testMoveIntDomain() {
		army.move(2, Direction.SOUTH);

		assertEquals(3, army.getPosition().getX());
		assertEquals(3, army.getPosition().getY());
		assertEquals(1, winterfell3.getArmy().getReadyTroops());
		Domain winterfell7 = (Domain) world.get(3, 3);
		assertEquals(2, winterfell7.getArmy().getMovedTroops());

	}

	@Test
	public void testMoveDomain() {
		army.move(2, Direction.SOUTH);

		assertEquals(3, army.getPosition().getX());
		assertEquals(3, army.getPosition().getY());
		assertEquals(0, winterfell3.getArmy().getReadyTroops());
		Domain winterfell7 = (Domain) world.get(3, 3);
		assertEquals(3, winterfell7.getArmy().getMovedTroops());

	}

	@Test
	public void testGetPosition() {
		assertEquals(winterfell3, army.getPosition());
	}

	@Test
	public void testGetHouse() {
		assertEquals(stark, army.getHouse());
	}

	@Test
	public void testGetState() {
		assertEquals(ArmyState.IDLE, army.getState());
		army.move(Direction.SOUTH);
		assertEquals(ArmyState.IDLE, army.getState());
	}

	@Test
	public void testAttack() {

		assertFalse(smallArmy.attack(bigArmy));
		assertEquals(ArmyState.DEAD, army.getState());
		assertEquals(ArmyState.WON, army.getState());

	}
}

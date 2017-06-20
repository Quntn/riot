package com.sopra.pox3.tile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.sopra.pox3.story.House;
import com.sopra.pox3.story.HouseFactory;

public class WorldTest {

	World world;

	@Before
	public void setUp() throws Exception {
		world = new World();
	}

	@Test
	public void testWorld() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerate() {
		world.generate();
		assertTrue(world.tiles.length == 11);
		assertTrue(world.tiles[0].length == 12);
	}

	@Test
	public void testAssignFreeDomain() {
		world.assignFreeDomain(1, 2, 4, 2, "Winterfell");
		assertTrue(world.tiles[1][2] instanceof Domain);
		Domain winterfell1 = (Domain) world.tiles[1][2];
		assertTrue(winterfell1.name.equals("Winterfell-1"));

		world.assignFreeDomain(8, 6, 2, 2, "Volantys");
		assertTrue(world.tiles[8][6] instanceof Domain);
		Domain volantys2 = (Domain) world.tiles[9][6];
		assertTrue(volantys2.name.equals("Volantys-2"));
		
		world.assignFreeDomain(2, 7, 2, 2, "Dorne");
		assertTrue(world.tiles[2][7] instanceof Domain);
		Domain dorne3 = (Domain) world.tiles[2][7];
		assertTrue(dorne3.name.equals("Dorne-1"));
	}
	
	@Test
	public void testAssignDomainWithHouse() {
		House stark = new HouseFactory().getStark();
		world.assignDomainWithHouse(1, 2, 4, 2,"Winterfell", stark);
		assertTrue(world.tiles[1][2] instanceof Domain);
		Domain winterfell1 = (Domain) world.tiles[1][2];
		assertTrue(winterfell1.name.equals("Winterfell-1"));

		world.assignFreeDomain(2, 7, 2, 2, "Dorne");
		House martell = new HouseFactory().getMartell();
		world.assignDomainWithHouse(2, 7, 2, 2,"Dorne", martell);
		assertTrue(world.tiles[2][7] instanceof Domain);
		Domain dorne1 = (Domain) world.tiles[2][7];
		assertTrue(dorne1.name.equals("Dorne-1"));
		assertTrue(dorne1.house.equals(Optional.of(martell)));
		
	} 
	
	@Test
	public void testFillWater(){
		
		House stark = new HouseFactory().getStark();
		world.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);
		
		world.fillWater();
		
		Domain winterfell1 = (Domain) world.tiles[1][2];
		assertTrue(winterfell1.name.equals("Winterfell-1"));
		
		assertTrue(world.tiles[6][6] instanceof WaterTile);
		
		
	}

	@Test
	public void testAllowMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsWinter() {
		assertFalse(world.winter);
		world.startWinter();
		assertTrue(world.winter);
		
		
	} 

}

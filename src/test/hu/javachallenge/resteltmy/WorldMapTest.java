package hu.javachallenge.resteltmy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/context.xml")
public class WorldMapTest {
	
	private WorldMap worldMap = new WorldMap();
	
	@Test
	public void testPlanets() {
		worldMap.getPlanets();
	}

}

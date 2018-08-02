package hu.javachallenge.resteltmy;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.fail;

@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/context.xml")
public class WorldMapTest {

  @Test
  void failingTest() {
    fail();
  }
}

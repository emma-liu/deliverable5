import static org.junit.Assert.*;

import org.junit.Test;


public class CoffeeMakerTest {

	//This test runAugs always return 0.
	@Test
	public void testRunAugs() {
		CoffeeMaker cm = new CoffeeMaker();
		int result = cm.runArgs("test");
		assertEquals(result,0);	
		
	}

}

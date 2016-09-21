import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testFrame_2_4_firstScoreEquals_2() throws BowlingException{
		Frame frm = new Frame(2,4);
		int firstScore = frm.getFirstThrow();
		assertEquals(2,firstScore);
	}
	
	@Test
	public void testFrame_2_4_secondScoreEquals_4() throws BowlingException{
		Frame frm = new Frame(2,4);
		int secondScore = frm.getSecondThrow();
		assertEquals(4,secondScore);
	}

	@Test (expected = BowlingException.class)
	public void testFrame_11_0_throwBowlingException() throws BowlingException{
		Frame frm = new Frame(11,0);
	}
	
	@Test (expected = BowlingException.class)
	public void testFrame_5_7_throwBowlingException() throws BowlingException{
		Frame frm = new Frame(5,7);
	}
	
	@Test (expected = BowlingException.class)
	public void testFrame_minus1_7_throwBowlingException() throws BowlingException{
		Frame frm = new Frame(-1,7);
	}
	
	@Test
	public void testFrame_2_6_return_8() throws BowlingException{
		Frame frm = new Frame(2,6);
		int score = frm.score();
		assertEquals(8,score);
	}
	
	@Test
	public void testFrame_0_9_return_9() throws BowlingException{
		Frame frm = new Frame(0,9);
		int score = frm.score();
		assertEquals(9,score);
	}
	
	@Test (expected = BowlingException.class)
	public void testFrame_minus1_8_throwBowlingException() throws BowlingException{
		Frame frm = new Frame(-1,9);
		int score = frm.score();
	}
}

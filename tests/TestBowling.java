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

	@Test
	public void testaddFrame_return_10() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(1,5));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.getThrowsNumber();
		assertEquals(10,number);
	}
	
	@Test (expected = BowlingException.class )
	public void testaddFrame_minus1_2_throwBowlingException() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(-1,2));
	}
	
	@Test
	public void testscore_example_81() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(1,5));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.score();
		assertEquals(81,number);
	}
	
	// example : [10,0] [3,6] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6]
	@Test
	public void testScoreWithStrike_examplecase_equals_94() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.score();
		assertEquals(94,number);
	}
	
	
	// example2 : [10,0] [3,6] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [9,0]
	@Test
	public void testScoreWithStrike_example2case_equals_96() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(9,0));
		int number = bg.score();
		assertEquals(95,number);
	}
	
	// example3 : [1,9] [3,6] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6]
	@Test
	public void testScoreWithSpare_example3case_equals_88() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(1,9));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.score();
		assertEquals(88,number);
	}
	
	// example4 : [10,0] [4,6] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6]
	@Test
	public void testScoreWithSpareFollowdBySpare_example4case_equals_103() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(4,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.score();
		assertEquals(103,number);
	}
	
	// example5 : [10,0] [10,0] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6]
	@Test
	public void testScoreWithTwoStrikeInARow_example5case_equals_112() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.score();
		assertEquals(112,number);
	}
	
	// example6 : [8,2] [5,5] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6]
	@Test
	public void testScoreWithTwoSpareInARow_example6case_equals_98() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(8,2));
		bg.addFrame(new Frame(5,5));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,6));
		int number = bg.score();
		assertEquals(98,number);		
	}
	
	// example7 : [8,2] [5,5] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6] ,bonus [7,0]
	@Test
	public void testScoreWithLastSpare_example7case_equals_90() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(1,5));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,8));
		bg.setBonus(7,0);
		int number = bg.score();
		assertEquals(90,number);	
	}
	
	// example8 : [8,2] [5,5] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6] ,bonus [7,2]
	@Test
	public void testScoreWithLastStrike_example8case_equals_92() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(1,5));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(10,0));
		bg.setBonus(7,2);
		int number = bg.score();
		assertEquals(92,number);
	}
	
	// example8 : [8,2] [5,5] [7,2] [3,6] [4,4] [5,3] [3,3] [4,5] [8,1] [2,6] ,bonus [10,0]
	@Test
	public void testScoreWithBonusAStrike_example9case_equals_93() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(1,5));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(3,6));
		bg.addFrame(new Frame(4,4));
		bg.addFrame(new Frame(5,3));
		bg.addFrame(new Frame(3,3));
		bg.addFrame(new Frame(4,5));
		bg.addFrame(new Frame(8,1));
		bg.addFrame(new Frame(2,8));
		bg.setBonus(10,0);
		int number = bg.score();
		assertEquals(93,number);
	}
	
	@Test
	public void testBestScore_equals_300() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));

		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		
		bg.setBonus(10,10);
		int number = bg.score();
		assertEquals(300,number);
	}
	
	@Test
	public void testRealGame_givenexample_equals_135() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(6,3));
		bg.addFrame(new Frame(7,1));
		bg.addFrame(new Frame(8,2));
		bg.addFrame(new Frame(7,2));
		bg.addFrame(new Frame(10,0));
		
		bg.addFrame(new Frame(6,2));
		bg.addFrame(new Frame(7,3));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(8,0));
		bg.addFrame(new Frame(7,3));
		
		bg.setBonus(10,0);
		int number = bg.score();
		assertEquals(135,number);
	}
}



































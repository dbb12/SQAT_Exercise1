import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// to get the number of frames a game consists of
	public int getThrowsNumber(){
		return frames.size();
	}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		frames.add(frame);
		if( frame.score()>10 )
			throw new BowlingException();
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		bonus = new Frame(firstThrow,secondThrow);
	}
	
	// Returns the game score
	public int score(){
		int score=0;
		for( int i=0 ; i<frames.size()-1 ; i++ )
		{
			score += (frames.get(i)).score();
			if( frames.get(i).isStrike() )
			{
				score += frames.get(i+1).score();
				if( frames.get(i+1).isStrike() && i!=8 )
					score += frames.get(i+2).getFirstThrow();
			}
			else if( frames.get(i).isSpare() )
				score += frames.get(i+1).getFirstThrow();
		}
		if ( frames.get(9).isStrike() )
			score += bonus.score();
		else if( frames.get(9).isSpare() )
			score += bonus.getFirstThrow();
		if( frames.get(8).isStrike() )
			score += bonus.getFirstThrow();
		return score+frames.get(9).score();
	}
}

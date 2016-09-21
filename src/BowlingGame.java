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
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
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
				if( frames.get(i+1).isStrike() && i!=9 )
					score += frames.get(i+2).getFirstThrow();
			}
			else if( frames.get(i).isSpare() )
				score += frames.get(i+1).getFirstThrow();
		}
		return score+frames.get(9).score();
	}
}

import properties.PropertyManager;

/**
 * A simple implementation of a black box framework
 * 
 * @author Daniel Pawelczyk
 */
public class Main {

	public static void main(String[] args) throws Exception {		
		// #if TweetDeck && Image && !Text
		new TweetWindow(new TweetDeckPlugin(), null, new ImagePlugin());
		// #endif
		
		// #if Android && !File && Text
//@		new TweetWindow(new AndroidPlugin(), new TextPlugin(), null);
		// #endif
		
		// #if iOS && Image && Text && Location
//@		new TweetWindow(new AppleIPhonePlugin(), new TextPlugin(), new ImagePlugin());
		// #endif
		
		// #if Android && Text && Poll
//@		new TweetWindow(new AndroidPlugin(), new TextPlugin(), new PollPlugin());
		// #endif
		
		// #if TweetDeck && Text && Video
//@		new TweetWindow(new TweetDeckPlugin(), new TextPlugin(), new VideoPlugin());
		// #endif
	}
}

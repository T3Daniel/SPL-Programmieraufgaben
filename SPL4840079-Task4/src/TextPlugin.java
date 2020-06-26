
public class TextPlugin implements ITextPlugin {
	
	@Override
	public String getTweetText() {
		return "This is a tweet!";
	}

	@Override
	public int getContentSize() {
		return 40;
	}

}

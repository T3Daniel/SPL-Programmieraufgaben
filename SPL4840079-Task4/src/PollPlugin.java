import java.awt.Dimension;

public class PollPlugin implements IFilePlugin {

	@Override
	public String getFilePath() {
		return "/images/poll.png";
	}

	@Override
	public Dimension getDimensions() {
		return new Dimension(571, 460);
	}

	@Override
	public int getContentSize() {
		return 155;
	}

}

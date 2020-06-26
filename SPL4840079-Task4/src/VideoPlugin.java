import java.awt.Dimension;

public class VideoPlugin implements IFilePlugin {

	@Override
	public String getFilePath() {
		return "/images/video.png";
	}

	@Override
	public Dimension getDimensions() {
		return new Dimension(571, 405);
	}

	@Override
	public int getContentSize() {
		return 405;
	}

}

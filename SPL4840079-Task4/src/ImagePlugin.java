import java.awt.Dimension;

public class ImagePlugin implements IFilePlugin {

	@Override
	public String getFilePath() {
		return "/images/image.png";
	}

	@Override
	public Dimension getDimensions() {
		return new Dimension(571, 460);
	}

	@Override
	public int getContentSize() {
		return 460;
	}
}

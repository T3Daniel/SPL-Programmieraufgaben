import java.io.IOException;

class TweetShell {
	private void createFile() throws IOException {
		BufferedImage source = ImageIO.read(new File(dir + "/images/image.png"));
		contentLabel = new JLabel(new ImageIcon(source), SwingConstants.LEFT);
		contentPanel.setPreferredSize(new Dimension(571, 460));
		contentSize += 460;
	}
}
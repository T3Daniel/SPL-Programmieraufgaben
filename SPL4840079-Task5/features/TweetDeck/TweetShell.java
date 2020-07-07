import java.io.IOException;

class TweetShell {
	private void addFooter() throws IOException {		
		original();
		footerPanel.remove(footerLabel);
		
		// Set platform
		platformLabel.setText("TweetDeck");
		footerPanel.add(platformLabel);
		footerPanel.add(footerLabel);
	}
}
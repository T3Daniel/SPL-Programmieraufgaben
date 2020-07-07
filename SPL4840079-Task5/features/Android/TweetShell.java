import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

class TweetShell {
	private void addFooter() throws IOException {		
		original();
		footerPanel.remove(footerLabel);
		
		// Set platform
		platformLabel.setText("Twitter for Android");
		footerPanel.add(platformLabel);
		footerPanel.add(footerLabel);
	}
}
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

class TweetShell {
	
	private JLabel platformLabel;
	
	private void addFooter() throws IOException {
		original();
		
		// Add platform
		platformLabel = new JLabel("", SwingConstants.LEFT);

		Font newLabelFont = new Font(platformLabel.getFont().getName(), Font.PLAIN, platformLabel.getFont().getSize());
		platformLabel.setFont(newLabelFont.deriveFont(15.0f));
		platformLabel.setForeground(PLATFORM_TEXT_COLOR);
		platformLabel.setAlignmentX(Component.LEFT_ALIGNMENT);		
	}
}
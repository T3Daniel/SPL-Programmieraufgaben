import java.io.IOException;

class TweetShell {
	
	private JLabel textLabel;
	
	private void createWindow() throws IOException {
		original();
		
		createText();
		addText();
	}
	
	private void addText()  throws IOException {			
		//Add Text
		contentPanel.add(textLabel, BorderLayout.WEST);
		contentSize += 40;
		frame.setPreferredSize(new Dimension(610, contentSize));
		mainPanel.add(contentPanel);
	}
	
	private void createText() {
		//Create Text
		textLabel = new JLabel("This is a tweet!");
		Font newLabelFont = new Font(textLabel.getFont().getName(), Font.BOLD, textLabel.getFont().getSize());
		textLabel.setFont(newLabelFont.deriveFont(16.0f));
		textLabel.setForeground(Color.white);
		textLabel.setPreferredSize(new Dimension(590, 30));
		textLabel.setBackground(Color.white);
		textLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));		
	}
}
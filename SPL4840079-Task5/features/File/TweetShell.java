import java.io.IOException;

class TweetShell {
	private JLabel contentLabel;

	private void createWindow() throws IOException {
		original();
		
		createFile();
		addFile();
	}
	
	private void addFile()  throws IOException {	
		//AddFile
		contentPanel.add(contentLabel, BorderLayout.WEST);
		frame.setPreferredSize(new Dimension(610, contentSize));
		mainPanel.add(contentPanel);
	}
	
	private void createFile() throws IOException {
		
	}
}
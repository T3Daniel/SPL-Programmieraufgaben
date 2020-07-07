import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TweetShell {
	private static final Color TWITTER_BG_COLOR = new Color(21, 32, 43);
	private static final Color PLATFORM_TEXT_COLOR = new Color(27, 149, 224);
	private static final String dir = System.getProperty("user.dir");
	
	private JFrame frame;
	
	private JPanel mainPanel;
	private JPanel contentPanel;
	private JPanel footerPanel;

	private JLabel footerLabel;
	private JLabel headerLabel;

	private int contentSize = 260;

	private static TweetShell application;
	
	public static void main(String[] args) {
		application = new TweetShell();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					application.createWindow();
					application.displayWindow();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void createWindow() throws IOException {
		// Create and set up the window.
		frame = new JFrame("Tweet");
		mainPanel = new JPanel(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set panel color
		mainPanel.setBackground(TWITTER_BG_COLOR);
		
		//Add Header
		addHeader();
		
		//Add Footer
		addFooter();
		
		//Add Content
		contentPanel = new JPanel(new FlowLayout());
		contentPanel.setBackground(TWITTER_BG_COLOR);		
	}
	
	private void addHeader() throws IOException {
		// Set twitter header
		BufferedImage twitterHeaderImg = ImageIO.read(new File(dir + "/images/twitter_top.png"));
		headerLabel = new JLabel(new ImageIcon(twitterHeaderImg));
		mainPanel.add(headerLabel, BorderLayout.NORTH);
	}
	
	private void addFooter() throws IOException {
		// Set twitter footer
		footerPanel = new JPanel();
		footerPanel.setBackground(TWITTER_BG_COLOR);
		LayoutManager footerOverlay = new OverlayLayout(footerPanel);
		footerPanel.setLayout(footerOverlay);

		BufferedImage twitterFooterImg = ImageIO.read(new File(dir + "/images/twitter_bottom.png"));
		footerLabel = new JLabel(new ImageIcon(twitterFooterImg));
		footerLabel.setAlignmentX(0.325f);
		footerLabel.setAlignmentY(0.135f);		
		footerPanel.add(footerLabel);
		
		// Add footer to main panel
		mainPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	private void displayWindow() {
		// Display the window
		frame.setPreferredSize(new Dimension(610, contentSize));		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		frame.getContentPane().add(mainPanel);
	}
}
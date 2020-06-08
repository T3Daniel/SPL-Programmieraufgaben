import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TweetWindow {
	
	private static final Color TWITTER_BG_COLOR = new Color(21, 32, 43);
	private static final Color PLATFORM_TEXT_COLOR = new Color(27, 149, 224);
	private static final String dir = System.getProperty("user.dir");
	
	public void createWindow() throws IOException {
		// Create and set up the window.
		JFrame frame = new JFrame("Tweet");
		JPanel mainPanel = new JPanel(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set panel color
		mainPanel.setBackground(TWITTER_BG_COLOR);
		
		//Set twitter header				
		BufferedImage twitterHeaderImg = ImageIO.read(new File(dir + "/images/twitter_top.png"));
		JLabel headerLabel = new JLabel(new ImageIcon(twitterHeaderImg));	
		mainPanel.add(headerLabel, BorderLayout.NORTH);
        
		//Set twitter footer				
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(TWITTER_BG_COLOR);
		LayoutManager footerOverlay = new OverlayLayout(footerPanel);
		footerPanel.setLayout(footerOverlay);
		
		BufferedImage twitterFooterImg = ImageIO.read(new File(dir + "/images/twitter_bottom.png"));
		JLabel footerLabel = new JLabel(new ImageIcon(twitterFooterImg));	
		footerLabel.setAlignmentX(0.325f);
		footerLabel.setAlignmentY(0.135f);
		
		//Set platform
		JLabel platformLabel = new JLabel("", SwingConstants.LEFT);
				
		// #if Android
//@		platformLabel.setText("Twitter for Android");
		// #endif

		// #if TweetDeck
//@		platformLabel.setText("TweetDeck");
		// #endif

		// #if iOS
		platformLabel.setText("Twitter for iPhone");
		// #endif
				
		Font newLabelFont = new Font(platformLabel.getFont().getName(), Font.PLAIN, platformLabel.getFont().getSize());
		platformLabel.setFont(newLabelFont.deriveFont(15.0f));
		platformLabel.setForeground(PLATFORM_TEXT_COLOR);
		platformLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Add footer and platform to main panel
		footerPanel.add(platformLabel);	
		footerPanel.add(footerLabel);
		mainPanel.add(footerPanel, BorderLayout.SOUTH);

		//Create content from config
		JPanel contentPanel = new JPanel(new FlowLayout());	
		contentPanel.setBackground(TWITTER_BG_COLOR);
		
		int tweetSize = createContent(contentPanel);
		frame.setPreferredSize(new Dimension(610, tweetSize));

		mainPanel.add(contentPanel);
		
		// Display the window
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().add(mainPanel);
	}
	 
	/**
	 * Throw exception if configuration is not viable.
	 * 
	 * @return Size the tweet needs to be fully displayed 
	 */
	private static int createContent(JPanel targetPanel) throws IOException {
		int tweetSize = 260;

		// #if Text
		JLabel textLabel = new JLabel("This is a tweet.");
		Font newLabelFont = new Font(textLabel.getFont().getName(), Font.BOLD, textLabel.getFont().getSize());
		textLabel.setFont(newLabelFont.deriveFont(16.0f));
		textLabel.setForeground(Color.white);
		textLabel.setPreferredSize(new Dimension(590, 30));
		textLabel.setBackground(Color.white);
		textLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		targetPanel.add(textLabel, BorderLayout.WEST);
		tweetSize += 40;
		// #endif

		// #if Image
		BufferedImage image = ImageIO.read(new File(dir + "/images/image.png"));
		JLabel imageLabel = new JLabel(new ImageIcon(image), SwingConstants.LEFT);
		targetPanel.setPreferredSize(new Dimension(571, 460));
		targetPanel.add(imageLabel, BorderLayout.WEST);
		tweetSize += 460;
		// #endif
		
		// #if Poll
//@		BufferedImage poll = ImageIO.read(new File(dir + "/images/poll.png"));
//@		JLabel pollLabel = new JLabel(new ImageIcon(poll), SwingConstants.LEFT);
//@		targetPanel.setPreferredSize(new Dimension(571, 460));
//@		targetPanel.add(pollLabel, BorderLayout.WEST);
//@		tweetSize += 155;
		// #endif

		// #if Video
//@		BufferedImage video = ImageIO.read(new File(dir + "/images/video.png"));
//@		JLabel videoLabel = new JLabel(new ImageIcon(video), SwingConstants.LEFT);
//@		targetPanel.setPreferredSize(new Dimension(571, 405));
//@		targetPanel.add(videoLabel, BorderLayout.WEST);
//@		tweetSize += 405;
		// #endif
		
		return tweetSize;
	}
}

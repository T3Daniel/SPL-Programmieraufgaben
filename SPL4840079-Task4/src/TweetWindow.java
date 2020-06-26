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
	
	private int contentSize = 260;
	private IPlatformPlugin platformPlugin;
	private ITextPlugin textPlugin;
	private IFilePlugin filePlugin;

	public TweetWindow(IPlatformPlugin _platformPlugin, ITextPlugin _textPlugin, IFilePlugin _filePlugin) {
		this.platformPlugin = _platformPlugin;
		this.textPlugin = _textPlugin;
		this.filePlugin = _filePlugin;
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createWindow();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
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
		
		if(platformPlugin != null) {
			platformLabel.setText(platformPlugin.getPlatformName());
		}
				
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
		
		createContent(contentPanel);
		frame.setPreferredSize(new Dimension(610, contentSize));

		mainPanel.add(contentPanel);
		
		// Display the window
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().add(mainPanel);
	}
	 
	/**
	 * Adds content to the tweet window
	 * 
	 * @return Size the tweet needs to be fully displayed 
	 */
	private void createContent(JPanel targetPanel) throws IOException {
		
		if(textPlugin != null) {
			JLabel textLabel = new JLabel(textPlugin.getTweetText());
			Font newLabelFont = new Font(textLabel.getFont().getName(), Font.BOLD, textLabel.getFont().getSize());
			textLabel.setFont(newLabelFont.deriveFont(16.0f));
			textLabel.setForeground(Color.white);
			textLabel.setPreferredSize(new Dimension(590, 30));
			textLabel.setBackground(Color.white);
			textLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			targetPanel.add(textLabel, BorderLayout.WEST);
			contentSize += textPlugin.getContentSize();
		}
		
		if(filePlugin != null) {
			BufferedImage source = ImageIO.read(new File(dir + filePlugin.getFilePath()));
			JLabel contentLabel = new JLabel(new ImageIcon(source), SwingConstants.LEFT);
			targetPanel.setPreferredSize(filePlugin.getDimensions());
			targetPanel.add(contentLabel, BorderLayout.WEST);
			contentSize += filePlugin.getContentSize();
		}
	}
}

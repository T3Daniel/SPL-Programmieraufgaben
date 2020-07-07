import java.awt.*; 
import java.awt.image.BufferedImage; 
import java.io.File; import java.io.IOException; 

import javax.imageio.ImageIO; 
import javax.swing.*; import java.awt.Component; 
import java.awt.Font; 

import javax.swing.JLabel; 
import javax.swing.SwingConstants; 

public 

class  TweetShell {
	
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

	

	 private void  createWindow__wrappee__Create_Tweet  () throws IOException {
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

	

	private void createWindow() throws IOException {
		createWindow__wrappee__Create_Tweet();
		
		createFile();
		addFile();
	}

	
	
	private void addHeader() throws IOException {
		// Set twitter header
		BufferedImage twitterHeaderImg = ImageIO.read(new File(dir + "/images/twitter_top.png"));
		headerLabel = new JLabel(new ImageIcon(twitterHeaderImg));
		mainPanel.add(headerLabel, BorderLayout.NORTH);
	}

	
	
	 private void  addFooter__wrappee__Create_Tweet  () throws IOException {
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

	
	
	 private void  addFooter__wrappee__Platform  () throws IOException {
		addFooter__wrappee__Create_Tweet();
		
		// Add platform
		platformLabel = new JLabel("", SwingConstants.LEFT);

		Font newLabelFont = new Font(platformLabel.getFont().getName(), Font.PLAIN, platformLabel.getFont().getSize());
		platformLabel.setFont(newLabelFont.deriveFont(15.0f));
		platformLabel.setForeground(PLATFORM_TEXT_COLOR);
		platformLabel.setAlignmentX(Component.LEFT_ALIGNMENT);		
	}

	
	private void addFooter() throws IOException {		
		addFooter__wrappee__Platform();
		footerPanel.remove(footerLabel);
		
		// Set platform
		platformLabel.setText("TweetDeck");
		footerPanel.add(platformLabel);
		footerPanel.add(footerLabel);
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

	
	
	private JLabel platformLabel;

	
	private JLabel contentLabel;

	
	
	private void addFile()  throws IOException {	
		//AddFile
		contentPanel.add(contentLabel, BorderLayout.WEST);
		frame.setPreferredSize(new Dimension(610, contentSize));
		mainPanel.add(contentPanel);
	}

	
	private void createFile  () throws IOException {
		BufferedImage source = ImageIO.read(new File(dir + "/images/image.png"));
		contentLabel = new JLabel(new ImageIcon(source), SwingConstants.LEFT);
		contentPanel.setPreferredSize(new Dimension(571, 460));
		contentSize += 460;
	}


}

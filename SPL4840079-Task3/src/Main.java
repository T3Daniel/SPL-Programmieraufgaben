import java.io.IOException;

import javax.swing.SwingUtilities;
import properties.PropertyManager;

/**
 * A simple implementation of runtime properties.
 * 
 * @author Daniel Pawelczyk
 */
public class Main {

	public static void main(String[] args) throws Exception {
			
		validateConfig();
		
		TweetWindow tweet = new TweetWindow();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					tweet.createWindow();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Throw exception if configuration is not viable.
	 */
	private static void validateConfig() throws Exception {
		
		//---------------------
		// Validation doesn't use Antenna, because unreachable code will be created due to the exceptions
		//---------------------
		
		//Constraints 
		if(!(PropertyManager.getProperty("Text") || PropertyManager.getProperty("File"))) {
			throw new Exception("Either \"Text\" or \"File\" must be selected.");
		}
		
		if((PropertyManager.getProperty("Image") && PropertyManager.getProperty("Poll")) || (PropertyManager.getProperty("Video") && PropertyManager.getProperty("Poll"))) {
			throw new Exception("If \"Poll\" is selected, \"Video\" and/or \"Image\" can not be selected.");
		}
		
		if((PropertyManager.getProperty("Poll") && PropertyManager.getProperty("Video")) || (PropertyManager.getProperty("Image") && PropertyManager.getProperty("Video"))) {
			throw new Exception("If \"Video\" is selected, \"Image\" and/or \"Poll\" can not be selected.");
		}
		
		//Mandatory
		if(!PropertyManager.getProperty("Plattform")) {
			throw new Exception("\"Plattform\" must be selected.");
		}
		
		//Children
		if(!PropertyManager.getProperty("File")) {
			if(PropertyManager.getProperty("Image") || PropertyManager.getProperty("Poll") || PropertyManager.getProperty("Location") || PropertyManager.getProperty("Video")) {
				throw new Exception("\"File\" must be selected.");
			}
		}
		
		if(!PropertyManager.getProperty("Image")) {
			if(PropertyManager.getProperty("png") || PropertyManager.getProperty("jpg")) {
				throw new Exception("\"Image\" must be selected.");
			}
		}
		
		if(!PropertyManager.getProperty("Video")) {
			if(PropertyManager.getProperty("avi") || PropertyManager.getProperty("wmv")) {
				throw new Exception("\"Video\" must be selected.");
			}
		}
		
		//Alternative Groups
		if(PropertyManager.getProperty("png") && PropertyManager.getProperty("jpg")) {
			throw new Exception("Either \"png\" or \"jpg\" can be selected. Not both.");
		}
		
		if(PropertyManager.getProperty("Image")) {
			if(!(PropertyManager.getProperty("png") || PropertyManager.getProperty("jpg"))) {
				throw new Exception("Either \"png\" or \"jpg\" must be selected.");
			}
		}
		
		if(PropertyManager.getProperty("Video")) {
			if(!(PropertyManager.getProperty("avi") || PropertyManager.getProperty("wmv"))) {
				throw new Exception("Either \"avi\" or \"wmv\" must be selected.");
			}
		}
		
		if(PropertyManager.getProperty("avi") && PropertyManager.getProperty("wmv")) {
			throw new Exception("Either \"avi\" or \"wmv\" can be selected. Not both.");
		}
		
		int countPlattforms = 0;
		
		if(PropertyManager.getProperty("Android")) {
			countPlattforms++;
		}
		
		if(PropertyManager.getProperty("TweetDeck")) {
			countPlattforms++;
		}
		
		if(PropertyManager.getProperty("iOS")) {
			countPlattforms++;
		}
		
		if(countPlattforms > 1) {
			throw new Exception("Only one plattform can be selected.");
		}
		
		if(countPlattforms < 1) {
			throw new Exception("A plattform must be selected.");
		}
	}
}

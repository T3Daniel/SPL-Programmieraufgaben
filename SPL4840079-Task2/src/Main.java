import properties.PropertyManager;


/**
 * A simple implementation of runtime properties.
 * 
 * @author Daniel Pawelczyk
 */
public class Main {

	public static void main(String[] args) throws Exception {
			
		validateConfig();
		
		
		if(PropertyManager.getProperty("Plattform")) {
			System.out.println("Plattform ist angekreuzt");
			
			if(PropertyManager.getProperty("Android")) {
				System.out.println("Android ist angekreuzt");
			}
			
			if(PropertyManager.getProperty("TweetDeck")) {
				System.out.println("TweetDeck ist angekreuzt");
			}
			
			if(PropertyManager.getProperty("iOS")) {
				System.out.println("iOS ist angekreuzt");
			}
		}
		
		if(PropertyManager.getProperty("Text")) {
			System.out.println("Text ist angekreuzt");
		}
		
		if(PropertyManager.getProperty("File")) {
			System.out.println("File ist angekreuzt");
			
			if(PropertyManager.getProperty("Image")) {
				System.out.println("Image ist angekreuzt");
				
				if(PropertyManager.getProperty("png")) {
					System.out.println("png ist angekreuzt");
				}
				
				if(PropertyManager.getProperty("jpg")) {
					System.out.println("jpg ist angekreuzt");
				}
			}
			
			if(PropertyManager.getProperty("Poll")) {
				System.out.println("Poll ist angekreuzt");
			}
			
			if(PropertyManager.getProperty("Location")) {
				System.out.println("Location ist angekreuzt");
			}
			
			if(PropertyManager.getProperty("Video")) {
				System.out.println("Video ist angekreuzt");
				
				if(PropertyManager.getProperty("avi")) {
					System.out.println("avi ist angekreuzt");
				}
				
				if(PropertyManager.getProperty("wmv")) {
					System.out.println("wmv ist angekreuzt");
				}
			}
		}
	}
	
	/**
	 * Throw exception if configuration is not viable.
	 */
	private static void validateConfig() throws Exception {
		
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

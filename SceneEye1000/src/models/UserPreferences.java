package models;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sceneeyeftdi.CameraTextMode;

public class UserPreferences {

	private static final String TAG_SETTINGS = "ses-settings";
	private static final String TAG_APPLICATION = "application";
	private static final String TAG_APPLICATION_VERSION = "version";
	private static final String TAG_POINTER = "pointer";
	private static final String TAG_POINTER_SIZE = "size";
	private static final String TAG_POINTER_COLOR = "color";
	private static final String TAG_LOCALIZATION = "localisation";
	private static final String TAG_LOCALIZATION_LANGUAGE = "language";
	private static final String TAG_CAMERA = "camera";
	private static final String TAG_CAMERA_CONTRAST = "contrast";
	private static final String TAG_CAMERA_CONTRAST_LEVEL = "contrastlevel";
	private static final String TAG_CAMERA_TEXT = "text";
	private static final String TAG_CAMERA_FLIP = "flip";
	private static final String TAG_CAMERA_FREEZE = "freeze";
	private static final String TAG_CAMERA_ZOOM_LEVEL = "zoomlevel";
	private static final String TAG_SNAPSHOTS = "snapshots";
	private static final String TAG_SNAPSHOTS_FOLDER = "folder";

	private static final String DEFAULT_APPLICATION_VERSION = "2.0";
	private static final String DEFAULT_POINTER_SIZE = "medium";
	private static final String DEFAULT_POINTER_COLOR = "blue";
	private static final String DEFAULT_LANGUAGE = "English";
	private static final String DEFAULT_CAMERA_CONTRAST = "COLOR_NO_BOOST";
	private static final String DEFAULT_CAMERA_CONTRAST_LEVEL = "0";
	private static final String DEFAULT_CAMERA_TEXT = "TXT_WHITE_ON_BLACK";
	private static final String DEFAULT_CAMERA_FLIP = "NORMAL";
	private static final String DEFAULT_CAMERA_FREEZE = "OFF";
	private static final String DEFAULT_CAMERA_ZOOM_LEVEL = "0";
		
	private static Document settingsData = null;
	private static NodeList ref_applicationVersionNode = null;
	private static NodeList ref_pointerSizeNode = null;
	private static NodeList ref_pointerColorNode = null;
	private static NodeList ref_localizationNode = null;
	private static NodeList ref_cameraContrastNode = null;
	private static NodeList ref_cameraContrastLevelNode = null;
	private static NodeList ref_cameraTextNode = null;
	private static NodeList ref_cameraFlipNode = null;
	private static NodeList ref_cameraFreezeNode = null;
	private static NodeList ref_cameraZoomLevelNode = null;
	private static NodeList ref_snapshotFolderNode = null;
	
	/**
	* A handle to the unique Singleton instance.
	*/   
	static private UserPreferences _instance = null;
		 
   /**
	* @return The unique instance of this class.
	*/
	static public UserPreferences createInstance(Document settings) {
		   		
		settingsData = settings;
		
		if (settingsData != null && parse(settingsData)){
			_instance = new UserPreferences();
		}
		
		return _instance;
	}
	
	static public UserPreferences createInstance() {
	
		_instance = new UserPreferences();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder documentBuilder = null;
		
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		settingsData = documentBuilder.newDocument();
		
		Element ses_settings = settingsData.createElement(TAG_SETTINGS);
		settingsData.appendChild(ses_settings);
		
		Element application = settingsData.createElement(TAG_APPLICATION);
		ses_settings.appendChild(application);		
		Element appVersion = settingsData.createElement(TAG_APPLICATION_VERSION);
		appVersion.appendChild(settingsData.createTextNode(DEFAULT_APPLICATION_VERSION));
		application.appendChild(appVersion);
		
		Element pointer = settingsData.createElement(TAG_POINTER);
		ses_settings.appendChild(pointer);
		
		Element pointerSize = settingsData.createElement(TAG_POINTER_SIZE);
		pointerSize.appendChild(settingsData.createTextNode(DEFAULT_POINTER_SIZE));
		Element pointerColor = settingsData.createElement(TAG_POINTER_COLOR);
		pointerColor.appendChild(settingsData.createTextNode(DEFAULT_POINTER_COLOR));
		
		pointer.appendChild(pointerSize);
		pointer.appendChild(pointerColor);
		
		Element localization = settingsData.createElement(TAG_LOCALIZATION);
		ses_settings.appendChild(localization);
		
		Element localizationLanguage = settingsData.createElement(TAG_LOCALIZATION_LANGUAGE);
		localizationLanguage.appendChild(settingsData.createTextNode(DEFAULT_LANGUAGE));
		
		localization.appendChild(localizationLanguage);
		
		Element camera = settingsData.createElement(TAG_CAMERA);
		ses_settings.appendChild(camera);
		
		Element cameraContrast = settingsData.createElement(TAG_CAMERA_CONTRAST);
		cameraContrast.appendChild(settingsData.createTextNode(DEFAULT_CAMERA_CONTRAST));
		Element cameraContrastLevel = settingsData.createElement(TAG_CAMERA_CONTRAST_LEVEL);
		cameraContrastLevel.appendChild(settingsData.createTextNode(DEFAULT_CAMERA_CONTRAST_LEVEL));
		Element cameraText = settingsData.createElement(TAG_CAMERA_TEXT);
		cameraText.appendChild(settingsData.createTextNode(DEFAULT_CAMERA_TEXT));
		Element cameraFlip = settingsData.createElement(TAG_CAMERA_FLIP);
		cameraFlip.appendChild(settingsData.createTextNode(DEFAULT_CAMERA_FLIP));
		Element cameraFreeze = settingsData.createElement(TAG_CAMERA_FREEZE);
		cameraFreeze.appendChild(settingsData.createTextNode(DEFAULT_CAMERA_FREEZE));
		Element cameraZoom = settingsData.createElement(TAG_CAMERA_ZOOM_LEVEL);
		cameraZoom.appendChild(settingsData.createTextNode(DEFAULT_CAMERA_ZOOM_LEVEL));

		camera.appendChild(cameraContrast);
		camera.appendChild(cameraContrastLevel);
		camera.appendChild(cameraText);
		camera.appendChild(cameraFlip);
		camera.appendChild(cameraFreeze);
		camera.appendChild(cameraZoom);

		Element snapshots = settingsData.createElement(TAG_SNAPSHOTS);
		ses_settings.appendChild(snapshots);
		Element snapshotFolder = settingsData.createElement(TAG_SNAPSHOTS_FOLDER);
		snapshotFolder.appendChild(settingsData.createTextNode(""));
		snapshots.appendChild(snapshotFolder);
		
		parse(settingsData);
		return _instance;
	}

	public String getApplicationVersion(){
			
		try{
			Node n = (Node) ref_applicationVersionNode.item(0);
			return n.getNodeValue();
		}
		catch(Exception e){
			
		}
		return null;
	}
	
	public void setApplicationVersion(String version){
		
		version = (version != null && version.trim().length() > 0) ? version.toLowerCase() : DEFAULT_APPLICATION_VERSION;
		
		Node ptrAppVersion = settingsData.getElementsByTagName(TAG_APPLICATION).item(0);
		NodeList nodes = ptrAppVersion.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_APPLICATION_VERSION.equals(element.getNodeName())) { 
				element.setTextContent(version);
			}
		}
	}

	
	public String getPointerSize(){
		
		Node n = (Node) ref_pointerSizeNode.item(0);
		return n.getNodeValue();
	}
	
	public void setPointerSize(String ptrSize){
		
		ptrSize = (ptrSize != null && ptrSize.trim().length() > 0) ? ptrSize.toLowerCase() : DEFAULT_POINTER_SIZE;
		
		Node ptrColorSize = settingsData.getElementsByTagName(TAG_POINTER).item(0);
		NodeList nodes = ptrColorSize.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_POINTER_SIZE.equals(element.getNodeName())) { 
				element.setTextContent(ptrSize);
			}
		}
		
	}
	
	public String getPointerColor(){
		
		Node n = (Node) ref_pointerColorNode.item(0);
		return n.getNodeValue();
	}
	
	public void setPointerColor(String ptrColor){
				
		ptrColor = (ptrColor != null && ptrColor.trim().length() > 0) ? ptrColor.toLowerCase() : DEFAULT_POINTER_COLOR;
		
		Node ptrColorNode = settingsData.getElementsByTagName(TAG_POINTER).item(0);
		NodeList nodes = ptrColorNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_POINTER_COLOR.equals(element.getNodeName())) { 
				element.setTextContent(ptrColor);
			}
		}
	}
	
	public String getLanguage(){
		
		Node n = (Node) ref_localizationNode.item(0);
		return n.getNodeValue();
	}
	
	public void setLanguage(String language){
		
		language = (language != null && language.trim().length() > 0) ? language : DEFAULT_LANGUAGE;
		
		Node languageNode = settingsData.getElementsByTagName(TAG_LOCALIZATION).item(0);
		NodeList nodes = languageNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_LOCALIZATION_LANGUAGE.equals(element.getNodeName())) { 
				element.setTextContent(language);
			}
		}
	}
	
	public String getCameraContrast(){
		
		Node n = (Node) ref_cameraContrastNode.item(0);
		return n.getNodeValue();
	}
	
	public void setCameraContrast(String camContrast){
				
		camContrast = (camContrast != null && camContrast.trim().length() > 0) ? camContrast : DEFAULT_CAMERA_CONTRAST;
		
		Node ptrContrast = settingsData.getElementsByTagName(TAG_CAMERA).item(0);
		NodeList nodes = ptrContrast.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_CAMERA_CONTRAST.equals(element.getNodeName())) { 
				element.setTextContent(camContrast);
			}
		}
	}

	
	
	public String getCameraContrastLevel(){
		
		Node n = (Node) ref_cameraContrastLevelNode.item(0);
		return n.getNodeValue();
	}
	
	public void setCameraContrastLevel(String camContrastLevel){
				
		camContrastLevel = (camContrastLevel != null && camContrastLevel.trim().length() > 0) ? camContrastLevel : DEFAULT_CAMERA_CONTRAST_LEVEL;
		
		Node ptrContrastLevel = settingsData.getElementsByTagName(TAG_CAMERA).item(0);
		NodeList nodes = ptrContrastLevel.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_CAMERA_CONTRAST_LEVEL.equals(element.getNodeName())) { 
				element.setTextContent(camContrastLevel);
			}
		}
	}

	public String getCameraTextMode(){
		Node n = (Node) ref_cameraTextNode.item(0);
		return n.getNodeValue();
	}

	public void setCameraTextMode(String mode){
		
		String color = (mode != null && mode.trim().length() > 0) ? CameraTextMode.valueOf(mode).toString() : DEFAULT_CAMERA_TEXT;		
		
		Node colorNode = settingsData.getElementsByTagName(TAG_CAMERA).item(0); 
		NodeList nodes = colorNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_CAMERA_TEXT.equals(element.getNodeName())) { 
				element.setTextContent(color);
			}
		}
	}
	
	
	public String getCameraFlipMode(){
		
		Node n = (Node) ref_cameraFlipNode.item(0);
		return n.getNodeValue();
	}
	
	public void setCameraFlipMode(String camFlip){
				
		camFlip = (camFlip != null && camFlip.trim().length() > 0) ? camFlip.toUpperCase() : DEFAULT_CAMERA_FLIP;
		
		Node ptrColorNode = settingsData.getElementsByTagName(TAG_CAMERA).item(0);
		NodeList nodes = ptrColorNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_CAMERA_FLIP.equals(element.getNodeName())) { 
				element.setTextContent(camFlip);
			}
		}
	}
	
	public String getCameraZoomLevel(){
		
		Node n = (Node) ref_cameraZoomLevelNode.item(0);
		return n.getNodeValue();
	}
	
	public void setCameraZoomLevel(String camZoom){
				
		camZoom = (camZoom != null && camZoom.trim().length() > 0) ? camZoom : DEFAULT_CAMERA_ZOOM_LEVEL;
		
		Node ptrColorNode = settingsData.getElementsByTagName(TAG_CAMERA).item(0);
		NodeList nodes = ptrColorNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_CAMERA_ZOOM_LEVEL.equals(element.getNodeName())) { 
				element.setTextContent(camZoom);
			}
		}
	}
	
	public String getCameraFreezeMode(){
		
		Node n = (Node) ref_cameraFreezeNode.item(0);
		return n.getNodeValue();
	}
	
	public void setCameraFreezeMode(String camFreeze){
				
		camFreeze = (camFreeze != null && camFreeze.trim().length() > 0) ? camFreeze.toUpperCase() : DEFAULT_CAMERA_FREEZE;
		
		Node ptrColorNode = settingsData.getElementsByTagName(TAG_CAMERA).item(0);
		NodeList nodes = ptrColorNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_CAMERA_FREEZE.equals(element.getNodeName())) { 
				element.setTextContent(camFreeze);
			}
		}
	}
	
	public String getSnapshotsFolder(){
		
		Node n = (Node) ref_snapshotFolderNode.item(0);
		
		if (n != null){
			return n.getNodeValue(); 
		}
		return null;
	}
	
	public void setSnapshotsFolder(String snapshotFolder){
				
		snapshotFolder = (snapshotFolder != null && snapshotFolder.trim().length() > 0) ? snapshotFolder.toUpperCase() : "";
		
		Node ptrFolder = settingsData.getElementsByTagName(TAG_SNAPSHOTS).item(0);
		NodeList nodes = ptrFolder.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) { 
			Node element = nodes.item(i); 
			if (TAG_SNAPSHOTS_FOLDER.equals(element.getNodeName())) { 
				element.setTextContent(snapshotFolder);
			}
		}
	}
	
	private static boolean parse(Document settings){
		
	    settings.getDocumentElement().normalize();
	    
	    if (settings.getElementsByTagName(TAG_SETTINGS) != null){
	    	
	    	// We have a "ses-settings" xml file.
	    	// Wet get what we can.  If not, we'll provide defaults values.
	    	parseApplicationData(settings);
	    	parsePointerData(settings);
		    parseLocalizationData(settings);
		    parseCameraData(settings);
		    parseSnapshotsData(settings);
		    
			return true;
	    }
	    
	    return false;
	}
	
	
	private static void parseApplicationData(Document settings){
		
		NodeList nl = settings.getElementsByTagName(TAG_APPLICATION);
	    
		if (nl != null){
		    Node fstNode = nl.item(0);
		    
		    if (fstNode!= null && fstNode.getNodeType() == Node.ELEMENT_NODE) {
		  
		      Element fstElmnt = (Element) fstNode;
		      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_APPLICATION_VERSION);
		      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_applicationVersionNode = fstNmElmnt.getChildNodes();
		    }
		}
	}
	
	private static void parsePointerData(Document settings){
		
		NodeList nl = settings.getElementsByTagName(TAG_POINTER);
	    
		if (nl != null){
		    Node fstNode = nl.item(0);
		    
		    if (fstNode != null && fstNode.getNodeType() == Node.ELEMENT_NODE) {
		  
		      Element fstElmnt = (Element) fstNode;
		      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_POINTER_SIZE);
		      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_pointerSizeNode = fstNmElmnt.getChildNodes();

		      NodeList lstNmElmntLst = fstElmnt.getElementsByTagName(TAG_POINTER_COLOR);
		      Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
		      ref_pointerColorNode = lstNmElmnt.getChildNodes();
		    }
		}
	}
	
	private static void parseLocalizationData(Document settings){
		
		NodeList nl = settings.getElementsByTagName(TAG_LOCALIZATION);
    
	    if (nl != null){
	    
		    Node fstNode = nl.item(0);
		    
		    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
		  
		      Element fstElmnt = (Element) fstNode;
		      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_LOCALIZATION_LANGUAGE);
		      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_localizationNode = fstNmElmnt.getChildNodes();
		    }
	    }
	}
	
	private static void parseCameraData(Document settings){
		
		NodeList nl = settings.getElementsByTagName(TAG_CAMERA);
	    
		if (nl != null){
		    Node fstNode = nl.item(0);
		    
		    if (fstNode != null && fstNode.getNodeType() == Node.ELEMENT_NODE) {
		  
		      Element fstElmnt = (Element) fstNode;
		      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_CAMERA_CONTRAST);
		      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_cameraContrastNode = fstNmElmnt.getChildNodes();

		      fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_CAMERA_CONTRAST_LEVEL);
		      Element lstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_cameraContrastLevelNode = lstNmElmnt.getChildNodes();
		      
		      fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_CAMERA_TEXT);
		      lstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_cameraTextNode = lstNmElmnt.getChildNodes();
		      
		      fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_CAMERA_FLIP);
		      lstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_cameraFlipNode = lstNmElmnt.getChildNodes();
		      
		      fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_CAMERA_FREEZE);
		      lstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_cameraFreezeNode = lstNmElmnt.getChildNodes();
		      
		      fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_CAMERA_ZOOM_LEVEL);
		      lstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_cameraZoomLevelNode = lstNmElmnt.getChildNodes();
		    }
		}
	}
	
	private static void parseSnapshotsData(Document settings){
		
		NodeList nl = settings.getElementsByTagName(TAG_SNAPSHOTS);
	    
		if (nl != null){
		    Node fstNode = nl.item(0);
		    
		    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
		  
		      Element fstElmnt = (Element) fstNode;
		      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(TAG_SNAPSHOTS_FOLDER);
		      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		      ref_snapshotFolderNode = fstNmElmnt.getChildNodes();
		    }
		}
	}
	
	public String toString(){
		
		StringBuilder data = new StringBuilder();
		
		data.append("CLASS:  " + getClass().getName());
		data.append("\n" + TAG_SETTINGS.toUpperCase() + "- START");
		data.append("\n   " + TAG_APPLICATION);
		data.append("\n      " + TAG_APPLICATION_VERSION + ":   " + getApplicationVersion());		
		data.append("\n   " + TAG_POINTER);
		data.append("\n      " + TAG_POINTER_SIZE + ":   " + getPointerSize());
		data.append("\n      " + TAG_POINTER_COLOR + ":  " + getPointerColor());
		data.append("\n   " + TAG_LOCALIZATION);
		data.append("\n      " + TAG_LOCALIZATION_LANGUAGE + ":  " + getLanguage());
		data.append("\n   " + TAG_CAMERA);
		data.append("\n      " + TAG_CAMERA_CONTRAST + ":  " + getCameraContrast());
		data.append("\n      " + TAG_CAMERA_CONTRAST_LEVEL + ":  " + getCameraContrastLevel());
		data.append("\n      " + TAG_CAMERA_TEXT + ":  " + getCameraTextMode());
		data.append("\n      " + TAG_CAMERA_FLIP + ":  " + getCameraFlipMode());
		data.append("\n      " + TAG_CAMERA_FREEZE + ":  " + getCameraFreezeMode());
		data.append("\n      " + TAG_CAMERA_ZOOM_LEVEL + ":  " + getCameraZoomLevel());
		data.append("\n   " + TAG_SNAPSHOTS);
		data.append("\n      " + TAG_SNAPSHOTS_FOLDER + ":  " + getSnapshotsFolder());
		data.append("\n" + TAG_SETTINGS.toUpperCase() + " - END");
		
		return data.toString();
	}
	
	public Document getXmlDocument(){

		return settingsData;
	}
}


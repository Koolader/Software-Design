package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import models.UserPreferences;

/**
 * Servlet implementation class UpdateUserPreferences
 */
@WebServlet("/updateUserPreferences")
public class UpdateUserPreferences extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SETTINGS_FILE = "/data/sceneEyeSettings.xml";

    /**
     * Default constructor. 
     */
    public UpdateUserPreferences() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserPreferences prefs = null;
		ServletContext servlet = request.getServletContext();
		
		String appVersion =  request.getParameter("app_version");
		String pointerSize =  request.getParameter("ff_ptr_size");
		String pointerColor =  request.getParameter("ff_ptr_color");
		String language =  request.getParameter("ff_language");
		String camContrast =  request.getParameter("ff_camera_contrast");
		String camContrastLevel =  request.getParameter("ff_camera_contrast_level");
		String camText = request.getParameter("ff_camera_text");
		String camFlip =  request.getParameter("ff_camera_flip");
		String camFreeze =  request.getParameter("ff_camera_freeze");
		String camZoomLevel =  request.getParameter("ff_camera_zoom_level");
		String snapshotFolder =  request.getParameter("ff_snapshots_folder");
		
		
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    DocumentBuilder db = dbf.newDocumentBuilder();
		    try{
		    	Document doc = db.parse(servlet.getResource(SETTINGS_FILE).openStream());

		    	if (doc != null){
		    		prefs = UserPreferences.createInstance(doc);
		    	}
		    	servlet.getResource(SETTINGS_FILE).openStream().close();			    
		    }
		    catch (Exception e){

		    	prefs = UserPreferences.createInstance();
		    }
		    
		    if (appVersion != null && appVersion.trim().length() > 0){
		    	
				prefs.setPointerSize(appVersion);
			}
		    
			if (pointerSize != null && pointerSize.trim().length() > 0){
				
				prefs.setPointerSize(pointerSize);
			}
			
			if (pointerColor != null && pointerColor.trim().length() > 0){
				
				prefs.setPointerColor(pointerColor);
			}
			
			if (language != null && language.trim().length() > 0){
				prefs.setLanguage(language);
			}
			
			if (camContrast != null && camContrast.trim().length() > 0){
				prefs.setCameraContrast(camContrast);
			}
			
			if (camContrastLevel != null && camContrastLevel.trim().length() > 0){
				prefs.setCameraContrastLevel(camContrastLevel);
			}
			
			if (camText != null && camText.trim().length() > 0){
				prefs.setCameraTextMode(camText);
			}
			
			if (camFlip != null && camFlip.trim().length() > 0){
				prefs.setCameraFlipMode(camFlip);
			}
			
			if (camFreeze != null && camFreeze.trim().length() > 0){
				prefs.setCameraFreezeMode(camFreeze);
			}
			
			if (camZoomLevel != null && camZoomLevel.trim().length() > 0){
				prefs.setCameraZoomLevel(camZoomLevel);
			}
			
			if (snapshotFolder != null && snapshotFolder.trim().length() > 0){
				prefs.setSnapshotsFolder(snapshotFolder);
			}
		} 
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		DOMSource domSource = new DOMSource(prefs.getXmlDocument());
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		StreamResult result = null;
		
		try {
			transformer = tf.newTransformer();
			result =  new StreamResult(new StringWriter());
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
			transformer.transform(domSource, result);

		} catch (TransformerException e1) {

			e1.printStackTrace();
		}

		String path = getServletContext().getRealPath("");
		
		
          FileOutputStream fop = null;
          File file;
          try {
        	  
			file = new File(path, SETTINGS_FILE);
			fop = new FileOutputStream(file);
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
			    file.createNewFile();
			}
			
			// get the content in bytes
			String xmlString = result.getWriter().toString();
			byte[] contentInBytes = xmlString.getBytes();
			
			fop.write(contentInBytes);
			fop.flush();
			fop.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

		
		write(response);
	}
	
	
	private void write(HttpServletResponse response) throws IOException{
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("OK");
	}
}

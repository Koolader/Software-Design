package models;

import java.io.File;
import java.io.FilenameFilter;

public class ImageFileFilter implements FilenameFilter {

	/* TODO - Could be converted into a list of image type
	 *      - Only .jpg currently supported
	 */
	private static final char EXT_DELIMTER = '.';
	private static final String EXT_JPG = "jpg";

    public ImageFileFilter() { 	
    }

    public boolean accept(File dir, String name) {
    	
    	if (dir == null || name == null){
    		return false;
    	}
    	
    	return name.toLowerCase().endsWith(EXT_DELIMTER + EXT_JPG);
    }
}


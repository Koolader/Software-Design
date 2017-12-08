package models;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageCarousel {
	
	private int curIndex = 0;
	String[] imagesList = null;
	
	public ImageCarousel(File folder){
		
		if (folder != null && folder.exists()){
			
			File[] fileList = getImageFilenamesFromFolder(folder);
			
			if (fileList != null && fileList.length > 0){
				curIndex = fileList.length - 1;
				imagesList = new String[fileList.length];
				
				for (int i=0; i < fileList.length; i++){
					imagesList[i] = fileList[i].getAbsolutePath().toString(); 
				}
			}    		
		}
	}
	
	public BufferedImage next(){

		curIndex++;
		BufferedImage bImg = null;
		
		if (imagesList != null && imagesList.length > 0 ){
			curIndex %= imagesList.length;
			 bImg = getImageFile(imagesList[curIndex]);
		}
		
		return bImg;
	}
	
	public BufferedImage previous(){

		curIndex--;
		
		if (curIndex < 0){
			curIndex = imagesList.length - 1; 
		}
		
		curIndex %= imagesList.length;
		BufferedImage bImg = getImageFile(imagesList[curIndex]); 
		return bImg;
	}
	
	public BufferedImage first(){
		curIndex = 0;
		return getImageFile(imagesList[curIndex]);
	}
		
	public BufferedImage last(){
		curIndex = (imagesList.length - 1);
		
		return getImageFile(imagesList[curIndex]);
	}
	
	public int getTotalImageCount(){
		
		return ( imagesList != null ? imagesList.length : 0 );
	}
	
	public int getImageIndex(){
		
		return (curIndex + 1);
	}
	
	public String getImageFilenameAtIndex(int i){
		
		if (i > 0){		
			return imagesList[i-1];
		}
		
		return null;
	}
	
	
	private File[] getImageFilenamesFromFolder(File dir){
		
    	ImageFileFilter filter = new ImageFileFilter();
    	
    	if (dir.exists()){
    		 return dir.listFiles(filter);
    	}

    	return null;
		
	}
	
	private BufferedImage getImageFile(String filename){
		
		try{
			File file = new File(filename);
			if (file.exists()){
				//System.out.println("CAN READ: " + file.canRead() + " " + filename + "Cache: " + ImageIO.getUseCache());				
			
				BufferedImage b = ImageIO.read(file);
				
				return b;
			}
		}
		catch (IOException e){
			System.out.println("SceneEye >  " + this.getClass().getName() + " " + e);
		}
		return null;
	}
		
}

package sceneeyeftdi;

/*This enum enumerates two types for images. RGB and YUV.*/
public enum ImageType {
	
	/*NOTE: An RGB image is an image expressed in terms of red, green, and blue values.*/
	RGB(0),
	
	/*YUV is another method of expressing a digital image.
	The Y-component is brightness, and the U and V components are coordinates on
	a color plane.*/
	YUV(1);
	
	/*ImageType value. 0 for RGB, 1 for YUV.*/
	private final int value;

	/*Constructor for ImageType. Sets value to parameter value*/
	private ImageType(int value) {
		this.value = value;
	}

	/*Returns the ImageType value as a byte value.*/
	public byte getValue() {
		return (byte)value;
	}	
	
	/*Returns true if paramater i is equal to ImageType value, otherwise returns false*/
	public boolean equals(int i){
		
		return (i == value);
	}
}

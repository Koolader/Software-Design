package sceneeyeftdi;


public class SceneEyeFtdiJNI {

	public static boolean initError = false;
	/*load libraries*/
	static{
		try{
			System.setProperty("java.library.path", "C:/Windows/System32");			
			//String property = System.getProperty("java.library.path");
			
			System.loadLibrary("ftd2xx");
            System.loadLibrary("opencv_core2410");
            System.loadLibrary("opencv_highgui2410");
            System.loadLibrary("opencv_ml2410");
            System.loadLibrary("opencv_imgproc2410");
            System.loadLibrary("opencv_video2410");
            System.loadLibrary("opencv_flann2410");
            System.loadLibrary("opencv_features2d2410");    
            System.loadLibrary("opencv_calib3d2410");                    
            System.loadLibrary("opencv_legacy2410");                      
            System.loadLibrary("SceneEyeFtdi");

		} catch (UnsatisfiedLinkError e) {
			initError = true;
			System.out.println("Failure during static initialization" + e);
		}
	}
	/*functions that call the appropriate method of the USB interface*/
	synchronized public static native boolean ftdi_connect(byte captureMode, byte fps);
	synchronized public static native void ftdi_disconnect();
	synchronized public static native void ftdi_start();
	synchronized public static native byte[] ftdi_capture_image(boolean deinterlace); 
	synchronized public static native boolean ftdi_frame_rate_ctrl(byte fps);
	synchronized public static native int ftdi_zoom_ctrl(byte mode, long position, int speed);
	synchronized public static native boolean ftdi_freeze_mode_ctrl(byte mode);
	synchronized public static native boolean ftdi_focus_mode_ctrl(byte mode, long position);
	synchronized public static native boolean ftdi_contrast_mode_ctrl(byte mode);
	synchronized public static native boolean ftdi_text_mode_ctrl(byte mode);
	synchronized public static native boolean ftdi_servo_ctrl(byte mode, int pan_value, int tilt_value);
	synchronized public static native int ftdi_getWidth();
	synchronized public static native int ftdi_getHeight();
	synchronized public static native boolean ftdi_is_connected();
	synchronized public static native boolean ftdi_check_usb_camera();
	synchronized public static native int ftdi_getCurrentFPS();
	
	/*initialization*/
	synchronized public static boolean ftdi_init(){
		return !initError;
	};
	
	public SceneEyeFtdiJNI(){
		
	}
	
	
}

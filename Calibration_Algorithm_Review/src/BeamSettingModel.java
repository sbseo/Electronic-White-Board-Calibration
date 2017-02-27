import java.awt.EventQueue;

public class BeamSettingModel {

    //길이
    public static double X;
    public static double Y;
    public static double H;
    public static double h;
    public static double D;
    public static double d;

    // 비율
    public static double RATIO_FULLWIDTH;
    public static double RATIO_WIDTH;
    public static double RATIO_FULLHEIGHT;
    public static double RATIO_HEIGHT;
    public static BeamSettingView frame = null;
   
    //각도
    public static double P1ThetaL;
    public static double P2ThetaL;
    public static double P3ThetaL;
    public static double P4ThetaL;
    
    public static double P1ThetaR;
    public static double P2ThetaR;
    public static double P3ThetaR;
    public static double P4ThetaR;
    
    //장치 그리기
    public static boolean drawDevice = false;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BeamSettingView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    
}
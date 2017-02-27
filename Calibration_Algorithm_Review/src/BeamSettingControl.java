public class BeamSettingControl {


	public static void initEnvironment(BeamSettingView arg){
		//길이 
		BeamSettingModel.X = arg.getTxt_X();
		BeamSettingModel.Y = arg.getTxt_Y();
		BeamSettingModel.H = arg.getTxt_H();
		BeamSettingModel.D = arg.getTxt_D();
		BeamSettingModel.h = arg.getTxt_h();
		BeamSettingModel.d = arg.getTxt_d();

		// 비율
		BeamSettingModel.RATIO_FULLWIDTH = arg.getTxt_widthLeft() + arg.getTxt_widthCenter() + arg.getTxt_widthRight();
		BeamSettingModel.RATIO_WIDTH = arg.getTxt_widthLeft();
		BeamSettingModel.RATIO_FULLHEIGHT = arg.getTxt_heightLeft() + arg.getTxt_heightCenter() + arg.getTxt_heightRight();
		BeamSettingModel.RATIO_HEIGHT = arg.getTxt_heightLeft();

		// Theta 입력
		arg.setTxt_pl1(getP1ThetaL());
		arg.setTxt_pl2(getP2ThetaL());
		arg.setTxt_pl3(getP3ThetaL());
		arg.setTxt_pl4(getP4ThetaL());

		arg.setTxt_pr1(getP1ThetaR());
		arg.setTxt_pr2(getP2ThetaR());
		arg.setTxt_pr3(getP3ThetaR());
		arg.setTxt_pr4(getP4ThetaR());
	}

	public static void initConfirm(BeamSettingView arg){

		BeamSettingModel.drawDevice = true;

		//길이 
		BeamSettingModel.X = arg.getTxt_X();
		BeamSettingModel.Y = arg.getTxt_Y();
		BeamSettingModel.H = arg.getTxt_H();
		BeamSettingModel.D = arg.getTxt_D();
		BeamSettingModel.h = arg.getTxt_h();
		BeamSettingModel.d = arg.getTxt_d();

		// 비율
		BeamSettingModel.RATIO_FULLWIDTH = arg.getTxt_widthLeft() + arg.getTxt_widthCenter() + arg.getTxt_widthRight();
		BeamSettingModel.RATIO_WIDTH = arg.getTxt_widthLeft();
		BeamSettingModel.RATIO_FULLHEIGHT = arg.getTxt_heightLeft() + arg.getTxt_heightCenter() + arg.getTxt_heightRight();
		BeamSettingModel.RATIO_HEIGHT = arg.getTxt_heightLeft();

		// Theta 입력
		BeamSettingModel.P1ThetaL = arg.getTxt_pl1();
		BeamSettingModel.P2ThetaL = arg.getTxt_pl2();
		BeamSettingModel.P3ThetaL = arg.getTxt_pl3();
		BeamSettingModel.P4ThetaL = arg.getTxt_pl4();

		BeamSettingModel.P1ThetaR = arg.getTxt_pr1();
		BeamSettingModel.P2ThetaR = arg.getTxt_pr2();
		BeamSettingModel.P3ThetaR = arg.getTxt_pr3();
		BeamSettingModel.P4ThetaR = arg.getTxt_pr4();
	}


	public static double getP1ThetaL(){

		double phyX = (BeamSettingModel.X * BeamSettingModel.RATIO_WIDTH) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * BeamSettingModel.RATIO_HEIGHT) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX + (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//  System.out.println("P1L (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X + BeamSettingModel.d);

		return (theta * 180)/Math.PI;   
	}

	private static double getP1ThetaR()
	{
		double phyX = (BeamSettingModel.X * BeamSettingModel.RATIO_WIDTH) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * BeamSettingModel.RATIO_HEIGHT) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX - (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//    System.out.println("P1R (" + phyX.ToString() + ", " + phyY.ToString() + "), "+((theta * 180)/Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X - BeamSettingModel.d);

		return (theta * 180)/Math.PI;
	}
	private static double getP2ThetaL()
	{
		double phyX = (BeamSettingModel.X * BeamSettingModel.RATIO_WIDTH) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * (BeamSettingModel.RATIO_FULLHEIGHT - BeamSettingModel.RATIO_HEIGHT)) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX + (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//      System.out.println("P2L (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X + BeamSettingModel.d);

		return (theta * 180)/Math.PI;
	}
	private static double getP2ThetaR()
	{
		double phyX = (BeamSettingModel.X * BeamSettingModel.RATIO_WIDTH) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * (BeamSettingModel.RATIO_FULLHEIGHT - BeamSettingModel.RATIO_HEIGHT)) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX - (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//    System.out.println("P2R (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X - BeamSettingModel.d);

		return (theta * 180)/Math.PI;
	}
	private static double getP3ThetaL()
	{
		double phyX = (BeamSettingModel.X * (BeamSettingModel.RATIO_FULLWIDTH - BeamSettingModel.RATIO_WIDTH)) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * (BeamSettingModel.RATIO_FULLHEIGHT - BeamSettingModel.RATIO_HEIGHT)) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX + (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//    System.out.println("P3L (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X + BeamSettingModel.d);

		return (theta * 180)/Math.PI;
	}
	private static double getP3ThetaR()
	{
		double phyX = (BeamSettingModel.X * (BeamSettingModel.RATIO_FULLWIDTH - BeamSettingModel.RATIO_WIDTH)) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * (BeamSettingModel.RATIO_FULLHEIGHT - BeamSettingModel.RATIO_HEIGHT)) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX - (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//    System.out.println("P3R (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X - BeamSettingModel.d);

		return (theta * 180)/Math.PI;
	}
	private static double getP4ThetaL()
	{
		double phyX = (BeamSettingModel.X * (BeamSettingModel.RATIO_FULLWIDTH - BeamSettingModel.RATIO_WIDTH)) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * BeamSettingModel.RATIO_HEIGHT) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX + (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//     System.out.println("P4L (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X + BeamSettingModel.d);

		return (theta * 180)/Math.PI;
	}


	private static double getP4ThetaR()
	{
		double phyX = (BeamSettingModel.X * (BeamSettingModel.RATIO_FULLWIDTH - BeamSettingModel.RATIO_WIDTH)) / BeamSettingModel.RATIO_FULLWIDTH;
		double phyY = (BeamSettingModel.Y * BeamSettingModel.RATIO_HEIGHT) / BeamSettingModel.RATIO_FULLHEIGHT;
		phyX = phyX - (BeamSettingModel.X / 2);
		phyY = phyY + (BeamSettingModel.H);

		phyX = phyX - (BeamSettingModel.d / 2);

		double theta = Math.atan2(phyY, phyX);

		//          System.out.println("P4R (" + phyX.ToString() + ", " + phyY.ToString() + "), " + ((theta * 180) / Math.PI).ToString());

		theta = theta - Math.atan2(BeamSettingModel.h * 2, BeamSettingModel.X - BeamSettingModel.d);

		return (theta * 180) / Math.PI;
	}


}

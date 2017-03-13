import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DrawPanel extends JPanel implements MouseInputListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double sensorLx;
	private double sensorRx;
	private double x1;
	private double x2;
	private double y1;
	private double y2; //P1 ~ P4 좌표 표현
	BufferedImage whiteBoard;
	private int border = 1; 

	private int horiLengthLineX1;
	private int horiLengthLineY1;
	private int vertiLengthLineX1;
	private int vertiLengthLineY1;

	private int horiLengthLineX2;
	private int horiLengthLineY2;
	private int vertiLengthLineX2;
	private int vertiLengthLineY2;

	/* 화면크기 구하기용 좌표 표시용 */
	double y1Point; double y2Point; double y3Point; double y4Point;
	double x1Point;	double x2Point;	double x3Point;	double x4Point;

	public Graphics2D g2;

	public DrawPanel(){

		drawWhiteBoard();
	}

	public int rectWidth; // 사각형 넓
	public int rectHeight; // 사격형 높이 
	public int deviceLength; // 디바이스 거
	public int deviceHeight; // 디바이스 - 스크린 높
	public double ratio; // 비례식에서 실제사각형 출력시 비율 

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g;

		//whiteBoard = new BufferedImage(200, 100, BufferedImage.TYPE_4BYTE_ABGR);
		//whiteBoard.setRGB(5, 20, Color.BLUE.getRGB());
		//g2.drawImage(whiteBoard, null, 0, 0);
		//System.out.print("테스트");
		//g2.draw(new Line2D.Double(0, 0, 30, 40));

		/* 비례식 만들기 */
		// Java창 : 사각형 = 1 : 비율
		// rectWidth = (int)500 + 2 * border;
		// rectHeight = (int)300 + 2 * border;
		// ratio = 1;

		rectWidth = (int)BeamSettingModel.X * border / 3; //Java창 크기에 맞게 바꿔줌.
		rectHeight = (int)BeamSettingModel.Y * border / 3; //Java창 크기에 맞춰줌.
		deviceLength = (int)BeamSettingModel.d /3; // Java창 크기에 맞게 바꿔줌.
		deviceHeight = (int)BeamSettingModel.H/3 ; //Java창 크기에 맞게 바꿔줌.
		/* Device */
		int DeviceSize = 10;

		/*사각형 시작위치 좌표 */
		int rectStartPosX = 50;
		int rectStartPosY = (DeviceSize / 2) + deviceHeight; // 초기값100에서 바꿈.

		/* WhiteBoard */ 
		g2.drawRect(rectStartPosX, rectStartPosY, rectWidth, rectHeight); // 값 바꿔야함

		/* WhiteBoard 가로길이, 실선으로 표현. y좌표에 +35정도 하면 보기좋음*/
		horiLengthLineX1 = rectStartPosX;				horiLengthLineY1 = rectStartPosY + rectHeight + 35;
		horiLengthLineX2 = rectStartPosX + rectWidth;	horiLengthLineY2 = rectStartPosY + rectHeight + 35;

		Point sw = new Point(horiLengthLineX1, horiLengthLineY1);
		Point ne = new Point(horiLengthLineX2, horiLengthLineY2);

		drawDashedLine(g2, horiLengthLineX1, horiLengthLineY1, horiLengthLineX2, horiLengthLineY2);

		drawArrowHead(g2, sw, ne, Color.black);
		drawArrowHead(g2, ne, sw, Color.black);

		/* WhiteBoard 세로 길이, 실선으로 표현. x좌표에 +35정도 하면 보기좋음.  */
		vertiLengthLineX1 = rectStartPosX + rectWidth + 35; vertiLengthLineY1 = rectStartPosY;
		vertiLengthLineX2 = rectStartPosX + rectWidth + 35; vertiLengthLineY2 = rectStartPosY + rectHeight; // 이게 왜 40

		Point start = new Point(vertiLengthLineX1, vertiLengthLineY1);
		Point end = new Point(vertiLengthLineX2, vertiLengthLineY2);

		drawDashedLine(g2, vertiLengthLineX1, vertiLengthLineY1, vertiLengthLineX2, vertiLengthLineY2);

		drawArrowHead(g2, start, end, Color.black);
		drawArrowHead(g2, end, start, Color.black);

		/* Draw String */
		g2.drawString(Double.toString(BeamSettingModel.X), (horiLengthLineX1 + horiLengthLineX2) / 2 - 15, (horiLengthLineY1 + horiLengthLineY2) / 2 - 5);
		g2.drawString(Double.toString(BeamSettingModel.Y), (vertiLengthLineX1 + vertiLengthLineX2) / 2 + 5, (vertiLengthLineY1 + vertiLengthLineY2) / 2 - 5);

		/* 장치 그리기 */
		if(BeamSettingModel.drawDevice == true){

			// 숫자가 지금 안맞음
			sensorLx = ((rectWidth - deviceLength) / 2) + border + rectStartPosX;
			sensorRx = ((rectWidth + deviceLength) / 2) + border + rectStartPosX;      

			g2.drawOval((int) (sensorLx - (DeviceSize / 2)), (DeviceSize / 2), DeviceSize, DeviceSize);
			g2.setColor(Color.red);
			g2.fillOval((int) (sensorLx - (DeviceSize / 2)), (DeviceSize / 2), DeviceSize, DeviceSize);

			g2.drawOval((int) (sensorRx - (DeviceSize / 2)), (DeviceSize / 2), DeviceSize, DeviceSize);
			g2.setColor(Color.red);
			g2.fillOval((int) (sensorRx - (DeviceSize / 2)), (DeviceSize / 2), DeviceSize, DeviceSize);	

			int deviceLengthLineX1 = (int) (sensorLx - (DeviceSize / 2)); int deviceLengthLineY1 = (DeviceSize / 2) + 25;
			int deviceLengthLineX2 = (int) (sensorRx - (DeviceSize / 2)) + DeviceSize; int deviceLengthLineY2 = (DeviceSize / 2) + 25;

			start = new Point(deviceLengthLineX1, deviceLengthLineY1);
			end = new Point(deviceLengthLineX2, deviceLengthLineY2);

			g2.setColor(Color.black);
			drawDashedLine(g2, deviceLengthLineX1, deviceLengthLineY1, deviceLengthLineX2, deviceLengthLineY2);

			drawArrowHead(g2, start, end, Color.black);
			drawArrowHead(g2, end, start, Color.black);

			/* Draw String */
			g2.drawString(Double.toString(BeamSettingModel.d), (deviceLengthLineX1 + deviceLengthLineX2) / 2 - 15, (deviceLengthLineY1 + deviceLengthLineY2) / 2 - 5);


			/* 장치와 화면간의 거리 구하기 */
			int heightLengthLineX1 = rectStartPosX + rectWidth + 35; int heightLengthLineY1 = (DeviceSize / 2);
			int heightLengthLineX2 = rectStartPosX + rectWidth + 35; int heightLengthLineY2 = (DeviceSize / 2) + deviceHeight;

			drawDashedLine(g2, heightLengthLineX1, heightLengthLineY1, heightLengthLineX2, heightLengthLineY2);

			start = new Point(heightLengthLineX1, heightLengthLineY1);
			end = new Point(heightLengthLineX2, heightLengthLineY2);

			drawArrowHead(g2, start, end, Color.black);
			drawArrowHead(g2, end, start, Color.black);	

			/* Draw String */
			g2.drawString(Double.toString(BeamSettingModel.H), (heightLengthLineX1 + heightLengthLineX2) / 2 + 5, (heightLengthLineY1 + heightLengthLineY2) / 2 + 5);

			/* 좌표 점 찍기 */
			int ratio = 1;
			Point2D p1 = new Point2D.Double();
			Point2D p2 = new Point2D.Double();
			Point2D p3 = new Point2D.Double();
			Point2D p4 = new Point2D.Double();
		
			// 각 점의 Y좌표 어디에 찍어야할지 구함.
			calY(1, BeamSettingModel.P1ThetaL, BeamSettingModel.P1ThetaR);
			calY(2, BeamSettingModel.P2ThetaL, BeamSettingModel.P2ThetaR);
			calY(3, BeamSettingModel.P3ThetaL, BeamSettingModel.P3ThetaR);
			calY(4, BeamSettingModel.P4ThetaL, BeamSettingModel.P4ThetaR);

			// 각 점의 X좌표 어디에 찍어야 할지 구함 
			calX(1, BeamSettingModel.P1ThetaL, BeamSettingModel.P1ThetaR);
			calX(2, BeamSettingModel.P2ThetaL, BeamSettingModel.P2ThetaR);
			calX(3, BeamSettingModel.P3ThetaL, BeamSettingModel.P3ThetaR);
			calX(4, BeamSettingModel.P4ThetaL, BeamSettingModel.P4ThetaR);
			
			p1.setLocation(x1Point, y1Point);
			p2.setLocation(x2Point, y2Point);
			p3.setLocation(x3Point, y3Point);
			p4.setLocation(x4Point, y4Point);

			g2.drawOval((int)p1.getX(), (int)p1.getY(), 5, 5);
			//g2.drawOval((int)p2.getX(), (int)p2.getY(), 5, 5);
			//g2.drawOval((int)p3.getX(), (int)p3.getY(), 5, 5);
			//g2.drawOval((int)p4.getX(), (int)p4.getY(), 5, 5);
		}

	}

	/* Device의 거리를 통해 좌표(p1,p2,p3,p4)의 X좌표를 구하는 함수 */ 
	public void calX(int pointNum, double thetaL, double thetaR){ 

		double sensorDistance = Math.abs(sensorRx - sensorLx) / 2;
		double half = sensorDistance / 2;
		
		switch(pointNum){
		case(1):
			// Device 중앙에서 왼쪽으로
			x1Point = half * (Math.tan(thetaR) + Math.tan(thetaL)) / (Math.tan(thetaL) - Math.tan(thetaR));
		break;
		case(2):
			// Device 중앙에서 왼쪽으로
			x2Point = half * (Math.tan(thetaR) + Math.tan(thetaL)) / (Math.tan(thetaL) - Math.tan(thetaR));
		break;
		case(3):
			// Device 중앙에서 오른쪽으로 
			x3Point = half * (Math.tan(thetaR) + Math.tan(thetaL)) / (Math.tan(thetaR) - Math.tan(thetaL));
		break;
		case(4):
			// Device 중앙에서 오른쪽으로 
			x4Point = half * (Math.tan(thetaR) + Math.tan(thetaL)) / (Math.tan(thetaR) - Math.tan(thetaL));
		break;
		}

	}

	/* thetaL과 thetaR을 통해 좌표(p1,p2,p3,p4)의 Y좌표를 구하는 함수 */ 
	public void calY(int pointNum, double thetaL, double thetaR){ 

		double sensorDistance = Math.abs(sensorRx - sensorLx) / 2;
		double half = sensorDistance / 2;
		
		switch(pointNum){
		case(1):
			y1Point = (2 * half * Math.tan(thetaR) * Math.tan(thetaL)) / (Math.tan(thetaL) - Math.tan(thetaR));
		break;
		case(2):
			y2Point = (2 * half * Math.tan(thetaR) * Math.tan(thetaL)) / (Math.tan(thetaL) - Math.tan(thetaR));
		break;
		case(3):
			y3Point = (2 * half * Math.tan(thetaR) * Math.tan(thetaL)) / (Math.tan(thetaR) - Math.tan(thetaL));
		break;
		case(4):
			y4Point = (2 * half * Math.tan(thetaR) * Math.tan(thetaL)) / (Math.tan(thetaR) - Math.tan(thetaL));
		break;
		}
	}

	public void drawDevice(){
		super.paintComponent(g2);
		g2 = (Graphics2D)g2;		
	}


	public void drawWhiteBoard(){

		Graphics2D g2 = null;
		whiteBoard = new BufferedImage(400, 300, BufferedImage.TYPE_4BYTE_ABGR);
		whiteBoard.setRGB(5, 20, Color.BLUE.getRGB());
		//g2.draw((Shape) whiteBoard);

		// canvas = new Bitmap((int)DevEnvironment.X + 2 * border, (int)(DevEnvironment.Y + DevEnvironment.H + 2 * border));
	}

	public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2){

		//creates a copy of the Graphics instance
		Graphics2D g2d = (Graphics2D) g.create();

		//set the stroke of the copy, not the original 
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, 0);
		g2d.setStroke(dashed);
		g2d.drawLine(x1, y1, x2, y2);

		//gets rid of the copy
		g2d.dispose();
	}


	double phi = Math.toRadians(40);
	int barb = 10;

	private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color)
	{
		g2.setPaint(color);
		double dy = tip.y - tail.y;
		double dx = tip.x - tail.x;
		double theta = Math.atan2(dy, dx);
		//System.out.println("theta = " + Math.toDegrees(theta));
		double x, y, rho = theta + phi;
		for(int j = 0; j < 2; j++)
		{
			x = tip.x - barb * Math.cos(rho);
			y = tip.y - barb * Math.sin(rho);
			g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
			rho = theta - phi;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}

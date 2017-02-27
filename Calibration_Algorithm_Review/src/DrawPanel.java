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

	public Graphics2D g2;

	public DrawPanel(){

		drawWhiteBoard();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g;

		//whiteBoard = new BufferedImage(200, 100, BufferedImage.TYPE_4BYTE_ABGR);
		//whiteBoard.setRGB(5, 20, Color.BLUE.getRGB());
		//g2.drawImage(whiteBoard, null, 0, 0);
		//System.out.print("테스트");
		//g2.draw(new Line2D.Double(0, 0, 30, 40));

		/* WhiteBoard */ 
		g2.drawRect(50, 100, (int)500 + 2 * border, (int)300 + 2 * border); // 값 바꿔야함

		/* WhiteBoard 가로길이, 실선으로 표현. y좌표에 +30정도 하면 보기좋음*/
		horiLengthLineX1 = 50;	horiLengthLineY1 = 435;
		horiLengthLineX2 = 552;	horiLengthLineY2 = 435;

		Point sw = new Point(horiLengthLineX1, horiLengthLineY1);
		Point ne = new Point(horiLengthLineX2, horiLengthLineY2);

		drawDashedLine(g2, horiLengthLineX1, horiLengthLineY1, horiLengthLineX2, horiLengthLineY2);

		drawArrowHead(g2, sw, ne, Color.black);
		drawArrowHead(g2, ne, sw, Color.black);

		/* WhiteBoard 세로 길이, 실선으로 표현. x좌표에 +30정도 하면 보기좋음.  */
		vertiLengthLineX1 = 582; vertiLengthLineY1 = 100;
		vertiLengthLineX2 = 582; vertiLengthLineY2 = 402;

		Point start = new Point(vertiLengthLineX1, vertiLengthLineY1);
		Point end = new Point(vertiLengthLineX2, vertiLengthLineY2);

		drawDashedLine(g2, vertiLengthLineX1, vertiLengthLineY1, vertiLengthLineX2, vertiLengthLineY2);

		drawArrowHead(g2, start, end, Color.black);
		drawArrowHead(g2, end, start, Color.black);

		/* Draw String */
		g2.drawString(Double.toString(BeamSettingModel.X), (horiLengthLineX1 + horiLengthLineX2) / 2, (horiLengthLineY1 + horiLengthLineY2) / 2 - 5);
		g2.drawString(Double.toString(BeamSettingModel.Y), (vertiLengthLineX1 + vertiLengthLineX2) / 2 + 5, (vertiLengthLineY1 + vertiLengthLineY2) / 2);

		/* 장치 그리기 */
		if(BeamSettingModel.drawDevice == true){
			/* Device */
			int DeviceSize = 10;
			// 숫자가 지금 안맞음
			// sensorLx = ((BeamSettingModel.X - BeamSettingModel.d) / 2) + border;
			// sensorRx = ((BeamSettingModel.X + BeamSettingModel.d) / 2) + border;      
			sensorLx = 200;
			sensorRx = 400;

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
			g2.drawString(Double.toString(BeamSettingModel.d), (deviceLengthLineX1 + deviceLengthLineX2) / 2, (deviceLengthLineY1 + deviceLengthLineY2) / 2 - 5);


			/* 장치와 화면간의 거리 구하기 */
			int heightLengthLineX1 = 582; int heightLengthLineY1 = (DeviceSize / 2) + 25;
			int heightLengthLineX2 = 582; int heightLengthLineY2 = 100;

			drawDashedLine(g2, heightLengthLineX1, heightLengthLineY1, heightLengthLineX2, heightLengthLineY2);

			start = new Point(heightLengthLineX1, heightLengthLineY1);
			end = new Point(heightLengthLineX2, heightLengthLineY2);

			drawArrowHead(g2, start, end, Color.black);
			drawArrowHead(g2, end, start, Color.black);	

			/* Draw String */
			g2.drawString(Double.toString(BeamSettingModel.H), (heightLengthLineX1 + heightLengthLineX2) / 2 + 25, (heightLengthLineY1 + heightLengthLineY2) / 2 );
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
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BeamSettingView extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lbl_X;
	private JTextField txt_X;
	private JLabel lbl_Y;
	private JTextField txt_Y;
	private JLabel lbl_H;
	private JTextField txt_H;
	private JLabel lbl_D;
	private JTextField txt_D;
	private JLabel lbl_h;
	private JTextField txt_h;
	private JLabel lbl_d;
	private JTextField txt_d;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextField txt_pl1;
	private JTextField txt_pr1;
	private JLabel lblNewLabel_15;
	private JTextField txt_pl2;
	private JTextField txt_pr2;
	private JLabel lblNewLabel_16;
	private JTextField txt_pl3;
	private JTextField txt_pr3;
	private JLabel lblNewLabel_17;
	private JTextField txt_pl4;
	private JTextField txt_pr4;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_22;
	private JTextField txt_widthLeft;
	private JTextField txt_widthCenter;
	private JTextField txt_widthRight;
	private JLabel lblNewLabel_23;
	private JTextField txt_heightLeft;
	private JTextField txt_heightCenter;
	private JTextField txt_heightRight;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private BeamSettingView thisClass = this; 

	/**
	 * Create the frame.
	 */
	public BeamSettingView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 450);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(7, 2, 0, 0));

		lblNewLabel = new JLabel("# Defined Value");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		lblNewLabel_7 = new JLabel(" ");
		panel.add(lblNewLabel_7);

		lbl_X = new JLabel("X", SwingConstants.CENTER);
		panel.add(lbl_X);

		txt_X = new JTextField();
		panel.add(txt_X);
		txt_X.setColumns(10);

		lbl_Y = new JLabel("Y");
		lbl_Y.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_Y);

		txt_Y = new JTextField();
		panel.add(txt_Y);
		txt_Y.setColumns(10);

		lbl_H = new JLabel("H");
		lbl_H.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_H);

		txt_H = new JTextField();
		panel.add(txt_H);
		txt_H.setColumns(10);

		lbl_D = new JLabel("D");
		lbl_D.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_D);

		txt_D = new JTextField();
		panel.add(txt_D);
		txt_D.setColumns(10);

		lbl_h = new JLabel("h");
		lbl_h.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_h);

		txt_h = new JTextField();
		panel.add(txt_h);
		txt_h.setColumns(10);

		lbl_d = new JLabel("d");
		lbl_d.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_d);

		txt_d = new JTextField();
		panel.add(txt_d);
		txt_d.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 3, 0, 0));

		lblNewLabel_8 = new JLabel("# Angle");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel(" ");
		panel_1.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel(" ");
		panel_1.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("thetaL");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel("thetaR");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_13);

		lblNewLabel_14 = new JLabel("P1");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_14);

		txt_pl1 = new JTextField();
		panel_1.add(txt_pl1);
		txt_pl1.setColumns(10);

		txt_pr1 = new JTextField();
		panel_1.add(txt_pr1);
		txt_pr1.setColumns(10);

		lblNewLabel_15 = new JLabel("P2");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_15);

		txt_pl2 = new JTextField();
		panel_1.add(txt_pl2);
		txt_pl2.setColumns(10);

		txt_pr2 = new JTextField();
		panel_1.add(txt_pr2);
		txt_pr2.setColumns(10);

		lblNewLabel_16 = new JLabel("P3");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_16);

		txt_pl3 = new JTextField();
		panel_1.add(txt_pl3);
		txt_pl3.setColumns(10);

		txt_pr3 = new JTextField();
		panel_1.add(txt_pr3);
		txt_pr3.setColumns(10);

		lblNewLabel_17 = new JLabel("P4");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_17);

		txt_pl4 = new JTextField();
		panel_1.add(txt_pl4);
		txt_pl4.setColumns(10);

		txt_pr4 = new JTextField();
		panel_1.add(txt_pr4);
		txt_pr4.setColumns(10);

		panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 4, 0, 0));

		lblNewLabel_18 = new JLabel("# Ratio ");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_18);

		lblNewLabel_19 = new JLabel("left");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_19);

		lblNewLabel_20 = new JLabel("center");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_20);

		lblNewLabel_21 = new JLabel("right");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_21);

		lblNewLabel_22 = new JLabel("Width");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_22);

		txt_widthLeft = new JTextField();
		panel_3.add(txt_widthLeft);
		txt_widthLeft.setColumns(10);

		txt_widthCenter = new JTextField();
		panel_3.add(txt_widthCenter);
		txt_widthCenter.setColumns(10);

		txt_widthRight = new JTextField();
		panel_3.add(txt_widthRight);
		txt_widthRight.setColumns(10);

		lblNewLabel_23 = new JLabel("Height");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_23);

		txt_heightLeft = new JTextField();
		panel_3.add(txt_heightLeft);
		txt_heightLeft.setColumns(10);

		txt_heightCenter = new JTextField();
		panel_3.add(txt_heightCenter);
		txt_heightCenter.setColumns(10);

		txt_heightRight = new JTextField();
		panel_3.add(txt_heightRight);
		txt_heightRight.setColumns(10);

		panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 2, 0, 0));

		btnNewButton = new JButton("Auto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				insertAutoValue();
				BeamSettingControl.initEnvironment(thisClass);

			}
		});
		panel_4.add(btnNewButton);

		btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BeamSettingControl.initConfirm(thisClass);
				BoardView.drawPanel.repaint();

			}
		});
		panel_4.add(btnNewButton_1);

	}

	public void insertAutoValue(){
		txt_X.setText("1428");
		txt_Y.setText("804");
		txt_H.setText("100");
		txt_D.setText("714");
		txt_h.setText("65");
		txt_d.setText("320");

		txt_widthLeft.setText("1");
		txt_widthCenter.setText("18");
		txt_widthRight.setText("1");

		txt_heightLeft.setText("1");
		txt_heightCenter.setText("8");
		txt_heightRight.setText("1");
	}

	public double getTxt_pl1() {
		return Double.parseDouble(txt_pl1.getText());
	}

	public void setTxt_pl1(Double args) {
		txt_pl1.setText(Double.toString(args));
	}

	public double getTxt_pr1() {
		return Double.parseDouble(txt_pr1.getText());
	}

	public void setTxt_pr1(Double args)  {
		txt_pr1.setText(Double.toString(args));
	}

	public double getTxt_pl2() {
		return Double.parseDouble(txt_pl2.getText());
	}

	public void setTxt_pl2(Double args) {
		txt_pl2.setText(Double.toString(args));
	}

	public double getTxt_pr2() {
		return Double.parseDouble(txt_pr2.getText());
	}

	public void setTxt_pr2(Double args)  {
		txt_pr2.setText(Double.toString(args));
	}

	public double getTxt_pl3() {
		return Double.parseDouble(txt_pl3.getText());
	}

	public void setTxt_pl3(Double args) {
		txt_pl3.setText(Double.toString(args));
	}

	public double getTxt_pr3() {
		return Double.parseDouble(txt_pr3.getText());
	}

	public void setTxt_pr3(Double args) {
		txt_pr3.setText(Double.toString(args));
	}

	public double getTxt_pl4() {
		return Double.parseDouble(txt_pl4.getText());
	}

	public void setTxt_pl4(Double args) {
		txt_pl4.setText(Double.toString(args));
	}

	public double getTxt_pr4() {
		return Double.parseDouble(txt_pr4.getText());
	}

	public void setTxt_pr4(Double args) {
		txt_pr4.setText(Double.toString(args));
	}

	public double getTxt_X() {
		return Double.parseDouble(txt_X.getText());
	}

	public void setTxt_X(JTextField txt_X) {
		this.txt_X = txt_X;
	}

	public double getTxt_Y() {
		return Double.parseDouble(txt_Y.getText());
	}

	public void setTxt_Y(JTextField txt_Y) {
		this.txt_Y = txt_Y;
	}

	public double getTxt_H() {
		return Double.parseDouble(txt_H.getText());
	}

	public void setTxt_H(JTextField txt_H) {
		this.txt_H = txt_H;
	}

	public double getTxt_D() {
		return Double.parseDouble(txt_D.getText());
	}

	public void setTxt_D(JTextField txt_D) {
		this.txt_D = txt_D;
	}

	public double getTxt_h() {
		return Double.parseDouble(txt_h.getText());
	}

	public void setTxt_h(JTextField txt_h) {
		this.txt_h = txt_h;
	}

	public double getTxt_d() {
		return Double.parseDouble(txt_d.getText());
	}

	public void setTxt_d(JTextField txt_d) {
		this.txt_d = txt_d;
	}

	public double getTxt_widthLeft() {
		return Double.parseDouble(txt_widthLeft.getText());
	}

	public void setTxt_widthLeft(JTextField txt_widthLeft) {
		this.txt_widthLeft = txt_widthLeft;
	}

	public double getTxt_widthCenter() {
		return Double.parseDouble(txt_widthCenter.getText());
	}

	public void setTxt_widthCenter(JTextField txt_widthCenter) {
		this.txt_widthCenter = txt_widthCenter;
	}

	public double getTxt_widthRight() {
		return Double.parseDouble(txt_widthRight.getText());
	}

	public void setTxt_widthRight(JTextField txt_widthRight) {
		this.txt_widthRight = txt_widthRight;
	}

	public double getTxt_heightLeft() {
		return Double.parseDouble(txt_heightLeft.getText());
	}

	public void setTxt_heightLeft(JTextField txt_heightLeft) {
		this.txt_heightLeft = txt_heightLeft;
	}

	public double getTxt_heightCenter() {
		return Double.parseDouble(txt_heightCenter.getText());
	}

	public void setTxt_heightCenter(JTextField txt_heightCenter) {
		this.txt_heightCenter = txt_heightCenter;
	}

	public double getTxt_heightRight() {
		return Double.parseDouble(txt_heightRight.getText());
	}

	public void setTxt_heightRight(JTextField txt_heightRight) {
		this.txt_heightRight = txt_heightRight;
	}


}
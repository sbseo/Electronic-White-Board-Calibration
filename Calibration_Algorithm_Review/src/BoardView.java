import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class BoardView extends JFrame {
	private JPanel contentPane;
	static DrawPanel drawPanel = null;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public BoardView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 530);
	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnFunction = new JMenu("Function");
		menuBar.add(mnFunction);
		
		JMenuItem mntmCalculateXyz = new JMenuItem("Calculate Beam Screen Size");
		mntmCalculateXyz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BeamSettingView beamFrame = new BeamSettingView();
				beamFrame.setVisible(true);
						
				drawPanel.repaint();
				
			}
		});
		mnFunction.add(mntmCalculateXyz);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Calculate Device Length ");
		mnFunction.add(mntmNewMenuItem);
		
		JMenuItem mntmCalculateResolution = new JMenuItem("Calculate Resolution");
		mnFunction.add(mntmCalculateResolution);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));	
		setContentPane(contentPane);
		// DrawPanel을 Content Pane에 넣음
		drawPanel = new DrawPanel();
		contentPane.add(drawPanel, BorderLayout.CENTER);

        
	}



}

package team;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class user_frame extends JFrame {
	private CardLayout cl;
	private JPanel contentPane;
	private user_panel panel;

	/**1
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					user_frame frame = new user_frame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("@@스터디카페");
		setBounds(0, 0, 600, 600);

		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(600, 600));

		setContentPane(contentPane);

		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.CENTER, 5, 5);
		contentPane.setLayout(fl_contentPane);

		JPanel cl_p = new JPanel();
		cl_p.setPreferredSize(new Dimension(600, 600));
		contentPane.add(cl_p);
		cl = new CardLayout();
		cl_p.setLayout(cl);

		panel = new user_panel();
		cl_p.add("second", panel);
	}
}

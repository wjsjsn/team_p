package team;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user_idf extends JPanel {

	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JTextField phone_tf;
	private JButton idf_bt;
	private JButton back_bt;

	/**
	 * Create the panel.
	 */
	public user_idf(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("login");
				phone_tf.setText("");
			}
		});

		// 아이디 찾기 버튼
		idf_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = "[0-9]+";
				String phone = phone_tf.getText();
				if (phone.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "핸드폰 번호 전부 입력해주세요.");
				} else {
					JOptionPane.showMessageDialog(getParent(), "@@@님의 아이디는 @@@입니다.");
					parent.showCard("login");
					phone_tf.setText("");
				}
			}
		});
	}

	public user_idf() {
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(600, 600));

		JLabel lblNewLabel = new JLabel("아이디 찾기");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);

		jp1 = new JPanel();
		add(jp1, BorderLayout.CENTER);
		jp1.setLayout(new BorderLayout(0, 0));

		jp2 = new JPanel();
		jp2.setBorder(new EmptyBorder(150, 70, 85, 70));
		jp1.add(jp2);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jp3 = new JPanel();
		FlowLayout fl_jp3 = (FlowLayout) jp3.getLayout();
		fl_jp3.setAlignment(FlowLayout.RIGHT);
		jp2.add(jp3);

		JLabel label = new JLabel("핸드폰 번호 :");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		jp3.add(label);

		jp4 = new JPanel();
		FlowLayout fl_jp4 = (FlowLayout) jp4.getLayout();
		fl_jp4.setAlignment(FlowLayout.LEFT);
		jp2.add(jp4);

		phone_tf = new JTextField();
		phone_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		jp4.add(phone_tf);
		phone_tf.setColumns(10);

		jp5 = new JPanel();
		jp5.setBorder(new EmptyBorder(5, 0, 150, 0));
		jp1.add(jp5, BorderLayout.SOUTH);

		idf_bt = new JButton("아이디 찾기");
		idf_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(idf_bt);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(back_bt);
	}
}

package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import mybatis.DAO_point;
import mybatis.VO_point;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class user_point extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JList list;
	private JComboBox<String> p_box;
	private JScrollPane jsp;
	private JButton back_bt;
	private JLabel lblNewLabel;
	private List<VO_point> p_list;
	private String[] p_com = { "선택해주세요", "포인트 사용내역", "포인트 환불내역", "포인트 충전내역" };
	private JPanel panel_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton charge_bt;
	private JButton refund_bt;

	/**
	 * Create the panel.
	 */

	public user_point(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
			}
		});

		// 포인트 환불 버튼
		refund_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("p_refund");
				((point_refund) parent.getP("p_refund")).refund_tf();
			}
		});

		// 포인트 충전 버튼
		charge_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("charge");
			}
		});

		p_box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> box = (JComboBox<String>) e.getSource();
				int index = box.getSelectedIndex();
				// 사용
				if (index == 1) {
					// 환불
				} else if (index == 2) {

					// 충전
				} else if (index == 3) {
					((user_point) parent.getP("point")).initp_charge_List();
				}
			}
		});

	}

	public user_point() {
		setPreferredSize(new Dimension(600, 600));

		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();
		add(jp1, BorderLayout.NORTH);
		jp1.setLayout(new GridLayout(3, 1, 0, 0));

		jp2 = new JPanel();
		jp1.add(jp2);
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setHorizontalAlignment(SwingConstants.LEFT);
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp2.add(back_bt);

		jp5 = new JPanel();
		jp1.add(jp5);

		lblNewLabel = new JLabel("포인트");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jp5.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(35, 0, 0, 0));
		jp1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		textField_3 = new JTextField();
		textField_3.setText("포인트 번호");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.white);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("포인트");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField_4.setBackground(Color.white);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("날짜");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField_5.setBackground(Color.white);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_2.add(textField_5);

		jp3 = new JPanel();
		jp3.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(jp3, BorderLayout.CENTER);
		jp3.setLayout(new BorderLayout(0, 0));

		jsp = new JScrollPane();
		jp3.add(jsp);

		list = new JList();
		list.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		jsp.setViewportView(list);

		p_box = new JComboBox<String>(p_com);
		p_box.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		// p_box.setModel(new DefaultComboBoxModel(new String[] {"선택해주세요", "포인트 사용내역",
		// "포인트 환불내역", "포인트 충전내역" }));
		p_box.setSelectedIndex(0);
		jsp.setColumnHeaderView(p_box);

		jp4 = new JPanel();
		add(jp4, BorderLayout.NORTH);
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		charge_bt = new JButton("  포인트 충전  ");
		charge_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp4.add(charge_bt);
		
		refund_bt = new JButton("  포인트 환불  ");
		refund_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp4.add(refund_bt);

	}

	public void setplist(String[] arr) {
		list.setListData(arr);
	}

	public void initp_charge_List() {
		p_list = DAO_point.p_All("충전");
		if (p_list.size() > 0) {
			String[] p_Arr = new String[p_list.size()];
			int i = 0;
			for (VO_point k : p_list) {
				if (k.getUser_id().equals(parent.getC_Vo().getUser_id())) {
					p_Arr[i++] = "            " +k.getPoint_num() + "               " + k.getPoint() + "                     " + k.getCharge_date().toString();
				}
			}
			list.setListData(p_Arr);
		} else {
			list.setListData(new String[] {});
		}
	}

}
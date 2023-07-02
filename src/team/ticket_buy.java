package team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import mybatis.DAO_point;
import mybatis.DAO_ticketbuy;
import mybatis.VO_point;
import mybatis.VO_ticketbuy;

public class ticket_buy extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp1_1, jp1_2, jp2, jp2_1, jp2_2, jp3;
	private JButton back_bt, buy;
	private JRadioButton ten, twenty, thirty, one, two, three, four, five;
	private ButtonGroup bg;
	private Timestamp time;

	public ticket_buy(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
				bg.clearSelection();
			}
		});

		// 확인 버튼
		buy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				time = new Timestamp(System.currentTimeMillis());
				int res = JOptionPane.showConfirmDialog(getParent(),
						"기간권을 선택하신 것이 맞으십니까?\n*기간권 사용 동안 일일 최대 사용 시간은 12시간입니다.*", "이용권 구매",
						JOptionPane.OK_CANCEL_OPTION);
				if (res == 0) {
					if (ten.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-8000");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							
							VO_ticketbuy vo_t = new VO_ticketbuy();
							vo_t.setBuy_date(time);
							vo_t.setPrice(vo.getPoint());
							vo_t.setTicket_id(ten.getText());
							vo_t.setUser_id(parent.getC_Vo().getUser_id());
							DAO_ticketbuy.getTInsert(vo_t);
							
							parent.showCard("com");
							((ticket_com)parent.getP("com")).ticketCom();
						} else if (twenty.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-9000");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						} else if (thirty.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-10000");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						} else if (one.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-100");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						} else if (two.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-200");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						} else if (three.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-300");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						} else if (four.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-400");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						} else if (five.isSelected()) {
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("사용");
							vo.setPoint("-500");
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							parent.showCard("com");
						}
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public ticket_buy() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();

		jp1.setLayout(new GridLayout(2, 1));

		jp1_1 = new JPanel();
		FlowLayout fl_jp1_1 = (FlowLayout) jp1_1.getLayout();
		fl_jp1_1.setAlignment(FlowLayout.LEFT);
		jp1.add(jp1_1);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp1_1.add(back_bt);

		jp1_2 = new JPanel();
		jp1.add(jp1_2);

		JLabel buy_lb = new JLabel("이용권 구매");
		buy_lb.setHorizontalAlignment(SwingConstants.CENTER);
		buy_lb.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jp1_2.add(buy_lb);

		jp2 = new JPanel();

		jp2_1 = new JPanel();
		jp2_1.setBorder(BorderFactory.createTitledBorder("기간권"));
		jp2.add(jp2_1);
		jp2_1.setLayout(new GridLayout(5, 1));

		ten = new JRadioButton("10일권(8000캐쉬)  ");
		ten.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ten.setHorizontalAlignment(SwingConstants.CENTER);
		jp2_1.add(ten);

		twenty = new JRadioButton("20일권(9000캐쉬)  ");
		twenty.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jp2_1.add(twenty);

		thirty = new JRadioButton("30일권(10000캐쉬)");
		thirty.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jp2_1.add(thirty);

		jp2_2 = new JPanel();
		jp2.add(jp2_2);
		jp2_2.setBorder(BorderFactory.createTitledBorder("일회권"));
		jp2_2.setLayout(new GridLayout(5, 1));

		one = new JRadioButton("1시간(100캐쉬)       ");
		one.setHorizontalAlignment(SwingConstants.CENTER);
		one.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jp2_2.add(one);

		two = new JRadioButton("2시간(200캐쉬)       ");
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jp2_2.add(two);

		three = new JRadioButton("3시간(300캐쉬)          ");
		three.setHorizontalAlignment(SwingConstants.CENTER);
		jp2_2.add(three);

		four = new JRadioButton("4시간(400캐쉬)       ");
		four.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jp2_2.add(four);

		five = new JRadioButton("5시간(500캐쉬)       ");
		five.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jp2_2.add(five);

		jp3 = new JPanel();

		buy = new JButton("   확인   ");
		buy.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp3.add(buy);

		bg = new ButtonGroup();
		bg.add(ten);
		bg.add(twenty);
		bg.add(thirty);
		bg.add(one);
		bg.add(two);
		bg.add(three);
		bg.add(four);
		bg.add(five);

		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
	}

	public void t_buy() {
		time = new Timestamp(System.currentTimeMillis());
		VO_ticketbuy vo_t = new VO_ticketbuy();
		VO_point vo_p = new VO_point();
		vo_t.setBuy_date(time);
		vo_t.setPrice(vo_p.getPoint());
	}
}
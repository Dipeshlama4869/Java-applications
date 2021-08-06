package start;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Calculator {
	
	JTextArea cal;
	JTextArea res;
	
	Calculator() {	
		this.cal = new JTextArea();
		this.res = new JTextArea();	
		res.setText("0.0");
		
		cal.setFont(new Font("Calculator", Font.BOLD, 80));
		res.setFont(new Font("Calculator", Font.BOLD, 80));
		cal.setBounds(10,10, 360,100);
		cal.setEditable(false);
		res.setBounds(10,110, 360,100);  
		res.setEditable(false);
	}
	
	private String calcA(String str) {
		str = str.replace("+", " ");
		double val = 0;
		String[] arr = str.split(" ");
		for (String st : arr) {
			if (!st.equals("+")) {
				val = val + Double.parseDouble(st);
			}
		}
		return String.valueOf(val);
	}
	
	private String calcS(String str) {
		int c = 0;int d = str.length()-1;double val = 0;
		for (int i = 0;i<str.length();i++) {
			if ((str.charAt(i) == '+') || (str.charAt(i) == 'x') || (str.charAt(i) == '/')) {
				c = i+1;
			}
			if (str.charAt(i) == '-') {
				for (int j = i+1;j<str.length();j++) {
					if ((str.charAt(j) == '+') || (str.charAt(j) == '-') || (str.charAt(j) == 'x') || (str.charAt(j) == '/')) {
						d = j-1;
						break;
					}
					if (j == str.length()-1) {
						d = j;
					}
				}
				val = Double.parseDouble(str.substring(c,i))-Double.parseDouble(str.substring(i+1,d+1));
				str = str.replaceFirst(str.substring(c,d+1), String.valueOf(val));
			}	
		}
		return calcA(str);
	}
	
	private String calcM(String str) {
		int c = 0;int d = str.length()-1;double val = 0;
		for (int i = 0;i<str.length();i++) {
			if ((str.charAt(i) == '+') || (str.charAt(i) == '-') || (str.charAt(i) == '/')) {
				c = i+1;
			}
			if (str.charAt(i) == 'x') {
				for (int j = i+1;j<str.length();j++) {
					if ((str.charAt(j) == '+') || (str.charAt(j) == '-') || (str.charAt(j) == 'x') || (str.charAt(j) == '/')) {
						d = j-1;
						break;
					}
					if (j == str.length()-1) {
						d = j;
					}
				}
				val = Double.parseDouble(str.substring(c,i))*Double.parseDouble(str.substring(i+1,d+1));
				str = str.replaceFirst(str.substring(c,d+1), String.valueOf(val));
			}
		}
		return calcS(str);
	}
	
	private String calculate(String str) {
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {str = "0"+str;}
		int c = 0;int d = str.length()-1;double val = 0;
		for (int i = 0;i<str.length();i++) {
			if ((str.charAt(i) == '+') || (str.charAt(i) == '-') || (str.charAt(i) == 'x')) {
				c = i+1;
			}
			if (str.charAt(i) == '/') {
				for (int j = i+1;j<str.length();j++) {
					if ((str.charAt(j) == '+') || (str.charAt(j) == '-') || (str.charAt(j) == 'x') || (str.charAt(j) == '/')) {
						d = j-1;
						break;
					}
					if (j == str.length()-1) {
						d = j;
					}
				}
				val = Double.parseDouble(str.substring(c,i))/Double.parseDouble(str.substring(i+1,d+1));
				str = str.replaceFirst(str.substring(c,d+1), String.valueOf(val));
			}
			
		}
		return calcM(str);
	}
	
	private void clear() {
		this.cal.setText("");
		this.res.setText("0.0");
	}
	
	private void calc() {
		String cal = this.cal.getText();
		try {
			DecimalFormat decimalFormat = new DecimalFormat("0.############");
			String result = decimalFormat.format(Double.parseDouble(calculate(calculate(cal))));
			this.res.setText(result);
		}
		catch (Exception e) {
			if (!this.cal.getText().equals("")) {this.res.setText("Error");}
		}
		
	}
	
	private void adjustFont() {
		if (cal.getText().length() > 18) {
			cal.setFont(new Font("Calculator", Font.BOLD, 20));
		}
		else if (cal.getText().length() > 9) {
			cal.setFont(new Font("Calculator", Font.BOLD, 40));
		}
		else {
			cal.setFont(new Font("Calculator", Font.BOLD, 80));
		}	
		
		if (res.getText().length() > 18) {
			res.setFont(new Font("Calculator", Font.BOLD, 20));
			res.setText("\n\n\n"+res.getText());
		}
		else if (res.getText().length() > 9) {
			res.setFont(new Font("Calculator", Font.BOLD, 40));
			res.setText("\n"+res.getText());
		}
		else {
			res.setFont(new Font("Calculator", Font.BOLD, 80));
		}
	}
	
	public void launch() {

		JFrame frame = new JFrame("Calculator");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(385,730);
		
		frame.getContentPane().add(cal);
		frame.getContentPane().add(res);
		
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bAdd = new JButton("+");
		JButton bSub = new JButton("-");
		JButton bMult = new JButton("x");
		JButton bDiv = new JButton("/");
		JButton bBs = new JButton("bs");
		JButton bClear = new JButton("C");
		JButton bPoint = new JButton(".");
		JButton bEquals = new JButton("=");
		
		bBs.setBounds(190,230,90,90);
		bClear.setBounds(280,230,90,90);
		
		b7.setBounds(10,320,90,90);
		b8.setBounds(100,320,90,90);
		b9.setBounds(190,320,90,90);
		bAdd.setBounds(280,320,90,90);
		
		b4.setBounds(10,410,90,90);
		b5.setBounds(100,410,90,90);
		b6.setBounds(190,410,90,90);
		bSub.setBounds(280,410,90,90);
		
		b1.setBounds(10,500,90,90);
		b2.setBounds(100,500,90,90);
		b3.setBounds(190,500,90,90);
		bMult.setBounds(280,500,90,90);
		
		bPoint.setBounds(10,590,90,90);
		b0.setBounds(100,590,90,90);
		bEquals.setBounds(190,590,90,90);
		bDiv.setBounds(280,590,90,90);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();

		buttons.add(b7);
		buttons.add(b8);
		buttons.add(b9);
		buttons.add(bAdd);
		buttons.add(b4);
		buttons.add(b5);
		buttons.add(b6);
		buttons.add(bSub);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		buttons.add(bMult);
		buttons.add(bPoint);
		buttons.add(b0);
		buttons.add(bEquals);
		buttons.add(bDiv);	
		buttons.add(bBs);
		buttons.add(bClear);
		
		for (JButton btn : buttons) {
			frame.getContentPane().add(btn);
			if (!(btn.equals(bBs) || btn.equals(bClear) || btn.equals(bEquals))) {
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						if ((btn.equals(bDiv) || btn.equals(bSub) || btn.equals(bAdd) || btn.equals(bMult))) {
							if (!(res.getText().equals("0.0") || res.getText().equals("error"))) {
								cal.setText(res.getText().trim());
							}
						}
						cal.setText(cal.getText() + btn.getText());
						adjustFont();
					}
				});
			}
		}
		
		bBs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					cal.setText(cal.getText().substring(0,cal.getText().length()-1));
					adjustFont();
				}
				catch (Exception e) {
					cal.setText("");	
				}
			}
		});
		
		bClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clear();
				adjustFont();
			}
			
		});
		
		bEquals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				calc();
				adjustFont();
			}
			
		});
		
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public static void main(String[] args) throws FontFormatException {
		new Calculator().launch();
	}
}

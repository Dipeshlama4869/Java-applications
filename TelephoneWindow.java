package PhoneBook;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class TelephoneWindow implements ActionListener {
	
	private JFrame frame;
	private JTextField textFieldFN;
	private JTextField textFieldLN;
	private JTextField textFieldP;
	private JTable table;
	private DefaultTableModel model;
	private JCheckBox checkBoxPrivate;
	private JRadioButton radioFL;
	private JRadioButton radioLF;
	private JButton btnSearch;
	private JButton btnClear;
	private JButton btnAdd;
	private JButton btnRemove;
	private JMenuItem editAdd;
	private JMenuItem editRemove;
	private JMenuItem editSearch;
	private JMenuItem editClear;
	private JMenuItem fileExit;
	private JMenuItem helpAbout;
	private int index;
	
	public TelephoneWindow() {
		frame = new JFrame();
		textFieldFN = new JTextField();
		textFieldLN = new JTextField();
		textFieldP = new JTextField();
		table = new JTable();
		index = 0;
		model = new DefaultTableModel();
	}
	
	public void launch() {
		frame.setTitle("Phone Book");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		// --------------------------------------- MenuBar -------------------------------------------
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// ------------------------------------- File ----------------------------
		
		JMenu file = new JMenu("File");
		fileExit = new JMenuItem("Exit");
		fileExit.addActionListener(this);
		file.add(fileExit);
		
		menuBar.add(file);
		
		// ------------------------------ Edit ---------------------------------------
		
		JMenu edit = new JMenu("Edit");
		editClear = new JMenuItem("Clear");
		editClear.addActionListener(this);
		edit.add(editClear);
		
		editSearch = new JMenuItem("Search");
		editSearch.addActionListener(this);
		edit.add(editSearch);
		
		JSeparator separator = new JSeparator();
		edit.add(separator);
		
		editAdd = new JMenuItem("Add");
		editAdd.addActionListener(this);
		edit.add(editAdd);
		
		editRemove = new JMenuItem("Remove");
		editRemove.addActionListener(this);
		edit.add(editRemove);
		
		menuBar.add(edit);
		
		//------------------------------------------- Help -----------------------------------
		
		JMenu help = new JMenu("Help");
		helpAbout = new JMenuItem("About");
		helpAbout.addActionListener(this);
		help.add(helpAbout);
		
		menuBar.add(help);
		
		//-------------------------------------- ScrollPane -> table -----------------------
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 453, 524);
		String title = "Name:";
		Border border = BorderFactory.createTitledBorder(title);
		scrollPane.setBorder(border);
		frame.getContentPane().add(scrollPane);
		model.setRowCount(35);
		model.setColumnIdentifiers(new String[] {"First Name", "Last Name", "Phone No.", "Privacy"});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		//---------------------------------------- Input Area -------------------------------------
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(475, 9, 407, 250);
		panelInfo.setLayout(null);
		title = "Info:";
		border = BorderFactory.createTitledBorder(title);
		panelInfo.setBorder(border);
		frame.getContentPane().add(panelInfo);
			
		textFieldFN.setBounds(181, 33, 200, 37);
		panelInfo.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(181, 80, 200, 37);
		panelInfo.add(textFieldLN);
		
		textFieldP.setColumns(10);
		textFieldP.setBounds(181, 128, 200, 37);
		panelInfo.add(textFieldP);
		
		checkBoxPrivate = new JCheckBox("Private");
		checkBoxPrivate.setFont(new Font("Rockwell", Font.PLAIN, 20));
		checkBoxPrivate.setBounds(31, 173, 169, 56);
		checkBoxPrivate.setFocusPainted(false);
		panelInfo.add(checkBoxPrivate);
		
		JLabel labelFirstName = new JLabel("First Name:");
		labelFirstName.setFont(new Font("Rockwell", Font.PLAIN, 20));
		labelFirstName.setBounds(21, 47, 150, 23);
		panelInfo.add(labelFirstName);
		
		JLabel labelLastName = new JLabel("Last Name:");
		labelLastName.setFont(new Font("Rockwell", Font.PLAIN, 20));
		labelLastName.setBounds(21, 91, 150, 23);
		panelInfo.add(labelLastName);
		
		JLabel labelPhone = new JLabel("Phone:");
		labelPhone.setFont(new Font("Rockwell", Font.PLAIN, 20));
		labelPhone.setBounds(21, 139, 150, 23);
		panelInfo.add(labelPhone);
		
		//------------------------------------------- RadioButtons for sort---------------------------
		
		JPanel panelFileAs = new JPanel();
		panelFileAs.setBounds(475, 271, 407, 99);
		panelFileAs.setLayout(null);
		title = "File As:";
		border = BorderFactory.createTitledBorder(title);
		panelFileAs.setBorder(border);
		frame.getContentPane().add(panelFileAs);
		
		radioFL = new JRadioButton("Firstname, Lastname");
		radioFL.setFont(new Font("Rockwell", Font.PLAIN, 20));
		radioFL.setBounds(54, 17, 247, 32);
		radioFL.setSelected(true);
		radioFL.setFocusPainted(false);
		
		radioLF = new JRadioButton("Lastname, Firstname");
		radioLF.setFont(new Font("Rockwell", Font.PLAIN, 20));
		radioLF.setBounds(54, 60, 247, 32);
		radioLF.setFocusPainted(false);
		
		
		ButtonGroup radios = new ButtonGroup();
		radios.add(radioFL);
		radios.add(radioLF);
		
		panelFileAs.add(radioFL);
		panelFileAs.add(radioLF);

		//--------------------------------- Buttons --------------------------------------------
		
		JPanel panelBtns = new JPanel();
		panelBtns.setBounds(475, 384, 405, 151);
		panelBtns.setLayout(null);
		frame.getContentPane().add(panelBtns);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnAdd.setBounds(10, 84, 151, 60);
		btnAdd.setFocusPainted(false);
		panelBtns.add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);
		btnRemove.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnRemove.setBounds(246, 83, 151, 61);
		btnRemove.setFocusPainted(false);
		panelBtns.add(btnRemove);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnClear.setBounds(10, 11, 151, 61);
		btnClear.setFocusPainted(false);
		btnClear.addActionListener(this);
		panelBtns.add(btnClear);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnSearch.setBounds(246, 11, 151, 61);
		btnSearch.setFocusPainted(false);
		panelBtns.add(btnSearch);
		

		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fileExit) System.exit(0);
		if (e.getSource() == editAdd) btnAdd.doClick();
		if (e.getSource() == editRemove) btnRemove.doClick();
		if (e.getSource() == editSearch) btnSearch.doClick();
		if (e.getSource() == editClear) btnClear.doClick();
		if (e.getSource() == helpAbout) JOptionPane.showMessageDialog(frame,"It is still in trial version!");
		
		if (e.getSource() == btnClear) {
			textFieldFN.setText("");
			textFieldLN.setText("");
			textFieldP.setText("");
			radioFL.setSelected(true);
			checkBoxPrivate.setSelected(false);
		}
		
		if (e.getSource() == btnAdd) {
			String fn = textFieldFN.getText();
			String ln = textFieldLN.getText();
			String pn = textFieldP.getText();
			for (int i = 0;i < index;i++) {
				if (model.getValueAt(i, 2).equals(pn)) {
					JOptionPane.showMessageDialog(frame,"Phone Number already exists!");
					return;
				}
			} 
			if (!fn.equals("") && !textFieldP.getText().equals("")) {	
				model.insertRow(index, new String[] {fn, ln, pn, checkBoxPrivate.isSelected() ? "Private" : "Public"});
				index ++;
			}
			else JOptionPane.showMessageDialog(frame, "Incomplete Information!");
		}
		
		if (e.getSource() == btnRemove) {
			try {
				model.removeRow(table.getSelectedRow());
				index --;
				if (index < 0) index = 0;
			}
			catch (Exception ee) {
				JOptionPane.showMessageDialog(frame, "Select one row for deletiion!");
			}
		}
		
		if (e.getSource() == btnSearch) 
			for (int i = 0;i < index;i++) 
				if (model.getValueAt(i, 0).toString().contains(textFieldFN.getText())
					&& model.getValueAt(i, 1).toString().contains(textFieldLN.getText())
					&& model.getValueAt(i, 2).toString().contains(textFieldP.getText())) 
						table.setRowSelectionInterval(i, i);
	}
	
	public static void main(String[] args) {
		new TelephoneWindow().launch();
	}

}

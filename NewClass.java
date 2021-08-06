
package coursework;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;


public class NewClass implements ActionListener {
JFrame frame;
JLabel lbl_1,lbl_2,lbl_3,lbl_4,lbl_5;
JCheckBox chk_1;
JButton btn_1,btn_2,btn_3,btn_4;
JTextField txt_1,txt_2,txt_3;
JRadioButton rbtn_1,rbtn_2;
JTable tbl_1;
DefaultTableModel dtm;
JPanel Pnl_1,Pnl_2,Pnl_3,Pnl_4,right;
JScrollPane spn;
JMenuBar mb;
JMenu file,edit,help;
JMenuItem exit,clear,search,add,remove,about ;
TitledBorder bor_1, bor_2,bor_3;

public NewClass(){
frame=new JFrame();

bor_1=new TitledBorder("Name:");
bor_2=new TitledBorder("Info:");
bor_3=new TitledBorder("File as:");

lbl_1=new JLabel("First Name");
lbl_2=new JLabel("Second Name");
lbl_3=new JLabel("Phone");

chk_1=new JCheckBox("Private");

btn_1=new JButton("Clear");
btn_2=new JButton("Search");
btn_3=new JButton("Add");
btn_4=new JButton("Remove");

rbtn_1=new JRadioButton("Forename,Surname");
rbtn_2=new JRadioButton("Surname,Forename");

txt_1=new JTextField();
txt_2=new JTextField();
txt_3=new JTextField();

mb=new JMenuBar();

file=new JMenu("File");
edit=new JMenu("Edit");
help=new JMenu("Help");

exit=new JMenuItem("Exit");
clear=new JMenuItem("Clear");
search=new JMenuItem("Search");
add=new JMenuItem("Add");
remove=new JMenuItem("Remove");
about=new JMenuItem("About");


Pnl_1=new JPanel();
Pnl_2=new JPanel();
Pnl_3=new JPanel();
right=new JPanel();

spn=new JScrollPane();

dtm=new DefaultTableModel(50,0);
tbl_1=new JTable(dtm); 
tbl_1.setModel(dtm);

  dtm.addColumn("First Name");
  dtm.addColumn("Last Name");
  dtm.addColumn("Phone");
  dtm.addColumn("Private or not");
  
frame.add(spn); 
frame.add(Pnl_1);
frame.add(Pnl_2);
frame.add(Pnl_3);
frame.add(right);
frame.setJMenuBar(mb);

mb.add(file);
mb.add(edit);
mb.add(help);

file.add(exit);
edit.add(clear);
edit.add(add);
edit.add(search);
edit.add(remove);
help.add(about);


Pnl_1.setBorder(bor_2);
Pnl_1.add(lbl_1);
Pnl_1.add(txt_1);
Pnl_1.add(lbl_2);
Pnl_1.add(txt_2);
Pnl_1.add(lbl_3);
Pnl_1.add(txt_3);
Pnl_1.add(chk_1);

Pnl_2.setBorder(bor_3);
Pnl_2.add(rbtn_1);
Pnl_2.add(rbtn_2);
rbtn_1.setSelected(true);

Pnl_3.add(btn_1);
Pnl_3.add(btn_2);
Pnl_3.add(btn_3);
Pnl_3.add(btn_4);


spn.setBorder(bor_1);
spn.setViewportView(tbl_1);

frame.setTitle("PhoneBook");
frame.setSize(500,500);
frame.setResizable(true);
frame.setLayout(new GridLayout(1,2));
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Pnl_1.setLayout(new GridLayout(4,2));
Pnl_2.setLayout(new GridLayout(2,1));
Pnl_3.setLayout(new GridLayout(2,2));
        
right.setLayout(new GridLayout(3,1));

right.add(Pnl_1);
right.add(Pnl_2);
right.add(Pnl_3);


 btn_1.addActionListener(this);
 btn_2.addActionListener(this);
 btn_3.addActionListener(this);
 btn_4.addActionListener(this);
 exit.addActionListener(this);
 clear.addActionListener(this);
 search.addActionListener(this);
 add.addActionListener(this);
 remove.addActionListener(this);
 about.addActionListener(this);
}   
 @Override
 public void actionPerformed(ActionEvent e){
     int n = 0;
       if(e.getSource()==btn_3 || e.getSource() == add){
           String First_Name,Last_Name,Phone,ph;
           First_Name=txt_1.getText();
           Last_Name=txt_2.getText();
           Phone=txt_3.getText();
            if(chk_1.isSelected()==true){
               ph="Private";
            }
            else{
            ph="";          
       }
        
             Object[] row={First_Name,Last_Name,Phone,ph};
             dtm.insertRow(n, row);
           txt_1.setText("");
           txt_2.setText("");
           txt_3.setText("");
           chk_1.setSelected(false);
           n = n + 1;
       }
       else if(e.getSource()==btn_1 || e.getSource()==clear){
           txt_1.setText("");
           txt_2.setText("");
           txt_3.setText("");
           chk_1.setSelected(false);
           
       }
       else if(e.getSource()==btn_4 || e.getSource()==remove){
           dtm.removeRow(tbl_1.getSelectedRow());
       }
       else if(e.getSource()==btn_2 || e.getSource()==search){
           JOptionPane.showMessageDialog(null, "Search functionality will be supported in the professional version.", "Info", JOptionPane.WARNING_MESSAGE);
       }
       else if(e.getSource()==about){
       JOptionPane.showMessageDialog(null, "It is still in trial version!!", "Info", JOptionPane.WARNING_MESSAGE);
       }
       else if(e.getSource()==exit){
       System.exit(0);
       }
       else if(e.getSource()==rbtn_1){
      
       }
       }
}


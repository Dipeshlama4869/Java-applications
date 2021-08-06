package coursework;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CourseWork implements ActionListener {
    //Declaring variables
    
    private JFrame frame;
    
    private JMenuBar menubar;
    private JMenu file,edit,help;
    private JMenuItem exit,clear,search,add,remove,about;
    
    private TitledBorder b1,b2,b3;
    
    private JTable tbl;
    private DefaultTableModel dtm;
    
    private JScrollPane sc_pn;
    
    private JLabel lbl_1,lbl_2,lbl_3;
    private JTextField txt_1,txt_2,txt_3;
    private JCheckBox chk;
    private JRadioButton rdb_1,rdb_2;
    private JButton btn_1,btn_2,btn_3,btn_4;
    
    private JPanel pnl_1,pnl_2,pnl_3,pnl;
    
    public CourseWork(){
        //Creating Frame
        frame = new JFrame("PhoneBook");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,1));
        frame.setSize(1200,800);
        
        //Adding menubar
        menubar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        exit = new JMenuItem("Exit");
        clear = new JMenuItem("Clear");
        search = new JMenuItem("Search");
        add = new JMenuItem("Add");
        remove = new JMenuItem("Remove");
        about = new JMenuItem("About");
        
        frame.setJMenuBar(menubar);
        
        menubar.add(file);
        file.add(exit);
        exit.addActionListener(this);
        
        menubar.add(edit);
        edit.add(clear);
        clear.addActionListener(this);
        edit.add(search);
        search.addActionListener(this);
        edit.add(add);
        add.addActionListener(this);
        edit.add(remove);
        remove.addActionListener(this);
        
        menubar.add(help);
        help.add(about);
        about.addActionListener(this);
        
        //adding table inside scrollpane
        sc_pn = new JScrollPane();
        dtm = new DefaultTableModel(0,0);
        tbl = new JTable(dtm);
        b1 = new TitledBorder("Name: ");

            
        frame.getContentPane().add(sc_pn);
        sc_pn.setViewportView(tbl);
        sc_pn.setBorder(b1);
        dtm.addColumn("Fist Name");
        dtm.addColumn("Second Name");
        dtm.addColumn("Phone");
        dtm.addColumn("Privacy");
        
        //adding Info input
        pnl_1 = new JPanel();
        b2 = new TitledBorder("info");
        lbl_1 = new JLabel("FirstName");
        lbl_2 = new JLabel("SecondName");
        lbl_3 = new JLabel("Phone");
        txt_1 = new JTextField(10);
        txt_2 = new JTextField(10);
        txt_3 = new JTextField(10);
        chk = new JCheckBox("Private");
        
        frame.add(pnl_1);
        pnl_1.setLayout(new GridLayout(4,3));
        pnl_1.setBorder(b2);
        pnl_1.add(lbl_1);
        pnl_1.add(txt_1);
        pnl_1.add(lbl_2);
        pnl_1.add(txt_2);
        pnl_1.add(lbl_3);
        pnl_1.add(txt_3);
        pnl_1.add(chk);
        
        //adding radio buttons
        pnl_2 = new JPanel();
        b3 = new TitledBorder("File as: ");
        rdb_1 = new JRadioButton("Forename,Surname");
        rdb_2 = new JRadioButton("Surname,Forename");
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdb_1);
        bg.add(rdb_2);
        
        frame.add(pnl_2);
        pnl_2.setBorder(b3);
        pnl_2.setLayout(new GridLayout(2,0));
        pnl_2.add(rdb_1);
        pnl_2.add(rdb_2);
        rdb_1.setSelected(true);
        rdb_1.setEnabled(false);
        rdb_1.addActionListener(this);
        rdb_2.addActionListener(this);
        
        //adding buttons
        pnl_3 = new JPanel();
        btn_1 = new JButton("Clear");
        btn_2 = new JButton("Search");
        btn_3 = new JButton("Add");
        btn_4 = new JButton("Remove");
        
        frame.add(pnl_3);
        pnl_3.setLayout(new GridLayout(2,2));
        pnl_3.add(btn_1);
        pnl_3.add(btn_2);
        pnl_3.add(btn_3);
        pnl_3.add(btn_4);
        
        btn_1.addActionListener(this);
        btn_2.addActionListener(this);
        btn_3.addActionListener(this);
        btn_4.addActionListener(this);
        
        //Managing layout
        pnl = new JPanel();
        frame.add(pnl);
        pnl.setLayout(new GridLayout(3,0));
        pnl.add(pnl_1);
        pnl.add(pnl_2);
        pnl.add(pnl_3);
        
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        CourseWork courseWork = new CourseWork();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit)
            System.exit(0);
        
        if(ae.getSource() == clear || ae.getSource() == btn_1){
            txt_1.setText("");
            txt_2.setText("");
            txt_3.setText("");
            chk.setSelected(false);
        }
        
        if(ae.getSource() == search || ae.getSource() == btn_2){
            JOptionPane.showMessageDialog(frame,"Search Functionality will be Supported in Professional version");
        }
        
        if(ae.getSource() == add || ae.getSource() == btn_3){
            int i = 0;
            String fname,lname,phone,privacy;
            fname = txt_1.getText();
            lname = txt_2.getText();
            phone = txt_3.getText();
            if(chk.isSelected()){
                privacy = "Private";
            }
            else{
                privacy="";
            }
            
            String[] data = {fname,lname,phone,privacy};
            
            dtm.insertRow(i, data);
            i++;
            
            txt_1.setText("");
            txt_2.setText("");
            txt_3.setText("");
            chk.setSelected(false);    
        }
        
        if(ae.getSource() == remove || ae.getSource() == btn_4){
            dtm.removeRow(tbl.getSelectedRow());
        }
        
        if(ae.getSource() == about){
            JOptionPane.showMessageDialog(frame,"It is still in trial version!!");
        }
        
        if(rdb_1.isSelected()){
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl.getModel());
            tbl.setRowSorter(sorter);
            List<RowSorter.SortKey> list = new ArrayList<>();
            list.add(new RowSorter.SortKey(0,SortOrder.ASCENDING));
            sorter.setSortKeys(list);  
            sorter.sort(); 
            
            rdb_1.setEnabled(false);
            rdb_2.setEnabled(true);
        }
                
        if(rdb_2.isSelected()){
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl.getModel());
            tbl.setRowSorter(sorter);
            List<RowSorter.SortKey> list = new ArrayList<>();
            list.add(new RowSorter.SortKey(1,SortOrder.ASCENDING));
            sorter.setSortKeys(list);  
            sorter.sort(); 
            
            rdb_1.setEnabled(true);
            rdb_2.setEnabled(false);
        }
        

    }
}

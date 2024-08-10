import javax.management.JMX;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class frame_cl extends JFrame  {
	private GridLayout W;
	private JLabel symbole;
	private JLabel crName;
	private JLabel crNum1;
	private JLabel rateUPDATE;
	private JLabel newRate;
	private JLabel amount;
	private JLabel rate;
	
	private JTextField j1;
	private JTextField j2;
	private JTextField j3;
	private JTextField j4;
	private JTextField j5;
	private JComboBox TestJTEXT;
	
	private JComboBox Jcombo1;
	private JComboBox Jcombo2 ;
	private JComboBox Jcombo3;
	private JComboBox Jcombo4;
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;

	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	
	private JList <String> listA;
	DefaultListModel<String> Jlist_Array;
	
public frame_cl()
{
	super("                                                    "
			+ "                    "
			+ "            "
			+ "    "
			+ "                    "+"Currency Exchange ");

	 symbole=new JLabel("Symbole");
	 crName=new JLabel("Currency Name");	
	 crNum1=new JLabel("1");
	 rateUPDATE=new JLabel("Rate to Update");	
	 newRate=new JLabel("New Rate");	
	 amount=new JLabel("Amount");	
	 rate=new JLabel("Rate");	

	  j1=new JTextField(5);
	  j2=new JTextField(10);;
	  j3=new JTextField(5);;
	  j4=new JTextField(5);;
	  j5=new JTextField(7);;
	 
	  Handler_AW hd=new Handler_AW();
	
	  b1=new JButton("Add Currency");  b1.addActionListener(hd);
      b2=new JButton("Add Rate");b2.addActionListener(hd);
	  b3=new JButton("Update");b3.addActionListener(hd);
	  b4=new JButton("Add");b4.addActionListener(hd);
	  b5=new JButton("Remove");
	  b5.addActionListener(hd);
	
	  b2.setEnabled(false);
	  b3.setEnabled(false);
	  b4.setEnabled(false);
	  b5.setEnabled(false);
	  
	  Jcombo1=new JComboBox(); 
	  Jcombo2=new JComboBox();
	  Jcombo3=new JComboBox();
	  Jcombo4=new JComboBox();
	  
	  Jcombo1. addActionListener(hd);
	  Jcombo2.addActionListener(hd);
	  
	  p1=new JPanel();
	  p2=new JPanel();
	  p3=new JPanel();
	  p4=new JPanel();
	  p5=new JPanel();
	 
	  W=new GridLayout(5,1);//5 rows  1 col
	  setLayout(W);

	  Jlist_Array =new DefaultListModel<String>();
	  listA=new JList<>(Jlist_Array);
	  listA.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  listA.setFixedCellWidth(250);
	  listA.setFixedCellHeight(10);
	
		
	  p1.add(symbole);p1.add(j1);p1.add(crName);p1.add(j2);p1.add(b1);
	  p2.add(crNum1);p2.add(Jcombo1);p2.add(j3);p2.add(Jcombo2);p2.add(b2);
	  p3.add(rateUPDATE);p3.add(Jcombo3);p3.add(newRate);p3.add(j4);p3.add(b3);
	  p4.add(amount);p4.add(j5);p4.add(rate);p4.add(Jcombo4);p4.add(b4);
      p5.add(new JScrollPane(listA));p5.add(b5);
     
      p1.setBorder(BorderFactory.createLineBorder(getForeground()));
      p2.setBorder(BorderFactory.createLineBorder(getForeground()));
      p3.setBorder(BorderFactory.createLineBorder(getForeground()));
      p4.setBorder(BorderFactory.createLineBorder(getForeground()));
      
    add(p1);
	add(p2);
    add(p3);
	add(p4);
	add(p5);
	
	color_AW a=new color_AW();
    this.addMouseMotionListener(a);
}
private class color_AW implements MouseMotionListener
{
	public void  mouseMoved(MouseEvent E)
	{
		int red=(E.getY())%255;//255 Pixel->getting number lower 
		int green=200;
		int blue=90;
		Color e=new Color (red,green,blue);
	p1.setBackground(e);
	p2.setBackground(e);
    p3.setBackground(e);
	p4.setBackground(e);
	p5.setBackground(e);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
private class Handler_AW implements ActionListener
{   
	public void actionPerformed(ActionEvent event)
	{
		int x=0;
		if(event.getSource()==b1)//addCurrency
		{
			Currency_cl C=new Currency_cl();
			C.setSymbole(j1.getText());
			C.setCrName(j2.getText());
			int add_flag = 0;
			for(int i=0; i< Jcombo1.getItemCount(); i++) {
				String item_value = (String) Jcombo1.getItemAt(i);
				String cur_name = item_value.split("\\(")[0];
				String cur_symbol = item_value.split("\\(")[1].split("\\)")[0];
				if (C.cur_symbols.contains(cur_symbol.toUpperCase())) {
					add_flag = 1;
					JOptionPane.showMessageDialog(null , "Currency symbol exists");
				}
				if (C.cur_names.contains(cur_name.toUpperCase(getLocale()))) {
					add_flag = 1;
					JOptionPane.showMessageDialog(null , "Currency name exists");
				}
			} // validation 
			if (add_flag != 1) {
			Jcombo1.addItem(C.toString());
			
			Jcombo2.addItem(C.toString());
			} // Add only if validation passed
			
			if((Jcombo1.getSelectedItem().equals(Jcombo2.getSelectedItem()))||  (Jcombo2.getSelectedItem().equals(Jcombo1.getSelectedItem()))     )
			{
			    b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				b5.setEnabled(false);
			}
			
			if(j1.getText().equals(j2.getText()))
			{
				JOptionPane.showMessageDialog(null , "You cant add Currency name as the symbole ");
			}
		}
	
		if(event.getSource()==Jcombo1)
		{
			if(!(Jcombo1.getSelectedItem().equals(Jcombo2.getSelectedItem())))
			{
				
			    b2.setEnabled(true);
				b4.setEnabled(true);
				b5.setEnabled(true);

			}
			else
			{
				b2.setEnabled(false);
			    b3.setEnabled(false);
			    b4.setEnabled(false);
			    b5.setEnabled(false);
			}}
		
		if(event.getSource()==Jcombo2)
		{
			if(!(Jcombo2.getSelectedItem().equals(Jcombo1.getSelectedItem())))
			{	
			   b2.setEnabled(true);
			   b5.setEnabled(true);	
			}
			else
			{
			   b2.setEnabled(false);
			   b3.setEnabled(false);
			   b4.setEnabled(false);
			   b5.setEnabled(false);
			}
		}
		if(event.getSource()==b2)
		{	
			try {						 
					 b3.setEnabled(false); 
					 
			exchange_cl E=new  exchange_cl();
		
			E.setX1(Jcombo1.getSelectedItem().toString());
			E.setX2(Jcombo2.getSelectedItem().toString());
			E.setRate_V(Float.parseFloat(j3.getText()));
	    	E.setX(1);
				Jcombo3.addItem(E.toString());
		    	Jcombo4.addItem(E.toString());
		    	
	    	        b3.setEnabled(true);
			}
			catch (NumberFormatException a) 
			{
				JOptionPane.showMessageDialog(null , "Please make sure the rate is a number");
			}
			
		}
		
	    if(event.getSource()==b3)
	    {
	    	b4.setEnabled(true);
	    	try
	    	{
	    	exchange_cl R=new  exchange_cl();
	    	R.setX1(Jcombo1.getSelectedItem().toString());
			R.setX2(Jcombo2.getSelectedItem().toString());
	    	R.setRate_V(Float.parseFloat(j4.getText()));
	    	R.setX(1);
	    
	    	Jcombo3.removeItem(Jcombo3.getSelectedItem()); 
	    	Jcombo3.addItem(R.toString());
	    	Jcombo4.removeItem(Jcombo4.getSelectedItem()); 
	    	Jcombo4.addItem(R.toString());
	    	}
	    	catch (NumberFormatException a) 
			{
				JOptionPane.showMessageDialog(null , "Please make sure the rate is a number");
			}}
	    if(event.getSource()==b4)//update
	    {
	   try
	   {
	    	exchange_cl A=new  exchange_cl();
	    	
	    	A.setV3(Float.parseFloat (j5.getText()));
	    	A.setV4(Float.parseFloat(j3.getText()));
	    	A.setX1(Jcombo1.getSelectedItem().toString());
			A.setX2(Jcombo2.getSelectedItem().toString());
	    	A.setRate_V(Float.parseFloat(j4.getText()));
	    	A.setX(2);
	    	Jlist_Array.add(0,A.toString());
	   }
	   catch (NumberFormatException b)
	   {
		   JOptionPane.showMessageDialog(null , "Please make sure the amount is a number");
	   }
	    }
	    if(event.getSource()==b5)//remove
	    {	    
	    	try
	    	{
	   Jlist_Array.removeElementAt(listA.getSelectedIndex());
	   
	    	}
	    	catch(Exception e)
	    	{
	    		JOptionPane.showMessageDialog(null , "Please make sure that you entered amount and press add");
	    	} } } }}

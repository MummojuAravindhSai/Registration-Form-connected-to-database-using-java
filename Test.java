import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
class Test extends Frame implements ItemListener,ActionListener 
{
Label b1,b4,b5,p1,p2,gender,state,Technicalskills,address,accept;
List l1,l2,l3,l4;
Button submit,cancel;
TextField t1,t2,t3,t4;
TextArea area;
Checkbox g1,g2,ca1,ca2;
CheckboxGroup cbg;
Choice c1;
String msg="";
Test()
{
setLayout(new FlowLayout());
b4=new Label("Username:");
add(b4);
t1=new TextField(15);
t1.addActionListener(this);
add(t1);
b5=new Label("Password:");
add(b5);
t2=new TextField(15);
t2.setEchoChar('*');
t2.addActionListener(this);
add(t2);
b1=new Label("Date of birth:");
add(b1);
l1=new List(2,true);
l1.addItemListener(this);
l1.add("1");l1.add("2");l1.add("3");l1.add("4");l1.add("5");l1.add("6");l1.add("7");l1.add("8");l1.add("9");l1.add("10");
l1.add("11");l1.add("12");l1.add("13");l1.add("14");l1.add("15");l1.add("16");l1.add("17");l1.add("18");l1.add("19");
l1.add("20");l1.add("21");l1.add("22");l1.add("23");l1.add("24");l1.add("25");l1.add("26");l1.add("27");l1.add("28");
l1.add("29");l1.add("30");l1.add("31");
add(l1);
l2=new List(2,true);
l2.addItemListener(this);
l2.add("january");
l2.add("february");
l2.add("march");
l2.add("april");
l2.add("may");
l2.add("june");
l2.add("july");
l2.add("august");
l2.add("september");
l2.add("october");
l2.add("november");
l2.add("december");
add(l2);
l3=new List(2,true);
l3.addItemListener(this);
l3.add("1999");l3.add("2000");l3.add("2001");l3.add("2002");l3.add("2003");l3.add("2004");l3.add("2005");l3.add("2006");
l3.add("2007");l3.add("2008");l3.add("2009");l3.add("2010");l3.add("2010");l3.add("2011");l3.add("2012");l3.add("2013");
l3.add("2014");l3.add("2015");l3.add("2016");l3.add("2017");l3.add("2018");l3.add("2019");l3.add("2020");
add(l3);
t3=new TextField("enter phoneno");
p1=new Label("Phoneno:");
add(p1);
t3.addActionListener(this);
add(t3);
t4=new TextField("enter emailid");
p2=new Label("emialid:");
add(p2);
t4.addActionListener(this);
add(t4);
gender=new Label("gender:");
add(gender);
cbg=new CheckboxGroup();
g1=new Checkbox("male",true,cbg);
g2=new Checkbox("female",false,cbg);
g1.addItemListener(this);
g2.addItemListener(this);
add(g1);
add(g2);
state=new Label("state:");
add(state);
c1=new Choice();
c1.add("select state");
c1.add("telangana");
c1.add("andhra pradesh");
c1.add("kerala");
c1.add("karnataka");
c1.add("tamilnadu");
c1.add("madya pradesh");
c1.add("jammu & kashmir");
c1.add("new delhi");
c1.add("punjab");
c1.addItemListener(this);
add(c1);
Technicalskills=new Label("Technical skills:");
add(Technicalskills);
l4=new List(2,true);
l4.addItemListener(this);
l4.add("c");l4.add("c++");l4.add("java");l4.add("python");l4.add("java script");l4.add("ruby");l4.add("php");l4.add("css");l4.add("mysql");l4.add("html");
add(l4);
address=new Label("address:");
add(address); 
area=new TextArea();  
area.setBounds(20,100,300,300);
add(area);
accept=new Label("click on accept to continue");
add(accept);
ca1=new Checkbox("accept");
ca2=new Checkbox("denied");
ca1.addItemListener(this);
ca2.addItemListener(this);
add(ca1);
add(ca2);
submit=new Button("submit");
submit.addActionListener(this);
add(submit); 
cancel=new Button("cancel");
cancel.addActionListener(this);
add(cancel); 
}
public void actionPerformed(ActionEvent ae)
{
 String s=ae.getActionCommand();
Connection con=null;
PreparedStatement pstmt=null;
if(s.equals("submit"))
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
System.out.println("connection established:");
String q="create table student(username char(30),password char(30),date int,month int,year int,phoneno Long,email char(30),gender char(10),state char(30),technicalskills char(70),address char(70))";
pstmt.executeUpdate(q);
System.out.println("table created");
String p="insert into student values(?,?,?,?,?,?,?,?,?)";
pstmt=con.prepareStatement(q);
pstmt.setString(1,t1.getText());
pstmt.setString(2,t2.getText());
pstmt.setString(3,l1.getSelectedItem());
pstmt.setString(4,l2.getSelectedItem());
pstmt.setString(5,l3.getSelectedItem());
pstmt.setString(6,t3.getText());
pstmt.setString(7,t4.getText());
pstmt.setString(8,gender.getText());
pstmt.setString(9,c1.getSelectedItem());
pstmt.setString(10,l4.getSelectedItem());
pstmt.setString(11,area.getText());
pstmt.executeUpdate();
System.out.println("row inserted:");
}
catch(Exception e)
{
 System.out.println("connection failed:"+e);
}
}
public void itemStateChanged(ItemEvent ie)
{
 repaint();
}
public void paint(Graphics g)
{
String s[]=l1.getSelectedItems();
Checkbox t=cbg.getSelectedCheckbox();
}
public static void main(String args[])throws Exception
{
 Test t=new Test();
t.setVisible(true);
t.setTitle("registration form");
t.setSize(1500,700);
}
}

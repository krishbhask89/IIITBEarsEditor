/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author michael
 */
import iiitbEarsEditor.View.LeftPaneUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JButtonTableExample extends JFrame {

public JButtonTableExample() {
super( "JButtonTable Example" );

DefaultTableModel dm = new DefaultTableModel();
dm.setDataVector( new Object[][] { {"1" },  }, new Object[] {"Buttons","" } );

JTable table = new JTable( dm );
//table.getColumnModel().getColumn(0).setCellRenderer( new LeftPaneUI() );
//table.getColumn( "Buttons" ).setCellEditor( new PanelEditor( new JCheckBox() ) );
JScrollPane scroll = new JScrollPane( table );
table.setRowHeight( 95 );
table.getColumnModel().getColumn(0).setPreferredWidth(200);
getContentPane().add( scroll );
setSize( 400, 150 );
setVisible( true );
}

public static void main( String[] args ) {
JButtonTableExample frame = new JButtonTableExample();
frame.addWindowListener( new WindowAdapter() {
public void windowClosing( WindowEvent e ) {
System.exit( 0 );
}
} );
}

class PanelRenderer extends JPanel implements TableCellRenderer {

public PanelRenderer() {
setOpaque( true );
init();
}

private void init() {
setLayout( new FlowLayout( FlowLayout.CENTER, 5, 0 ) );
add( new JButton( "A" ) );
add( new JButton( "B" ) );
}

public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column ) {
if ( isSelected )
{
setForeground( table.getSelectionForeground() );
setBackground( table.getSelectionBackground() );
} else
{
setForeground( table.getForeground() );
setBackground( UIManager.getColor( "Button.background" ) );
}
return this;
}
}

class PanelEditor extends DefaultCellEditor {
protected JPanel panel;

protected JButton button1;

protected JButton button2;

public PanelEditor( JCheckBox checkBox ) {
super( checkBox );
panel = new JPanel( new FlowLayout( FlowLayout.CENTER, 5, 0 ) );
button1 = new JButton( "1" );
button1.setOpaque( true );
button1.setActionCommand( "Action1" );
button1.addActionListener( new ActionListener() {
public void actionPerformed( ActionEvent e ) {
JOptionPane.showMessageDialog( button1, button1.getText()
+ ": Ouch!" );
fireEditingStopped();
}
} );
button2 = new JButton( "2" );
button2.setOpaque( true );
button2.addActionListener( new ActionListener() {
public void actionPerformed( ActionEvent e ) {
JOptionPane.showMessageDialog( button2, button2.getText()
+ ": Ouch!" );
fireEditingStopped();
}
} );
panel.add( button1 );
panel.add( button2 );
}

public Component getTableCellEditorComponent( JTable table, Object value, boolean isSelected, int row, int column ) {
if ( isSelected )
{
button1.setForeground( table.getSelectionForeground() );
button1.setBackground( table.getSelectionBackground() );
} else
{
button1.setForeground( table.getForeground() );
button1.setBackground( table.getBackground() );
}
return panel;
}
}
}

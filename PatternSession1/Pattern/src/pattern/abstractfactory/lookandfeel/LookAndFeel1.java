package pattern.abstractfactory.lookandfeel;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeel1 extends JPanel implements ActionListener {

	private JButton jbmMetal = new JButton("Metal");
	private JButton jbnMotif = new JButton("Motif");
	private JButton jbnWindows = new JButton("Windows");

	public LookAndFeel1() {

	    add(jbmMetal);
	    add(jbnMotif);
	    add(jbnWindows);
	
	    jbmMetal.addActionListener(this);
	    jbnMotif.addActionListener(this);
	    jbnWindows.addActionListener(this);
	}

	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  String laf = "";
		  if (source == jbmMetal)
			  laf = "javax.swing.plaf.metal.MetalLookAndFeel";
		  else if (source == jbnMotif)
			  laf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		  else if (source == jbnWindows)
			  laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		  try {
			  		UIManager.setLookAndFeel(laf); //static method
			  		SwingUtilities.updateComponentTreeUI(this);
		  	  } catch (Exception excep) {
		  	  }
	  }

  public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setTitle("Look and Feel Test");
	    frame.setSize(300, 200);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new LookAndFeel1());
	
	    frame.setVisible(true);
  }
}

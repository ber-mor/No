import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Graphics;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class No extends JFrame{
	private JPanel panel;
	private JCheckBox cb;
	private int x, y, d;

	public No(){
		initComponents();
	}

	private void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setTitle("No");
		setLocationRelativeTo(null);

		panel = new Panel();
		panel.setBackground(Color.white);

		cb = new JCheckBox();
		cb.setBackground(Color.white);

		panel.add(cb);
		add(panel);

		cb.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(cb.isSelected()){
					x=80;
					y=300;
					d=-1;
					cb.setEnabled(false);
				}
			}
		});
	}

	class Panel extends JPanel{
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(x!=0 && y<=300) g.fillOval(x,y,20,20);
			
			if(y==0){
				d=1;
				cb.setSelected(false);
				//cb.setEnabled(true);
			} 
			if(y>300) cb.setEnabled(true);
			y=y+d;

			repaint();
		}
	}

	public static void main(String[] args) {
		new No().setVisible(true);
	}
}
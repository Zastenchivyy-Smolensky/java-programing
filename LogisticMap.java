import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogisticMap extends JFrame implements ActionListener
{
	JButton bt1, bt2, bt3;
	JTextField tfA, tfX0;
	GraphPanel gp;
	int DataNum = 0, DataStep = 0;

	double A=4.0, X0=0.1;
	int frame_width=700, frame_height=500;
	int graph_width=600, graph_height=300;
	double xmin=-0.0, xmax=60.0, ymin=0.0, ymax=1.0;
	double[] range  = { xmin, xmax, ymin, ymax };

	public LogisticMap()
	{
		Container cnt = getContentPane();
		setSize(frame_width, frame_height);
		cnt.add(new JLabel("ロジスティック写像のシミュレーション"), BorderLayout.NORTH);

		JPanel p1 = new JPanel();

		bt1 = new JButton("計算");
		bt1.addActionListener(this);

		bt2 = new JButton("クリア");
		bt2.addActionListener(this);

		bt3 = new JButton("ステップ");
		bt3.addActionListener(this);

		tfA = new JTextField(5);
		tfA.setText(Double.toString(A));

		tfX0 = new JTextField(10);
		tfX0.setText(Double.toString(X0));

		p1.add(bt1); p1.add(bt2);
		p1.add(new JLabel("A=")); p1.add(tfA);
		p1.add(new JLabel("X0=")); p1.add(tfX0);
		p1.add(bt3);
		gp = new GraphPanel(graph_width, graph_height );

		cnt.add(p1,BorderLayout.SOUTH);
		cnt.add(gp,BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		gp.viewPort(10, 10, false, range);
		gp.clearImage();
		gp.drawAxis("step", 5, "Xn", 5);
		gp.repaint();
	}
	public void actionPerformed(ActionEvent e)
	{
		Color[] line = new Color[] {
			Color.red, Color.blue, Color.green, Color.magenta,
			Color.cyan, Color.yellow, Color.orange
		};
		Color[] point = new Color[] {
			Color.green, Color.magenta, Color.cyan, Color.yellow,
			Color.orange, Color.red, Color.blue
		};

		Object o = e.getSource();

		if(o == bt1 || o == bt3){
			double[] t = new double[61];
			double[] x = new double[61];

			double x0 = Double.parseDouble(tfX0.getText());
			double a = Double.parseDouble(tfA.getText());

			if(x0 != X0 || a != A) {
				A = a; X0 = x0;
				DataStep = 0;
				DataNum++;
			}

			x[0] = X0; t[0]=0;
			int num;
			if(o == bt3){
				DataStep++;
				num = DataStep;
				if(num>61) num=61;
			}
			else {
				num = 61;
				DataStep = 0;
			}

			for(int i=1; i<num; i++){
				x[i] = A*x[i-1]*(1-x[i-1]);
				t[i] = i;
			}

			gp.plotData(t,x,num,line[DataNum%7], point[DataNum%7]);
		}
		else if(o == bt2){
			gp.clearImage();
		    gp.drawAxis("step", 5, "Xn", 5);
			DataNum=0;
			DataStep=0;
		}
		gp.repaint();
	}

	public static void main(String args[])
	{
		LogisticMap frm = new LogisticMap();
	}
}

package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Display extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu = new JMenuBar();//�����˵���
	private JMenu m1,m2;//�˵���
	private JMenuItem m3;//�˵�����
	private JButton b[][] = new JButton[4][4];
	private JLabel scorelabel = new JLabel();//���÷�����ǩ
	private JPanel gamepanel = new JPanel();//������Ϸ���
	private JPanel scorepanel = new JPanel();//������������ŷ�����ǩ
	private Box mainbox = Box.createVerticalBox();//������ֱ���Ӳ���
	private Move m = new Move();
	private Font font = new Font("΢���ź�",1,20);//��������
	public static int flag = 0;
	
	public Display() throws InterruptedException {
		gamepanel.setLayout(new GridLayout(4,4,3,3));//����Ϸ������������񲼾�
		scorepanel.setLayout(new BoxLayout(scorepanel,BoxLayout.Y_AXIS));//���ñ�ǩ����ļ�಻Ҫ̫��
		
		m1 = new JMenu("Choice");
		m2 = new JMenu("Help");
		m3 = new JMenuItem("Start");
		m1.add(m3);
		menu.add(m1);
		menu.add(m2);
		
		m.Init(Move.a);
		m.add(Move.a);
		m.print(Move.a);
		
		addKeyListener(new MyKeyListener());//�ڴ�����Ӽ��̼����¼�
		
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++){
				b[i][j] = new JButton();
				if(Move.a[i][j]!=0)
					b[i][j].setText(""+Move.a[i][j]);
				scorelabel.setFont(font);
				scorelabel.setText("Score:"+Move.score);
				b[i][j].setFont(font);//���ð�ť����
				b[i][j].setBackground(Color.gray);//���ð�ť��ɫ
				b[i][j].setRolloverEnabled(false);//ʹ����ƹ��ǲ����б߿�仯
				b[i][j].setEnabled(false);//ʹ��ť������Ӧ
				UIManager.put("Button.disabledText", new Color(0,0,0));//����������ɫ������Ϊ��ť����Ӧ�����
				gamepanel.add(b[i][j]);
			}
		
		scorepanel.add(scorelabel);
		mainbox.add(scorepanel);
		mainbox.add(gamepanel);
		add(mainbox);
		setTitle("2048");
		setJMenuBar(menu);
		setSize(400,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);//���ڲ�������
		setVisible(true);
		
		displayOnDesktopCenter(this);
		
		while(!m.Isend(Move.a)){
			if(flag==1){
				if(Move.ismo==1)
					m.add(Move.a);
			m.print(Move.a);
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++){
					if(Move.a[i][j]!=0)
						b[i][j].setText(""+Move.a[i][j]);
					else
						b[i][j].setText("");
					scorelabel.setText("Score:"+Move.score);
				}
			flag=0;
			}
			
		}
	}
	//������ʾ
	public void displayOnDesktopCenter(JFrame frame){
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension dim=toolkit.getScreenSize();
		int screenWidth=dim.width;
		int screenHeight=dim.height;
		int w=frame.getWidth();
		int h=frame.getHeight();
		int x=(screenWidth-w)/2;
		int y=(screenHeight-h)/2;
		frame.setLocation(x,y);
	}
}

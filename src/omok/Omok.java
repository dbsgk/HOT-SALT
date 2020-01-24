package omok;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Omok extends JFrame implements MouseListener, MouseMotionListener{
	
	private ImageIcon icon;
	private Image img;
	private Image imgB = Toolkit.getDefaultToolkit().getImage("검돌.png");
	private Image imgW = Toolkit.getDefaultToolkit().getImage("흰돌.png");
	private List<OmokDTO> list = new ArrayList<OmokDTO>();//1인분
	private OmokMap[][] mapList = new OmokMap[19][19]; //좌표 배열
	private boolean bb = false; //바둑돌 색
	private boolean win = false; //true = 승
	
	//밑으로 내리세요.
	private int x = 0;
	private int y = 0;
	
	public void OmokSet() {
		int mx = 35;
		int my = 53;
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				mapList[i][j] = new OmokMap(mx,my,i,j);
				System.out.println(mx+":"+my+" "+i+":"+j);
				if(j%2==0)mx+=44;
				else if(j%2!=0)mx+=43;
			}
			mx =35;
			my+=44;
		}
	}
	public Omok(){
		
		OmokSet();
		icon = new ImageIcon("omok.jpg");
		JPanel jP = new JPanel();
		JLabel background = new JLabel();
		
		img = icon.getImage().getScaledInstance(850, 850, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		background.setIcon(icon);
		background.setSize(new Dimension(300,500));
		background.setVisible(true);

		add(jP);
		jP.setLayout(new BorderLayout(0,0));
		jP.add(background);
		
		jP.setBackground(Color.BLACK);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		setBounds(400,50,853,877);
		setResizable(false);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		for(OmokDTO dto : list) {//이전에 그린 바둑돌들
			if(dto.isBb()==true) {
				g.drawImage(imgW, dto.getX()-20, dto.getY()-20, 40,40,this);
			}else if(dto.isBb()==false) {
				g.drawImage(imgB, dto.getX()-20, dto.getY()-20, 40,40,this);
			}
		}
	}

	public static void main(String[] args) {
		new Omok();

	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void update(Graphics g) {
//		repaint();
		//super.update(g);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(bb) { //흑돌 백돌 체인지
			bb=false;
		} else if(!bb) {
			bb=true;
		}
		OmokDTO dto = new OmokDTO();
		int x = 0, y = 0;
		for(int i = 0; i < mapList.length; i++) {
			if (mapList[0][i].getMapX() + 18 > e.getX()) {
				x = mapList[0][i].getMapX(); //좌표값이 고정으로 잡혀있어서.
				//System.out.println(mapList[0][i].getMapX()); 
				break;
			} 
		}
		
		for(int i = 0; i < mapList.length; i++) {
			if (mapList[i][0].getMapY() + 18 > e.getY()) {
				y = mapList[i][0].getMapY();
//				System.out.println(mapList[i][0].getMapY());
				break;
			} 
		}
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(mapList[i][j].getMapX() == x && mapList[i][j].getMapY() == y) {
					dto.setIndexX(i);
					dto.setIndexY(j);
				}
			}
		}
		
		System.out.println(x); System.out.println(y);
		dto.setX(x);
		dto.setY(y);
//		dto.setX(e.getX());
//		dto.setY(e.getY());
		dto.setBb(!bb);
//		dto.setCommand(OmokImage.);
		for(OmokDTO data : list) {//이전에 그린 바둑돌들
			if(data.getX()==x && data.getY()==y) {
				if(bb) { //흑돌 백돌 체인지
					bb=false;
				} else if(!bb) {
					bb=true;
				}
				JOptionPane.showMessageDialog(this, "이미 돌이 놓여있습니다.");
				return;
			} 
		}
		list.add(dto);
		winCheck(x,y);
		//System.out.println(e.getX() +" : "+e.getY());
		
		
		repaint();
		if(win)JOptionPane.showMessageDialog(this, "승리");	
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void winCheck(int x, int y) {

		int count=0;
		ArrayList<Integer> checkX = new ArrayList<Integer>();
		ArrayList<Integer> checkY = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			
		}//for
	}//winCheck

}//class

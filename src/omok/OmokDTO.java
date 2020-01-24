package omok;

import java.awt.Image;



public class OmokDTO {
	private int x,y;
	private boolean bb;//false = Èæ
	private int indexX, indexY; //ÀÌ°Ç ÁÂÇ¥ ÀÎµ¦½º °ª.
	
	public int getIndexX() {
		return indexX;
	}

	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}

	public int getIndexY() {
		return indexY;
	}

	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}

	public boolean isBb() {
		return bb;
	}

	public void setBb(boolean bb) {
		this.bb = bb;
	}

	public OmokDTO(){
		
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}

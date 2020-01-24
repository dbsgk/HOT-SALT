package omok;
//¹ÙµÏÆÇ ÁÂÇ¥À§Ä¡

public class OmokMap {
	int mapX;
	int mapY;
	int indexX, indexY;
	
	public OmokMap(int mapX, int mapY, int indexX, int indexY) {
		super();
		this.mapX = mapX;
		this.mapY = mapY;
		this.indexX = indexX;
		this.indexY = indexY;
	}

	public int getMapX() {
		return mapX;
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public int getMapY() {
		return mapY;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}

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
	

}

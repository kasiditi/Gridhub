package stage;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import stage.gameobj.FloorPiece;
import stage.gameobj.IDrawable;

/**
 * This class represents the floorLevel (Z value) for each Scene or Stage
 * 
 * 
 * @author Thanat Jatuphattharachat
 *
 */

public class FloorLevel {

	private int[][] floorLevelMap;
	private int sizeX;
	private int sizeY;

	/**
	 * Get size of map in x-axis.
	 * 
	 * @return Integer representing size of map in x-axis.
	 */
	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Get size of map in y-axis.
	 * 
	 * @return Integer representing size of map in y-axis.
	 */
	public int getSizeY() {
		return sizeY;
	}

	/**
	 * Instantiate the new FloorLevel Object.
	 * 
	 * @param gridSizeX
	 *            the size of map in x-axis
	 * @param gridSizeY
	 *            the size of map in y-axis
	 */
	public FloorLevel(int gridSizeX, int gridSizeY) {
		floorLevelMap = new int[gridSizeX][gridSizeY];
		sizeX = gridSizeX;
		sizeY = gridSizeY;
	}

	public List<FloorPiece> getFloorPieces() {
		ArrayList<FloorPiece> pieceList = new ArrayList<>(); 
		
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				pieceList.add(new FloorPiece(i, j, getZValueFromXY(i, j)));
			}
		}
		
		return pieceList;
	}

	public int[][] getFloorMap() {
		return floorLevelMap;
	}

	public int getZValueFromXY(int x, int y) {
		if (x >= floorLevelMap.length || x < 0 || y >= floorLevelMap[0].length || y < 0)
			return 0;
		return floorLevelMap[x][y];
	}

	public void setZValue(int x, int y, int z) {
		if (x > sizeX-1 || x < 0 || y > sizeY-1 || y < 0 || z < 0)
			return;
		else
			floorLevelMap[x][y] = z;
	}

	public boolean isOutOfMap(int x, int y) {
		return x > sizeX-1 || x < 0 || y > sizeY-1 || y < 0;
	}

}

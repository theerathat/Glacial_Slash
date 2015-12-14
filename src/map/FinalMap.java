package map;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.InputStream;

import res.Resource;

public class FinalMap extends GameMap {
	
	private CheckPoint finalCheckPoint;
	private boolean isWin;

	public FinalMap() {
		super(Resource.finalMap);
		finalCheckPoint = checkPoints[checkPoints.length-1];
		isWin = false;
	}
	
	@Override
	public void render(Graphics2D g) {
		super.render(g);
	}
		
	public void renderTheEndContent(Graphics2D g) {
		if (isWin)
			g.drawImage(Resource.theEndContent, null, 0, 0);
	}

	@Override
	public void collideCheckPoints(Rectangle collisionBox) {
		super.collideCheckPoints(collisionBox);
		if (finalCheckPoint.getBoundaries().intersects(collisionBox))
			isWin = true;
	}

}
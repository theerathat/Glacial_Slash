package res;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Resource {

	public static BufferedImage playerIdleSprite;
	public static BufferedImage tileGround, tileLeft, tileRight, tileMid, tileTop, tileTopLeft, tileTopRight, tileIce;
	public static BufferedImage checkpoint;
	public static BufferedImage[] mana = new BufferedImage[21], maxMana = new BufferedImage[21];
	public static BufferedImage slash;
	public static BufferedImage doubleJump, glacialDrift, iceSummon, skyUppercut, concentration;
	public static BufferedImage[] standSprite = new BufferedImage[2];
	public static BufferedImage[][] jumpSprite = new BufferedImage[2][12];
	public static BufferedImage[][] walkSprite = new BufferedImage[2][30];
	public static BufferedImage[][] cutSprite = new BufferedImage[2][27];
	public static BufferedImage[][] dashSprite = new BufferedImage[2][16];
	public static BufferedImage[][] iceSummonSprite = new BufferedImage[2][54];
	public static BufferedImage[] cardAnimation = new BufferedImage[12];

	public static InputStream emptyMap, testMap, bigMap, tutorialMap;

	private static ClassLoader loader = Resource.class.getClassLoader();

	static {

		try {
			playerIdleSprite = ImageIO.read(loader.getResource("res/sprite/player.png"));
		} catch (IOException e) {
			playerIdleSprite = null;
		}
		// Load tileset ..
		try {
			tileGround = ImageIO.read(loader.getResource("res/tile/tile_ground.png"));
		} catch (IOException e) {
			tileGround = null;
		}
		try {
			tileLeft = ImageIO.read(loader.getResource("res/tile/tile_left.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileLeft = null;
		}
		try {
			tileRight = ImageIO.read(loader.getResource("res/tile/tile_right.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileRight = null;
		}
		try {
			tileMid = ImageIO.read(loader.getResource("res/tile/tile_mid.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileMid = null;
		}
		try {
			tileTop = ImageIO.read(loader.getResource("res/tile/tile_top.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileTop = null;
		}
		try {
			tileIce = ImageIO.read(loader.getResource("res/tile/tile_ice.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			tileIce = null;
		}
		try {
			checkpoint = ImageIO.read(loader.getResource("res/tile/checkpoint.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			checkpoint = null;
		}
		try {
			tileTopLeft = ImageIO.read(loader.getResource("res/tile/tile_topleft.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileTopLeft = null;
		}
		try {
			tileTopRight = ImageIO.read(loader.getResource("res/tile/tile_topright.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileTopRight = null;
		}

		// Load mana,maxMana and slash
		for (int i = 0; i <= 20; i++) {
			try {
				mana[i] = ImageIO.read(loader.getResource("res/mana/" + i + ".png"));
			} catch (IOException e) {
				mana[i] = null;
			}
		}
		for (int i = 0; i <= 20; i++) {
			try {
				maxMana[i] = ImageIO.read(loader.getResource("res/mana/m" + i + ".png"));
			} catch (IOException e) {
				maxMana[i] = null;
			}
		}
		try {
			slash = ImageIO.read(loader.getResource("res/mana/slash.png"));
		} catch (IOException e) {
			slash = null;
		}

		try {
			doubleJump = ImageIO.read(loader.getResource("res/card/DoubleJump.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			doubleJump = null;
		}
		try {
			glacialDrift = ImageIO.read(loader.getResource("res/card/GlacialDrift.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			glacialDrift = null;
		}
		try {
			iceSummon = ImageIO.read(loader.getResource("res/card/IceSummon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			iceSummon = null;
		}
		try {
			skyUppercut = ImageIO.read(loader.getResource("res/card/SkyUppercut.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			skyUppercut = null;
		}

		try {
			concentration = ImageIO.read(loader.getResource("res/card/Concentration.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			concentration = null;
		}
		// Load sprite
		try {
			standSprite[0] = ImageIO.read(loader.getResource("res/sprite/stand/stl0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			standSprite[0] = null;
		}
		try {
			standSprite[1] = ImageIO.read(loader.getResource("res/sprite/stand/str0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			standSprite[1] = null;
		}
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 11; j++) {
				try {
					jumpSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/jump/j" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					jumpSprite[i][j] = null;
				}
			}
		}

		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 29; j++) {
				try {
					walkSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/walk/w" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					walkSprite[i][j] = null;
				}
			}
		}
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 26; j++) {
				try {
					cutSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/cut/c" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					cutSprite[i][j] = null;
				}
			}
		}
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 7; j++) {
				try {
					dashSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/dash/d" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					dashSprite[i][j] = null;
				}
			}
		}

		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 26; j++) {
				try {
					iceSummonSprite[i][j] = ImageIO
							.read(loader.getResource("res/sprite/icesummon/i" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					iceSummonSprite[i][j] = null;
				}
			}
		}

		for (int i = 0; i <= 11; i++) {
			try {
				cardAnimation[i] = ImageIO.read(loader.getResource("res/sprite/card/animation/card_" + i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				cardAnimation = null;
			}
		}

		emptyMap = loader.getResourceAsStream("res/map/emptyMap.map");
		testMap = loader.getResourceAsStream("res/map/testMap.map");
		bigMap = loader.getResourceAsStream("res/map/bigMap.map");
		tutorialMap = loader.getResourceAsStream("res/map/tutorialMap.map");

	}

}

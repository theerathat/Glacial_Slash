package player;

import java.awt.Graphics2D;

import exception.SkillCardUnusableException;

public class SkyUppercut extends SkillCard {

	public SkyUppercut() {
		cost = 2;
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void activate() throws SkillCardUnusableException {
		// TODO Auto-generated method stub
		if (!PlayerStatus.getPlayer().getPlayerCharacter().isOnGround()) throw new SkillCardUnusableException(SkillCardUnusableException.UnusableType.ACTIVATE_CONDITION_NOT_MET);
		playActivateAnimation();
		PlayerStatus.getPlayer().getPlayerCharacter().performSkyUpperCut();
	}

}

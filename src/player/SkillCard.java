/*
 * Abstract class representing every kind of cards
 */

package player;

import java.awt.Graphics2D;
import java.awt.Image;

import exception.SkillCardUnusableException;
import render.Renderable;

public abstract class SkillCard implements Renderable, Comparable<SkillCard> {

	protected int cost;
	protected int[] command; // maybe hardcode the command to player
	protected Image cardImage;
	private int x;
	
	public abstract void activate() throws SkillCardUnusableException;
	
	public static final SkillCard createSkillCard(String name) {
		// TODO create new SkillCard from its name
		switch (name) {
		case "Sky Uppercut": return new SkyUppercut();
		case "Double Jump": return new DoubleJump();
		case "Glacial Drift": return new GlacialDrift();
		default: return null;
		}
	}
	
	public void playActivateAnimation() {
		// TODO play activate animation
	}
	
	@Override
	public int compareTo(SkillCard other) {
		int costCompare = Integer.compare(this.cost, other.cost);
		if (costCompare == 0)
			return this.getClass().getSimpleName().compareToIgnoreCase(other.getClass().getSimpleName());
		else
			return costCompare;
	}
	
	public void render(Graphics2D g, int index) {
		x = 10 + 180*index;
		render(g);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(cardImage, x, 430, null);
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}
	
	@Override
	public int getZ() {
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getClass().getSimpleName().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillCard other = (SkillCard) obj;
		return this.getClass().getSimpleName().equals(other.getClass().getSimpleName());
	}

}
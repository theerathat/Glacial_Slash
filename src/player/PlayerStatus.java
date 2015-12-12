/*
 * The physical player playing the game
 * Shows the status on the screen, such as mana and hand
 */

package player;

import java.util.List;

import entity.map.GameMap;
import exception.SkillCardUnusableException;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import render.Renderable;
import res.Resource;

public class PlayerStatus implements Renderable {
	
	private static PlayerStatus player;
	private int currentMana, maxMana;
	private List<SkillCard> hand;
	private GameMap currentMap;
	private PlayerCharacter playerCharacter;
	
	public static synchronized PlayerStatus newPlayer() {
		player = new PlayerStatus();
		return player;
	}
	
	public static synchronized void loadPlayer(PlayerStatus player) {
		PlayerStatus.player = player;
	}
	
	public static synchronized PlayerStatus getPlayer() {
		if (player == null)
			player = newPlayer();
		return player;
	}

	private PlayerStatus() {
		// Mana debug
		maxMana = 10;
		currentMana = 10;
		hand = new ArrayList<SkillCard>();
		currentMap = new GameMap(Resource.tutorialMap);
		playerCharacter = new PlayerCharacter();
		
		// Debug
		addCard(SkillCard.createSkillCard("Sky Uppercut"));
		addCard(SkillCard.createSkillCard("Double Jump"));
		addCard(SkillCard.createSkillCard("Glacial Drift"));
		addCard(SkillCard.createSkillCard("Ice Summon"));
		addCard(SkillCard.createSkillCard("Ice Summon"));
		addCard(SkillCard.createSkillCard("Ice Summon"));
		addCard(SkillCard.createSkillCard("Concentration 2 S D"));

	}
	
	public PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}
	
	public int getCurrentMana() {
		return currentMana;
	}
	
	public int getMaxMana() {
		return maxMana;
	}
	
	public void chargeMana(SkillCard charged) {
		if (hand.remove(charged)) {
			maxMana++;
			currentMana++;
		}
	}
	
	public List<SkillCard> getHand() {
		return hand;
	}
	
	public void addCard(SkillCard skillCard) {
		hand.add(skillCard);
		Collections.sort(hand);
	}
	
	public void useCard(SkillCard used) throws SkillCardUnusableException {
		try {
			SkillCard using = hand.get(hand.indexOf(used));
			if (currentMana >= using.cost) {
				using.activate();
				currentMana -= using.cost;
				hand.remove(using);
			}
			else throw new SkillCardUnusableException(SkillCardUnusableException.UnusableType.NOT_ENOUGH_MANA);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new SkillCardUnusableException(SkillCardUnusableException.UnusableType.NO_SUCH_CARD_IN_HAND);
		}
	}
	
	public GameMap getCurrentMap() {
		return currentMap;
	}

	@Override
	public void render(Graphics2D g) {
		// render mana
		g.drawImage(Resource.mana[currentMana], null, 20, 20);
		g.drawImage(Resource.slash, null, 80, 20);
		g.drawImage(Resource.maxMana[maxMana], null, 130, 50);
		
		// render cards in hand
		synchronized (hand) {
			int n = hand.size();
			for (int i = 0; i < n; i++) {
				hand.get(i).render(g, i);
			}
		}
	}

}

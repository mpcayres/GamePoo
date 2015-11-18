package unb.cic.poo.game2d.fases;

import java.util.LinkedList;

import unb.cic.poo.game2d.GameManager;
import unb.cic.poo.game2d.waves.Wave;

public class Fase{
	protected LinkedList<Wave> waves;
	protected boolean faseFinished;
	protected FaseHandler handler;
	
	public Fase(LinkedList<Wave> waves){
		this.waves = waves;
		faseFinished = false;
	}

	public LinkedList<Wave> getWaves() {
		return waves;
	}

	public void setWaves(LinkedList<Wave> waves) {
		this.waves = waves;
	}
	
	public Wave getCurrentWave(){
		return waves.isEmpty() ? null : waves.getFirst();
	}
	
	public Wave nextWave(){
		waves.removeFirst();
		return waves.isEmpty() ? null : waves.getFirst();
	}

	public void setFase() {
		this.waves.get(0).setWave();
	}

	public boolean isFaseFinished() {
		return faseFinished;
	}

	public void setFaseFinished(boolean faseFinished) {
		this.faseFinished = faseFinished;
	}
	
	public void start(){
		waves.getFirst().setWave();
		handler = new FaseHandler(this);
		GameManager.getInstance().getGameScene().registerUpdateHandler(handler);
	}
}
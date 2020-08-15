package fr.namu.bs.runnable;

import org.bukkit.scheduler.BukkitRunnable;

import fr.namu.bs.MainBS;
import fr.namu.bs.enumbs.StateBS;

public class BlockRun extends BukkitRunnable {

	private MainBS main;
	
	public BlockRun(MainBS main) {
		this.main = main;
	}

	
	public void run() {
		this.main.timer.resetTimer();
		if(this.main.isState(StateBS.GAME)) {
			this.main.bloc.BlockSelect();
		}
	}
}

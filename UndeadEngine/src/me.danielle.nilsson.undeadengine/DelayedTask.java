package me.danielle.nilsson.undeadengine;

import java.util.ArrayList;
import java.util.List;

public abstract class DelayedTask implements Runnable {

	private long runTime;
	private int maxRepeats = 1;
	private int currentRepeat=0;
	private long delayBetweenRepeats = 0;
	private static List<DelayedTask> taskList = new ArrayList<>();

	/**
	 *  Registers the delayed task to run.
	 * @param delay
	 * @return
	 */
	public DelayedTask runTaskLater(long delay){
		this.runTime = System.currentTimeMillis()+delay;
		taskList.add(this);
		return this;
	}

	/**
	 * Registers the delayed task to run.
	 *
	 * @param initialDelay
	 * @param delayBetweenRepeats
	 * @param maxRepeats
	 * @return
	 */
	public DelayedTask runTaskRepeatedly(long initialDelay, long delayBetweenRepeats, int maxRepeats){
		this.maxRepeats = maxRepeats;
		this.delayBetweenRepeats = delayBetweenRepeats;
		return runTaskLater(initialDelay);
	}

	public static void tickDelayedTasks(){
		if(taskList.size()!=0)
		for(DelayedTask tasks : new ArrayList<>(taskList)){
			if(tasks.runTime <= System.currentTimeMillis()){
				tasks.run();
				tasks.currentRepeat++;
				if(tasks.currentRepeat >= tasks.maxRepeats){
					taskList.remove(tasks);
				}else{
					tasks.runTime += tasks.delayBetweenRepeats;
				}
			}
		}
	}
}

package threads;

import java.util.ArrayList;

public class Producer extends Thread{
	//Producer fills data in the queue
	ArrayList<Integer> queueList;
	int index;
	
	Producer() {
		index =0;
		queueList = new ArrayList<Integer>();
	}
	
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void insert(int value) {
		if(queueList.size()<20) {
			queueList.add(value);
			System.out.println(value+ " enqueued");
		}else {
			System.out.println("Waiting for consumer...");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Producer interrupted");
		}
	}

	public void produce() throws InterruptedException {
		int value =0;
		while(true) {
				insert(value++);
		}
	}

}

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
		queueList.add(value);
		System.out.println(value+ " enqueued");
	}

	public void produce() throws InterruptedException {
		// TODO Auto-generated method stub
		int value =0;
		while(true) {
			synchronized(this) {
				//Producer cannot fill the queue if it is full
				while(queueList.size()==10) {
						wait();
				}
				insert(value++);
				notify();
			}
		}
	}

}

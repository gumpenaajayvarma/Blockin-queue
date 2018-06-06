package threads;

public class Consumer extends Thread{
	Producer produce;
	
	Consumer(Producer produce){
		this.produce = produce;
	}
	
	public void run(){
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void consume() throws InterruptedException {
		while(true) {
			dequeue();
			
		}
	}

	private void dequeue() {
		int dequedElement;
		if(!produce.queueList.isEmpty()) {
			dequedElement = produce.queueList.remove(0);
			System.out.println(dequedElement+" dequeued");
		}else {
			System.out.println("Waiting for producer...");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread interrupted");
		}
	}
}

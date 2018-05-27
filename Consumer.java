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
			synchronized(this) {
				while(produce.queueList.isEmpty()) {
					wait();
				}
				
				dequeue();
				
				notify();
			}
		}
	}

	private void dequeue() {
		int dequedElement = produce.queueList.remove(0);
		System.out.println(dequedElement+" dequeued");
	}
}

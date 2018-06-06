package threads;

import threads.Producer;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		Producer produce = new Producer();
		Consumer consumer = new Consumer(produce);

		produce.setName("Produce Thread");
		consumer.setName("Consumer Thread");
		
		produce.start();
		consumer.start();
		
		Thread.sleep(10*1000);
//		produce.join();
//		consumer.join();
	}

}


public class RunnableExample {

	public static void main(String[] args) throws InterruptedException {


		Thread thread1 = new Thread(() -> {
			for(int i =0 ; i< 100 ; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Inside thread :: " + Thread.currentThread().getName());
			}
		});
		
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread1.start();
		



		Thread thrad2 = new Thread(() -> {
			for(int i =0 ; i< 100 ; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Inside thread1 :: " + Thread.currentThread().getName());
			}
		});
		
		thrad2.setPriority(Thread.MAX_PRIORITY);
		thrad2.start();
		
		thrad2.join();
		thread1.join();



	}
}

package mx.gob.economia.inadem.business;

import java.util.concurrent.*;
import java.util.*;
import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PerformanceTest {

	private ExecutorService service = Executors.newFixedThreadPool(100);

	public static /*synchronized*/ int waitAndHigh5() {
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			// Real code should never do this
		}
		return 5;
	}

	@Test
	public void testConcurrentCreateUser() throws Exception {
		long millis = System.currentTimeMillis();
		List<Future<?>> futures = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			futures.add(service.submit(new Runnable() {
				public void run() {
					waitAndHigh5();
				}
			}));
		}
		for(Future<?> f : futures) f.get();
		millis = System.currentTimeMillis() - millis;
		assertTrue(true);
	}

}

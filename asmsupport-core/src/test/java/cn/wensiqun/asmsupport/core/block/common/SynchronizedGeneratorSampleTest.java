package cn.wensiqun.asmsupport.core.block.common;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class SynchronizedGeneratorSampleTest {

	private Object lock = new Object();
	
	public List<Integer> list = new ArrayList<>();
	
	public void syncThis() {
		synchronized (this) {
			int i=0;
			while(i<10) {
				list.add(i);
				i++;
			}
		}
	}
	
	public void syncLock() {
		synchronized (lock) {
			int i=0;
			while(i<10) {
				list.add(i);
				i++;
			}
		}
	}
}

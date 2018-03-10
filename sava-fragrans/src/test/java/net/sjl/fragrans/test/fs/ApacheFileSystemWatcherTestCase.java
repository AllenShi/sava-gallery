package net.sjl.fragrans.test.fs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;

import net.sjl.fragrans.fs.ApacheFileSystemWatcher;

public class ApacheFileSystemWatcherTestCase {
	
	@Test
	public void testFileCreationMonitor() throws IOException {
		ApacheFileSystemWatcher watcher = new ApacheFileSystemWatcher();
		File target = new File("/opt/ibm/ecc/ecm_staging_deploy/cfg");
		try {
			watcher.watchDir(target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000*60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

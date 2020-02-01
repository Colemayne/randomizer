package com.coleman.randomizer;

import com.coleman.randomizer.domain.WorkerThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class RandomizerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RandomizerApplication.class, args);

        WorkerThread workerThread1 = new WorkerThread("worker 1");
        WorkerThread workerThread2 = new WorkerThread("worker 2");
        WorkerThread workerThread3 = new WorkerThread("worker 3");
        WorkerThread workerThread4 = new WorkerThread("worker 4");
        WorkerThread workerThread5 = new WorkerThread("worker 5");

        workerThread1.start();
        workerThread2.start();
        workerThread3.start();
        workerThread4.start();
        workerThread5.start();
    }
}

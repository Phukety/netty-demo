package com.phukety.netty;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        ScheduledFuture<String> future = service.schedule(Executors.callable(() -> System.out.println(1), "success"), 3, TimeUnit.SECONDS);
        service.shutdownNow();
        System.out.println(service.isShutdown());
        System.out.println(future.get());
    }
}

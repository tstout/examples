package guava.examples.futures;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.google.common.collect.Lists.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class FutureListTest {

    private ExecutorService executor = Executors.newCachedThreadPool();
    private ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);

    @Test
    public void listTest() throws ExecutionException, InterruptedException {
        List<ListenableFuture<Integer>> futureTasks = newArrayList();

        futureTasks.add(getFuture(1));
        futureTasks.add(getFuture(2));
        futureTasks.add(getFuture(3));

        ListenableFuture<List<Integer>> futures = Futures.allAsList(futureTasks);
        Futures.addCallback(futures, new Callback(), executor);

        List<Integer> results = futures.get();

        assertThat(results.size(), is(3));
        assertThat(results.get(0), is(1));
        assertThat(results.get(1), is(2));
        assertThat(results.get(2), is(3));

    }

    <T> ListenableFuture<T> getFuture(final T futureValue) {
        return executorService.submit(new Callable<T>() {
            public T call() {
                return futureValue;
            }
        });
    }

    class Callback implements FutureCallback<List<Integer>> {

        @Override
        public void onSuccess(List<Integer> result) {
        }

        @Override
        public void onFailure(Throwable t) {
        }
    }
}

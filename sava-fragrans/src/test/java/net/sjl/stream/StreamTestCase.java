package net.sjl.stream;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.*;
import static org.junit.Assert.*;

public class StreamTestCase {

  @Test
  public void testParallelFilterMap() {

    Arrays.asList("a1", "a2", "b1", "c2", "c1")
    .parallelStream()
    .filter(s -> {
        System.out.format("filter: %s [%s]\n",
            s, Thread.currentThread().getName());
        return true;
    })
    .map(s -> {
        System.out.format("map: %s [%s]\n",
            s, Thread.currentThread().getName());
        return s.toUpperCase();
    })
    .forEach(s -> System.out.format("forEach: %s [%s]\n",
        s, Thread.currentThread().getName()));
  }

  @Test
  public void testReduceSumInSequence() {
    int totalSum = Stream.of(1, 2, 3, 4, 5, 6)
    .reduce(0, 
       (sum, p) -> {
         System.out.format("accumulator: sum=%s, p=%s [%s]\n",
           sum, p, Thread.currentThread().getName());
         return sum += p;
       },
       (sum1, sum2) -> {
         System.out.format("combiner: sum1=%s, sum2=%s [%s]\n",
           sum1, sum2, Thread.currentThread().getName());
         return sum1 + sum2;
       });
    assertEquals(21, totalSum); 
  }

  @Test
  public void testReduceSumInParallel() {
    int totalSum = Stream.of(1, 2, 3, 4, 5, 6).parallel()
    .reduce(0, 
       (sum, p) -> {
         System.out.format("accumulator: sum=%s, p=%s [%s]\n",
           sum, p, Thread.currentThread().getName());
         return sum += p;
       },
       (sum1, sum2) -> {
         System.out.format("combiner: sum1=%s, sum2=%s [%s]\n",
           sum1, sum2, Thread.currentThread().getName());
         return sum1 + sum2;
       });
    assertEquals(21, totalSum); 
  }
}

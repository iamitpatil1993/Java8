package com.example.forkjoin;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrallelisamTricks {

	static {
//		System.out.println("free Memory :: " + Runtime.getRuntime().freeMemory() / (1024 * 1024));
//		System.out.println("total Memory :: " + Runtime.getRuntime().totalMemory() / (1024 * 1024));
//		System.out.println("max Memory :: " + Runtime.getRuntime().maxMemory() / (1024 * 1024));
//		System.out.println("available logical processors :: " + Runtime.getRuntime().availableProcessors());
//		System.out.println(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
//		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
//		System.out.println(System.getProperties().getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
//	
		}

	public static void main(String[] args) {
		System.out.println("Fastest time iterative is :: " + measureSumPerformance(PrallelisamTricks::iterative, 10000000) + " msecs");;
		System.out.println("Fastest time sequential is :: " + measureSumPerformance(PrallelisamTricks::sequential, 10000000) + " msecs");;
		System.out.println("Fastest time sequential is :: " + measureSumPerformance(PrallelisamTricks::parallel, 10000000) + " msecs");;
		
		System.out.println("\n\n\t\t using long stream \n\n");
		System.out.println("Fastest time iterative is :: " + measureSumPerformance(PrallelisamTricks::iterative, 10000000) + " msecs");;
		System.out.println("Fastest time sequential is :: " + measureSumPerformance(PrallelisamTricks::sequentialLongRange, 10000000) + " msecs");;
		System.out.println("Fastest time sequential is :: " + measureSumPerformance(PrallelisamTricks::parallelLongRange, 10000000) + " msecs");;
		
	}

	public static long iterative(long no) {

		long sum = 0;
		for (long i = 1; i <= no; i++) {
			sum += i;
		}
		return sum;
	}
	
	
	public static long sequential(long number) {
		// We can use collector as well to sum the numbers
		//return Stream.iterate(1, no -> no + 1).limit(number).collect(Collectors.summingInt(no -> no));
		 return Stream.iterate(1, no -> no + 1).limit(number).reduce(0, (no1, no2) -> no1 + no2);
		
	}
	
	public static long parallel(long number) {
		return Stream.iterate(0, no -> no + 1).limit(number).parallel().reduce(0, (no1, no2) -> no1 + no2);
	}
	
	public static long sequentialLongRange(long number) {
		return LongStream.range(0, number).sum();
	}
	
	public static long parallelLongRange(long number) {
		return LongStream.rangeClosed(0, number).parallel().sum();
	}


	public static long measureSumPerformance(Function<Long, Long> function, long no) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = function.apply(no);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}
}

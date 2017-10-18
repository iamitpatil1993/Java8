package com.example.forkjoin;

import java.util.stream.LongStream;

public class ParallizationTrickUsingAccumulator {

	public static void main(String[] args) {
		
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, 10000).forEach(accumulator::add);
		System.out.println("Sequential Sum :: " + accumulator.getTotal());
		
		Accumulator accumulatorParallel = new Accumulator();
		LongStream.rangeClosed(1, 10000).parallel().forEach(accumulatorParallel::add);
		System.out.println("Parallel Sum(Will be wrong) :: " + accumulatorParallel.getTotal());
		
	/*	Notes
		1. This is why we should consider using parallel stream very carefully.
		2. We should always first do operation sequentially and then parallelly and then compare correctness of result in parallel
		   case before considering or comparing performance. 
	
	Reason for above wrong result in case of parallel processing
	--> 1. This is caused by the fact that multiple threads are concurrently accessing the accumulator and
		   in particular executing total += value, which, despite its appearance, isn’t an atomic operation.
		2. The origin of the problem is that the method invoked inside the forEach block has the side effect
			of changing the mutable state of an object shared among multiple threads. It’s mandatory to
			avoid these kinds of situations if you want to use parallel Streams without incurring similar bad
			surprises.   
	*/}
	
}

class Accumulator {
	private long total = 0;
	
	public void add (long no) {
		total += no;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}

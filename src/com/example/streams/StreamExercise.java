package com.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExercise {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1.
		List<Transaction> ans1 = transactions.stream().filter(transaction -> 2011 == transaction.getYear())
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toCollection(ArrayList::new));

		System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high).");
		ans1.forEach(System.out::println);

		// 2.
		List<String> ans2 = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct()
				.collect(Collectors.toCollection(ArrayList::new));

		System.out.println("\n\n2. What are all the unique cities where the tradtrers work?");
		ans2.forEach(System.out::println);

		// 3.
		List<Trader> ans3 = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());

		System.out.println("\n\n3. Find all traders from Cambridge and sort them by name.");
		ans3.forEach(System.out::println);

		// 4.
		String ans4 = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().reduce("",
				(identity, traderName) -> identity.concat(traderName + " "));

		System.out.println("\n\n4. Return a string of all traders’ names sorted alphabetically.");
		System.out.println(ans4);

		// 5.
		boolean ans5 = transactions.stream().map(Transaction::getTrader)
				.anyMatch(trader -> "Milan".equalsIgnoreCase(trader.getCity()));

		System.out.println("\n\n5. Are any traders based in Milan?");
		System.out.println(ans5 ? "YES" : "NO");

		// 6.
		System.out.println("\n\n6. Print all transactions’ values from the traders living in Cambridge.");
		transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
				.forEach(transaction -> System.out.println(transaction.getValue()));

		// 7.
		Integer ans7 = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);

		System.out.println("\n\n7. What’s the highest value of all the transactions?");
		System.out.println(ans7);

		// 7.
		Optional<Integer> ans8 = transactions.stream().map(Transaction::getValue).reduce(Integer::min);

		System.out.println("\n\n8. Find the transaction with the smallest value");
		if (ans8.isPresent()) {
			System.out.println(ans8.get());
		} else
			System.out.println("NA");

		// Collectoes.toList(), Collectors.toSet(), Collectos.toMap() these
		// method returns arbitrary type of collection interface implementation.
		// Like in case of list, it mauy return ArrayList, LinkedLit etc. In
		// case of set it may return HashSet, TreeSet, LinkedHashSet.
		// So, if we are ok with this arbitary implementation then it's ok and
		// we can use above listed api to collect data into collection.
		// but if we want particular implementation in taht case we will have to
		// use toCollection() method with supplier that will return
		// collection implementation of desired type.
		// We can use Constructor reference as well as a lambda to supplier
		// functional interface, since Supplier functional interfacce's
		// functtional
		// interface is get() method, so that colleciton implementation must
		// have constructor that matches this method defination.
	}
}

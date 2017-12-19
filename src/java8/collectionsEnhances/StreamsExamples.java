package java8.collectionsEnhances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsExamples {
	public static void main(String[] args) {
		
		List<Personn> persons = Arrays.asList(new Personn("Max", 18), new Personn("Peter", 23), new Personn("Pamela", 23), new Personn("David", 12));

		//
		//
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList
		    .stream()
		    .filter(s -> s.startsWith("c"))
		    .map(String::toUpperCase)
		    .sorted()
		    .forEach(System.out::println);
		
		//
		// Collect
		// Collect is an extremely useful terminal operation to transform the elements of the stream into a different kind of result, e.g. a List, Set or Map.		
		collectorsGroupingBy(persons);
		collectorsAveragingInt(persons);		
		collectorsSummarizingInt(persons);		
		collectorsJoining(persons);		
		collectorsToMap(persons);		
		userDefinedCollector(persons);
		
		//
		// FlatMap
		// FlatMap accepts a function which has to return a stream of objects.
		flatMapSimple();
		flatMap();
		
		//
		// Reduce
		// The reduction operation combines all elements of the stream into a single result.
		reduce(persons);
		
		//
		// Parallel Stream
		// Streams can be executed in parallel to increase runtime performance on large amount of input elements.
		parallelStream();
	}

	private static void reduce(List<Personn> persons) {
		Personn result = persons 
							.stream()
					        .reduce(new Personn("", 0), (p1, p2) -> {
					            p1.age += p2.age;
					            p1.name += p2.name;
					            return p1;
					        });

		System.out.format("name=%s; age=%s", result.name, result.age); // name=MaxPeterPamelaDavid; age=76
	}

	private static void userDefinedCollector(List<Personn> persons) {
		Collector<Personn, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

		String names = persons
		    .stream()
		    .collect(personNameCollector);

		System.out.println(names);  // MAX | PETER | PAMELA | DAVID
	}

	private static void collectorsToMap(List<Personn> persons) {
		Map<Integer, String> map = persons
			    .stream()
			    .collect(Collectors.toMap(
			        p -> p.age,
			        p -> p.name,
			        (name1, name2) -> name1 + ";" + name2));

		System.out.println(map); // {18=Max, 23=Peter;Pamela, 12=David}
	}

	private static void collectorsJoining(List<Personn> persons) {
		String phrase = persons
			    .stream()
			    .filter(p -> p.age >= 18)
			    .map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

		System.out.println(phrase); // In Germany Max and Peter and Pamela are of legal age.
	}

	private static void collectorsSummarizingInt(List<Personn> persons) {
		IntSummaryStatistics ageSummary = persons
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary); // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
	}

	private static void collectorsAveragingInt(List<Personn> persons) {
		Double averageAge = persons
			    .stream()
			    .collect(Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge);     // 19.0
	}

	private static void collectorsGroupingBy(List<Personn> persons) {
		Map<Integer, List<Personn>> personsByAge = persons
			    .stream()
			    .collect(Collectors.groupingBy(p -> p.age));

		personsByAge
		    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		// age 18: [Max]
		// age 23: [Peter, Pamela]
		// age 12: [David]
	}

	private static void flatMapSimple() {
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream
		    .range(1, 4)
		    .forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f ->
		    IntStream
		        .range(1, 4)
		        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
		
		foos.stream()
		    .flatMap(f -> f.bars.stream())
		    .forEach(b -> System.out.println(b.name));
	}

	private static void flatMap() {
		IntStream.range(1, 4)
		    .mapToObj(i -> new Foo("Foo" + i))
		    .peek(f -> IntStream.range(1, 4)
		        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
		        .forEach(f.bars::add))
		    .flatMap(f -> f.bars.stream())
		    .forEach(b -> System.out.println(b.name));
	}

	private static void parallelStream() {
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
		    .parallelStream()
		    .filter(s -> {
		        System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
		        return true;
		    })
		    .map(s -> {
		        System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
		        return s.toUpperCase();
		    })
		    .sorted((s1, s2) -> {
		        System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
		        return s1.compareTo(s2);
		    })
		    .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

class Personn {
    String name;
    int age;

    Personn(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}


package com.debugchaos.springbase.lamdaexperiments.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class LambdaService  {

	public void printElements(List<?> elements){

		elements.forEach(p -> System.out.println(p));

	}

	public void transformUpper(List<String> elements) {
		
		elements.stream().
		map((final String name) -> name.toUpperCase()).
		forEach(name -> System.out.println(name + " "));
	}

	public Predicate<String> checkStartsWith(String letter){

		return name -> name.startsWith(letter);
	}

	final Function<String, Predicate<String>> startsWithLetterFunc = letter -> name -> name.startsWith(letter);

	public void filterElements(List<String> elemList, String startsWithLetter){

		List<String> filteredElems = elemList.stream().
		// filter(checkStartsWith(startsWithLetter)).collect(Collectors.toList());
				filter(startsWithLetterFunc.apply(startsWithLetter)).collect(Collectors.toList());

		printElements(filteredElems);
	}

	public void getFirstELement(List<String> elemList, String startsWithLetter) {

		Optional<String> foundName = elemList.stream().filter(startsWithLetterFunc.apply(startsWithLetter)).findFirst();

		foundName.ifPresent(name -> System.out.println(name));

		
	}


	public void joinElements(List<String> elemList) {

		String joinedElements = elemList.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println(joinedElements);

	}

	public void findLargest(List<String> elemList){

		Optional<String> largeElement = elemList.stream().
		reduce((name1, name2) -> name1.length()> name2.length()? name1: name2);

		largeElement.ifPresent(name -> System.out.println("Largest element in the list is: "+ name));

	}

	final Comparator<String> sortByName = (name1,name2) -> name1.compareTo(name2);

	public void sortElements(List<String> elemList) {

		List<String> sortedList = elemList.stream()
				.sorted(sortByName).collect(Collectors.toList());

		sortedList.forEach(System.out::println);
	}


	public void listAllFiles(String strPath) {
		
		try {
			
			Files.list(Paths.get(strPath)).flatMap(path -> {
				try {
					return Files.list(path) == null? Stream.of(path): Files.list(
							path);
				} catch (IOException e) {
					return Stream.of(path);
				}
			})
			//.filter(path -> path.getFileName().toString().startsWith(".")? false: true)

			.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	
}

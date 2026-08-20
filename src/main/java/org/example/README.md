Stream API Examples 
Overview
This project demonstrates Java Stream API usage through  practical examples:

Student Pipeline - Filtering, sorting, grouping, and joining student data

Word Count - Reading a file, tokenizing, and counting word frequencies

1. Student Pipeline
   Features
.Filter students with GPA ≥ 3.0
. Sort by GPA (descending), then by name (ascending)
. Group students by grade band (A/B/C/F)
. Generate comma-separated list of honour-roll students (GPA ≥ 3.7)

Key Stream Operations
java
// Filter and sort
students.stream()
.filter(s -> s.getGpa() >= 3.0)
.sorted(Comparator.comparingDouble(Student::getGpa).reversed()
.thenComparing(Student::getName))
.collect(Collectors.toList());

// Group by grade band
students.stream()
.collect(Collectors.groupingBy(s ->
s.getGpa() >= 3.7 ? "A" :
s.getGpa() >= 3.0 ? "B" :
s.getGpa() >= 2.0 ? "C" : "F"
));

// Join honour roll names
students.stream()
.filter(s -> s.getGpa() >= 3.7)
.map(Student::getName)
.collect(Collectors.joining(", "));
 
2. Word Count
   Features
. Read text file line by line using Files.lines()

. Tokenize words using split("\\W+")

. Filter empty tokens and convert to lowercase

. Count word frequencies with groupingBy()

. Display top 10 most frequent words

Key Stream Operations
java
// Word count pipeline
Map<String, Long> wordFrequency = Files.lines(filePath)
.flatMap(line -> Arrays.stream(line.split("\\W+")))
.filter(token -> !token.isEmpty())
.map(String::toLowerCase)
.collect(Collectors.groupingBy(
Function.identity(),
Collectors.counting()
));

// Top 10 words
wordFrequency.entrySet().stream()
.sorted(Map.Entry.<String, Long>comparingByValue().reversed()
.thenComparing(Map.Entry.comparingByKey()))
.limit(10)
.forEach(entry -> System.out.printf("%-15s : %d%n",
entry.getKey(), entry.getValue()));

Stream API Concepts Demonstrated


Operation	      Purpose	                                  Example
filter()	Select elements matching a condition	.filter(s -> s.getGpa() >= 3.0)
map()	     Transform elements	                      .map(Student::getName)
flatMap()	Flatten nested structures	           .flatMap(line -> Arrays.stream(line.split()))
sorted()	Sort with custom comparator	           .sorted(Comparator.comparingDouble(...))
collect()	Terminal operation to gather results	.collect(Collectors.toList())
groupingBy()	Group elements by a classifier	     .collect(Collectors.groupingBy(...))
joining()	Concatenate strings with delimiter   	.collect(Collectors.joining(", "))
limit()     	Limit stream size	                   .limit(10)
reversed()	   Reverse sort order	                .comparingByValue().reversed()

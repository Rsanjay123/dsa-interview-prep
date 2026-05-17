package DSAPREP.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInterviewQuestions {
  
  static class Employee {
    String name;
    String department;
    double salary;
    
    public Employee(String name, String department, double salary) {
      this.name = name;
      this.department = department;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDepartment() {
      return department;
    }

    public void setDepartment(String department) {
      this.department = department;
    }

    public double getSalary() {
      return salary;
    }

    public void setSalary(double salary) {
      this.salary = salary;
    }
  }

  public static void main(String[] args) {
    List<Employee> list = Arrays.asList(new Employee("Bliss", "HR", 50000),
        new Employee("Bob", "IT", 60000),
        new Employee("Charlie", "HR", 55000),
        new Employee("David", "IT", 70000),
        new Employee("Eve", "Finance", 65000),
        new Employee("Sanjay", "Finance", 80000),
        new Employee("Sairam", "HR", 56000),
        new Employee("Suresh", "IT", 90000));

    List<Integer> numbers = Arrays.asList(24, 12, 36, 48, 60, 53, 73, 87, 91, 21);

    List<Integer> numList = Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);
    //return a list of unique numbers from the given list
    List<Integer> distinctNums = numList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    System.out.println(distinctNums);

    streamOperationsOnNames();
//
//    streamOperationsNumberList(numbers);
//
//    streamOperationsOnEmployees(list);
  }

  private static void streamOperationsOnNames() {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Sanjay", "Sairam", "Suresh");
    //return count of words whose length is greater than 5
    List<Integer> countWords = names.stream().filter(n -> n.length() > 5).map(n -> n.length()).sorted().collect(Collectors.toList());
    System.out.println(countWords);
    //return the words whose length is greater than 5
    List<String> countNames = names.stream().filter(n -> n.length() > 5).sorted().collect(Collectors.toList());
    System.out.println(countNames);
    //return a string of all names concatenated with a comma within square brackets
    String concatenatedName = names.stream().collect(Collectors.joining(" , ", "[", "]"));
    System.out.println(concatenatedName);
  }

  private static void streamOperationsNumberList(List<Integer> numbers) {
    //sum of all even numbers
    int sumEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    System.out.println(sumEven);
    //sum of all odd numbers
    int sumOdd = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
    System.out.println(sumOdd);
    //return a list of squares of all even numbers
    List<Integer> squaresNum = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).sorted().collect(Collectors.toList());
    System.out.println(squaresNum);
    //return a list of squares of all odd numbers
    List<Integer> squaresNumOdd = numbers.stream().filter(n -> n % 2 != 0).map(n -> n * n).sorted().collect(Collectors.toList());
    System.out.println(squaresNumOdd);
    //return a list of all even numbers
    List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
    System.out.println(evenNumbers);
  }

  private static void streamOperationsOnEmployees(List<Employee> list) {
    //sum of salaries in each department
    Map<String, Double> map1 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
    System.out.println(map1);
    //highest salary in each department
    Map<String, Double> map2 = list.stream().collect(Collectors.toMap(Employee::getDepartment, Employee::getSalary, Double::max));
    System.out.println(map2);
    //employee with the highest salary in each department
    Map<String, Optional<Employee>> map3 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    map3.forEach((dept, emp) -> emp.ifPresent(e -> System.out.println(dept + " -> " + e.getName() + " : " + e.getSalary())));
    //highest salary in the office
    double maxSalary = list.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
    System.out.println(maxSalary);
    //second-highest salary in the office
    Double secondHighestSalary = list.stream().mapToDouble(Employee::getSalary).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
    System.out.println(secondHighestSalary);

    //return employees whose names starts with 'S'
    List<Employee> s = list.stream().filter(e -> e.getName().startsWith("S")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    s.forEach(e -> System.out.println(e.getName().toUpperCase()));
  }
}

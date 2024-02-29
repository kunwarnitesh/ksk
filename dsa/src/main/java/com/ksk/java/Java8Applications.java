package com.ksk.java;


import java.util.*;
import java.util.stream.Collectors;

public class Java8Applications {

    public static void main(String[] args) {

        List<Employee> list = DataBaseUtil.getData();
        list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
        Map<Employee, Integer> map = DataBaseUtil.getDataMap();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);
        List<String> collect = list.stream().map(Employee::getName).toList();


//        Long result = list.stream().reduce(0,(employee, employee2) -> employee.getSalary()+employee2.getSalary());

        List<Integer> sumList = Arrays.asList(1,2,3,4,5,6);
//        System.out.println(sumList.stream().mapToInt(i->i).sum());
        int sum = sumList.stream().reduce(0,(i,j)->i+j);
        System.out.println(sum);

        double result = list.stream().filter(employee -> employee.getSalary()>10000)
                .map(employee -> employee.getSalary())
                .mapToDouble(x->x)
                .sum();
        System.out.println(result);

    }

    public static class Calculator {
        public BiFunction<Integer, Integer, Integer> calculcate() {
            return (x, y) -> x + y;
        }
    }
}

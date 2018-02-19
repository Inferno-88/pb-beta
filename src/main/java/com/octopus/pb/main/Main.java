//package com.octopus.pb.main;
//
//
//import com.sun.tools.javac.util.List;
//
//import java.util.Optional;
//
//public class Main {
////    public view void main(String[] args) {
////
//////        String s = "Hello world";
//////
//////        Runnable runnable = () -> {
//////            System.out.println(s);
//////        };
//////
//////        runnable.run();
////
//////        List<String> list = List.of("qwerty1", "qwerty12", "qwerty123", "qwerty1234", "123qwerty1234");
//////        Integer count = list.stream()
//////                .filter(it -> it.startsWith("q"))
//////                .map(String::length)
//////                .reduce((s1, s2) -> s1 + s2).get();
//////        System.out.println(count);
//////        System.out.println("qwerty1qwerty12qwerty123qwerty1234".length());
////
//////        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(1, 2, 3, 4), List.of(1, 2, 3, 4, 5));
//////
//////        lists.stream().flatMap(integers -> integers.stream()).map(i -> i + 10).forEach(System.out::println);
////
//////        String sample = "qwerty1qwerty12qwerty123qwerty1234";
//////        Integer count = Optional.ofNullable(sample).map(String::length).orElse(0);
//////        if (sample != null) {
//////            Integer count = sample.length();
//////        } else {
//////            Integer count = 0;
//////        }
//////        SampleClass sampleClass = null;
//////        sampleClass.setName(Optional.ofNullable(null));
//////        String s = Optional.ofNullable(sampleClass).flatMap(c -> c.getName()).orElse("Unknown");
//////        System.out.println(s);
////
//////        BinaryOperator<Integer> binOpApp = (num1, num2) -> (num1 * num2);
//////
//////        System.out.println(binOpApp.apply(8, 8));
//////
//////        BinaryOperator<Integer> binOpComp = BinaryOperator.minBy(Comparator.naturalOrder());
//////        System.out.println(binOpComp.apply(6,5));
////
////
////
////        List<String> numbersList = List.of ("123", "456", "789");
////
////        numbersList.stream()
////                .filter(number -> number.equals("456"))
////                .map(number -> number.substring(2))
////                .forEach(System.out::println);
////
////
////
////    }
////
////    public view class SampleClass {
////        public Long id;
////        public Optional<String> name;
////
////        public Long getId() {
////            return id;
////        }
////
////        public void setId(Long id) {
////            this.id = id;
////        }
////
////        public Optional<String> getName() {
////            return name;
////        }
////
////        public void setName(Optional<String> name) {
////            this.name = name;
////        }
////    }
////
//}

package com.filippov.lambdas.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number> {
    double process(T element,T element2);
}

@FunctionalInterface
interface ExecuteFunction {
    void process();
}

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.4);
        doubleList.add(8.6);
        doubleList.add(1.23);
        doubleList.add(4.13);
        doubleList.add(12.2);

        processElements(intList,4, (x,y)->multiply(x,y));
        TimeUtil util = new TimeUtil();
        util.measure(() -> Arrays.sort(createRandomArray()));
        String s= "hello";
        Double d = 0.123;

        TransformUtils<Double> transformUtils = new TransformUtils<>();
        transformUtils.transform(d, Math::sin);
        TransformUtils<String> stringTransformUtils = new TransformUtils<>();
        stringTransformUtils.transform(s,TransformUtils::exclaim);
        String suffix="Alex";
        stringTransformUtils.transform(suffix,s::concat);
        System.out.println(stringTransformUtils.transform(s,String::toUpperCase));
    }

    private static <T extends Number> void processElements(List<T> intList, double a, ElementProcessor function) {
        List<Double> doubleList = new ArrayList<>();
        for (Number i : intList ) {
            doubleList.add(function.process(i,a));
        }
        System.out.println(doubleList);
    }

    private static double multiply(Number x, Number y) {
        return x.doubleValue() * y.doubleValue() / 5.0;
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[100000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = r.nextInt(myArray.length);
        }
        return myArray;
    }

    public static class TimeUtil {
        private void measure(ExecuteFunction function) {
            long start = System.currentTimeMillis();
            function.process();
            long end = System.currentTimeMillis();
            System.out.println("Time spent" + (end - start));
        }


    }
}

/*
 * Example3.java
 *
 * 05.06.2010
 *
 * Copyright 2010 Michael Lieshoff
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mili.jmibs.examples;

import java.util.*;

import org.mili.jmibs.api.*;
import org.mili.jmibs.impl.*;

/**
 * This class shows an example use of string representation of suite results from a interval
 * benchmark suite.
 *
 * @author Michael Lieshoff
 * @version 1.1 05.06.2010
 * @since 1.1
 */
public class Example3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval{How would a function like Fibonacci be
         * benched? For this behavior there is the interval benchmark suite. It's perfectly
         * designed for things like: Do the function 10, 100, 1000 times with values from 1..10,
         * 50..75 and 1..1000. The suite type is defined in interface
         * &quot;IterationIntervalBenchmarkSuite&quot;. The default class for this interface
         * defines all needed.}
         */
        /* list with iterations. */
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval{Define a list with iteration counts.
         * Let's try with 10, 100 and 1.000 bench iterations. This means a single benchmark will
         * be executed in times 10, 100 and 1.000.}
         * @doc jMibs/II/Getting Started Guide/2. Interval(Pre){
         * List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);}}; }
         */
        List<Integer> il = new ArrayList<Integer>() {
            {
                add(1);
                add(10);
                add(100);
            }
        };

        /* list with intervals. */
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval{Define a list with intervals. Remember
         * interval has minimum and maximum. Let's try an interval from 1 to 10 and 50 to 100.
         * This means a single benchmark will be executed for the both intervals. The intervals
         * used are integer intervals, mean min and max are integer values. There long interval
         * too, and for other function custom intervals can be created.}
         * @doc jMibs/II/Getting Started Guide/2. Interval(Pre){
         * List<IntegerInterval> ol = new ArrayList<IntegerInterval>(){{IntegerInterval.create(0, 10), IntegerInterval.create(50, 100)}}; }
         */
        List<IntegerInterval> ol = new ArrayList<IntegerInterval>() {
            {
                add(IntegerInterval.create(1, 10));
                add(IntegerInterval.create(25, 50));
            }
        };

        /* create the suite. */
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval{Then get an instance for the right suite
         * and both lists.}
         * @doc jMibs/II/Getting Started Guide/2. Interval(Pre){
         * BenchmarkSuite bs = DefaultIterationIntervalBenchmarkSuite.create("Example3", il, ol); }
         */
        BenchmarkSuite bs = DefaultIterationIntervalBenchmarkSuite.create("Example3", il, ol);

        /* add some benches. */
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval/1. How do i bind a bench in a suite?{
         * Two example benchmarks are prepared. The benchmark class
         * &quot;FibonacciEndRecursiveBenchmark&quot; defines a benchmark to computeFibonacci
         * number end recursive. This benchmark will be added to the suite above with the
         * addBenchmark() method.}
         * @doc jMibs/II/Getting Started Guide/2. Interval/1. How do i bind a bench in a suite?(Pre){
         * bs.addBenchmark(new FibonacciEndRecursiveBenchmark()); }
         */
        bs.addBenchmark(new FibonacciEndRecursiveBenchmark());
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval/1. How do i bind a bench in a suite?{
         * Second prepared benchmark class is &quot;FibonacciRecursiveBenchmark&quot;. It
         * defines a benchmark to compute Fibonacci number recursive. This benchmark
         * will be added to the suite above with the addBenchmark() method.}
         * @doc jMibs/II/Getting Started Guide/2. Interval/1. How do i bind a bench in a suite?(Pre){
         * bs.addBenchmark(new FibonacciRecursiveBenchmark()); }
         */
        bs.addBenchmark(new FibonacciRecursiveBenchmark());

        /* execute the suite. */
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval/1. How do i bind a bench in a suite?{
         * Then the suite can be started with execute() method. The return value contains the
         * benchmark results for all benchmarks, in all iteration with all intervals, in suite.}
         * @doc jMibs/II/Getting Started Guide/2. Interval/1. How do i bind a bench in a suite?(Pre){
         * IterationIntervalBenchmarkSuiteResult<IntegerInterval> bsr = (IterationIntervalBenchmarkSuiteResult) bs.execute(); }
         */
        IterationIntervalBenchmarkSuiteResult<IntegerInterval> bsr =
                (IterationIntervalBenchmarkSuiteResult<IntegerInterval>) bs.execute();

        /* create a renderer. */
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval/2. How do i report my results?{Next
         * a more human readable interpretation of suite result seems to be good. This job is
         * done by renderers implementing the interface &quot;BenchmarkSuiteResultRenderer&quot;.
         * We use a simple implementation to render the result information in a simple string
         * table. The class used is &quot;StringIterationIntervalBenchmarkSuiteResultRenderer&quot;.}
         * @doc jMibs/II/Getting Started Guide/2. Interval/2. How do i report my results?(Pre){
         * BenchmarkSuiteResultRenderer<String> bsrr = StringIterationIntervalBenchmarkSuiteResultRenderer.create();
         * System.out.println(bsrr.render(bsr)); }
         */
        BenchmarkSuiteResultRenderer<String> bsrr =
                StringIterationIntervalBenchmarkSuiteResultRenderer.create();
        /* display the results. */
        System.out.println(bsrr.render(bsr));
        /*
         * @doc jMibs/II/Getting Started Guide/2. Interval/3. How do i make my own bench?{Your
         * own benchmark can be maked with the two example benchmarks as pattern. For
         * iteration/interval based benchmarks extends the abstract class
         * &quot;AbstractIntervalBenchmark&quot;. For some specially custom benchmarks based
         * on other facts extends the abstract class &quot;AbstractBenchmark&quot; or implement
         * the interface &quot;Benchmark&quot;.}
         */
    }

}

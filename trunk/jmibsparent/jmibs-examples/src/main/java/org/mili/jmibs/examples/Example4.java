/*
 * Example4.java
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
 * This class shows an example use of string representation of suite results from an object load
 * interval benchmark suite.
 *
 * @author Michael Lieshoff
 * @version 1.0 05.06.2010
 * @since 1.1
 */
public class Example4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load{There is a combined
         * benchmark suite that combines object load with interval. This means we run benchmarks
         * in suite n-times with m-objects in i-intervals. The suite type for this is
         * defined in interface &quot;IterationObjectLoadIntervalBenchmarkSuite&quot;. The
         * default class for this interface defines all needed.}
         */

        /* list with iterations. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load{Define a list with
         * iteration counts. Let's try with 10, 100 and 1.000 bench iterations. This means a single
         * benchmark will be executed in times 10, 100 and 1.000.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load(Pre){
         * List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);}}; }
         */
        List<Integer> il = new ArrayList<Integer>() {
            {
                add(10);
                add(100);
                add(1000);
            }
        };

        /* list with objects. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load{Define a list with
         * object loading counts. Let's try with 100 and 1.000 object loading counts. This means
         * a single benchmark will be used intern 100 and 1.000 object for each defined
         * iteration count.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load(Pre){
         * List<Integer> ol = new ArrayList<Integer>(){{add(100); add(1000);}}; }
         */
        List<Integer> ol = new ArrayList<Integer>() {
            {
                add(10);
                add(100);
            }
        };

        /* list with object loadings. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load{Define a list with
         * intervals. Remember interval has minimum and maximum. Let's try an interval from 1 to
         * 10 and 50 to 100. This means a single benchmark will be executed for the both
         * intervals. The intervals used are integer intervals, mean min and max are integer
         * values. There long interval too, and for other function custom intervals can be
         * created.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load(Pre){
         * List<IntegerInterval> ol = new ArrayList<IntegerInterval>(){{IntegerInterval.create(0, 10), IntegerInterval.create(50, 100)}}; }
         */
        List<IntegerInterval> itl = new ArrayList<IntegerInterval>() {
            {
                add(IntegerInterval.create(0, 10));
                add(IntegerInterval.create(50, 100));
            }
        };

        /* create the suite. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load{Then get an instance
         * for the iteration object load interval suite and the three lists.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load(Pre){
         * BenchmarkSuite bs = DefaultIterationObjectLoadIntervalBenchmarkSuite.create("Example4", il, ol, itl); }
         */
        BenchmarkSuite bs = DefaultIterationObjectLoadIntervalBenchmarkSuite.create("Example4",
                il, ol, itl);

        /* add some benches. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/1. How do i bind a bench in a suite?{
         * One example benchmark is prepared. The benchmark class &quot;ObjectLoadIntervalBenchmark&quot;
         * defines a benchmark to do the job. This benchmark will be added to the suite above
         * with the addBenchmark() method.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/1. How do i bind a bench in a suite?(Pre){
         * bs.addBenchmark(new ObjectLoadIntervalBenchmark()); }
         */
        bs.addBenchmark(new ObjectLoadIntervalBenchmark());

        /* execute the suite. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/1. How do i bind a bench in a suite?{
         * Then the suite can be started with execute() method. The return value contains the
         * benchmark results for all benchmarks, in all iteration with all object loading
         * counts and all intervals, in suite.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/1. How do i bind a bench in a suite?(Pre){
         * IterationObjectLoadIntervalBenchmarkSuiteResult<IntegerInterval> bsr = (IterationObjectLoadIntervalBenchmarkSuiteResult<IntegerInterval>) bs.execute(); }
         */
        IterationObjectLoadIntervalBenchmarkSuiteResult<IntegerInterval> bsr =
                (IterationObjectLoadIntervalBenchmarkSuiteResult<IntegerInterval>) bs.execute();

        /* create a renderer. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/2. How do i report my results?{
         * Next a more human readable interpretation of suite result seems to be good. This job
         * is done by renderers implementing the interface &quot;BenchmarkSuiteResultRenderer&quot;.
         * We use a simple implementation to render the result information in a simple string
         * table. The class used is &quot;StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer&quot;.}
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/2. How do i report my results?(Pre){
         * BenchmarkSuiteResultRenderer<String> bsrr = StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer.create();
         * System.out.println(bsrr.render(bsr)); }
         */
        BenchmarkSuiteResultRenderer<String> bsrr =
                StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer.create();
        /* display the results. */
        System.out.println(bsrr.render(bsr));
        /*
         * @doc jMibs/II/Getting Started Guide/3. Interval and object load/3. How do i make my own bench?{
         * Your own benchmark can be maked with the example benchmark as pattern. For
         * iteration/object loading/interval based benchmarks extends the abstract class
         * &quot;AbstractObjectLoadIntervalBenchmark&quot;. For some specially custom benchmarks based
         * on other facts extends the abstract class &quot;AbstractBenchmark&quot; or implement
         * the interface &quot;Benchmark&quot;.}
         */
    }

}

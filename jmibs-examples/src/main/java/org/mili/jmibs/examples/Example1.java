/*
 * Example1.java
 *
 * 12.04.2010
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
 * This class shows an example use of string representation of suite results.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class Example1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * @doc jMibs/II/Getting Started Guide{First get the right suite. Use a benchmark suite,
         * based on iteration and some object loading. This means we run benchmarks in suite
         * n-times with m-objects. The suite type for this is defined in interface
         * &quot;IterationObjectLoadBenchmarkSuite&quot;. The default class for this interface
         * defines all needed.}
         */

        /* list with iterations. */
        /*
         * @doc jMibs/II/Getting Started Guide{Define a list with iteration counts. Let's try
         * with 10, 100 and 1.000 bench iteration. This means a single benchmark will be
         * executed in times 10, 100 and 1.000.}
         * @doc jMibs/II/Getting Started Guide(Pre){
         * List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);}}; }
         */
        List<Integer> il = new ArrayList<Integer>() {
            {
                add(10);
                add(100);
                add(1000);
            }
        };

        /* list with object loadings. */
        /*
         * @doc jMibs/II/Getting Started Guide{Define a list with object loading counts. Let's
         * try with 100 and 1.000 object loading counts. This means a single benchmark will be
         * used intern 100 and 1.000 object for each defined iteration count.}
         * @doc jMibs/II/Getting Started Guide(Pre){
         * List<Integer> ol = new ArrayList<Integer>(){{add(100); add(1000);}}; }
         */
        List<Integer> ol = new ArrayList<Integer>() {
            {
                add(100);
                add(1000);
            }
        };

        /* create the suite. */
        /*
         * @doc jMibs/II/Getting Started Guide{Then get an instance for the right suite and both
         * lists.}
         * @doc jMibs/II/Getting Started Guide(Pre){
         * BenchmarkSuite bs = DefaultIterationObjectLoadBenchmarkSuite.create("Example1", il, ol); }
         */
        BenchmarkSuite bs = DefaultIterationObjectLoadBenchmarkSuite.create("Example1", il, ol);

        /* add some benches. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. How do i bind a bench in a suite?{Two example
         * benchmarks are prepared. The benchmark class
         * &quot;TraverseForEachArrayListStringBenchmark&quot; defines a benchmark to traverse
         * an ArrayList of String objects with for-each idiom. This benchmark will be added to
         * the suite above with the addBenchmark() method.}
         * @doc jMibs/II/Getting Started Guide/3. How do i bind a bench in a suite?(Pre){
         * bs.addBenchmarkClass(TraverseForEachArrayListStringBenchmark.class); }
         */
        bs.addBenchmarkClass(TraverseForEachArrayListStringBenchmark.class);
        /*
         * @doc jMibs/II/Getting Started Guide/3. How do i bind a bench in a suite?{Second
         * prepared benchmark class is
         * &quot;TraverseHighSpeedIdiomArrayListStringBenchmark&quot;. It defines a benchmark to
         * traverse an ArrayList of String objects with high-speed-for idiom. This benchmark
         * will be added to the suite above with the addBenchmark() method.}
         * @doc jMibs/II/Getting Started Guide/3. How do i bind a bench in a suite?(Pre){
         * bs.addBenchmarkClass(TraverseHighSpeedIdiomArrayListStringBenchmark.class); }
         */
        bs.addBenchmarkClass(TraverseHighSpeedIdiomArrayListStringBenchmark.class);

        /* execute the suite. */
        /*
         * @doc jMibs/II/Getting Started Guide/3. How do i bind a bench in a suite?{Then the
         * suite can be started with execute() method. The return value contains the benchmark
         * results for all benchmarks, in all iteration with all object loading counts, in
         * suite.}
         * @doc jMibs/II/Getting Started Guide/3. How do i bind a bench in a suite?(Pre){
         * IterationObjectLoadBenchmarkSuiteResult bsr = (IterationObjectLoadBenchmarkSuiteResult) bs.execute(); }
         */
        IterationObjectLoadBenchmarkSuiteResult bsr = (IterationObjectLoadBenchmarkSuiteResult)
                bs.execute();

        /* create a renderer. */
        /*
         * @doc jMibs/II/Getting Started Guide/4. How do i report my results?{Next a more human
         * readable interpretation of suite result seems to be good. This job is done be
         * renderers implementing the interface &quot;BenchmarkSuiteResultRenderer&quot;. We use
         * a simple implementation to render the result information in a simple string table.
         * The class used is &quot;StringIterationObjectLoadBenchmarkSuiteResultRenderer&quot;.}
         * @doc jMibs/II/Getting Started Guide/4. How do i report my results?(Pre){
         * BenchmarkSuiteResultRenderer<String> bsrr = StringIterationObjectLoadBenchmarkSuiteResultRenderer.create();
         * System.out.println(bsrr.render(bsr)); }
         */
        BenchmarkSuiteResultRenderer<String> bsrr =
                StringIterationObjectLoadBenchmarkSuiteResultRenderer.create();
        /* display the results. */
        System.out.println(bsrr.render(bsr));

        /*
         * @doc jMibs/II/Getting Started Guide/3. How do i make my own bench?{Your own benchmark
         * can be maked with the two example benchmarks as pattern. For iteration/object loading
         * based benchmarks extends the abstract class &quot;AbstractObjectLoadBenchmark&quot;.
         * For some specially custom benchmarks based on other facts extends the abstract class
         * &quot;AbstractBenchmark&quot; or implement the interface &quot;Benchmark&quot;. You
         * will see some output of string rendered suite results.}
         * @doc jMibs/II/Getting Started Guide/6. Running the examples{Examples can be found in
         * the project &quot;jmibs-examples&quot; or, with jFree, in &quot;jmibs-jfree&quot;.
         * The classes with prefix &quot;Example&quot; in the packages &quot;examples&quot; are
         * able to start with Maven like this:}
         * @doc jMibs/II/Getting Started Guide/6. Running the examples(Pre){
         * jmibs/jmibs-examples/mvn exec:java -Dexec.mainClass="org.mili.jmibs.examples.Example1"}
         * @doc jMibs/II/Getting Started Guide/6. Running the examples{or}
         * @doc jMibs/II/Getting Started Guide/6. Running the examples(Pre){
         * jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example2"
         * jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example3"
         * jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example4"
         * jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example5"
         * jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example6"}
         */
    }

}

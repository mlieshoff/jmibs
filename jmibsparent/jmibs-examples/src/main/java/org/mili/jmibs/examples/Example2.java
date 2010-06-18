/*
 * Example2.java
 *
 * 06.05.2010
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
 * This class shows an example use of the three types of ad hoc benchmarks.
 *
 * @author Michael Lieshoff
 * @version 1.0 06.05.2010
 * @since 1.1
 */
public class Example2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches{Like to ad hoc bench something
         * or don't like to write a bench class? Then ad hoc benches should be used. Ad hoc
         * benches are a short version of benchmarks. They only must created with two anonymous
         * implemented function for prepare and execute. Then they are ready. Combined with
         * createAndRun() method in each suite they can started quickly. Nothing to inherit or
         * overload, simply create a class with create() method.}
         */
        /* object load. */
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches/1. Object load{For object load
         * benches use create() method from &quot;AdHocObjectLoadBenchmark&quot;. Notice that
         * you must declare the model outside of the benchmark, because prepare and execute
         * methods would access the model.}*/
        final List<String> l = new ArrayList<String>();
        final AdHocObjectLoadBenchmark b1 = AdHocObjectLoadBenchmark.create(
                "ad hoc benchmark 1",
                new PrepareFunction<Integer>() {
                    @Override
                    public void prepare(Integer ctx) {
                        l.clear();
                        for (int i = 0, n = ctx; i < n; i++) {
                            l.add(String.valueOf(i));
                        }
                    }
                }, new ExecuteFunction<Integer>() {
                    @Override
                    public void execute(Integer ctx) {
                        for (int i = 0, n = l.size(); i < n; i++) {
                            String s = l.get(i);
                        }
                    }
                });
        /* create the suite and run it, then display results. */
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches/1. Object load{Next use
         * createAndRun() method from calls &quot;DefaultIterationObjectLoadBenchmarkSuite&quot;.
         * Parameters are the name of the suite, a renderer class, an array with benchmarks,
         * iterations and object loads. The suite will be created and started automatically.
         * }
         */
        System.out.println(DefaultIterationObjectLoadBenchmarkSuite.createAndRun("ad hoc suite",
                StringIterationObjectLoadBenchmarkSuiteResultRenderer.class,
                new Benchmark[]{b1}, new int[]{10, 100, 1000}, new int[]{10, 100, 1000}));

        /* interval. */
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches/2. Interval{For interval benches
         * use create() method from &quot;AdHocIntervalBenchmark&quot;.}*/
        final AdHocIntervalBenchmark<LongInterval> b2 = AdHocIntervalBenchmark.create(
                "ad hoc benchmark 2",
                new PrepareFunction<LongInterval>() {
                    @Override
                    public void prepare(LongInterval ctx) {
                    }
                }, new ExecuteFunction<LongInterval>() {
                    @Override
                    public void execute(LongInterval ctx) {
                        FibonacciEndRecursiveBenchmark.fib(ctx.getValue().intValue());
                    }
                });
        /* create the suite and run it, then display results. */
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches/2. Interval{Next use
         * createAndRun() method from calls &quot;DefaultIterationIntervalBenchmarkSuite&quot;.
         * Parameters are the name of the suite, a renderer class, an array with benchmarks,
         * iterations and intervals. The suite will be created and started automatically.
         * }
         */
        System.out.println(DefaultIterationIntervalBenchmarkSuite.createAndRun("ad hoc suite",
                StringIterationIntervalBenchmarkSuiteResultRenderer.class,
                new Benchmark[]{b2}, new int[]{1, 10}, new LongInterval[]{LongInterval.create(1,
                500)}));
        /* object-load interval */
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches/3. Interval and object load{
         * For object load and interval benches use create() method from
         * &quot;AdHocObjectLoadIntervalBenchmark&quot;.}*/
        final AdHocObjectLoadIntervalBenchmark<String, LongInterval> b3 =
                AdHocObjectLoadIntervalBenchmark.create("ad hoc benchmark 3",
                new PrepareFunction<Integer>() {
                    @Override
                    public void prepare(Integer ctx) {
                    }
                }, new ExecuteFunction<LongInterval>() {
                    @Override
                    public void execute(LongInterval ctx) {
                    }
                });
        /*
         * @doc jMibs/II/Getting Started Guide/4. AdHoc benches/3. Interval and object load{Next
         * use createAndRun() method from calls &quot;DefaultIterationObjectLoadIntervalBenchmarkSuite&quot;.
         * Parameters are the name of the suite, a renderer class, an array with benchmarks,
         * iterations, object loads and intervals. The suite will be created and started
         * automatically.}
         */
        System.out.println(DefaultIterationObjectLoadIntervalBenchmarkSuite.createAndRun(
                "ad hoc suite", StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer
                .class, new Benchmark[]{b3}, new int[]{1, 10}, new int[]{10, 100},
                new LongInterval[]{LongInterval.create(1, 10), LongInterval.create(1, 100)}));
    }

}

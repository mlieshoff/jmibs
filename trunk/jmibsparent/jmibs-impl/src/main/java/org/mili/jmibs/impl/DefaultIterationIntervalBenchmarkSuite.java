/*
 * DefaultIterationIntervalBenchmarkSuite.java
 *
 * 04.06.2010
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

package org.mili.jmibs.impl;

import java.util.*;

import org.mili.jmibs.api.*;

/**
 * This class defines a special default implementation of a benchmark suite based on
 * informations about iteration count and interval.
 *
 * @author Michael Lieshoff
 * @version 1.0 04/06/2010
 * @since 1.1
 */
public class DefaultIterationIntervalBenchmarkSuite<I extends Interval<?>>
        extends AbstractBenchmarkSuite implements IterationIntervalBenchmarkSuite<I> {

    private List<Integer> iterationList = null;
    private List<I> intervalList = null;

    /**
     * creates a new default iteration interval benchmark suite.
     */
    protected DefaultIterationIntervalBenchmarkSuite() {
        this(DefaultIterationIntervalBenchmarkSuite.class.getName(), new ArrayList<Integer>(),
                new ArrayList<I>());
    }

    /**
     * creates a new named default iteration interval benchmark suite.
     *
     * @param name name of the suite.
     */
    protected DefaultIterationIntervalBenchmarkSuite(String name) {
        this(name, new ArrayList<Integer>(), new ArrayList<I>());
    }

    /**
     * creates a new default iteration interval benchmark suite with list of iteration counts
     * and list of intervals.
     *
     * @param iterationList list with iteration counts.
     * @param intervalList list with intervals.
     */
    protected DefaultIterationIntervalBenchmarkSuite(List<Integer> iterationList,
            List<I> intervalList) {
        this(DefaultIterationIntervalBenchmarkSuite.class.getName(), iterationList,
                intervalList);
    }

    /**
     * creates a new named default iteration interval benchmark suite with list of iteration
     * counts and list of intervals.
     *
     * @param name name of the suite.
     * @param iterationList list with iteration counts.
     * @param intervalList list with intervals.
     */
    protected DefaultIterationIntervalBenchmarkSuite(String name, List<Integer> iterationList,
            List<I> intervalList) {
        super();
        if (iterationList == null) {
            throw new IllegalArgumentException("iteration list can't be null!");
        }
        if (intervalList == null) {
            throw new IllegalArgumentException("interval list can't be null!");
        }
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        this.iterationList = iterationList;
        this.intervalList = intervalList;
        this.setName(name);
    }

    /**
     * creates a new default iteration interval benchmark suite.
     *
     * @return new default iteration interval benchmark suite.
     */
    public static <I extends Interval<?>> DefaultIterationIntervalBenchmarkSuite<I> create() {
        return DefaultIterationIntervalBenchmarkSuite.create(
                DefaultIterationIntervalBenchmarkSuite.class.getName(),
                new ArrayList<Integer>(), new ArrayList<I>());
    }

    /**
     * creates a new named default iteration interval benchmark suite.
     *
     * @param name name of the suite.
     * @return new default iteration interval benchmark suite.
     */
    public static <I extends Interval<?>> DefaultIterationIntervalBenchmarkSuite<I> create(String name) {
        return DefaultIterationIntervalBenchmarkSuite.create(name, new ArrayList<Integer>(),
                new ArrayList<I>());
    }

    /**
     * creates a new default iteration interval benchmark suite with list of iteration counts
     * and list of intervals.
     *
     * @param iterationList list with iteration counts.
     * @param intervalList list with intervals.
     * @return new default iteration interval benchmark suite with list of iteration counts and
     *         list of intervals.
     */
    public static <I extends Interval<?>> DefaultIterationIntervalBenchmarkSuite<I> create(
            List<Integer> iterationList, List<I> intervalList) {
        return DefaultIterationIntervalBenchmarkSuite.create(
                DefaultIterationIntervalBenchmarkSuite.class.getName(), iterationList,
                intervalList);
    }

    /**
     * creates a new named default iteration interval benchmark suite with list of
     * iteration counts and list of intervals.
     *
     * @param name name of the suite.
     * @param iterationList list with iteration counts.
     * @param intervalList list with intervals.
     * @return new default iteration interval benchmark suite with list of iteration
     *         counts and list of intervals.
     */
    public static <I extends Interval<?>> DefaultIterationIntervalBenchmarkSuite<I> create(
            String name, List<Integer> iterationList, List<I> intervalList) {
        return new DefaultIterationIntervalBenchmarkSuite<I>(name, iterationList, intervalList);
    }

    @Override
    public List<Integer> getIterationList() {
        return this.iterationList;
    }

    @Override
    public void addIteration(int iteration) {
        if (iteration <= 0) {
            throw new IllegalArgumentException("iteration must be positive!");
        }
        this.iterationList.add(iteration);
    }

    @Override
    public List<I> getIntervalList() {
        return this.intervalList;
    }

    @Override
    public void addInterval(I interval) {
        if (interval == null) {
            throw new IllegalArgumentException("interval can't be null!");
        }
        this.intervalList.add(interval);
    }

    @Override
    public BenchmarkSuiteResult execute() {
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration interval suite(Concat){
         * The execute method starts the proceeded to execute all benchmarks assigned to this
         * suite.}
         */
        DefaultIterationIntervalBenchmarkSuiteResult<I> bsr =
                DefaultIterationIntervalBenchmarkSuiteResult.<I>create();
        bsr.setBenchmarkSuite(this);
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration interval suite(Concat){
         * First a virtual machine warm up phase is proceeding that tries to activate the hot
         * spot.}
         */
        // warm up vm and let the hot spot.
        int wuc = Integer.getInteger(this.getClass().getName() + ".WarmUpHotSpotCount", 100000);
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration interval suite(Concat){
         * By default this phase will prepare and execute a benchmark with a minimum interval
         * 1.000.000 times. This integer value can be set with property
         * &quot;org.mili.jmibs.impl.DefaultIterationIntervalBenchmarkSuiteWarmUpHotSpotCount&quot;.}
         */
        System.out.println("Phase: warm up VM and let the hot spot.");
        // for legacy code only
        for (int i = 0, n = this.getBenchmarkClassList().size(); i < n; i++) {
            Class<?> cls = this.getBenchmarkClassList().get(i);
            IntervalBenchmark<?> olb = null;
            try {
                olb = (IntervalBenchmark<?>) cls.newInstance();
                this.addBenchmark(olb);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0, n = this.getBenchmarkList().size(); i < n; i++) {
            Benchmark b = this.getBenchmarkList().get(i);
            if (b instanceof IntervalBenchmark<?>) {
                IntervalBenchmark<I> olb = (IntervalBenchmark<I>) b;
                olb.setInterval((I) this.getIntervalList().get(0).getMinimumInterval());
                olb.getInterval().selectMinimum();
                for (int ii = 0; ii < wuc; ii++) {
                    olb.prepare();
                    olb.execute();
                }
            }
        }
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration interval suite(Concat){
         * After this phase all benchmarks will be prepared and executed in order with defined
         * suite settings.}
         */
        // traverse benches forward
        System.out.println("Phase: traverse forward");
        for (int i = 0, n = this.getBenchmarkList().size(); i < n; i++) {
            Benchmark b = this.getBenchmarkList().get(i);
            if (b instanceof IntervalBenchmark<?>) {
                this.startBench(bsr, (IntervalBenchmark<I>) b);
            }
        }
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration interval suite(Concat){
         * Then the suite will prepare and execute all the benchmarks again in reverse order and
         * merge the results. This ends the execution of the suite.}
         */
        // traverse benches backward
        System.out.println("Phase: traverse backward");
        for (int i = this.getBenchmarkList().size() - 1; i > -1; i--) {
            Benchmark b = this.getBenchmarkList().get(i);
            if (b instanceof IntervalBenchmark<?>) {
                this.startBench(bsr, (IntervalBenchmark<I>) b);
            }
        }
        return bsr;
    }

    private void startBench(DefaultIterationIntervalBenchmarkSuiteResult<I> diolbsr,
            IntervalBenchmark<I> olb) {
        for (int i = 0, n = this.intervalList.size(); i < n; i++) {
            I oc = this.intervalList.get(i);
            System.out.println(oc.getMin() + " - " + oc.getMax());
            for (int ii = 0, nn = this.iterationList.size(); ii < nn; ii++) {
                int ic = this.iterationList.get(ii);
                System.out.println("    " + ic);
                System.out.println("        " + olb.getName());
                DefaultBenchmarkResult dbr0 = this.iterate0(olb, oc, ic);
                DefaultIterationIntervalBenchmarkContext<I> diolbc = DefaultIterationIntervalBenchmarkContext
                        .create(olb, ic, oc);
                dbr0.setBenchmarkContext(diolbc);
                diolbsr.addPrepareResult(ic, oc, dbr0);
                DefaultBenchmarkResult dbr1 = this.iterate1(olb, ic, oc);
                diolbc = DefaultIterationIntervalBenchmarkContext.create(olb, ic, oc);
                dbr1.setBenchmarkContext(diolbc);
                diolbsr.addExecuteResult(ic, oc, dbr1);
            }
        }
    }

    private DefaultBenchmarkResult iterate0(IntervalBenchmark<I> olb, I oc, int ic) {
        DefaultBenchmarkResult dbr = this.prepare(olb, oc);
        long avg = oc.getDifference();
        dbr.setAverageTime(dbr.getTotalTime() / avg);
        dbr.setAverageTimeNanos(dbr.getTotalTimeNanos() / avg);
        DefaultIterationIntervalBenchmarkContext<I> diolbc = DefaultIterationIntervalBenchmarkContext
                .create(olb, ic, oc);
        dbr.setBenchmarkContext(diolbc);
        return dbr;
    }

    private DefaultBenchmarkResult iterate1(IntervalBenchmark<I> olb, int ic, I oc) {
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
        for (int i = 0; i < ic; i++) {
            DefaultBenchmarkResult dbr0 = this.execute(olb, oc);
            dbr.setMemoryInfoBefore(dbr0.getMemoryInfoBefore());
            dbr.setMemoryInfoAfter(dbr0.getMemoryInfoAfter());
            dbr.setTotalTime(dbr.getTotalTime() + dbr0.getTotalTime());
            dbr.setTotalTimeNanos(dbr.getTotalTimeNanos() + dbr0.getTotalTimeNanos());
        }
        dbr.setAverageTime(dbr.getTotalTime() / ic);
        dbr.setAverageTimeNanos(dbr.getTotalTimeNanos() / ic);
        return dbr;
    }

    private DefaultBenchmarkResult prepare(IntervalBenchmark<I> olb, I oc) {
        olb.setInterval(oc);
        MemoryInfo bmi = DefaultMemoryInfo.createActual();
        long ns = -System.nanoTime();
        long ms = -System.currentTimeMillis();
        olb.prepare();
        ms += System.currentTimeMillis();
        ns += System.nanoTime();
        MemoryInfo ami = DefaultMemoryInfo.createActual();
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
        dbr.setMemoryInfoBefore(bmi);
        dbr.setMemoryInfoAfter(ami);
        dbr.setTotalTime(ms);
        dbr.setTotalTimeNanos(ns);
        return dbr;
    }

    private DefaultBenchmarkResult execute(IntervalBenchmark<?> olb, Interval<?> oc) {
        MemoryInfo bmi = DefaultMemoryInfo.createActual();
        long ns = -System.nanoTime();
        long ms = -System.currentTimeMillis();
        oc.traverse(olb);
        ms += System.currentTimeMillis();
        ns += System.nanoTime();
        MemoryInfo ami = DefaultMemoryInfo.createActual();
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
        dbr.setMemoryInfoBefore(bmi);
        dbr.setMemoryInfoAfter(ami);
        dbr.setTotalTime(ms);
        dbr.setTotalTimeNanos(ns);
        return dbr;
    }

    /**
     * creates an then runs an ad hoc benchmark suite with included benchmarks.
     *
     * @param name name of benchmark suite.
     * @param rc result renderer class.
     * @param bs list of benchmarks.
     * @param ic iteration counts.
     * @param il intervals.
     * @return rendered benchmark suite result.
     */
    public static <X, I extends Interval<?>> Object createAndRun(String name,
            Class<? extends BenchmarkSuiteResultRenderer<X>> rc, Benchmark[] bs, int[] ic,
            I[] il) {
        if (ic == null) {
            throw new IllegalArgumentException("iteration list can't be null!");
        }
        if (il == null) {
            throw new IllegalArgumentException("interval list can't be null!");
        }
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        if (bs == null) {
            throw new IllegalArgumentException("benchmarks can't be null!");
        }
        if (rc == null) {
            throw new IllegalArgumentException("result renderer can't be null!");
        }
        BenchmarkSuiteResultRenderer<X> bsrs = null;
        try {
            bsrs = rc.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        List<Integer> l0 = new ArrayList<Integer>();
        for (int i = 0; i < ic.length; i++) {
            l0.add(ic[i]);
        }
        List<I> l1 = new ArrayList<I>();
        for (int i = 0; i < il.length; i++) {
            l1.add(il[i]);
        }
        IterationIntervalBenchmarkSuite<I> iolbs = DefaultIterationIntervalBenchmarkSuite
                .create(name, l0, l1);
        for (int i = 0; i < bs.length; i++) {
            iolbs.addBenchmark(bs[i]);
        }
        return bsrs.render(iolbs.execute());
    }

}

/*
 * DefaultIterationObjectLoadIntervalBenchmarkSuite.java
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
 * informations about iteration count, object loading count and intervals.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationObjectLoadIntervalBenchmarkSuite<I extends Interval<?>>
        extends AbstractBenchmarkSuite implements IterationObjectLoadIntervalBenchmarkSuite
        <ObjectLoadIntervalBenchmark<?, I>, I> {

    private List<Integer> iterationList = null;
    private List<Integer> objectLoadList = null;
    private List<I> intervalList = null;

    /**
     * creates a new default iteration object loading interval benchmark suite.
     */
    protected DefaultIterationObjectLoadIntervalBenchmarkSuite() {
        this(DefaultIterationObjectLoadIntervalBenchmarkSuite.class.getName(),
                new ArrayList<Integer>(), new ArrayList<Integer>(),
                new ArrayList<I>());
    }

    /**
     * creates a new named default iteration object loading interval benchmark suite.
     *
     * @param name name of the suite.
     */
    protected DefaultIterationObjectLoadIntervalBenchmarkSuite(String name) {
        this(name, new ArrayList<Integer>(), new ArrayList<Integer>(),
                new ArrayList<I>());
    }

    /**
     * creates a new default iteration object loading interval benchmark suite with list of
     * iteration counts, list of object loading counts and list of intervals.
     *
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     * @param intervalList list with intervals.
     */
    protected DefaultIterationObjectLoadIntervalBenchmarkSuite(List<Integer> iterationList,
            List<Integer> objectLoadList, List<I> intervalList) {
        this(DefaultIterationObjectLoadIntervalBenchmarkSuite.class.getName(), iterationList,
                objectLoadList, intervalList);
    }

    /**
     * creates a new named default iteration object loading benchmark suite with list of
     * iteration counts, list of object loading counts and list of intervals.
     *
     * @param name name of the suite.
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     * @param intervalList list with intervals.
     */
    protected DefaultIterationObjectLoadIntervalBenchmarkSuite(String name,
            List<Integer> iterationList, List<Integer> objectLoadList,
            List<I> intervalList) {
        super();
        if (iterationList == null) {
            throw new IllegalArgumentException("iteration list can't be null!");
        }
        if (objectLoadList == null) {
            throw new IllegalArgumentException("object loading list can't be null!");
        }
        if (intervalList == null) {
            throw new IllegalArgumentException("interval list can't be null!");
        }
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("name can't be empty!");
        }
        this.iterationList = iterationList;
        this.objectLoadList = objectLoadList;
        this.intervalList = intervalList;
        this.setName(name);
    }

    /**
     * creates a new default iteration object loading interval benchmark suite.
     *
     * @return new default iteration object loading interval benchmark suite.
     */
    public static <I extends Interval<?>> DefaultIterationObjectLoadIntervalBenchmarkSuite<I>
            create() {
        return DefaultIterationObjectLoadIntervalBenchmarkSuite.create(
                DefaultIterationObjectLoadIntervalBenchmarkSuite.class.getName(),
                new ArrayList<Integer>(), new ArrayList<Integer>(),
                new ArrayList<I>());
    }

    /**
     * creates a new named default iteration object loading interval benchmark suite.
     *
     * @param name name of the suite.
     * @return new default iteration object loading interval benchmark suite.
     */
    public static <I extends Interval<?>> DefaultIterationObjectLoadIntervalBenchmarkSuite<I>
            create(String name) {
        return DefaultIterationObjectLoadIntervalBenchmarkSuite.create(name,
                new ArrayList<Integer>(), new ArrayList<Integer>(),
                new ArrayList<I>());
    }

    /**
     * creates a new default iteration object loading interval benchmark suite with list of
     * iteration counts, list of object loading counts and list of intervals.
     *
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     * @param intervalList list with intervals.
     * @return new default iteration object loading intervak benchmark suite with list of
     *         iteration counts, list of object loading counts and list of intervals.
     */
    public static <I extends Interval<?>> DefaultIterationObjectLoadIntervalBenchmarkSuite<I>
            create(List<Integer> iterationList, List<Integer> objectLoadList,
            List<I> intervalList) {
        return DefaultIterationObjectLoadIntervalBenchmarkSuite.create(
                DefaultIterationObjectLoadIntervalBenchmarkSuite.class.getName(),
                iterationList, objectLoadList, intervalList);
    }

    /**
     * creates a new named default iteration object loading interval benchmark suite with list
     * of iteration counts, list of object loading counts and list of intervals.
     *
     * @param name name of the suite.
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     * @param intervalList list with intervals.
     * @return new default iteration object loading benchmark suite with list of iteration
     *         counts, list of object loading counts and list of intervals.
     */
    public static <I extends Interval<?>> DefaultIterationObjectLoadIntervalBenchmarkSuite<I>
            create(String name, List<Integer> iterationList, List<Integer> objectLoadList,
            List<I> intervalList) {
        return new DefaultIterationObjectLoadIntervalBenchmarkSuite<I>(name, iterationList,
                objectLoadList, intervalList);
    }

    @Override
    public List<Integer> getIterationList() {
        return this.iterationList;
    }

    @Override
    public List<Integer> getObjectLoadList() {
        return this.objectLoadList;
    }

    @Override
    public void addIteration(int iteration) {
        if (iteration <= 0) {
            throw new IllegalArgumentException("iteration must be positive!");
        }
        this.iterationList.add(iteration);
    }

    @Override
    public void addObjectLoad(int objectLoad) {
        if (objectLoad <= 0) {
            throw new IllegalArgumentException("object load must be positive!");
        }
        this.objectLoadList.add(objectLoad);
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
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load interval suite(Concat){
         * The execute method starts the proceeded to execute all benchmarks assigned to this
         * suite.}
         */
        DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<I> bsr =
                DefaultIterationObjectLoadIntervalBenchmarkSuiteResult.<I>create();
        bsr.setBenchmarkSuite(this);
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load interval suite(Concat){
         * First a virtual machine warm up phase is proceeding that tries to activate the hot
         * spot.}
         */
        // warm up vm and let the hot spot.
        int wuc = Integer.getInteger(this.getClass().getSimpleName() + ".WarmUpHotSpotCount",
                100000);
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load interval suite(Concat){
         * By default this phase will prepare and execute a benchmark with a one object loading
         * 1.000.000 times. This integer value can be set with property
         * &quot;org.mili.jmibs.impl.DefaultIterationObjectLoadIntervalBenchmarkSuite.WarmUpHotSpotCount&quot;.}
         */
        System.out.println("Phase: warm up VM and let the hot spot.");
        // for legacy code only
        for (int i = 0, n = this.getBenchmarkClassList().size(); i < n; i++) {
            Class<?> cls = this.getBenchmarkClassList().get(i);
            ObjectLoadIntervalBenchmark<?, ?> olb = null;
            try {
                olb = (ObjectLoadIntervalBenchmark<?, ?>) cls.newInstance();
                this.addBenchmark(olb);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0, n = this.getBenchmarkList().size(); i < n; i++) {
            Benchmark b = this.getBenchmarkList().get(i);
            if (b instanceof ObjectLoadIntervalBenchmark<?, ?>) {
                ObjectLoadIntervalBenchmark<?, I> olb = (ObjectLoadIntervalBenchmark<?, I>) b;
                olb.setObjectLoad(1);
                olb.setInterval((I) this.getIntervalList().get(0).getMinimumInterval());
                olb.getInterval().selectMinimum();
                for (int ii = 0; ii < wuc; ii++) {
                    olb.prepare();
                    olb.execute();
                }
            }
        }
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load interval suite(Concat){
         * After this phase all benchmarks will be prepared and executed in order with defined
         * suite settings.}
         */
        // traverse benches forward
        System.out.println("Phase: traverse forward");
        for (int i = 0, n = this.getBenchmarkList().size(); i < n; i++) {
            Benchmark b = this.getBenchmarkList().get(i);
            if (b instanceof ObjectLoadIntervalBenchmark<?, ?>) {
                this.startBench(bsr, (ObjectLoadIntervalBenchmark<?, I>) b);
            }
        }
        /*
         * @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load interval suite(Concat){
         * Then the suite will prepare and execute all the benchmarks again in reverse order and
         * merge the results. This ends the execution of the suite.}
         */
        // traverse benches backward
        System.out.println("Phase: traverse backward");
        for (int i = this.getBenchmarkList().size() - 1; i > -1; i--) {
            Benchmark b = this.getBenchmarkList().get(i);
            if (b instanceof ObjectLoadIntervalBenchmark<?, ?>) {
                this.startBench(bsr, (ObjectLoadIntervalBenchmark<?, I>) b);
            }
        }
        return bsr;
    }

    private void startBench(DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<I> diolbsr,
            ObjectLoadIntervalBenchmark<?, I> olb) {
        for (int i = 0, n = this.objectLoadList.size(); i < n; i++) {
            int oc = this.objectLoadList.get(i);
            System.out.println(oc);
            for (int ii = 0, nn = this.iterationList.size(); ii < nn; ii++) {
                int ic = this.iterationList.get(ii);
                System.out.println("    " + ic);
                System.out.println("        " + olb.getName());
                for (int iii = 0, nnn = this.intervalList.size(); iii < nnn; iii++) {
                    I interval = this.intervalList.get(iii);
                    System.out.println("            " + interval.getMin() + " - "
                            + interval.getMax());
                    DefaultBenchmarkResult dbr0 = this.iterate0(olb, oc, ic, (I) interval
                            .getMinimumInterval());
                    DefaultIterationObjectLoadIntervalBenchmarkContext<I> diolbc =
                            DefaultIterationObjectLoadIntervalBenchmarkContext.create(olb, ic,
                            oc, interval);
                    dbr0.setBenchmarkContext(diolbc);
                    diolbsr.addPrepareResult(ic, oc, interval, dbr0);
                    DefaultBenchmarkResult dbr1 = this.iterate1(olb, ic, interval);
                    diolbc = DefaultIterationObjectLoadIntervalBenchmarkContext.create(olb, ic,
                            oc, interval);
                    dbr1.setBenchmarkContext(diolbc);
                    diolbsr.addExecuteResult(ic, oc, interval, dbr1);
                }
            }
        }
    }

    private DefaultBenchmarkResult iterate0(ObjectLoadIntervalBenchmark<?, I> olb, int oc,
            int ic, I interval) {
        DefaultBenchmarkResult dbr = this.prepare(olb, oc, interval);
        dbr.setAverageTime(dbr.getTotalTime() / oc);
        dbr.setAverageTimeNanos(dbr.getTotalTimeNanos() / oc);
        DefaultIterationObjectLoadIntervalBenchmarkContext<I> diolbc =
                DefaultIterationObjectLoadIntervalBenchmarkContext.create(olb, ic, oc,
                interval);
        dbr.setBenchmarkContext(diolbc);
        return dbr;
    }

    private DefaultBenchmarkResult iterate1(ObjectLoadIntervalBenchmark<?, I> olb, int ic,
            I interval) {
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
        for (int i = 0; i < ic; i++) {
            DefaultBenchmarkResult dbr0 = this.execute(olb, interval);
            dbr.setMemoryInfoBefore(dbr0.getMemoryInfoBefore());
            dbr.setMemoryInfoAfter(dbr0.getMemoryInfoAfter());
            dbr.setTotalTime(dbr.getTotalTime() + dbr0.getTotalTime());
            dbr.setTotalTimeNanos(dbr.getTotalTimeNanos() + dbr0.getTotalTimeNanos());
        }
        dbr.setAverageTime(dbr.getTotalTime() / ic);
        dbr.setAverageTimeNanos(dbr.getTotalTimeNanos() / ic);
        return dbr;
    }

    private DefaultBenchmarkResult prepare(ObjectLoadIntervalBenchmark<?, I> olb, int oc,
            I interval) {
        olb.setObjectLoad(oc);
        olb.setInterval(interval);
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

    private DefaultBenchmarkResult execute(ObjectLoadIntervalBenchmark<?, I> olb,
            I interval) {
        MemoryInfo bmi = DefaultMemoryInfo.createActual();
        long ns = -System.nanoTime();
        long ms = -System.currentTimeMillis();
        interval.traverse(olb);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((iterationList == null) ? 0 : iterationList.hashCode());
        result = prime * result + ((objectLoadList == null) ? 0 : objectLoadList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultIterationObjectLoadIntervalBenchmarkSuite<I> other =
                (DefaultIterationObjectLoadIntervalBenchmarkSuite<I>) obj;
        if (iterationList == null) {
            if (other.iterationList != null)
                return false;
        } else if (!iterationList.equals(other.iterationList))
            return false;
        if (objectLoadList == null) {
            if (other.objectLoadList != null)
                return false;
        } else if (!objectLoadList.equals(other.objectLoadList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DefaultIterationObjectLoadIntervalBenchmarkSuite [intervalList=" + intervalList
                + ", iterationList=" + iterationList + ", objectLoadList=" + objectLoadList
                + "]";
    }

    /**
     * creates an then runs an ad hoc benchmark suite with included benchmarks.
     *
     * @param name name of benchmark suite.
     * @param rc result renderer class.
     * @param bs list of benchmarks.
     * @param ic iteration count.
     * @param ol object load count.
     * @param il list with intervals.
     * @return rendered benchmark suite result.
     */
    public static <I extends Interval<?>> Object createAndRun(String name,
            Class<? extends BenchmarkSuiteResultRenderer<?>> rc, Benchmark[] bs, int[] ic,
            int[] ol, I[] il) {
        BenchmarkSuiteResultRenderer<?> bsrs = null;
        try {
            bsrs = rc.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        List<Integer> l0 = new ArrayList<Integer>();
        for (int i = 0; i < ic.length; i++) {
            l0.add(ic[i]);
        }
        List<Integer> l1 = new ArrayList<Integer>();
        for (int i = 0; i < ol.length; i++) {
            l1.add(ol[i]);
        }
        List<I> l2 = new ArrayList<I>();
        for (int i = 0; i < il.length; i++) {
            l2.add(il[i]);
        }
        IterationObjectLoadIntervalBenchmarkSuite<?, I> iolbs =
                DefaultIterationObjectLoadIntervalBenchmarkSuite.create(name, l0, l1, l2);
        for (int i = 0; i < bs.length; i++) {
            iolbs.addBenchmark(bs[i]);
        }
        return bsrs.render(iolbs.execute());
    }

}

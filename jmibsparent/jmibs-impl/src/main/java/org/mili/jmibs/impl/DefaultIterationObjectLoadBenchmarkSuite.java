/*
 * DefaultIterationObjectLoadBenchmarkSuite.java
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

package org.mili.jmibs.impl;

import java.util.*;

import org.mili.jmibs.api.*;

/**
 * This class defines a special default implementation of a benchmark suite based on
 * informations about iteration count and object loading count.
 *
 * @author Michael Lieshoff
 * @version 1.2 23/04/2010
 * @since 1.0
 * @changed ML 23.04.2010 - fixed preparation loop, extended name create and constructor.
 */
public class DefaultIterationObjectLoadBenchmarkSuite extends AbstractBenchmarkSuite implements
        IterationObjectLoadBenchmarkSuite<ObjectLoadBenchmark<?>> {

    private List<Integer> iterationList = null;
    private List<Integer> objectLoadList = null;

    /**
     * creates a new default iteration object loading benchmark suite.
     */
    protected DefaultIterationObjectLoadBenchmarkSuite() {
        this(DefaultIterationObjectLoadBenchmarkSuite.class.getName(),
                new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    /**
     * creates a new named default iteration object loading benchmark suite.
     *
     * @param name name of the suite.
     */
    protected DefaultIterationObjectLoadBenchmarkSuite(String name) {
        this(name, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    /**
     * creates a new default iteration object loading benchmark suite with list of iteration
     * counts and list of object loading counts.
     *
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     */
    protected DefaultIterationObjectLoadBenchmarkSuite(List<Integer> iterationList,
            List<Integer> objectLoadList) {
        this(DefaultIterationObjectLoadBenchmarkSuite.class.getName(), iterationList,
                objectLoadList);
    }

    /**
     * creates a new named default iteration object loading benchmark suite with list of
     * iteration counts and list of object loading counts.
     *
     * @param name name of the suite.
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     */
    protected DefaultIterationObjectLoadBenchmarkSuite(String name,
            List<Integer> iterationList, List<Integer> objectLoadList) {
        super();
        if (iterationList == null) {
            throw new IllegalArgumentException("iteration list can't be null!");
        }
        if (objectLoadList == null) {
            throw new IllegalArgumentException("object loading list can't be null!");
        }
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        this.iterationList = iterationList;
        this.objectLoadList = objectLoadList;
        this.setName(name);
    }

    /**
     * creates a new default iteration object loading benchmark suite.
     *
     * @return new default iteration object loading benchmark suite.
     */
    public static DefaultIterationObjectLoadBenchmarkSuite create() {
        return DefaultIterationObjectLoadBenchmarkSuite.create(
                DefaultIterationObjectLoadBenchmarkSuite.class.getName(),
                new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    /**
     * creates a new named default iteration object loading benchmark suite.
     *
     * @param name name of the suite.
     * @return new default iteration object loading benchmark suite.
     */
    public static DefaultIterationObjectLoadBenchmarkSuite create(String name) {
        return DefaultIterationObjectLoadBenchmarkSuite.create(name, new ArrayList<Integer>(),
                new ArrayList<Integer>());
    }

    /**
     * creates a new default iteration object loading benchmark suite with list of iteration
     * counts and list of object loading counts.
     *
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     * @return new default iteration object loading benchmark suite with list of iteration
     *         counts and list of object loading counts.
     */
    public static DefaultIterationObjectLoadBenchmarkSuite create(List<Integer> iterationList,
            List<Integer> objectLoadList) {
        return DefaultIterationObjectLoadBenchmarkSuite.create(
                DefaultIterationObjectLoadBenchmarkSuite.class.getName(), iterationList,
                objectLoadList);
    }

    /**
     * creates a new named default iteration object loading benchmark suite with list of
     * iteration counts and list of object loading counts.
     *
     * @param name name of the suite.
     * @param iterationList list with iteration counts.
     * @param objectLoadList list with object loading counts.
     * @return new default iteration object loading benchmark suite with list of iteration
     *         counts and list of object loading counts.
     */
    public static DefaultIterationObjectLoadBenchmarkSuite create(String name,
            List<Integer> iterationList, List<Integer> objectLoadList) {
        return new DefaultIterationObjectLoadBenchmarkSuite(name, iterationList,
                objectLoadList);
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
    public BenchmarkSuiteResult execute() {
        /* @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load suite(Concat){
         * The execute method starts the proceeded to execute all benchmarks assigned to this
         * suite.}*/
        DefaultIterationObjectLoadBenchmarkSuiteResult bsr =
                DefaultIterationObjectLoadBenchmarkSuiteResult.create();
        bsr.setBenchmarkSuite(this);
        /* @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load suite(Concat){
         * First a virtual machine warm up phase is proceeding that tries to activate the hot
         * spot.}*/
        // warm up vm and let the hot spot.
        int wuc = Integer.getInteger(this.getClass().getSimpleName() + ".WarmUpHotSpotCount",
                100000);
        /* @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load suite(Concat){
         * By default this phase will prepare and execute a benchmark with a one object loading
         * 1.000.000 times. This integer value can be set with property
         * &quot;org.mili.jmibs.impl.WarmUpHotSpotCount&quot;.}*/
        System.out.println("Phase: warm up VM and let the hot spot.");
        for (int i = 0, n = this.getBenchmarkClassList().size(); i < n; i++) {
            Class<?> cls = this.getBenchmarkClassList().get(i);
            ObjectLoadBenchmark<?> olb = null;
            try {
                olb = (ObjectLoadBenchmark<?>) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            olb.setObjectLoad(1);
            for (int ii = 0; ii < wuc; ii++) {
                olb.prepare();
                olb.execute();
            }
        }
        /* @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load suite(Concat){
         * After this phase all benchmarks will be prepared and executed in order with defined
         * suite settings.}*/
        // traverse benches forward
        System.out.println("Phase: traverse forward");
        for (int i = 0, n = this.getBenchmarkClassList().size(); i < n; i++) {
            Class<?> cls = this.getBenchmarkClassList().get(i);
            ObjectLoadBenchmark<?> olb = null;
            try {
                olb = (ObjectLoadBenchmark<?>) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            this.startBench(bsr, olb);
        }
        /* @doc jMibs/III/How it works?/1. Benchmark suites/Iteration object load suite(Concat){
         * Then the suite will prepare and execute all the benchmarks again in reverse order and
         * merge the results. This ends the execution of the suite.}*/
        // traverse benches backward
        System.out.println("Phase: traverse backward");
        for (int i = this.getBenchmarkClassList().size() - 1; i > -1; i--) {
            Class<?> cls = this.getBenchmarkClassList().get(i);
            ObjectLoadBenchmark<?> olb = null;
            try {
                olb = (ObjectLoadBenchmark<?>) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            this.startBench(bsr, olb);
        }
        return bsr;
    }

    private void startBench(DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr,
            ObjectLoadBenchmark<?> olb) {
        for (int i = 0, n = this.objectLoadList.size(); i < n; i++) {
            int oc = this.objectLoadList.get(i);
            System.out.println(oc);
            for (int ii = 0, nn = this.iterationList.size(); ii < nn; ii++) {
                int ic = this.iterationList.get(ii);
                System.out.println("    " + ic);
                System.out.println("        " + olb.getName());
                DefaultBenchmarkResult dbr0 = this.iterate0(olb, oc, ic);
                DefaultIterationObjectLoadBenchmarkContext diolbc =
                        DefaultIterationObjectLoadBenchmarkContext.create(olb, ic, oc);
                dbr0.setBenchmarkContext(diolbc);
                diolbsr.addPrepareResult(ic, oc, dbr0);
                DefaultBenchmarkResult dbr1 = this.iterate1(olb, ic);
                diolbc = DefaultIterationObjectLoadBenchmarkContext.create(olb, ic, oc);
                dbr1.setBenchmarkContext(diolbc);
                diolbsr.addExecuteResult(ic, oc, dbr1);
            }
        }
    }

    private DefaultBenchmarkResult iterate0(ObjectLoadBenchmark<?> olb, int oc, int ic) {
        DefaultBenchmarkResult dbr = this.prepare(olb, oc);
        dbr.setAverageTime(dbr.getTotalTime() / oc);
        dbr.setAverageTimeNanos(dbr.getTotalTimeNanos() / oc);
        DefaultIterationObjectLoadBenchmarkContext diolbc =
                DefaultIterationObjectLoadBenchmarkContext.create(olb, ic, oc);
        dbr.setBenchmarkContext(diolbc);
        return dbr;
    }

    private DefaultBenchmarkResult iterate1(ObjectLoadBenchmark<?> olb, int ic) {
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
        for (int i = 0; i < ic; i++) {
            DefaultBenchmarkResult dbr0 = this.execute(olb);
            dbr.setTotalTime(dbr.getTotalTime() + dbr0.getTotalTime());
            dbr.setTotalTimeNanos(dbr.getTotalTimeNanos() + dbr0.getTotalTimeNanos());
        }
        dbr.setAverageTime(dbr.getTotalTime() / ic);
        dbr.setAverageTimeNanos(dbr.getTotalTimeNanos() / ic);
        return dbr;
    }

    private DefaultBenchmarkResult prepare(ObjectLoadBenchmark<?> olb, int oc) {
        olb.setObjectLoad(oc);
        long ns = -System.nanoTime();
        long ms = -System.currentTimeMillis();
        olb.prepare();
        ms += System.currentTimeMillis();
        ns += System.nanoTime();
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
        dbr.setTotalTime(ms);
        dbr.setTotalTimeNanos(ns);
        return dbr;
    }

    private DefaultBenchmarkResult execute(ObjectLoadBenchmark<?> olb) {
        long ns = -System.nanoTime();
        long ms = -System.currentTimeMillis();
        olb.execute();
        ms += System.currentTimeMillis();
        ns += System.nanoTime();
        DefaultBenchmarkResult dbr = DefaultBenchmarkResult.create();
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
        DefaultIterationObjectLoadBenchmarkSuite other =
                (DefaultIterationObjectLoadBenchmarkSuite) obj;
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
        return "DefaultIterationObjectLoadBenchmarkSuite [iterationList=" + iterationList
                + ", objectLoadList=" + objectLoadList + "]";
    }

    /**
     * creates an then runs an ad hoc benchmark suite with included benchmarks.
     *
     * @param name name of benchmark suite.
     * @param rc result renderer class.
     * @param bs list of benchmarks.
     * @param ic iteration count.
     * @param ol object load count.
     * @return rendered benchmark suite result.
     */
    public static <T> Object createAndRun(String name,
            Class<? extends BenchmarkSuiteResultRenderer<T>> rc, Benchmark[] bs, int[] ic,
            int[] ol) {
        BenchmarkSuiteResultRenderer<T> bsrs = null;
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
        IterationObjectLoadBenchmarkSuite<ObjectLoadBenchmark<?>> iolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create(name, l0, l1);
        return bsrs.render(iolbs.execute());
    }

}

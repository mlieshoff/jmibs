/*
 * DefaultIterationObjectLoadIntervalBenchmarkSuiteResult.java
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
 * This class defines a special default implementation of a benchmark suite result that is based
 * on informations about iteration count, object loading count and intervals.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.0
 */
public class DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<I extends Interval<?>>
        extends DefaultBenchmarkSuiteResult
        implements IterationObjectLoadIntervalBenchmarkSuiteResult<I> {

    private Map<Integer, Map<Integer, Map<I, List<BenchmarkResult>>>> prepare =
            new TreeMap<Integer, Map<Integer, Map<I, List<BenchmarkResult>>>>();
    private Map<Integer, Map<Integer, Map<I, List<BenchmarkResult>>>> execute =
            new TreeMap<Integer, Map<Integer, Map<I, List<BenchmarkResult>>>>();

    /**
     * creates a new empty default iteration object load interval benchmark suite result.
     */
    protected DefaultIterationObjectLoadIntervalBenchmarkSuiteResult() {
        super();
    }

    /**
     * creates a new empty default iteration object load interval benchmark suite result.
     *
     * @return new empty default iteration object load interval benchmark suite result.
     */
    public static <I extends Interval<?>>
            DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<I> create() {
        return new DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<I>();
    }

    @Override
    public List<BenchmarkResult> getExecuteResults() {
        List<BenchmarkResult> l = new ArrayList<BenchmarkResult>();
        for (Iterator<Integer> i = this.execute.keySet().iterator(); i.hasNext();) {
            Map<Integer, Map<I, List<BenchmarkResult>>> m = this.execute
                    .get(i.next());
            for (Iterator<Integer> ii = m.keySet().iterator(); ii.hasNext();) {
                int k = ii.next();
                Map<I, List<BenchmarkResult>> m0 = m.get(k);
                for (Iterator<I> iii = m0.keySet().iterator(); iii.hasNext();) {
                    l.addAll(m0.get(iii.next()));
                }
            }
        }
        return l;
    }

    @Override
    public List<BenchmarkResult> getPrepareResults() {
        List<BenchmarkResult> l = new ArrayList<BenchmarkResult>();
        for (Iterator<Integer> i = this.prepare.keySet().iterator(); i.hasNext();) {
            Map<Integer, Map<I, List<BenchmarkResult>>> m = this.prepare
                    .get(i.next());
            for (Iterator<Integer> ii = m.keySet().iterator(); ii.hasNext();) {
                int k = ii.next();
                Map<I, List<BenchmarkResult>> m0 = m.get(k);
                for (Iterator<I> iii = m0.keySet().iterator(); iii.hasNext();) {
                    l.addAll(m0.get(iii.next()));
                }
            }
        }
        return l;
    }

    @Override
    public List<BenchmarkResult> getExecuteResult(int iteration, int objectLoad,
            I interval) {
        return this.execute.get(iteration).get(objectLoad).get(interval);
    }

    @Override
    public List<BenchmarkResult> getPrepareResult(int iteration, int objectLoad,
            I interval) {
        return this.prepare.get(iteration).get(objectLoad).get(interval);
    }

    /**
     * adds a benchmark result to specified iteration count, object loading count and interval
     * to execute results.
     *
     * @param iteration the iteration count.
     * @param objectLoad the object loading count.
     * @param interval the interval.
     * @param br benchmark result to add.
     */
    public void addExecuteResult(int iteration, int objectLoad, I interval,
            BenchmarkResult br) {
        this.add(iteration, objectLoad, interval, br, this.execute);
    }

    /**
     * adds a benchmark result to specified iteration count, object loading count and interval
     * to prepare results.
     *
     * @param iteration the iteration count.
     * @param objectLoad the object loading count.
     * @param interval the interval.
     * @param br benchmark result to add.
     */
    public void addPrepareResult(int iteration, int objectLoad, I interval,
            BenchmarkResult br) {
        this.add(iteration, objectLoad, interval, br, this.prepare);
    }

    private void add(int iteration, int objectLoad, I interval, BenchmarkResult br,
            Map<Integer, Map<Integer, Map<I, List<BenchmarkResult>>>> mm) {
        Map<Integer, Map<I, List<BenchmarkResult>>> m = mm.get(iteration);
        if (m == null) {
            m = new TreeMap<Integer, Map<I, List<BenchmarkResult>>>();
        }
        Map<I, List<BenchmarkResult>> m0 = m.get(objectLoad);
        if (m0 == null) {
            m0 = new TreeMap<I, List<BenchmarkResult>>();
        }
        List<BenchmarkResult> l = m0.get(interval);
        if (l == null) {
            l = new ArrayList<BenchmarkResult>();
            l.add(br);
        } else if (!this.update(l, br)) {
            l.add(br);
        }
        m0.put(interval, l);
        m.put(objectLoad, m0);
        mm.put(iteration, m);
    }

    private boolean update(List<BenchmarkResult> l, BenchmarkResult br) {
        for (int i = 0, n = l.size(); i < n; i++) {
            BenchmarkResult br0 = l.get(i);
            if (br0.getBenchmarkContext().getBenchmark().getName().equals(
                    br.getBenchmarkContext().getBenchmark().getName())) {
                br0.setTotalTime((br0.getTotalTime() + br.getTotalTime()) / 2);
                br0.setAverageTime((br0.getAverageTime() + br.getAverageTime()) / 2);
                br0.setTotalTimeNanos((br0.getTotalTimeNanos() + br.getTotalTimeNanos()) / 2);
                br0.setAverageTimeNanos((br0.getAverageTimeNanos() + br.getAverageTimeNanos())
                        / 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "DefaultIterationObjectLoadBenchmarkSuiteResult [execute=" + execute
                + ", prepare=" + prepare + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((execute == null) ? 0 : execute.hashCode());
        result = prime * result + ((prepare == null) ? 0 : prepare.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<?> other =
                (DefaultIterationObjectLoadIntervalBenchmarkSuiteResult<?>) obj;
        if (execute == null) {
            if (other.execute != null)
                return false;
        } else if (!execute.equals(other.execute))
            return false;
        if (prepare == null) {
            if (other.prepare != null)
                return false;
        } else if (!prepare.equals(other.prepare))
            return false;
        return true;
    }

}

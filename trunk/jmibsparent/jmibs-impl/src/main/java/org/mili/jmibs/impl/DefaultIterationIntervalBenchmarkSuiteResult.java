/*
 * DefaultIterationIntervalBenchmarkSuiteResult.java
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
 * on informations about iteration count and interval.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationIntervalBenchmarkSuiteResult<I extends Interval<?>> extends
        DefaultBenchmarkSuiteResult implements IterationIntervalBenchmarkSuiteResult<I> {

    private Map<Integer, Map<I, List<BenchmarkResult>>> prepare =
            new TreeMap<Integer, Map<I, List<BenchmarkResult>>>();
    private Map<Integer, Map<I, List<BenchmarkResult>>> execute =
            new TreeMap<Integer, Map<I, List<BenchmarkResult>>>();

    /**
     * creates a new empty default iteration interval benchmark suite result.
     */
    protected DefaultIterationIntervalBenchmarkSuiteResult() {
        super();
    }

    /**
     * creates a new empty default iteration interval benchmark suite result.
     *
     * @return new empty default iteration interval benchmark suite result.
     */
    public static <I extends Interval<?>> DefaultIterationIntervalBenchmarkSuiteResult<I>
            create() {
        return new DefaultIterationIntervalBenchmarkSuiteResult<I>();
    }

    @Override
    public List<BenchmarkResult> getExecuteResults() {
        List<BenchmarkResult> l = new ArrayList<BenchmarkResult>();
        for (Iterator<Integer> i = this.execute.keySet().iterator(); i.hasNext();) {
            Map<I, List<BenchmarkResult>> m = this.execute.get(i.next());
            for (Iterator<I> ii = m.keySet().iterator(); ii.hasNext();) {
                I nii = ii.next();
                l.addAll(m.get(nii));
            }
        }
        return l;
    }

    @Override
    public List<BenchmarkResult> getPrepareResults() {
        List<BenchmarkResult> l = new ArrayList<BenchmarkResult>();
        for (Iterator<Integer> i = this.prepare.keySet().iterator(); i.hasNext();) {
            Map<I, List<BenchmarkResult>> m = this.prepare.get(i.next());
            for (Iterator<I> ii = m.keySet().iterator(); ii.hasNext();) {
                l.addAll(m.get(ii.next()));
            }
        }
        return l;
    }

    @Override
    public List<BenchmarkResult> getExecuteResult(int iteration, I interval) {
        return this.execute.get(iteration).get(interval);
    }

    @Override
    public List<BenchmarkResult> getPrepareResult(int iteration, I interval) {
        return this.prepare.get(iteration).get(interval);
    }

    /**
     * adds a benchmark result to specified iteration count and interval to execute results.
     *
     * @param iteration the iteration count.
     * @param interval the interval.
     * @param br benchmark result to add.
     */
    public void addExecuteResult(int iteration, I interval, BenchmarkResult br) {
        this.add(iteration, interval, br, this.execute);
    }

    /**
     * adds a benchmark result to specified iteration count and interval to prepare results.
     *
     * @param iteration the iteration count.
     * @param interval the interval.
     * @param br benchmark result to add.
     */
    public void addPrepareResult(int iteration, I interval, BenchmarkResult br) {
        this.add(iteration, interval, br, this.prepare);
    }

    private void add(int iteration, I interval, BenchmarkResult br,
            Map<Integer, Map<I, List<BenchmarkResult>>> mm) {
        Map<I, List<BenchmarkResult>> m = mm.get(iteration);
        if (m == null) {
            m = new TreeMap<I, List<BenchmarkResult>>();
        }
        List<BenchmarkResult> l = m.get(interval);
        if (l == null) {
            l = new ArrayList<BenchmarkResult>();
            l.add(br);
        } else if (!this.update(l, br)) {
            l.add(br);
        }
        m.put(interval, l);
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
                br0
                        .setAverageTimeNanos((br0.getAverageTimeNanos() + br
                                .getAverageTimeNanos()) / 2);
                return true;
            }
        }
        return false;
    }

}

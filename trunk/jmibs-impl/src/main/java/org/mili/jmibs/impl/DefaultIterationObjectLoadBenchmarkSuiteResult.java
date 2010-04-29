/**
 * DefaultIterationObjectLoadBenchmarkSuiteResult.java
 *
 * 12.04.2010
 *
 * Copyright 2010 Michael Lieshoff
 */

/*
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
 * on informations about iteration count an object loading count.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class DefaultIterationObjectLoadBenchmarkSuiteResult extends DefaultBenchmarkSuiteResult
        implements IterationObjectLoadBenchmarkSuiteResult {

    private Map<Integer, Map<Integer, List<BenchmarkResult>>> prepare =
            new TreeMap<Integer, Map<Integer, List<BenchmarkResult>>>();
    private Map<Integer, Map<Integer, List<BenchmarkResult>>> execute =
            new TreeMap<Integer, Map<Integer, List<BenchmarkResult>>>();

    /**
     * creates a new empty default iteration object load benhmark suite result.
     */
    protected DefaultIterationObjectLoadBenchmarkSuiteResult() {
        super();
    }

    /**
     * creates a new empty default iteration object load benhmark suite result.
     *
     * @return new empty default iteration object load benhmark suite result.
     */
    public static DefaultIterationObjectLoadBenchmarkSuiteResult create() {
        return new DefaultIterationObjectLoadBenchmarkSuiteResult();
    }

    @Override
    public List<BenchmarkResult> getExecuteResults() {
        List<BenchmarkResult> l = new ArrayList<BenchmarkResult>();
        for (Iterator<Integer> i = this.execute.keySet().iterator(); i.hasNext();) {
            Map<Integer, List<BenchmarkResult>> m = this.execute.get(i.next());
            for (Iterator<Integer> ii = m.keySet().iterator(); ii.hasNext();) {
                int nii = ii.next();
                l.addAll(m.get(nii));
            }
        }
        return l;
    }

    @Override
    public List<BenchmarkResult> getPrepareResults() {
        List<BenchmarkResult> l = new ArrayList<BenchmarkResult>();
        for (Iterator<Integer> i = this.prepare.keySet().iterator(); i.hasNext();) {
            Map<Integer, List<BenchmarkResult>> m = this.prepare.get(i.next());
            for (Iterator<Integer> ii = m.keySet().iterator(); ii.hasNext();) {
                l.addAll(m.get(ii.next()));
            }
        }
        return l;
    }

    @Override
    public List<BenchmarkResult> getExecuteResult(int iteration, int objectLoad) {
        return this.execute.get(iteration).get(objectLoad);
    }

    @Override
    public List<BenchmarkResult> getPrepareResult(int iteration, int objectLoad) {
        return this.prepare.get(iteration).get(objectLoad);
    }

    /**
     * adds a benchmark result to specified iteration count and object loading count to execute
     * results.
     *
     * @param iteration the iteration count.
     * @param objectLoad the object loading count.
     * @param br benchmark result to add.
     */
    public void addExecuteResult(int iteration, int objectLoad, BenchmarkResult br) {
        this.add(iteration, objectLoad, br, this.execute);
    }

    /**
     * adds a benchmark result to specified iteration count and object loading count to prepare
     * results.
     *
     * @param iteration the iteration count.
     * @param objectLoad the object loading count.
     * @param br benchmark result to add.
     */
    public void addPrepareResult(int iteration, int objectLoad, BenchmarkResult br) {
        this.add(iteration, objectLoad, br, this.prepare);
    }

    private void add(int iteration, int objectLoad, BenchmarkResult br,
            Map<Integer, Map<Integer, List<BenchmarkResult>>> mm) {
        Map<Integer, List<BenchmarkResult>> m = mm.get(iteration);
        if (m == null) {
            m = new TreeMap<Integer, List<BenchmarkResult>>();
        }
        List<BenchmarkResult> l = m.get(objectLoad);
        if (l == null) {
            l = new ArrayList<BenchmarkResult>();
            l.add(br);
        } else if (!this.update(l, br)) {
            l.add(br);
        }
        m.put(objectLoad, l);
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
        DefaultIterationObjectLoadBenchmarkSuiteResult other =
                (DefaultIterationObjectLoadBenchmarkSuiteResult) obj;
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

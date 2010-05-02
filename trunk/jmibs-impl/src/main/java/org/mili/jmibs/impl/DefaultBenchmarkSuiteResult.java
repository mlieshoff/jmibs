/*
 * DefaultBenchmarkSuiteResult.java
 *
 * 13.04.2010
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
 * This class defines a default implementation of benchmark suite result interface.
 *
 * @author Michael Lieshoff
 * @version 1.0 13.04.2010
 * @since 1.0
 */
public class DefaultBenchmarkSuiteResult implements BenchmarkSuiteResult {

    private List<BenchmarkResult> executeResult = new ArrayList<BenchmarkResult>();
    private List<BenchmarkResult> prepareResult = new ArrayList<BenchmarkResult>();
    private BenchmarkSuite benchmarkSuite = null;

    /**
     * creates a new empty default benchmark suite result.
     */
    protected DefaultBenchmarkSuiteResult() {
        super();
    }

    /**
     * creates a new empty default benchmark suite result.
     *
     * @return new empty default benchmark suite result.
     */
    public static DefaultBenchmarkSuiteResult create() {
        DefaultBenchmarkSuiteResult dbsr = new DefaultBenchmarkSuiteResult();
        return dbsr;
    }

    @Override
    public List<BenchmarkResult> getExecuteResults() {
        return this.executeResult;
    }

    @Override
    public List<BenchmarkResult> getPrepareResults() {
        return this.prepareResult;
    }

    @Override
    public void addExecuteResult(BenchmarkResult br) {
        this.executeResult.add(br);
    }

    @Override
    public void addPrepareResult(BenchmarkResult br) {
        this.prepareResult.add(br);
    }

    /**
     * @return the underlying benchmark suite
     */
    public BenchmarkSuite getBenchmarkSuite() {
        return this.benchmarkSuite;
    }

    /**
     * @param benchmarkSuite the benchmark suite to set
     */
    public void setBenchmarkSuite(BenchmarkSuite benchmarkSuite) {
        this.benchmarkSuite = benchmarkSuite;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((benchmarkSuite == null) ? 0 : benchmarkSuite.hashCode());
        result = prime * result + ((executeResult == null) ? 0 : executeResult.hashCode());
        result = prime * result + ((prepareResult == null) ? 0 : prepareResult.hashCode());
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
        DefaultBenchmarkSuiteResult other = (DefaultBenchmarkSuiteResult) obj;
        if (benchmarkSuite == null) {
            if (other.benchmarkSuite != null)
                return false;
        } else if (!benchmarkSuite.equals(other.benchmarkSuite))
            return false;
        if (executeResult == null) {
            if (other.executeResult != null)
                return false;
        } else if (!executeResult.equals(other.executeResult))
            return false;
        if (prepareResult == null) {
            if (other.prepareResult != null)
                return false;
        } else if (!prepareResult.equals(other.prepareResult))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DefaultBenchmarkSuiteResult [benchmarkSuite=" + benchmarkSuite
                + ", executeResult=" + executeResult + ", prepareResult=" + prepareResult + "]";
    }

}

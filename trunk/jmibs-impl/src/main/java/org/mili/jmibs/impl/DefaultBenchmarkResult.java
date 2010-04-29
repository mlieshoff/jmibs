/**
 * DefaultBenchmarkResult.java
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

import org.mili.jmibs.api.*;

/**
 * This class defines a default implementation of a benchmark result.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class DefaultBenchmarkResult implements BenchmarkResult {

    private long averageTimeMs = 0;
    private long averageTimeNs = 0;
    private long totalTimeMs = 0;
    private long totalTimeNs = 0;
    private BenchmarkContext benchmarkContext = null;

    /**
     * creates a new empty default benchmark result.
     */
    protected DefaultBenchmarkResult() {
        super();
    }

    /**
     * creates a new empty default benchmark result.
     *
     * @return new empty default benchmark result.
     */
    public static DefaultBenchmarkResult create() {
        return new DefaultBenchmarkResult();
    }

    /**
     * creates a new default benchmark result with benchmark context.
     *
     * @param benchmarkContext the benchmark context.
     * @return new default benchmark result with benchmark context.
     */
    public static DefaultBenchmarkResult create(BenchmarkContext benchmarkContext) {
        if (benchmarkContext == null) {
            throw new IllegalArgumentException("benchmark context can't be null!");
        }
        DefaultBenchmarkResult dbr = new DefaultBenchmarkResult();
        dbr.setBenchmarkContext(benchmarkContext);
        return dbr;
    }

    @Override
    public long getAverageTime() {
        return this.averageTimeMs;
    }

    @Override
    public long getAverageTimeNanos() {
        return this.averageTimeNs;
    }

    @Override
    public BenchmarkContext getBenchmarkContext() {
        return this.benchmarkContext;
    }

    @Override
    public long getTotalTime() {
        return this.totalTimeMs;
    }

    @Override
    public long getTotalTimeNanos() {
        return this.totalTimeNs;
    }

    /**
     * @param benchmarkContext the benchmark context to set
     */
    public void setBenchmarkContext(BenchmarkContext benchmarkContext) {
        this.benchmarkContext = benchmarkContext;
    }

    /**
     * @param ms average time in ms.
     */
    public void setAverageTime(long ms) {
        this.averageTimeMs = ms;
    }

    /**
     * @param ns average time in ns.
     */
    public void setAverageTimeNanos(long ns) {
        this.averageTimeNs = ns;
    }

    /**
     * @param ms total time in ms.
     */
    public void setTotalTime(long ms) {
        this.totalTimeMs = ms;
    }

    /**
     * @param ns total time in ns.
     */
    public void setTotalTimeNanos(long ns) {
        this.totalTimeNs = ns;
    }

    @Override
    public String toString() {
        return "DefaultBenchmarkResult [averageTimeMs=" + averageTimeMs + ", averageTimeNs="
                + averageTimeNs + ", benchmarkContext=" + benchmarkContext + ", totalTimeMs="
                + totalTimeMs + ", totalTimeNs=" + totalTimeNs + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (averageTimeMs ^ (averageTimeMs >>> 32));
        result = prime * result + (int) (averageTimeNs ^ (averageTimeNs >>> 32));
        result = prime * result
                + ((benchmarkContext == null) ? 0 : benchmarkContext.hashCode());
        result = prime * result + (int) (totalTimeMs ^ (totalTimeMs >>> 32));
        result = prime * result + (int) (totalTimeNs ^ (totalTimeNs >>> 32));
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
        DefaultBenchmarkResult other = (DefaultBenchmarkResult) obj;
        if (averageTimeMs != other.averageTimeMs)
            return false;
        if (averageTimeNs != other.averageTimeNs)
            return false;
        if (benchmarkContext == null) {
            if (other.benchmarkContext != null)
                return false;
        } else if (!benchmarkContext.equals(other.benchmarkContext))
            return false;
        if (totalTimeMs != other.totalTimeMs)
            return false;
        if (totalTimeNs != other.totalTimeNs)
            return false;
        return true;
    }

}

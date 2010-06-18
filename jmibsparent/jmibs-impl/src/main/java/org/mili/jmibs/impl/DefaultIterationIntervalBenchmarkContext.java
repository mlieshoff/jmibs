/*
 * DefaultIterationIntervalBenchmarkContext.java
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

import org.mili.jmibs.api.*;

/**
 * This class defines a special default implementation for a benchmark context based on
 * informations about iterations and intervals.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationIntervalBenchmarkContext<I extends Interval<?>>
        extends DefaultBenchmarkContext implements IterationIntervalBenchmarkContext<I> {

    private int iteration = 0;
    private I interval = null;

    /**
     * creates a new empty default iteration interval benchmark context.
     */
    protected DefaultIterationIntervalBenchmarkContext() {
        super();
    }

    /**
     * creates a new default iteration interval benchmark context with benchmark and
     * informations about iterations and intervals.
     *
     * @param benchmark underlying benchmark.
     * @param iteration iteration count.
     * @param interval the interval.
     * @return new default iteration interval benchmark context with benchmark and
     *         informations about iterations and intervals.
     */
    public static <I extends Interval<?>> DefaultIterationIntervalBenchmarkContext<I> create(
            Benchmark benchmark, int iteration, I interval) {
        if (benchmark == null) {
            throw new IllegalArgumentException("benchmark can't be null!");
        }
        if (iteration <= 0) {
            throw new IllegalArgumentException("iteration must be positve!");
        }
        if (interval == null) {
            throw new IllegalArgumentException("interval can't be null!");
        }
        DefaultIterationIntervalBenchmarkContext<I> diolbc = new DefaultIterationIntervalBenchmarkContext<I>();
        diolbc.setBenchmark(benchmark);
        diolbc.setIteration(iteration);
        diolbc.setInterval(interval);
        return diolbc;
    }

    /**
     * @param iteration the iteration count to set
     */
    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(I interval) {
        this.interval = interval;
    }

    @Override
    public int getIteration() {
        return this.iteration;
    }

    @Override
    public I getInterval() {
        return this.interval;
    }

    @Override
    public String toString() {
        return "DefaultIterationIntervalBenchmarkContext [interval=" + interval
                + ", iteration=" + iteration + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((interval == null) ? 0 : interval.hashCode());
        result = prime * result + iteration;
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
        DefaultIterationIntervalBenchmarkContext<?> other =
                (DefaultIterationIntervalBenchmarkContext<?>) obj;
        if (interval == null) {
            if (other.interval != null)
                return false;
        } else if (!interval.equals(other.interval))
            return false;
        if (iteration != other.iteration)
            return false;
        return true;
    }

}

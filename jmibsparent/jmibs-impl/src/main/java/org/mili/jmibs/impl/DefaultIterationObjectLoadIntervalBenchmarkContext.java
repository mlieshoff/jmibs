/*
 * DefaultIterationObjectLoadIntervalBenchmarkContext.java
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
 * informations about iterations, object loading count and interval.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationObjectLoadIntervalBenchmarkContext<I extends Interval<?>>
        extends DefaultBenchmarkContext
        implements IterationObjectLoadIntervalBenchmarkContext<I> {

    private int iteration = 0;
    private int objectLoad = 0;
    private I interval = null;

    /**
     * creates a new empty default iteration object loading interval benchmark context.
     */
    protected DefaultIterationObjectLoadIntervalBenchmarkContext() {
        super();
    }

    /**
     * creates a new default iteration object loading benchmark context with benchmark and
     * informations about iterations, object loading counts and interval.
     *
     * @param benchmark underlying benchmark.
     * @param iteration iteration count.
     * @param objectLoad object loading count.
     * @param interval list with intervals.
     * @return new default iteration object loading benchmark context with benchmark and
     *         informations about iterations, object loading counts and interval.
     */
    public static <I extends Interval<?>> DefaultIterationObjectLoadIntervalBenchmarkContext<I>
            create(Benchmark benchmark, int iteration, int objectLoad, I interval) {
        if (benchmark == null) {
            throw new IllegalArgumentException("benchmark can't be null!");
        }
        if (interval == null) {
            throw new IllegalArgumentException("interval can't be null!");
        }
        if (iteration <= 0) {
            throw new IllegalArgumentException("iteration must be positve!");
        }
        if (objectLoad <= 0) {
            throw new IllegalArgumentException("object load must be positve!");
        }
        DefaultIterationObjectLoadIntervalBenchmarkContext<I> diolbc =
                new DefaultIterationObjectLoadIntervalBenchmarkContext<I>();
        diolbc.setBenchmark(benchmark);
        diolbc.setIteration(iteration);
        diolbc.setObjectLoad(objectLoad);
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
     * @param objectLoad the object loading count to set
     */
    public void setObjectLoad(int objectLoad) {
        this.objectLoad = objectLoad;
    }

    @Override
    public int getIteration() {
        return this.iteration;
    }

    @Override
    public int getObjectLoad() {
        return this.objectLoad;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(I interval) {
        this.interval = interval;
    }

    @Override
    public I getInterval() {
        return this.interval;
    }

    @Override
    public String toString() {
        return "DefaultIterationObjectLoadIntervalBenchmarkContext [interval=" + interval
                + ", iteration=" + iteration + ", objectLoad=" + objectLoad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((interval == null) ? 0 : interval.hashCode());
        result = prime * result + iteration;
        result = prime * result + objectLoad;
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
        DefaultIterationObjectLoadIntervalBenchmarkContext other =
                (DefaultIterationObjectLoadIntervalBenchmarkContext) obj;
        if (interval == null) {
            if (other.interval != null)
                return false;
        } else if (!interval.equals(other.interval))
            return false;
        if (iteration != other.iteration)
            return false;
        if (objectLoad != other.objectLoad)
            return false;
        return true;
    }

}

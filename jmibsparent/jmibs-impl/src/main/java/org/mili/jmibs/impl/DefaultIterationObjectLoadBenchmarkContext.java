/*
 * DefaultIterationObjectLoadBenchmarkContext.java
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

import org.mili.jmibs.api.*;

/**
 * This class defines a special default implementation for a benchmark context based on
 * informations about iterations and object loading count.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class DefaultIterationObjectLoadBenchmarkContext extends DefaultBenchmarkContext
        implements IterationObjectLoadBenchmarkContext {

    private int iteration = 0;
    private int objectLoad = 0;

    /**
     * creates a new empty default iteration object loading benchmark context.
     */
    protected DefaultIterationObjectLoadBenchmarkContext() {
        super();
    }

    /**
     * creates a new default iteration object loading benchmark context with benchmark and
     * informations about iterations and object loading counts.
     *
     * @param benchmark underlying benchmark.
     * @param iteration iteration count.
     * @param objectLoad object loading count.
     * @return new default iteration object loading benchmark context with benchmark and
     *         informations about iterations and object loading counts.
     */
    public static DefaultIterationObjectLoadBenchmarkContext create(Benchmark benchmark,
            int iteration, int objectLoad) {
        if (benchmark == null) {
            throw new IllegalArgumentException("benchmark can't be null!");
        }
        if (iteration <= 0) {
            throw new IllegalArgumentException("iteration must be positve!");
        }
        if (objectLoad <= 0) {
            throw new IllegalArgumentException("object load must be positve!");
        }
        DefaultIterationObjectLoadBenchmarkContext diolbc = new DefaultIterationObjectLoadBenchmarkContext();
        diolbc.setBenchmark(benchmark);
        diolbc.setIteration(iteration);
        diolbc.setObjectLoad(objectLoad);
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

    @Override
    public String toString() {
        return "DefaultIterationObjectLoadBenchmarkContext [iteration=" + iteration
                + ", objectLoad=" + objectLoad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
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
        DefaultIterationObjectLoadBenchmarkContext other =
                (DefaultIterationObjectLoadBenchmarkContext) obj;
        if (iteration != other.iteration)
            return false;
        if (objectLoad != other.objectLoad)
            return false;
        return true;
    }

}

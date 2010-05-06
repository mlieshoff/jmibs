/*
 * DefaultBenchmarkContext.java
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

import org.mili.jmibs.api.*;

/**
 * This class defines a default implementation of benchmark context.
 *
 * @author Michael Lieshoff
 * @version 1.0 13.04.2010
 * @since 1.0
 */
public class DefaultBenchmarkContext implements BenchmarkContext {

    private Benchmark benchmark = null;

    /**
     * creates a new empty default benchmark context.
     */
    protected DefaultBenchmarkContext() {
        super();
    }

    /**
     * creates a new default benchmark context with underlying benchmark.
     *
     * @param benchmark underlying benchmark.
     * @return new default benchmark context with underlying benchmark.
     */
    public static DefaultBenchmarkContext create(Benchmark benchmark) {
        if (benchmark == null) {
            throw new IllegalArgumentException("benchmark can't be null!");
        }
        DefaultBenchmarkContext dbc = new DefaultBenchmarkContext();
        dbc.setBenchmark(benchmark);
        return dbc;
    }

    @Override
    public Benchmark getBenchmark() {
        return this.benchmark;
    }

    /**
     * @param benchmark the benchmark to set
     */
    public void setBenchmark(Benchmark benchmark) {
        if (benchmark == null) {
            throw new IllegalArgumentException("benchmark can't be null!");
        }
        this.benchmark = benchmark;
    }

    @Override
    public String toString() {
        return "DefaultBenchmarkContext [benchmark=" + benchmark + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((benchmark == null) ? 0 : benchmark.hashCode());
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
        DefaultBenchmarkContext other = (DefaultBenchmarkContext) obj;
        if (benchmark == null) {
            if (other.benchmark != null)
                return false;
        } else if (!benchmark.equals(other.benchmark))
            return false;
        return true;
    }

}

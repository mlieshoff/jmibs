/*
 * IterationIntervalBenchmarkSuite.java
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

package org.mili.jmibs.api;

import java.util.List;

/**
 * This interface defines a specially benchmark suite that is based on iteration, object loading
 * and interval benchmark. A benchmark suite that benchmarks something 10 or 1000 times in
 * interval 1 to 100 and 1 to 1000 should implementing this interface.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public interface IterationIntervalBenchmarkSuite<I extends Interval<?>> extends BenchmarkSuite {

    /**
     * @return list with iterations.
     */
    List<Integer> getIterationList();

    /**
     * adds an iteration.
     *
     * @param iteration iteration to add.
     */
    void addIteration(int iteration);

    /**
     * @return list with intervals.
     */
    List<I> getIntervalList();

    /**
     * adds an interval.
     *
     * @param interval interval to add.
     */
    void addInterval(I interval);

}

/*
 * IterationIntervalBenchmarkSuiteResult.java
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
 * This interface defines a specially benchmark suite result that is used to describe suite
 * results based on iteration, object load count and interval.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public interface IterationIntervalBenchmarkSuiteResult<I extends Interval<?>>
        extends BenchmarkSuiteResult {

    /**
     * return the executing result of specified iteration, objectLoad and interval.
     *
     * @param iteration the iteration.
     * @param interval the interval.
     * @return execute result for specified iteration, objectLoad and interval.
     */
    List<BenchmarkResult> getExecuteResult(int iteration, I interval);

    /**
     * return the preparation result of specified iteration, objectLoad and interval.
     *
     * @param iteration the iteration.
     * @param interval the interval.
     * @return prepare result for specified iteration, objectLoad and interval.
     */
    List<BenchmarkResult> getPrepareResult(int iteration, I interval);

}

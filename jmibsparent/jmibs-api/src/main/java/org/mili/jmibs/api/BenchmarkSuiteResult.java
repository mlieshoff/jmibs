/*
 * BenchmarkSuiteResult.java
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

package org.mili.jmibs.api;

import java.util.*;

/**
 * The interface defines a benchmark suite result. It provides access to the results of
 * execution and preparation of benchmarking.
 *
 * @author Michael Lieshoff
 * @version 1.2 18.06.2010
 * @since 1.0
 * @changed ML 23.04.2010 - extend by benchmark suite getter.
 * @changed ML 18.06.2010 - added computer info methods.
 */
public interface BenchmarkSuiteResult {

    /**
     * @return the underlying becnhmark suite.
     */
    BenchmarkSuite getBenchmarkSuite();

    /**
     * @return result created while preparation of benchmarking.
     */
    List<BenchmarkResult> getPrepareResults();

    /**
     * adds a benchmark result to the list of prepare results.
     *
     * @param br benchmark prepare result.
     */
    void addPrepareResult(BenchmarkResult br);

    /**
     * @return result created while execution of benchmarking.
     */
    List<BenchmarkResult> getExecuteResults();

    /**
     * adds a benchmark result to the list of execute results.
     *
     * @param br benchmark execute result.
     */
    void addExecuteResult(BenchmarkResult br);

    /**
     * @return the computer info.
     */
    ComputerInfo getComputerInfo();

}

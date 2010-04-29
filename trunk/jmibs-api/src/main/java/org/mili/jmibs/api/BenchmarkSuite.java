/**
 * BenchmarkSuite.java
 *
 * 17.03.2010
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

package org.mili.jmibs.api;

/**
 * This interface defines a suite for benchmarks. This suite can execute defined benchmarks.
 *
 * @author Michael Lieshoff
 * @version 1.1 15.04.2010
 * @since 1.0
 * @changed ML 23.04.2010 - extended by getName().
 */
public interface BenchmarkSuite {

    /**
     * adds a benchmark to the suite.
     *
     * @param b benchmark.
     */
    void addBenchmarkClass(Class<?> cls);

    /**
     * executes the suite and create a benchmark suit result.
     *
     * @return benchmark suite result with result informations of suite execution.
     */
    BenchmarkSuiteResult execute();

    /**
     * @return the name of the suite.
     */
    String getName();

}

/**
 * IterationObjectLoadBenchmarkSuiteResult.java
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

package org.mili.jmibs.api;

import java.util.*;

/**
 * This interface defines a specially benchmark suite result that is used to describe suite
 * results based on iteration and object load count.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public interface IterationObjectLoadBenchmarkSuiteResult extends BenchmarkSuiteResult {

    /**
     * return the executing result of specified iteration and objectLoad.
     *
     * @param iteration the iteration.
     * @param objectLoad the objectLoad.
     * @return execute result for specified iteration and objectLoad.
     */
    List<BenchmarkResult> getExecuteResult(int iteration, int objectLoad);

    /**
     * return the preparation result of specified iteration and objectLoad.
     *
     * @param iteration the iteration.
     * @param objectLoad the objectLoad.
     * @return prepare result for specified iteration and objectLoad.
     */
    List<BenchmarkResult> getPrepareResult(int iteration, int objectLoad);

}

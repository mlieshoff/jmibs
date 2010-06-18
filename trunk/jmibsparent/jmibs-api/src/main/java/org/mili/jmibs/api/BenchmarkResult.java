/*
 * BenchmarkResult.java
 *
 * 17.03.2010
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

/**
 * This interface defines benchmark result. It stores time values of total and average execution
 * times in micro- and nano seconds.
 *
 * @author Michael Lieshoff
 * @version 1.1 05.06.2010
 * @since 1.0
 * @changed ML 05.06.2010 - formatting and added memoryInfo() methods.
 */
public interface BenchmarkResult {

    /**
     * @return the underlying benchmark context.
     */
    BenchmarkContext getBenchmarkContext();

    /**
     * @return total time in ms.
     */
    long getTotalTime();

    /**
     * @return total time in ns.
     */
    long getTotalTimeNanos();

    /**
     * @return average time in ms.
     */
    long getAverageTime();

    /**
     * @return average time in ns.
     */
    long getAverageTimeNanos();

    /**
     * @param ms total time in ms.
     */
    void setTotalTime(long ms);

    /**
     * @param ns total time in ns.
     */
    void setTotalTimeNanos(long ns);

    /**
     * @param ms average time in ms.
     */
    void setAverageTime(long ms);

    /**
     * @param ns average time in ns.
     */
    void setAverageTimeNanos(long ns);

    /**
     * @param mi the memory info before.
     */
    void setMemoryInfoBefore(MemoryInfo mi);

    /**
     * @return the memory info before.
     */
    MemoryInfo getMemoryInfoBefore();

    /**
     * @param mi the memory info after.
     */
    void setMemoryInfoAfter(MemoryInfo mi);

    /**
     * @return the memory info after.
     */
    MemoryInfo getMemoryInfoAfter();

}
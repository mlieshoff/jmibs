/*
 * IntervalBenchmark.java
 *
 * 03.06.2010
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
 * This interface defines a benchmark thats based on an interval thats used to call a function
 * like fac(n), fib(n) and so on.
 *
 * @author Michael Lieshoff
 * @version 1.0 03.06.2010
 * @since 1.1
 */
public interface IntervalBenchmark<I extends Interval<?>> extends Benchmark {
    /**
     * sets the interval.
     *
     * @param interval the interval to set.
     */
    void setInterval(I interval);

    /**
     * @return the interval.
     */
    I getInterval();

}

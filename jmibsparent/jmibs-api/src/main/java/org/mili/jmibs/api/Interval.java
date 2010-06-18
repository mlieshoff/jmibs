/*
 * Interval.java
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
 * This interface describes an benchmark interval. It's defined for values from min to max and
 * supports some informations about difference and minimum interval. Also it can traverse the
 * interval for all values through an interval benchmark.
 *
 * @author Michael Lieshoff
 * @version 1.0 03.06.2010
 * @since 1.1
 */
public interface Interval<T> {

    /**
     * @return the minimum.
     */
    T getMin();

    /**
     * @return the maximum.
     */
    T getMax();

    /**
     * sets the actual value.
     *
     * @param v the actual value.
     */
    void setValue(T v);

    /**
     * @return the actual value.
     */
    T getValue();

    /**
     * @return the difference between min and max as a long value.
     */
    long getDifference();

    /**
     * traverses the interval through an interval benchmark.
     *
     * @param ib interal benchmark.
     */
    void traverse(IntervalBenchmark<?> ib);

    /**
     * select the minimum.
     */
    void selectMinimum();

    /**
     * @return a minimum interval. For int values in interval (1, 100) this should be (0, 1).
     */
    Interval<T> getMinimumInterval();
}

/*
 * IntegerInterval.java
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

package org.mili.jmibs.impl;

import org.mili.jmibs.api.Interval;
import org.mili.jmibs.api.IntervalBenchmark;

/**
 * This class defines an interval thats based on int values.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class IntegerInterval extends AbstractInterval<Integer> {

    /**
     * create a new integer interval.
     */
    protected IntegerInterval() {
        super();
    }

    /**
     * creates a new long interval.
     *
     * @param min minimum.
     * @param max maximum.
     */
    protected IntegerInterval(int min, int max) {
        super();
        this.setMin(min);
        this.setMax(max);
    }

    /**
     * creates a new long interval.
     *
     * @param min minimum.
     * @param max maximum
     * @return a new long interval.
     */
    public static IntegerInterval create(int min, int max) {
        return new IntegerInterval(min, max);
    }

    @Override
    public int compareTo(Interval<Integer> i) {
        return (int) (this.getDifference() - i.getDifference());
    }

    @Override
    public void traverse(IntervalBenchmark<?> olb) {
        for (int i = this.getMin(); i < this.getMax(); i++) {
            this.setValue(i);
            olb.execute();
        }
    }

    @Override
    public long getDifference() {
        return Math.abs(this.getMax() - this.getMin());
    }

    @Override
    public IntegerInterval getMinimumInterval() {
        return IntegerInterval.create(0, 1);
    }

}

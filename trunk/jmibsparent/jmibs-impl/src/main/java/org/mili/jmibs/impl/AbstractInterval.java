/*
 * AbstractInterval.java
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

import org.mili.jmibs.api.*;

/**
 * This class defines an abstract interval.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public abstract class AbstractInterval<T> implements Interval<T>, Comparable<Interval<T>> {

    private T min = null;
    private T max = null;
    private T value = null;

    @Override
    public T getMax() {
        return this.max;
    }

    @Override
    public T getMin() {
        return this.min;
    }

    @Override
    public void setValue(T v) {
        this.value = v;
    }

    /**
     * @return the value.
     */
    public T getValue() {
        return value;
    }

    /**
     * @param min the min to set.
     */
    public void setMin(T min) {
        this.min = min;
    }

    /**
     * @param max the max to set.
     */
    public void setMax(T max) {
        this.max = max;
    }

    @Override
    public void selectMinimum() {
        this.setValue(this.getMinimumInterval().getMin());
    }

}

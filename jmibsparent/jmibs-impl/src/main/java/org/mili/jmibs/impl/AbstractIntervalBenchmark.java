/*
 * AbstractIntervalBenchmark.java
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
 * This abstract class provides some basic implementation of interval benchmark interface.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.0
 */
public abstract class AbstractIntervalBenchmark<I extends Interval<?>>
        extends AbstractBenchmark implements IntervalBenchmark<I> {

    private I interval = null;

    @Override
    public I getInterval() {
        return this.interval;
    }

    @Override
    public void setInterval(I interval) {
        this.interval = interval;
    }

}

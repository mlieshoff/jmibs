/*
 * DefaultIterationIntervalBenchmarkContextTest.java
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

import static org.junit.Assert.*;

import org.easymock.*;
import org.junit.*;
import org.mili.jmibs.api.*;

/**
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationIntervalBenchmarkContextTest {

    private Benchmark b = null;

    @Before
    public void setUp() throws Exception {
        this.b = EasyMock.createMock(Benchmark.class);
    }

    @Test
    public void testDefaultIterationIntervalBenchmarkContext() {
        DefaultIterationIntervalBenchmarkContext<LongInterval> c = new DefaultIterationIntervalBenchmarkContext<LongInterval>();
        assertNull(c.getBenchmark());
        assertNull(c.getInterval());
        assertEquals(0, c.getIteration());
    }

    @Test
    public void testCreateBenchmarkIntIntervalOfI_Negative() {
        EasyMock.replay(this.b);
        try {
            DefaultIterationIntervalBenchmarkContext.create(null, 1, new LongInterval());
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationIntervalBenchmarkContext.create(this.b, 1, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationIntervalBenchmarkContext.create(this.b, 0, new LongInterval());
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCreateBenchmarkIntIntervalOfI() {
        LongInterval li = new LongInterval();
        IterationIntervalBenchmarkContext<LongInterval> c = DefaultIterationIntervalBenchmarkContext
                .create(this.b, 1, li);
        assertEquals(this.b, c.getBenchmark());
        assertEquals(li, c.getInterval());
        assertEquals(1, c.getIteration());
    }

    @Test
    public void testGetSetIteration() {
        LongInterval li = new LongInterval();
        DefaultIterationIntervalBenchmarkContext<LongInterval> c = DefaultIterationIntervalBenchmarkContext
                .create(this.b, 1, li);
        c.setIteration(4711);
        assertEquals(4711, c.getIteration());
    }

    @Test
    public void testGetSetInterval() {
        LongInterval li0 = new LongInterval();
        DefaultIterationIntervalBenchmarkContext<LongInterval> c = DefaultIterationIntervalBenchmarkContext
                .create(this.b, 1, li0);
        LongInterval li = new LongInterval();
        c.setInterval(li);
        assertEquals(li, c.getInterval());
    }

}

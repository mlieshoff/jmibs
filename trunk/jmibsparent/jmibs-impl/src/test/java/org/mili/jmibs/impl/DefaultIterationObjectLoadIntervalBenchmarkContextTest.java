/*
 * DefaultIterationObjectLoadIntervalBenchmarkContextTest.java
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
public class DefaultIterationObjectLoadIntervalBenchmarkContextTest {

    private Benchmark b = null;

    @Before
    public void setUp() throws Exception {
        this.b = EasyMock.createMock(Benchmark.class);
    }

    @Test
    public void testDefaultIterationObjectLoadIntervalBenchmarkContext() {
        DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval> diolbc =
                new DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval>();
        assertNull(diolbc.getBenchmark());
        assertEquals(0, diolbc.getIteration());
        assertEquals(0, diolbc.getObjectLoad());
        assertEquals(null, diolbc.getInterval());
    }

    @Test
    public void testCreateBenchmarkIntIntIntervalOfI() {
        EasyMock.replay(this.b);
        IntegerInterval ii = new IntegerInterval(1, 10);
        try {
            DefaultIterationObjectLoadIntervalBenchmarkContext.create(null, 4711, 4711, ii);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadIntervalBenchmarkContext.create(this.b, 0, 4711, ii);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadIntervalBenchmarkContext.create(this.b, 4711, 0, ii);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadIntervalBenchmarkContext.create(this.b, -4711, 4711, ii);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadIntervalBenchmarkContext.create(this.b, 4711, -4711, ii);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadIntervalBenchmarkContext.create(this.b, 4711, 4711, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        IterationObjectLoadIntervalBenchmarkContext<IntegerInterval> iolbc =
                DefaultIterationObjectLoadIntervalBenchmarkContext.<IntegerInterval>create(
                this.b, 4711, 4711, ii);
        assertNotNull(iolbc);
        assertEquals(this.b, iolbc.getBenchmark());
        assertEquals(4711, iolbc.getIteration());
        assertEquals(4711, iolbc.getObjectLoad());
        assertEquals(ii, iolbc.getInterval());
    }

    @Test
    public void testGetSetIteration() {
        DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval> diolbc =
                new DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval>();
        diolbc.setIteration(4711);
        assertEquals(4711, diolbc.getIteration());
    }

    @Test
    public void testGetSetObjectLoad() {
        DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval> diolbc =
                new DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval>();
        diolbc.setObjectLoad(4711);
        assertEquals(4711, diolbc.getObjectLoad());
    }

    @Test
    public void testGetSetInterval() {
        IntegerInterval ii = new IntegerInterval(1, 10);
        DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval> diolbc =
                new DefaultIterationObjectLoadIntervalBenchmarkContext<IntegerInterval>();
        diolbc.setInterval(ii);
        assertEquals(ii, diolbc.getInterval());
    }

}

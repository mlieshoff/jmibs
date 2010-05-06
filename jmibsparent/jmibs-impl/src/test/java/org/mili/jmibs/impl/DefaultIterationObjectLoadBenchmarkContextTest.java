/*
 * DefaultIterationObjectLoadBenchmarkContextTest.java
 *
 * 14.04.2010
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
 * @version 1.0 14.04.2010
 * @since 1.0
 */
public class DefaultIterationObjectLoadBenchmarkContextTest {

    private Benchmark b = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.b = EasyMock.createMock(Benchmark.class);
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkContext#DefaultIterationObjectLoadBenchmarkContext()}
     * .
     */
    @Test
    public void testDefaultIterationObjectLoadBenchmarkContext() {
        DefaultIterationObjectLoadBenchmarkContext diolbc =
                new DefaultIterationObjectLoadBenchmarkContext();
        assertNull(diolbc.getBenchmark());
        assertEquals(0, diolbc.getIteration());
        assertEquals(0, diolbc.getObjectLoad());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkContext#create(org.mili.benchmark.api.Benchmark, int, int)}
     * .
     */
    @Test
    public void testCreateBenchmarkIntInt() {
        EasyMock.replay(this.b);
        try {
            DefaultIterationObjectLoadBenchmarkContext.create(null, 4711, 4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkContext.create(this.b, 0, 4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkContext.create(this.b, 4711, 0);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkContext.create(this.b, -4711, 4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkContext.create(this.b, 4711, -4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        IterationObjectLoadBenchmarkContext iolbc = DefaultIterationObjectLoadBenchmarkContext
                .create(this.b, 4711, 4711);
        assertNotNull(iolbc);
        assertEquals(this.b, iolbc.getBenchmark());
        assertEquals(4711, iolbc.getIteration());
        assertEquals(4711, iolbc.getObjectLoad());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkContext#setIteration(int)}
     * .
     */
    @Test
    public void testGetSetIteration() {
        DefaultIterationObjectLoadBenchmarkContext diolbc =
                new DefaultIterationObjectLoadBenchmarkContext();
        diolbc.setIteration(4711);
        assertEquals(4711, diolbc.getIteration());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkContext#setObjectLoad(int)}
     * .
     */
    @Test
    public void testGetSetObjectLoad() {
        DefaultIterationObjectLoadBenchmarkContext diolbc =
                new DefaultIterationObjectLoadBenchmarkContext();
        diolbc.setObjectLoad(4711);
        assertEquals(4711, diolbc.getObjectLoad());
    }

}

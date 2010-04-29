/**
 * DefaultBenchmarkResultTest.java
 *
 * 14.04.2010
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
public class DefaultBenchmarkResultTest {

    private BenchmarkContext bc = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.bc = EasyMock.createMock(BenchmarkContext.class);
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkResult#DefaultBenchmarkResult()}.
     */
    @Test
    public void testDefaultBenchmarkResult() {
        BenchmarkResult br = new DefaultBenchmarkResult();
        assertEquals(0, br.getAverageTime());
        assertEquals(0, br.getAverageTimeNanos());
        assertEquals(0, br.getTotalTime());
        assertEquals(0, br.getTotalTimeNanos());
        assertNull(br.getBenchmarkContext());
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkResult#create()}.
     */
    @Test
    public void testCreate() {
        BenchmarkResult br = DefaultBenchmarkResult.create();
        assertNotNull(br);
        assertEquals(0, br.getAverageTime());
        assertEquals(0, br.getAverageTimeNanos());
        assertEquals(0, br.getTotalTime());
        assertEquals(0, br.getTotalTimeNanos());
        assertNull(br.getBenchmarkContext());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkResult#create(org.mili.benchmark.api.BenchmarkContext)}
     * .
     */
    @Test
    public void testCreateBenchmarkContext() {
        EasyMock.replay(this.bc);
        try {
            DefaultBenchmarkResult.create(null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        BenchmarkResult br = DefaultBenchmarkResult.create(this.bc);
        assertNotNull(br);
        assertEquals(0, br.getAverageTime());
        assertEquals(0, br.getAverageTimeNanos());
        assertEquals(0, br.getTotalTime());
        assertEquals(0, br.getTotalTimeNanos());
        assertEquals(this.bc, br.getBenchmarkContext());
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkResult#getAverageTime()}.
     */
    @Test
    public void testGetSetAverageTime() {
        BenchmarkResult br = DefaultBenchmarkResult.create();
        br.setAverageTime(4711);
        assertEquals(4711, br.getAverageTime());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkResult#getAverageTimeNanos()}.
     */
    @Test
    public void testGetSetAverageTimeNanos() {
        BenchmarkResult br = DefaultBenchmarkResult.create();
        br.setAverageTimeNanos(4711);
        assertEquals(4711, br.getAverageTimeNanos());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkResult#getBenchmarkContext()}.
     */
    @Test
    public void testGetBenchmarkContext() {
        EasyMock.replay(this.bc);
        DefaultBenchmarkResult br = DefaultBenchmarkResult.create();
        br.setBenchmarkContext(this.bc);
        assertEquals(this.bc, br.getBenchmarkContext());
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkResult#getTotalTime()}.
     */
    @Test
    public void testGetSetTotalTime() {
        BenchmarkResult br = DefaultBenchmarkResult.create();
        br.setTotalTime(4711);
        assertEquals(4711, br.getTotalTime());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkResult#getTotalTimeNanos()}.
     */
    @Test
    public void testGetSetTotalTimeNanos() {
        BenchmarkResult br = DefaultBenchmarkResult.create();
        br.setTotalTimeNanos(4711);
        assertEquals(4711, br.getTotalTimeNanos());
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkResult#toString()}.
     */
    @Test
    public void testToString() {
        BenchmarkResult br = DefaultBenchmarkResult.create();
        assertNotNull(br.toString());
        assertTrue(br.toString().length() > 0);
    }

}

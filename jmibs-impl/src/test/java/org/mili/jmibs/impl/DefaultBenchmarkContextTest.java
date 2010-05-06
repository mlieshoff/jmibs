/*
 * DefaultBenchmarkContextTest.java
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
 * @version 1.1 15.04.2010
 * @since 1.0
 * @changed ML 23.04.2010 - extend test for hashCode and toString.
 */
public class DefaultBenchmarkContextTest {

    private Benchmark b = null;
    private Benchmark b0 = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.b = EasyMock.createMock(Benchmark.class);
        this.b0 = EasyMock.createMock(Benchmark.class);
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkContext#DefaultBenchmarkContext()}.
     */
    @Test
    public void testDefaultBenchmarkContext() {
        BenchmarkContext bc = new DefaultBenchmarkContext();
        assertNull(bc.getBenchmark());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkContext#create(org.mili.benchmark.api.Benchmark)}
     * .
     */
    @Test
    public void testCreate() {
        EasyMock.replay(this.b);
        try {
            DefaultBenchmarkContext.create(null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        assertNotNull(DefaultBenchmarkContext.create(this.b));
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkContext#getBenchmark()}.
     */
    @Test
    public void testGetBenchmark() {
        EasyMock.replay(this.b);
        BenchmarkContext bc = DefaultBenchmarkContext.create(this.b);
        assertEquals(bc.getBenchmark(), this.b);
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkContext#setBenchmark(org.mili.benchmark.api.Benchmark)}
     * .
     */
    @Test
    public void testSetBenchmark() {
        EasyMock.replay(this.b);
        DefaultBenchmarkContext bc = DefaultBenchmarkContext.create(this.b);
        try {
            bc.setBenchmark(null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        bc.setBenchmark(this.b);
        assertEquals(bc.getBenchmark(), this.b);
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkContext#toString()}.
     */
    @Test
    public void testToString() {
        DefaultBenchmarkContext o0 = DefaultBenchmarkContext.create(this.b);
        DefaultBenchmarkContext o1 = DefaultBenchmarkContext.create(this.b);
        assertEquals(o0.toString(), o1.toString());

        o0 = DefaultBenchmarkContext.create(this.b);
        o1 = DefaultBenchmarkContext.create(this.b0);
        assertNotSame(o0.toString(), o1.toString());
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkContext#hashCode()}.
     */
    @Test
    public void testHashCode() {
        DefaultBenchmarkContext o0 = DefaultBenchmarkContext.create(this.b);
        DefaultBenchmarkContext o1 = DefaultBenchmarkContext.create(this.b);
        assertEquals(o0.hashCode(), o1.hashCode());
    }

}

/*
 * DefaultBenchmarkSuiteResultTest.java
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
public class DefaultBenchmarkSuiteResultTest {

    private BenchmarkResult br = null;
    private BenchmarkSuite bs = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.br = EasyMock.createMock(BenchmarkResult.class);
        this.bs = EasyMock.createMock(BenchmarkSuite.class);
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkSuiteResult#DefaultBenchmarkSuiteResult()}
     * .
     */
    @Test
    public void testDefaultBenchmarkSuiteResult() {
        DefaultBenchmarkSuiteResult dbsr = new DefaultBenchmarkSuiteResult();
        assertNotNull(dbsr.getExecuteResults());
        assertNotNull(dbsr.getPrepareResults());
    }

    /**
     * Test method for {@link org.mili.jmibs.impl.DefaultBenchmarkSuiteResult#create()}.
     */
    @Test
    public void testCreate() {
        DefaultBenchmarkSuiteResult dbsr = DefaultBenchmarkSuiteResult.create();
        assertNotNull(dbsr.getExecuteResults());
        assertNotNull(dbsr.getPrepareResults());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkSuiteResult#getExecuteResults()}.
     */
    @Test
    public void testAddGetExecuteResults() {
        DefaultBenchmarkSuiteResult dbsr = new DefaultBenchmarkSuiteResult();
        dbsr.addExecuteResult(this.br);
        assertEquals(this.br, dbsr.getExecuteResults().get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkSuiteResult#getPrepareResults()}.
     */
    @Test
    public void testAddGetPrepareResults() {
        DefaultBenchmarkSuiteResult dbsr = new DefaultBenchmarkSuiteResult();
        dbsr.addPrepareResult(this.br);
        assertEquals(this.br, dbsr.getPrepareResults().get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultBenchmarkSuiteResult#getBenchmarkSuite()}.
     */
    @Test
    public void testGetSetBenchmarkSuite() {
        EasyMock.replay(this.bs);
        DefaultBenchmarkSuiteResult dbsr = new DefaultBenchmarkSuiteResult();
        assertNull(dbsr.getBenchmarkSuite());
        dbsr.setBenchmarkSuite(this.bs);
        assertEquals(this.bs, dbsr.getBenchmarkSuite());
    }

}

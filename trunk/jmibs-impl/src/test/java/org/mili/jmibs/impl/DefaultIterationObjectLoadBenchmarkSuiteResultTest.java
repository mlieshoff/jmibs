/**
 * DefaultIterationObjectLoadBenchmarkSuiteResultTest.java
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
public class DefaultIterationObjectLoadBenchmarkSuiteResultTest {

    private Benchmark b = null;
    private Benchmark b1 = null;
    private BenchmarkResult br = null;
    private BenchmarkResult br1 = null;
    private BenchmarkContext bc = null;
    private BenchmarkContext bc1 = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.b = EasyMock.createMock(Benchmark.class);
        this.b1 = EasyMock.createMock(Benchmark.class);
        this.br = EasyMock.createMock(BenchmarkResult.class);
        this.br1 = EasyMock.createMock(BenchmarkResult.class);
        this.bc = EasyMock.createMock(BenchmarkContext.class);
        this.bc1 = EasyMock.createMock(BenchmarkContext.class);
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuiteResult#getExecuteResults()}
     * .
     */
    @Test
    public void testGetAddExecuteResults() {
        EasyMock.replay(this.br);
        DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr =
                new DefaultIterationObjectLoadBenchmarkSuiteResult();
        diolbsr.addExecuteResult(1, 1, this.br);
        assertEquals(this.br, diolbsr.getExecuteResults().get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuiteResult#getPrepareResults()}
     * .
     */
    @Test
    public void testGetAddPrepareResults() {
        EasyMock.replay(this.br);
        DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr =
                new DefaultIterationObjectLoadBenchmarkSuiteResult();
        diolbsr.addPrepareResult(1, 1, this.br);
        assertEquals(this.br, diolbsr.getPrepareResults().get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuiteResult#DefaultIterationObjectLoadBenchmarkSuiteResult()}
     * .
     */
    @Test
    public void testDefaultIterationObjectLoadBenchmarkSuiteResult() {
        DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr =
                new DefaultIterationObjectLoadBenchmarkSuiteResult();
        assertNotNull(diolbsr.getExecuteResults());
        assertNotNull(diolbsr.getPrepareResults());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuiteResult#create()}.
     */
    @Test
    public void testCreate() {
        DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr =
                DefaultIterationObjectLoadBenchmarkSuiteResult.create();
        assertNotNull(diolbsr);
        assertNotNull(diolbsr.getExecuteResults());
        assertNotNull(diolbsr.getPrepareResults());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuiteResult#getExecuteResult(int, int)}
     * .
     */
    @Test
    public void testGetExecuteResult() {
        EasyMock.replay(this.br);
        DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr =
                new DefaultIterationObjectLoadBenchmarkSuiteResult();
        diolbsr.addExecuteResult(1, 1, this.br);
        assertEquals(this.br, diolbsr.getExecuteResult(1, 1).get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuiteResult#getPrepareResult(int, int)}
     * .
     */
    @Test
    public void testGetPrepareResult() {
        EasyMock.expect(this.br1.getBenchmarkContext()).andReturn(this.bc1);
        EasyMock.expect(this.bc1.getBenchmark()).andReturn(this.b1);
        EasyMock.expect(this.b1.getName()).andReturn("bla");
        EasyMock.expect(this.bc.getBenchmark()).andReturn(this.b).times(3);
        EasyMock.expect(this.b.getName()).andReturn("lala").times(3);
        EasyMock.expect(this.br.getBenchmarkContext()).andReturn(this.bc).times(3);
        EasyMock.expect(this.br.getAverageTime()).andReturn(4711L).times(2);
        EasyMock.expect(this.br.getTotalTime()).andReturn(4711L).times(2);
        EasyMock.expect(this.br.getAverageTimeNanos()).andReturn(4711L).times(2);
        EasyMock.expect(this.br.getTotalTimeNanos()).andReturn(4711L).times(2);
        this.br.setAverageTime(4711L);
        EasyMock.expectLastCall();
        this.br.setTotalTime(4711L);
        EasyMock.expectLastCall();
        this.br.setAverageTimeNanos(4711L);
        EasyMock.expectLastCall();
        this.br.setTotalTimeNanos(4711L);
        EasyMock.expectLastCall();
        EasyMock.replay(this.br, this.bc, this.b, this.br1, this.bc1, this.b1);
        DefaultIterationObjectLoadBenchmarkSuiteResult diolbsr =
                new DefaultIterationObjectLoadBenchmarkSuiteResult();
        diolbsr.addPrepareResult(1, 1, this.br);
        assertEquals(this.br, diolbsr.getPrepareResult(1, 1).get(0));
        diolbsr.addPrepareResult(1, 1, this.br);
        assertEquals(this.br, diolbsr.getPrepareResult(1, 1).get(0));
        diolbsr.addPrepareResult(1, 1, this.br1);
        assertEquals(this.br1, diolbsr.getPrepareResult(1, 1).get(1));
    }

}

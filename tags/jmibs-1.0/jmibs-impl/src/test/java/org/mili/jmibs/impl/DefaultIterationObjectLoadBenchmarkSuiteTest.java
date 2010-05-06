/*
 * DefaultIterationObjectLoadBenchmarkSuiteTest.java
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

import java.util.*;

import org.junit.*;
import org.mili.jmibs.api.*;

/**
 * @author Michael Lieshoff
 * @version 1.1 15.04.2010
 * @since 1.0
 * @changed ML 23.04.2010 - fixed preparation loop, extended name create and constructor.
 */
public class DefaultIterationObjectLoadBenchmarkSuiteTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#DefaultIterationObjectLoadBenchmarkSuite()}
     * .
     */
    @Test
    public void testDefaultIterationObjectLoadBenchmarkSuite() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                new DefaultIterationObjectLoadBenchmarkSuite();
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#DefaultIterationObjectLoadBenchmarkSuite(String)}
     * .
     */
    @Test
    public void testDefaultIterationObjectLoadBenchmarkSuiteString() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                new DefaultIterationObjectLoadBenchmarkSuite("abbas");
        assertEquals("abbas", diolbs.getName());
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#setName()} .
     */
    @Test
    public void testGetSetName() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                new DefaultIterationObjectLoadBenchmarkSuite();
        diolbs.setName("abbas");
        assertEquals("abbas", diolbs.getName());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#DefaultIterationObjectLoadBenchmarkSuite(java.util.List, java.util.List)}
     * .
     */
    @Test
    public void testDefaultIterationObjectLoadBenchmarkSuiteListList() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        try {
            new DefaultIterationObjectLoadBenchmarkSuite(null, l);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadBenchmarkSuite(l, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                new DefaultIterationObjectLoadBenchmarkSuite(l, l);
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#DefaultIterationObjectLoadBenchmarkSuite(String, java.util.List, java.util.List)}
     * .
     */
    @Test
    public void testDefaultIterationObjectLoadBenchmarkSuiteStringListList() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        try {
            new DefaultIterationObjectLoadBenchmarkSuite(null, l, l);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadBenchmarkSuite("", null, l);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadBenchmarkSuite("", l, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                new DefaultIterationObjectLoadBenchmarkSuite("abbas", l, l);
        assertEquals("abbas", diolbs.getName());
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#create()}.
     */
    @Test
    public void testCreate() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create();
        assertNotNull(diolbs);
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#create(String)} .
     */
    @Test
    public void testCreateString() {
        try {
            DefaultIterationObjectLoadBenchmarkSuite.create(null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create("abbas");
        assertNotNull(diolbs);
        assertEquals("abbas", diolbs.getName());
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#create(java.util.List, java.util.List)}
     * .
     */
    @Test
    public void testCreateListList() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        try {
            DefaultIterationObjectLoadBenchmarkSuite.create(null, l);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkSuite.create(l, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create(l, l);
        assertNotNull(diolbs);
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#create(String, java.util.List, java.util.List)}
     * .
     */
    @Test
    public void testCreateStringListList() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        try {
            DefaultIterationObjectLoadBenchmarkSuite.create(null, l, l);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkSuite.create("", null, l);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadBenchmarkSuite.create("", l, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create("abbas", l, l);
        assertEquals("abbas", diolbs.getName());
        assertNotNull(diolbs);
        assertNotNull(diolbs.getBenchmarkClassList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#getIterationList()}
     * .
     */
    @Test
    public void testAddGetIterationList() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create();
        try {
            diolbs.addIteration(-4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        diolbs.addIteration(4711);
        assertEquals(1, diolbs.getIterationList().size());
        assertEquals(Integer.valueOf(4711), diolbs.getIterationList().get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#getObjectLoadList()}
     * .
     */
    @Test
    public void testAddGetObjectLoadList() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create();
        try {
            diolbs.addObjectLoad(-4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        diolbs.addObjectLoad(4711);
        assertEquals(1, diolbs.getObjectLoadList().size());
        assertEquals(Integer.valueOf(4711), diolbs.getObjectLoadList().get(0));
    }

    /**
     * Test method for
     * {@link org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite#execute()} .
     */
    @Test
    public void testExecute() {
        DefaultIterationObjectLoadBenchmarkSuite diolbs =
                DefaultIterationObjectLoadBenchmarkSuite.create();
        diolbs.addIteration(1);
        diolbs.addObjectLoad(1);
        diolbs.addBenchmarkClass(SimpleBenchmark.class);
        BenchmarkSuiteResult bsr = diolbs.execute();
        assertEquals(1, bsr.getExecuteResults().size());
        assertEquals(1, bsr.getPrepareResults().size());
    }

}

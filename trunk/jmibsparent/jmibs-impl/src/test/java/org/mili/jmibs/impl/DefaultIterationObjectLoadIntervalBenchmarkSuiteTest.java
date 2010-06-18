/*
 * DefaultIterationObjectLoadIntervalBenchmarkSuiteTest.java
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

import java.util.*;

import org.junit.*;
import org.mili.jmibs.api.*;

/**
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationObjectLoadIntervalBenchmarkSuiteTest {

    @Test
    public void testDefaultIterationObjectLoadIntervalBenchmarkSuite() {
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>();
        assertNotNull(diolbs.getBenchmarkList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
        assertNotNull(diolbs.getIntervalList());
    }

    @Test
    public void testDefaultIterationObjectLoadIntervalBenchmarkSuiteString() {
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>("abbas");
        assertEquals("abbas", diolbs.getName());
        assertNotNull(diolbs.getBenchmarkList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
        assertNotNull(diolbs.getIntervalList());
    }

    @Test
    public void testDefaultIterationObjectLoadIntervalBenchmarkSuiteListOfIntegerListOfIntegerListOfIntervalOfI() {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        List<IntegerInterval> l3 = new ArrayList<IntegerInterval>();
        l3.add(new IntegerInterval(1, 10));
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>(null, l2, l3);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>(l1, null, l3);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>(l1, l2, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>(l1, l2,
                l3);
        assertNotNull(diolbs.getBenchmarkList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
        assertNotNull(diolbs.getIntervalList());
    }

    @Test
    public void testDefaultIterationObjectLoadIntervalBenchmarkSuiteStringListOfIntegerListOfIntegerListOfIntervalOfI() {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        List<IntegerInterval> l3 = new ArrayList<IntegerInterval>();
        l3.add(new IntegerInterval(1, 10));
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>(null, l1, l2,
                    l3);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>("", l1, l2,
                    l3);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>("a", null, l2,
                    l3);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>("a", l1, null,
                    l3);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>("a", l1, l2,
                    null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                new DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval>("a", l1,
                l2, l3);
        assertEquals("a", diolbs.getName());
        assertNotNull(diolbs.getBenchmarkList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
        assertNotNull(diolbs.getIntervalList());
    }

    @Test
    public void testCreate() {
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                DefaultIterationObjectLoadIntervalBenchmarkSuite.create();
        assertNotNull(diolbs);
        assertNotNull(diolbs.getBenchmarkList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    @Test
    public void testCreateString() {
        try {
            DefaultIterationObjectLoadIntervalBenchmarkSuite.create(null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationObjectLoadIntervalBenchmarkSuite.create("");
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                DefaultIterationObjectLoadIntervalBenchmarkSuite.create("abbas");
        assertNotNull(diolbs);
        assertEquals("abbas", diolbs.getName());
        assertNotNull(diolbs.getBenchmarkList());
        assertNotNull(diolbs.getIterationList());
        assertNotNull(diolbs.getObjectLoadList());
    }

    @Test
    public void testCreateListOfIntegerListOfIntegerListOfIntervalOfI() {
        // TODO
    }

    @Test
    public void testCreateStringListOfIntegerListOfIntegerListOfIntervalOfI() {
        // TODO
    }

    @Test
    public void testAddGetIterationList() {
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                DefaultIterationObjectLoadIntervalBenchmarkSuite.create();
        try {
            diolbs.addIteration(-4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        diolbs.addIteration(4711);
        assertEquals(1, diolbs.getIterationList().size());
        assertEquals(Integer.valueOf(4711), diolbs.getIterationList().get(0));
    }

    @Test
    public void testGetObjectLoadList() {
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                DefaultIterationObjectLoadIntervalBenchmarkSuite.create();
        try {
            diolbs.addObjectLoad(-4711);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        diolbs.addObjectLoad(4711);
        assertEquals(1, diolbs.getObjectLoadList().size());
        assertEquals(Integer.valueOf(4711), diolbs.getObjectLoadList().get(0));
    }

    @Test
    public void testExecute() {
        DefaultIterationObjectLoadIntervalBenchmarkSuite<IntegerInterval> diolbs =
                DefaultIterationObjectLoadIntervalBenchmarkSuite.create();
        diolbs.addIteration(1);
        diolbs.addObjectLoad(1);
        diolbs.addInterval(new IntegerInterval(1, 10));
        diolbs.addBenchmarkClass(SimpleObjectLoadIntervalBenchmark.class);
        BenchmarkSuiteResult bsr = diolbs.execute();
        assertEquals(1, bsr.getExecuteResults().size());
        assertEquals(1, bsr.getPrepareResults().size());
    }

    @Test
    public void testCreateAndRun() {
        // TODO
    }

}

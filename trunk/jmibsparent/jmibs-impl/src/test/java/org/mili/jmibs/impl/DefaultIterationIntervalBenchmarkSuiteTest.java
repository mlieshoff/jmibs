/*
 * DefaultIterationIntervalBenchmarkSuiteTest.java
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

/**
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultIterationIntervalBenchmarkSuiteTest {

    @Test
    public void testDefaultIterationIntervalBenchmarkSuite() {
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                new DefaultIterationIntervalBenchmarkSuite<LongInterval>();
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(0, s.getIntervalList().size());
        assertEquals(0, s.getIterationList().size());
        assertEquals(DefaultIterationIntervalBenchmarkSuite.class.getName(), s.getName());
    }

    @Test
    public void testDefaultIterationIntervalBenchmarkSuiteString() {
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                new DefaultIterationIntervalBenchmarkSuite<LongInterval>("b1");
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(0, s.getIntervalList().size());
        assertEquals(0, s.getIterationList().size());
        assertEquals("b1", s.getName());
    }

    @Test
    public void testDefaultIterationIntervalBenchmarkSuiteListOfIntegerListOfIntervalOfT() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                new DefaultIterationIntervalBenchmarkSuite<LongInterval>(l0, l1);
        assertEquals(0, s.getBenchmarkClassList().size());
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(l1, s.getIntervalList());
        assertEquals(l0, s.getIterationList());
        assertEquals(DefaultIterationIntervalBenchmarkSuite.class.getName(), s.getName());
    }

    @Test
    public void testDefaultIterationIntervalBenchmarkSuiteStringListOfIntegerListOfIntervalOfT() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                new DefaultIterationIntervalBenchmarkSuite<LongInterval>("b1", l0, l1);
        assertEquals(0, s.getBenchmarkClassList().size());
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(l1, s.getIntervalList());
        assertEquals(l0, s.getIterationList());
        assertEquals("b1", s.getName());
    }

    @Test
    public void testDefaultIterationIntervalBenchmarkSuiteStringListOfIntegerListOfIntervalOfT_Negative() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        try {
            new DefaultIterationIntervalBenchmarkSuite<LongInterval>(null, l0, l1);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationIntervalBenchmarkSuite<LongInterval>("b1", null, l1);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new DefaultIterationIntervalBenchmarkSuite<LongInterval>("b1", l0, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCreate() {
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create();
        assertEquals(0, s.getBenchmarkClassList().size());
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(0, s.getIntervalList().size());
        assertEquals(0, s.getIterationList().size());
        assertEquals(DefaultIterationIntervalBenchmarkSuite.class.getName(), s.getName());
    }

    @Test
    public void testCreateString() {
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1");
        assertEquals(0, s.getBenchmarkClassList().size());
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(0, s.getIntervalList().size());
        assertEquals(0, s.getIterationList().size());
        assertEquals("b1", s.getName());
    }

    @Test
    public void testCreateListOfIntegerListOfIntervalOfT() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create(l0, l1);
        assertEquals(0, s.getBenchmarkClassList().size());
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(l1, s.getIntervalList());
        assertEquals(l0, s.getIterationList());
        assertEquals(DefaultIterationIntervalBenchmarkSuite.class.getName(), s.getName());
    }

    @Test
    public void testCreateStringListOfIntegerListOfIntervalOfT() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        assertEquals(0, s.getBenchmarkClassList().size());
        assertEquals(0, s.getBenchmarkList().size());
        assertEquals(l1, s.getIntervalList());
        assertEquals(l0, s.getIterationList());
        assertEquals("b1", s.getName());
    }

    @Test
    public void testCreateStringListOfIntegerListOfIntervalOfT_Negative() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        try {
            DefaultIterationIntervalBenchmarkSuite.create(null, l0, l1);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationIntervalBenchmarkSuite.create("b1", null, l1);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            DefaultIterationIntervalBenchmarkSuite.create("b1", l0, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetIterationList() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        assertEquals(l0, s.getIterationList());
    }

    @Test
    public void testAddIteration() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        assertEquals(l0, s.getIterationList());
        s.addIteration(1);
        assertEquals(1, (int) s.getIterationList().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddIteration_Negative() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        s.addIteration(-1);
    }

    @Test
    public void testGetIntervalList() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        assertEquals(l1, s.getIntervalList());
    }

    @Test
    public void testAddInterval() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        assertEquals(l0, s.getIterationList());
        LongInterval li = new LongInterval(2, 4);
        s.addInterval(li);
        assertEquals(li, s.getIntervalList().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInterval_Negative() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        s.addInterval(null);
    }

    @Test
    public void testExecute() {
        List<Integer> l0 = new ArrayList<Integer>();
        List<LongInterval> l1 = new ArrayList<LongInterval>();
        DefaultIterationIntervalBenchmarkSuite<LongInterval> s =
                DefaultIterationIntervalBenchmarkSuite.create("b1", l0, l1);
        assertEquals(l0, s.getIterationList());
        LongInterval li = new LongInterval(2, 4);
        s.addInterval(li);
        s.addIteration(1);
        assertEquals(li, s.getIntervalList().get(0));
        s.addBenchmark(new SimpleIntervalBenchmark());
        s.execute();
    }

    @Test
    public void testCreateAndRun() {
        // TODO
    }

}

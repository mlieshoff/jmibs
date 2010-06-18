/*
 * AdHocObjectLoadBenchmarkTest.java
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
public class AdHocObjectLoadBenchmarkTest {

    PrepareFunction<Integer> pf = new PrepareFunction<Integer>() {
        @Override
        public void prepare(Integer ctx) {
        }
    };

    ExecuteFunction<Integer> ef = new ExecuteFunction<Integer>() {
        @Override
        public void execute(Integer ctx) {
        }
    };

    @Test
    public void testAdHocObjectLoadBenchmark_Negative() {
        try {
            new AdHocObjectLoadBenchmark(null, this.pf, this.ef);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new AdHocObjectLoadBenchmark("", this.pf, this.ef);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new AdHocObjectLoadBenchmark("b1", null, this.ef);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new AdHocObjectLoadBenchmark("b1", this.pf, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAdHocIntervalBenchmark() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        assertNull(b.getModel());
        assertEquals(0, b.getObjectLoad());
    }

    @Test
    public void testCreate() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        assertNotNull(b);
    }

    @Test
    public void testExecute() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        b.setObjectLoad(1);
        b.execute();
    }

    @Test
    public void testPrepare() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        b.setObjectLoad(1);
        b.prepare();
    }

    @Test
    public void testGetSetObjectLoad() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        b.setObjectLoad(100);
        assertEquals(100, b.getObjectLoad());
    }

    @Test
    public void testGetSetModel() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        List<String> l = new ArrayList<String>();
        b.setModel(l);
        assertEquals(l, b.getModel());
    }

    @Test
    public void testGetSetName() {
        AdHocObjectLoadBenchmark b = AdHocObjectLoadBenchmark.create("b1", this.pf, this.ef);
        assertEquals("b1", b.getName());
        b.setName("b2");
        assertEquals("b2", b.getName());
    }

}

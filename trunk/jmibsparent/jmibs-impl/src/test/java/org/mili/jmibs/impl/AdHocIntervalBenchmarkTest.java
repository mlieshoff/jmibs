/*
 * AdHocIntervalBenchmarkTest.java
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

import org.junit.*;
import org.mili.jmibs.api.*;

/**
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class AdHocIntervalBenchmarkTest {

    PrepareFunction<LongInterval> pf = new PrepareFunction<LongInterval>() {
        @Override
        public void prepare(LongInterval ctx) {
        }
    };

    ExecuteFunction<LongInterval> ef = new ExecuteFunction<LongInterval>() {
        @Override
        public void execute(LongInterval ctx) {
        }
    };

    @Test
    public void testAdHocIntervalBenchmark_Negative() {
        try {
            new AdHocIntervalBenchmark<LongInterval>("", this.pf, this.ef);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new AdHocIntervalBenchmark<LongInterval>(null, this.pf, this.ef);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new AdHocIntervalBenchmark<LongInterval>("a", null, this.ef);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new AdHocIntervalBenchmark<LongInterval>("a", this.pf, null);
            fail("exception expected!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAdHocIntervalBenchmark() {
        AdHocIntervalBenchmark<LongInterval> b = AdHocIntervalBenchmark.create("b1", this.pf,
                this.ef);
        assertNull(b.getInterval());
    }

    @Test
    public void testCreate() {
        AdHocIntervalBenchmark<LongInterval> b = AdHocIntervalBenchmark.create("b1", this.pf,
                this.ef);
        assertNotNull(b);
    }

    @Test
    public void testExecute() {
        AdHocIntervalBenchmark<LongInterval> b = AdHocIntervalBenchmark.create("b1", this.pf,
                this.ef);
        b.setInterval(new LongInterval(1, 10));
        b.execute();
    }

    @Test
    public void testPrepare() {
        AdHocIntervalBenchmark<LongInterval> b = AdHocIntervalBenchmark.create("b1", this.pf,
                this.ef);
        b.setInterval(new LongInterval(1, 10));
        b.prepare();
    }

    @Test
    public void testGetSetInterval() {
        AdHocIntervalBenchmark<LongInterval> b = AdHocIntervalBenchmark.create("b1", this.pf,
                this.ef);
        assertNull(b.getInterval());
        LongInterval li = new LongInterval(1, 100);
        b.setInterval(li);
        assertEquals(li, b.getInterval());
    }

    @Test
    public void testGetSetName() {
        AdHocIntervalBenchmark<LongInterval> b = AdHocIntervalBenchmark.create("b1", this.pf,
                this.ef);
        assertEquals("b1", b.getName());
        b.setName("b2");
        assertEquals("b2", b.getName());
    }

}

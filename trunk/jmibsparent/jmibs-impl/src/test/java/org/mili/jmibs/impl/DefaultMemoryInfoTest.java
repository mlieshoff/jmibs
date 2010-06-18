/*
 * DefaultMemoryInfoTest.java
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

/**
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class DefaultMemoryInfoTest {

    @Test
    public void testDefaultMemoryInfo() {
        DefaultMemoryInfo dmi = new DefaultMemoryInfo();
        assertEquals(0L, dmi.getFree());
        assertEquals(0L, dmi.getMax());
        assertEquals(0L, dmi.getTotal());
    }

    @Test
    public void testDefaultMemoryInfoLongLongLong() {
        DefaultMemoryInfo dmi = new DefaultMemoryInfo(1L, 2L, 3L);
        assertEquals(1L, dmi.getFree());
        assertEquals(2L, dmi.getMax());
        assertEquals(3L, dmi.getTotal());
    }

    @Test
    public void testCreate() {
        DefaultMemoryInfo dmi = DefaultMemoryInfo.create(1L, 2L, 3L);
        assertEquals(1L, dmi.getFree());
        assertEquals(2L, dmi.getMax());
        assertEquals(3L, dmi.getTotal());
    }

    @Test
    public void testCreateActual() {
        DefaultMemoryInfo dmi = DefaultMemoryInfo.createActual();
        assertTrue(dmi.getFree() > 0);
        assertTrue(dmi.getMax() > 0);
        assertTrue(dmi.getTotal() > 0);
    }

}

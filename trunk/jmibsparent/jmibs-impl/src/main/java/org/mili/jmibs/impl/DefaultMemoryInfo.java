/*
 * DefaultMemoryInfo.java
 *
 * 05.06.2010
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

import org.mili.jmibs.api.MemoryInfo;

/**
 * This class is a default implementation of interface {@link MemoryInfo}.
 *
 * @author Michael Lieshoff
 * @version 1.0 05.06.2010
 * @since 1.0
 */
public class DefaultMemoryInfo implements MemoryInfo {

    private long freeMemory = 0;
    private long maxMemory = 0;
    private long totalMemory = 0;

    /**
     * creates new memory informations.
     */
    protected DefaultMemoryInfo() {
        super();
    }

    /**
     * creates new memory informations.
     *
     * @param freeMemory free memory.
     * @param maxMemory max memory.
     * @param totalMemory total memory.
     */
    protected DefaultMemoryInfo(long freeMemory, long maxMemory, long totalMemory) {
        super();
        this.freeMemory = freeMemory;
        this.maxMemory = maxMemory;
        this.totalMemory = totalMemory;
    }

    /**
     * creates new memory informations.
     *
     * @param freeMemory free memory.
     * @param maxMemory max memory.
     * @param totalMemory total memory.
     * @return new memory informations.
     */
    public static DefaultMemoryInfo create(long freeMemory, long maxMemory, long totalMemory) {
        return new DefaultMemoryInfo(freeMemory, maxMemory, totalMemory);
    }

    /**
     * creates new memory informations.
     *
     * @return new memory informations.
     */
    public static DefaultMemoryInfo createActual() {
        Runtime r = Runtime.getRuntime();
        return new DefaultMemoryInfo(r.freeMemory(), r.maxMemory(), r.totalMemory());
    }

    @Override
    public long getFree() {
        return this.freeMemory;
    }

    @Override
    public long getMax() {
        return this.maxMemory;
    }

    @Override
    public long getTotal() {
        return this.totalMemory;
    }

    @Override
    public String toString() {
        final String t = "%,dMB/%,dMB/%,dMB";
        final int MB = 1024 * 1024;
        StringBuilder s = new StringBuilder();
        s.append(String.format(t, this.totalMemory/MB, this.maxMemory/MB, this.freeMemory/MB));
        return s.toString();
    }
}

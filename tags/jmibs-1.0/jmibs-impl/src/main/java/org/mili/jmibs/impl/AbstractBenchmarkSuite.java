/*
 * AbstractBenchmarkSuite.java
 *
 * 12.04.2010
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

import java.util.*;

import org.mili.jmibs.api.*;

/**
 * This abstract class provides some basic implmentation of benchmark suite interface.
 *
 * @author Michael Lieshoff
 * @version 1.1 15.04.2010
 * @since 1.0
 * @changed ML 23.04.2010 - extended name.
 */
public abstract class AbstractBenchmarkSuite implements BenchmarkSuite {

    private String name = "";
    private List<Class<?>> benchmarkClassList = new ArrayList<Class<?>>();

    @Override
    public void addBenchmarkClass(Class<?> cls) {
        this.benchmarkClassList.add(cls);
    }

    /**
     * @return the list of benchmark classes
     */
    public List<Class<?>> getBenchmarkClassList() {
        return benchmarkClassList;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name of the suite
     */
    public void setName(String name) {
        this.name = name;
    }


}

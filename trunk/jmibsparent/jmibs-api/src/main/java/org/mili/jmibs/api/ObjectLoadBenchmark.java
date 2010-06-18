/*
 * ObjectLoadBenchmark.java
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

package org.mili.jmibs.api;

/**
 * This interface defines a benchmark thats based on object loading. A benchmark handles with
 * object stores, like lists or other structures, should implements this interface.
 *
 * @author Michael Lieshoff
 * @version 1.0 17/03/2010
 * @since 1.0
 */
public interface ObjectLoadBenchmark<T> extends Benchmark {

    /**
     * @return the underlying model of structure used in this benchmark.
     */
    T getModel();

    /**
     * sets the actually object loading count.
     *
     * @param objectLoad object loading count.
     */
    void setObjectLoad(int objectLoad);
}

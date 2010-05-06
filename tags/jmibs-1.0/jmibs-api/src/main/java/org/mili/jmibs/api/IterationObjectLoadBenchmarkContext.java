/*
 * IterationObjectLoadBenchmarkContext.java
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
 * This interface defines a specially benchmark context to describe informations abaout
 * iteration and object loading of benchmarks.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public interface IterationObjectLoadBenchmarkContext extends BenchmarkContext {

    /**
     * @return the number of iterations.
     */
    int getIteration();

    /**
     * @return this loading count of objects.
     */
    int getObjectLoad();

}

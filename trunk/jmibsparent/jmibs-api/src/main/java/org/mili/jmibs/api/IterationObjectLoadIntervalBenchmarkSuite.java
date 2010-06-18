/*
 * IterationObjectLoadIntervalBenchmarkSuite.java
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

package org.mili.jmibs.api;

/**
 * This interface defines a specially benchmark suite that is based on iteration, object loading
 * and interval benchmark. A benchmark suite that benchmarks 10, 1.000, and 100.000 times some
 * benchmarks that used an object count of 10.000 and 100.000 objects in interval 1 to 100 and 1
 * to 1000 should implementing this interface.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public interface IterationObjectLoadIntervalBenchmarkSuite
        <T extends ObjectLoadIntervalBenchmark<?, I>, I extends Interval<?>>
        extends IterationObjectLoadBenchmarkSuite<T>, IterationIntervalBenchmarkSuite<I> {
}

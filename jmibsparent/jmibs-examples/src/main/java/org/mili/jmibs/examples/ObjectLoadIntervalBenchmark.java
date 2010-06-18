/*
 * ObjectLoadIntervalBenchmark.java
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

package org.mili.jmibs.examples;

import org.mili.jmibs.impl.*;

/**
 * This class defines an object load interval benchmark as empty dummy example.
 *
 * @author Michael Lieshoff
 * @version 1.0 05.06.2010
 * @since 1.1
 */
public class ObjectLoadIntervalBenchmark
        extends AbstractObjectLoadIntervalBenchmark<String, IntegerInterval> {

    /**
     * creates a new object load interval benchmark-
     */
    public ObjectLoadIntervalBenchmark() {
        super();
        this.setName("ObjectLoad-Interval Benchmark");
    }

    @Override
    public void execute() {
        // do some mystery here.
    }

    @Override
    public void prepare() {
        // do some mystery here.
    }

}

/**
 * FibonacciRecursiveBenchmark.java
 *
 * 29.04.2010
 *
 * Copyright 2010 Michael Lieshoff
 */

/*
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
 * This class defines a benchmark to test performance Fibonacci numbers recursive.
 *
 * @author Michael Lieshoff
 * @version 1.0 29.04.2010
 * @since 1.0
 */
public class FibonacciRecursiveBenchmark extends AbstractObjectLoadBenchmark<String> {

    /**
     * creates a new recursive fib benchmark.
     */
    public FibonacciRecursiveBenchmark() {
        super();
        this.setName("Fibonacci: recursive");
    }

    private int fib(int a) {
        if (a == 1 || a == 2)
            return 1;
        else
            return fib(a - 1) + fib(a - 2);
    }

    @Override
    public void execute() {
        this.fib(this.getObjectLoad());
    }

    @Override
    public void prepare() {
        // don't need
    }

}

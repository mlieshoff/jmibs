/**
 * FibonacciEndRecursiveBenchmark.java
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
 * This class defines a benchmark to test performance Fibonacci numbers end recursive.
 *
 * @author Michael Lieshoff
 * @version 1.0 29.04.2010
 * @since 1.0
 */
public class FibonacciEndRecursiveBenchmark extends AbstractObjectLoadBenchmark<String> {

    /**
     * creates a new end recursive fib benchmark.
     */
    public FibonacciEndRecursiveBenchmark() {
        super();
        this.setName("Fibonacci: end-recursive");
    }

    private int fib0(int x, int y, int i, int n) {
        if (i > n)
            return y;
        else
            return fib0(y, x + y, i + 1, n);
    }

    private int fib(int n) {
        return fib0(1, 1, 2, n);
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

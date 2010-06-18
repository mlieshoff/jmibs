/*
 * AdHocObjectLoadIntervalBenchmark.java
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

import org.mili.jmibs.api.*;

/**
 * This class defines an ad hoc object load interval benchmark.
 *
 * @author Michael Lieshoff
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class AdHocObjectLoadIntervalBenchmark<T, I extends Interval<?>> extends
        AbstractObjectLoadIntervalBenchmark<T, I> {

    private PrepareFunction<Integer> pf = null;
    private ExecuteFunction<I> ef = null;

    /**
     * creates a new ad hoc object load interval benchmark.
     *
     * @param name name of benchmark.
     * @param pf prepare function.
     * @param ef execute function.
     */
    protected AdHocObjectLoadIntervalBenchmark(String name, PrepareFunction<Integer> pf,
            ExecuteFunction<I> ef) {
        super();
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("name can't be null or empty!");
        }
        if (pf == null) {
            throw new IllegalArgumentException("prepare function can't be null!");
        }
        if (ef == null) {
            throw new IllegalArgumentException("execute function can't be null!");
        }
        this.setName(name);
        this.pf = pf;
        this.ef = ef;
    }

    /**
     * creates a new ad hoc object load interval benchmark.
     *
     * @param name name of benchmark.
     * @param pf prepare function.
     * @param ef execute function.
     * @return new ad hoc object load interval benchmark.
     */
    public static <T, I extends Interval<?>> AdHocObjectLoadIntervalBenchmark<T, I> create(
            String name, PrepareFunction<Integer> pf, ExecuteFunction<I> ef) {
        return new AdHocObjectLoadIntervalBenchmark<T, I>(name, pf, ef);
    }

    @Override
    public void execute() {
        this.ef.execute(this.getInterval());
    }

    @Override
    public void prepare() {
        this.pf.prepare(this.getObjectLoad());
    }

}

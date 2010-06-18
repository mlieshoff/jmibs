/*
 * AdHocObjectLoadBenchmark.java
 *
 * 06.05.2010
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
 * This class defines an ad hoc object load benchmark.
 *
 * @author Michael Lieshoff
 * @version 1.0 06.05.2010
 * @since 1.1
 */
public class AdHocObjectLoadBenchmark extends AbstractObjectLoadBenchmark<Object> {

    private PrepareFunction<Integer> pf = null;
    private ExecuteFunction<Integer> ef = null;

    /**
     * creates a new ad hoc object load benchmark.
     *
     * @param name name of benchmark.
     * @param pf prepare function.
     * @param ef execute function.
     */
    protected AdHocObjectLoadBenchmark(String name, PrepareFunction<Integer> pf,
            ExecuteFunction<Integer> ef) {
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
     * creates a new ad hoc object load benchmark.
     *
     * @param name name of benchmark.
     * @param pf prepare function.
     * @param ef execute function.
     * @return new ad hoc object load benchmark.
     */
    public static AdHocObjectLoadBenchmark create(String name, PrepareFunction<Integer> pf,
            ExecuteFunction<Integer> ef) {
        return new AdHocObjectLoadBenchmark(name, pf, ef);
    }

    @Override
    public void execute() {
        this.ef.execute(this.getObjectLoad());
    }

    @Override
    public void prepare() {
        this.pf.prepare(this.getObjectLoad());
    }

}

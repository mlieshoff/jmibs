/**
 * ReplaceStringAppendBenchmark.java
 *
 * 12.04.2010
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
 * This class defines a benchmark to test performance while append to a String with replace
 * through appending in use of one line instruction.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class ReplaceStringAppendBenchmark extends AbstractObjectLoadBenchmark<String> {

    /**
     * creates a new append string replace benchmark.
     */
    public ReplaceStringAppendBenchmark() {
        super();
        this.setName("Replace: String(replace, concat instr.)");
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        // notice the pattern!
        // String pattern = "{%}";
        for (int i = 0; i < this.getObjectLoad(); i++) {
            sb.append("{").append(String.valueOf(i)).append("}");
        }
    }

    @Override
    public void prepare() {
        // no need
    }

}

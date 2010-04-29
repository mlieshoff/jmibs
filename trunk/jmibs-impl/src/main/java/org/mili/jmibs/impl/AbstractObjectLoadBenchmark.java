/**
 * AbstractObjectLoadBenchmark.java
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

package org.mili.jmibs.impl;

import org.mili.jmibs.api.*;

/**
 * This abstract class provides some basic implementation of object load benchmark interface.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public abstract class AbstractObjectLoadBenchmark<T> extends AbstractBenchmark implements
        ObjectLoadBenchmark<T> {

    private T model = null;
    private int objectLoad = 0;

    @Override
    public T getModel() {
        return this.model;
    }

    /**
     * @param model the model structure to set
     */
    public void setModel(T model) {
        this.model = model;
    }

    /**
     * @return the object loading count.
     */
    public int getObjectLoad() {
        return this.objectLoad;
    }

    @Override
    public void setObjectLoad(int objectLoad) {
        this.objectLoad = objectLoad;
    }

}

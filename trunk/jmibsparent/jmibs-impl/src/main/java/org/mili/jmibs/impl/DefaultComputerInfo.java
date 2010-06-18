/*
 * DefaultComputerInfo.java
 *
 * 18.06.2010
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
 * This class defines a default implementation of interface {@link ComputerInfo}.
 *
 * @author Michael Lieshoff
 * @version 1.0 18.06.2010
 * @since 1.1
 */
public class DefaultComputerInfo implements ComputerInfo {

    /**
     * creates new computer info.
     */
    protected DefaultComputerInfo() {
        super();
    }

    /**
     * creates new computer info.
     *
     * @return new computer info.
     */
    public static DefaultComputerInfo create() {
        return new DefaultComputerInfo();
    }

    @Override
    public String getJavaRuntimeVersion() {
        return System.getProperty("java.runtime.name") + "(build " + System.getProperty(
                "java.runtime.version") + ")";
    }

    @Override
    public String getJavaVersion() {
        return "java version " + System.getProperty("java.version");
    }

    @Override
    public String getJavaVMVersion() {
        return System.getProperty("java.vm.name") + "(build " + System.getProperty(
                "java.vm.version") + ", " + System.getProperty("java.vm.info") + ")";
    }

    @Override
    public String getOs() {
        return System.getProperty("os.name") + "(" + System.getProperty("os.version") + ") "
                + System.getProperty("os.arch");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getJavaVersion());
        s.append("\n");
        s.append(this.getJavaRuntimeVersion());
        s.append("\n");
        s.append(this.getJavaVMVersion());
        s.append("\n");
        s.append(this.getOs());
        return s.toString();
    }

}

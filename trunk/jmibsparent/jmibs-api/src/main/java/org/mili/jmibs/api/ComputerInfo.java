/*
 * ComputerInfo.java
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

package org.mili.jmibs.api;

/**
 * The interface defines computer informations.
 *
 * @author Michael Lieshoff
 * @version 1.0 18.06.2010
 * @since 1.1
 */
public interface ComputerInfo {

    /**
     * @return the Java version.
     */
    String getJavaVersion();

    /**
     * @return the Java runtime version.
     */
    String getJavaRuntimeVersion();

    /**
     * @return the Java VM version.
     */
    String getJavaVMVersion();

    /**
     * @return operation system name and version.
     */
    String getOs();

}

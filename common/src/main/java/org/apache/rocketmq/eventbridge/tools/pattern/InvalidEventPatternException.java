/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.tools.pattern;

/**
 * This exception is raised if there is a serious issue that occurs during parsing of a Event pattern string.
 */
public class InvalidEventPatternException extends RuntimeException {
    static final long serialVersionUID = -1158730467890354646L;

    /**
     * Creates exception with the specified message. If you are wrapping another exception, consider using {@link
     * #InvalidEventPatternException(String, Throwable)} instead.
     *
     * @param msg error message describing a possible cause of this exception.
     */
    public InvalidEventPatternException(String msg) {
        super(msg);
    }

    /**
     * Creates exception with the specified message and cause.
     *
     * @param msg   error message describing what happened.
     * @param cause root exception that caused this exception to be thrown.
     */
    public InvalidEventPatternException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Creates exception with the specified cause. Consider using {@link #InvalidEventPatternException(String,
     * Throwable)} instead if you can describe what happened.
     *
     * @param cause root exception that caused this exception to be thrown.
     */
    public InvalidEventPatternException(Throwable cause) {
        super(cause);
    }
}

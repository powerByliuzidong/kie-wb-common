/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.kie.workbench.common.services.datamodeller.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation is intended for UI testing purposes.
 */

@java.lang.annotation.Retention( RetentionPolicy.RUNTIME )
@java.lang.annotation.Target({ ElementType.TYPE, ElementType.FIELD })
public @interface IntParamsAnnotation {

    int intParam1() default 0;

    int intParam2();

    int[] intArrayParam1() default {};

    int[] intArrayParam2();

}

/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.forms.fields.shared.fieldTypes;

import org.junit.Test;
import org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.HasMaxLength;
import org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.HasPlaceHolder;
import org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.HasRows;
import org.kie.workbench.common.forms.model.FieldDefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractFieldDefinitionTest<FIELD extends FieldDefinition> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LABEL = "label";
    public static final String BINDING = "binding";
    public static final String STANDALONE_CLASS_NAME = "class";

    public static final String PLACE_HOLDER = "placeHolder";
    public static final Integer MAX_LENGTH = 255;
    public static final Integer MAX_ROWS = 255;

    public static final Boolean READONLY = Boolean.TRUE;
    public static final Boolean REQUIRED = Boolean.TRUE;
    public static final Boolean VALIDATE_ON_CHANGE = Boolean.FALSE;

    @Test
    public void testCopyFrom() {
        FIELD originalFieldDefinition = getEmptyFieldDefinition();

        FIELD newFieldDefinition = getNewFieldDefinition();

        assertFalse(originalFieldDefinition.equals(newFieldDefinition));

        originalFieldDefinition.copyFrom(newFieldDefinition);

        // COPYING fields not affected by copyFrom to make equals work
        originalFieldDefinition.setId(newFieldDefinition.getId());
        originalFieldDefinition.setName(newFieldDefinition.getName());

        assertTrue(originalFieldDefinition.equals(newFieldDefinition));
    }

    protected FIELD getNewFieldDefinition() {
        FIELD field = getFullFieldDefinition();

        field.setId(ID);
        field.setName(NAME);
        field.setLabel(LABEL);
        field.setBinding(BINDING);
        field.setReadOnly(READONLY);
        field.setRequired(REQUIRED);
        field.setStandaloneClassName(STANDALONE_CLASS_NAME);
        field.setValidateOnChange(VALIDATE_ON_CHANGE);

        if (field instanceof HasMaxLength) {
            ((HasMaxLength) field).setMaxLength(MAX_LENGTH);
        }

        if (field instanceof HasPlaceHolder) {
            ((HasPlaceHolder) field).setPlaceHolder(PLACE_HOLDER);
        }

        if (field instanceof HasRows) {
            ((HasRows) field).setRows(MAX_ROWS);
        }

        return field;
    }

    protected abstract FIELD getEmptyFieldDefinition();

    protected abstract FIELD getFullFieldDefinition();
}

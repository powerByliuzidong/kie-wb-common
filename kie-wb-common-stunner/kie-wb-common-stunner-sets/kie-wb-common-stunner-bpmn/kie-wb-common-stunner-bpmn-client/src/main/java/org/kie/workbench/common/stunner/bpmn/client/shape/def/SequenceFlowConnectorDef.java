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

package org.kie.workbench.common.stunner.bpmn.client.shape.def;

import org.kie.workbench.common.stunner.bpmn.client.resources.BPMNImageResources;
import org.kie.workbench.common.stunner.bpmn.definition.SequenceFlow;
import org.kie.workbench.common.stunner.bpmn.definition.property.font.FontFamily;
import org.kie.workbench.common.stunner.core.client.shape.SvgDataUriGlyph;
import org.kie.workbench.common.stunner.core.client.shape.view.HasTitle;
import org.kie.workbench.common.stunner.core.definition.shape.Glyph;
import org.kie.workbench.common.stunner.shapes.def.ConnectorShapeDef;

public final class SequenceFlowConnectorDef
        implements BPMNShapeDef<SequenceFlow>,
                   ConnectorShapeDef<SequenceFlow> {

    @Override
    public String getBackgroundColor(final SequenceFlow element) {
        return element.getBackgroundSet().getBgColor().getValue();
    }

    @Override
    public double getBackgroundAlpha(final SequenceFlow element) {
        return 1;
    }

    @Override
    public String getBorderColor(final SequenceFlow element) {
        return element.getBackgroundSet().getBorderColor().getValue();
    }

    @Override
    public double getBorderSize(final SequenceFlow element) {
        return element.getBackgroundSet().getBorderSize().getValue();
    }

    @Override
    public double getBorderAlpha(final SequenceFlow element) {
        return 1;
    }

    @Override
    public String getFontFamily(final SequenceFlow element) {
        return FontFamily.defaultValue;
    }

    @Override
    public String getFontBorderColor(final SequenceFlow element) {
        return element.getFontSet().getFontBorderColor().getValue();
    }

    @Override
    public HasTitle.Position getFontPosition(final SequenceFlow element) {
        return HasTitle.Position.TOP;
    }

    @Override
    public double getFontRotation(final SequenceFlow element) {
        return 0;
    }

    @Override
    public Glyph getGlyph(final Class<? extends SequenceFlow> type) {
        return SvgDataUriGlyph.Builder.build(BPMNImageResources.INSTANCE.sequenceFlow().getSafeUri());
    }
}

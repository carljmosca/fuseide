/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.camel.model.generated;

import java.util.Map;

import org.apache.camel.model.language.ExpressionDefinition;
import org.apache.camel.model.LoopDefinition;
import org.apache.camel.model.ProcessorDefinition;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.fusesource.ide.camel.model.AbstractNode;
import org.fusesource.ide.camel.model.ExpressionPropertyDescriptor;
import org.fusesource.ide.camel.model.RouteContainer;
import org.fusesource.ide.camel.model.util.Objects;
import org.fusesource.ide.commons.properties.BooleanPropertyDescriptor;
import org.fusesource.ide.commons.properties.ComplexPropertyDescriptor;
import org.fusesource.ide.commons.properties.ComplexUnionPropertyDescriptor;
import org.fusesource.ide.commons.properties.EnumPropertyDescriptor;
import org.fusesource.ide.commons.properties.ListPropertyDescriptor;
import org.fusesource.ide.commons.properties.UnionTypeValue;

/**
 * The Node class from Camel's LoopDefinition
 *
 * NOTE - this file is auto-generated using Velocity.
 *
 * DO NOT EDIT!
 */
public class Loop extends AbstractNode {

    public static final String PROPERTY_EXPRESSION = "Loop.Expression";
    public static final String PROPERTY_COPY = "Loop.Copy";

    private ExpressionDefinition expression;
    private Boolean copy;

    public Loop() {
    }

    public Loop(LoopDefinition definition, RouteContainer parent) {
        super(parent);
        loadPropertiesFromCamelDefinition(definition);
        loadChildrenFromCamelDefinition(definition);
    }

    @Override
    public String getIconName() {
        return "generic.png";
    }

    @Override
    public String getDocumentationFileName() {
        return "loopEIP";
    }

    @Override
    public String getCategoryName() {
        return "Control Flow";
    }

    /**
     * @return the expression
     */
    public ExpressionDefinition getExpression() {
        return this.expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(ExpressionDefinition expression) {
        ExpressionDefinition oldValue = this.expression;
        this.expression = expression;
        if (!isSame(oldValue, expression)) {
            firePropertyChange(PROPERTY_EXPRESSION, oldValue, expression);
        }
    }

    /**
     * @return the copy
     */
    public Boolean getCopy() {
        return this.copy;
    }

    /**
     * @param copy the copy to set
     */
    public void setCopy(Boolean copy) {
        Boolean oldValue = this.copy;
        this.copy = copy;
        if (!isSame(oldValue, copy)) {
            firePropertyChange(PROPERTY_COPY, oldValue, copy);
        }
    }

    @Override
    protected void addCustomProperties(Map<String, PropertyDescriptor> descriptors) {
        super.addCustomProperties(descriptors);

        PropertyDescriptor descExpression = new ExpressionPropertyDescriptor(PROPERTY_EXPRESSION, Messages.propertyLabelLoopExpression);
        PropertyDescriptor descCopy = new BooleanPropertyDescriptor(PROPERTY_COPY, Messages.propertyLabelLoopCopy);

        descriptors.put(PROPERTY_EXPRESSION, descExpression);
        descriptors.put(PROPERTY_COPY, descCopy);
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource\#setPropertyValue(java.lang.Object, java.lang.Object)
     */
    @Override
    public void setPropertyValue(Object id, Object value) {
        if (PROPERTY_EXPRESSION.equals(id)) {
            setExpression(Objects.convertTo(value, ExpressionDefinition.class));
            return;
        }
        if (PROPERTY_COPY.equals(id)) {
            setCopy(Objects.convertTo(value, Boolean.class));
            return;
        }
        super.setPropertyValue(id, value);
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.model.AbstractNode\#getPropertyValue(java.lang.Object)
     */
    @Override
    public Object getPropertyValue(Object id) {
        if (PROPERTY_EXPRESSION.equals(id)) {
            return this.getExpression();
        }
        if (PROPERTY_COPY.equals(id)) {
            return this.getCopy();
        }
        return super.getPropertyValue(id);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ProcessorDefinition createCamelDefinition() {
        LoopDefinition answer = new LoopDefinition();

        answer.setExpression(toXmlPropertyValue(PROPERTY_EXPRESSION, this.getExpression()));
        answer.setCopy(toXmlPropertyValue(PROPERTY_COPY, this.getCopy()));

        super.savePropertiesToCamelDefinition(answer);
        return answer;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class<?> getCamelDefinitionClass() {
        return LoopDefinition.class;
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected void loadPropertiesFromCamelDefinition(ProcessorDefinition processor) {
        super.loadPropertiesFromCamelDefinition(processor);

        if (processor instanceof LoopDefinition) {
            LoopDefinition node = (LoopDefinition) processor;

            this.setExpression(node.getExpression());
            this.setCopy(node.getCopy());
        } else {
            throw new IllegalArgumentException("ProcessorDefinition not an instanceof LoopDefinition. Was " + processor.getClass().getName());
        }
    }

}

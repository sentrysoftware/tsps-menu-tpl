/**
 * Classes mimicking BMC TSPS code that is necessary to compile the Java code
 * that declares our menu.
 *
 * These classes are excluded from the .war artifact and from the plugin .zip file
 * as their "real" counterparts will be provided at runtime in the classpath of
 * the JVM executing TSPS and our code.
 *
 * DO NOT CHANGE.
 */
package com.bmc.truesight.api.dto;


import com.bmc.truesight.api.dto.exceptions.ComponentManagementException;
import java.io.Serializable;

public class ComponentAttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String attributeName;
	private String attributeValue;
	private Component component;
	private long id;
	private String key;
	private String attributeNameKey;
	private ComponentAttributeType type;
	private Object defaultValue;
	private String description;
	private String descriptionKey;
	private int order;
	private boolean required;
	private int max_length;
	private int min_length;
	private String pattern;
	private String requriedMessageKey;
	private String validationMessageKey;
	private boolean display = true;
	private boolean disabledInEditMode = true;
	private String displayNote = "";

	public enum ComponentAttributeType {
		TEXT, PASSWORD, NUMBER, CELL, CHECKBOX;
	}

	public Component getComponent() {
		return this.component;
	}

	public void setComponent(final Component component) {
		this.component = component;
	}



	public ComponentAttributeEntity(final String key, final String attributeName, final String attributeNameKey,
			final String attributeValue, final ComponentAttributeType type, final Object defaultValue,
			final String description, final String descriptionKey, final int order, final boolean required,
			final int max_length, final int min_length, final String pattern, final String requriedMessageKey,
			final String validationMessageKey) throws ComponentManagementException {
		if (attributeName == null || attributeName.isEmpty()) {
			throw new ComponentManagementException("Attribute Name cannot be null/empty.");
		}
		this.key = key;
		this.attributeName = attributeName;
		this.attributeNameKey = attributeNameKey;
		this.attributeValue = attributeValue;
		this.type = type;
		this.defaultValue = defaultValue;
		this.description = description;
		this.descriptionKey = descriptionKey;
		this.order = order;
		this.required = required;
		this.max_length = max_length;
		this.min_length = min_length;
		this.pattern = pattern;
		this.requriedMessageKey = requriedMessageKey;
		this.validationMessageKey = validationMessageKey;
	}

	public ComponentAttributeEntity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(final String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(final String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public ComponentAttributeType getType() {
		return this.type;
	}

	public void setType(final ComponentAttributeType type) {
		this.type = type;
	}

	public Object getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(final Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(final int order) {
		this.order = order;
	}

	public boolean isDisplay() {
		return this.display;
	}

	public void setDisplay(final boolean display) {
		this.display = display;
	}

	public boolean isRequired() {
		return this.required;
	}

	public void setRequired(final boolean required) {
		this.required = required;
	}

	public int getMax_length() {
		return this.max_length;
	}

	public void setMax_length(final int max_length) {
		this.max_length = max_length;
	}

	public int getMin_length() {
		return this.min_length;
	}

	public void setMin_length(final int min_length) {
		this.min_length = min_length;
	}

	public String getPattern() {
		return this.pattern;
	}

	public void setPattern(final String pattern) {
		this.pattern = pattern;
	}

	public String getAttributeNameKey() {
		return this.attributeNameKey;
	}

	public void setAttributeNameKey(final String attributeNameKey) {
		this.attributeNameKey = attributeNameKey;
	}

	public String getDescriptionKey() {
		return this.descriptionKey;
	}

	public void setDescriptionKey(final String descriptionKey) {
		this.descriptionKey = descriptionKey;
	}

	public String getRequriedMessageKey() {
		return this.requriedMessageKey;
	}

	public void setRequriedMessageKey(final String requriedMessageKey) {
		this.requriedMessageKey = requriedMessageKey;
	}

	public String getValidationMessageKey() {
		return this.validationMessageKey;
	}

	public void setValidationMessageKey(final String validationMessageKey) {
		this.validationMessageKey = validationMessageKey;
	}

	public boolean isDisabledInEditMode() {
		return this.disabledInEditMode;
	}

	public void setDisabledInEditMode(final boolean disabledInEditMode) {
		this.disabledInEditMode = disabledInEditMode;
	}

	public String getDisplayNote() {
		return this.displayNote;
	}

	public void setDisplayNote(final String displayNote) {
		this.displayNote = displayNote;
	}

	@Override
	public String toString() {
		return "ComponentAttributeEntity [attributeName=" + this.attributeName + ", attributeValue="
				+ ((this.type == ComponentAttributeType.PASSWORD) ? "*****" : this.attributeValue) + ", component="
				+ this.component + ", id=" + this.id + ", key=" + this.key + ", attributeNameKey="
				+ this.attributeNameKey + ", type=" + this.type + ", defaultValue=" + this.defaultValue
				+ ", description=" + this.description + ", descriptionKey=" + this.descriptionKey + ", order="
				+ this.order + ", required=" + this.required + ", max_length=" + this.max_length + ", min_length="
				+ this.min_length + ", pattern=" + this.pattern + ", validationMessage=" + this.requriedMessageKey
				+ ", validationMessageKey=" + this.validationMessageKey + ", display=" + this.display
				+ ", disabledInEditMode=" + this.disabledInEditMode + "]";
	}
}


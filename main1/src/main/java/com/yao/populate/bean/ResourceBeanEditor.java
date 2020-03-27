package com.yao.populate.bean;

import com.yao.populate.App;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * 2020-03-17 00:59
 *
 * @author yaoyy
 */
public class ResourceBeanEditor extends PropertyEditorSupport {

	@Override
	public void setValue(Object value) {
		App app = (App) value;
		super.setValue(app.getResourceBean());
	}
}

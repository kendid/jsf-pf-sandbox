package com.codenotfound.primefaces;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;

@Named
public class HelloWorld {

  private static final Log LOGGER = LogFactory.getLog(HelloWorld.class);

  private Integer selection;
  private String text;
  private InputText textBinding;

  public HelloWorld() {
    this.selection = 0;
  }

  public DataTable getTable() {
    return new DataTable();
  }

  public List<SelectItem> getMenuItems() {
    LOGGER.trace("getMenuItems()");
    final ArrayList<SelectItem> result = new ArrayList<>();
    result.add(new SelectItem(0, "ONE"));
    result.add(new SelectItem(1, "TWO"));
    result.add(new SelectItem(2, "THREE"));
    return result;
  }

  public boolean isThree() {
    LOGGER.trace("isThree()? " + selection);
    final boolean result = (2 == selection);
    if (!result) {
      setText("");
    }
    return result;
  }

  public Integer getSelection() {
    LOGGER.trace("getSelection(): " + selection);
    return selection;
  }

  public void setSelection(final Integer value) {
    LOGGER.trace("setSelection(" + value + ")");
    this.selection = value;
  }

  public void onSelectionChanged() {
    LOGGER.trace("onSelectionChanged(), current values: " + text + ", "
            + (textBinding != null ? textBinding.getValue() : null));
    LOGGER.info(getSelection());

//    final InputText component = (InputText) FacesContext.getCurrentInstance().getViewRoot().findComponent("helloworld-form:table:textfield");
  }

  public String getText() {
    LOGGER.trace("getText(): " + text);
    return text;
  }

  public void setText(final String value) {
    LOGGER.trace("setText(" + value + ")");
    this.text = value;
  }

  public void submit() {
    LOGGER.info(String.format("Selection: %d, Text: '%s', Binding: '%s'.",
            selection, text, (textBinding != null) ? textBinding.getValue() : null));
  }
}

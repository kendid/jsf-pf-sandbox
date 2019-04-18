package com.codenotfound.primefaces;

import javax.faces.model.SelectItem;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.component.datatable.DataTable;

@Named
public class HelloWorld {

  private Integer selection;

  public HelloWorld() {
    this.selection = 0;
  }

  public DataTable getTable() {
    return new DataTable();
  }

  public List<SelectItem> getMenuItems() {
    final ArrayList<SelectItem> result = new ArrayList<>();
    result.add(new SelectItem(0, "ONE"));
    result.add(new SelectItem(1, "TWO"));
    result.add(new SelectItem(2, "THREE"));
    return result;
  }

  public boolean isThree() {
    return 2 == selection;
  }

  public Integer getSelection() {
    return selection;
  }

  public void setSelection(final Integer selection) {
    this.selection = selection;
  }
}

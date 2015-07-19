package com.george.gsonexample;

/**
 * Created by shizhe on 15/7/18.
 */
public class TreeNodeObject {

  private String scene_img_id;

  private boolean isRoot;

  private TreeNodeObject[] children_node;

  private ChildCoordObject[] children_coord;

  public String getScene_img_id() {
    return scene_img_id;
  }

  public void setScene_img_id(String scene_img_id) {
    this.scene_img_id = scene_img_id;
  }

  public boolean isRoot() {
    return isRoot;
  }

  public void setRoot(boolean isRoot) {
    this.isRoot = isRoot;
  }

  public TreeNodeObject[] getChildren_node() {
    return children_node;
  }

  public void setChildren_node(TreeNodeObject[] children_node) {
    this.children_node = children_node;
  }

  public ChildCoordObject[] getChildren_coord() {
    return children_coord;
  }

  public void setChildren_coord(ChildCoordObject[] children_coord) {
    this.children_coord = children_coord;
  }
}

package com.george.gsonexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GsonExampleActivity extends Activity {
  private TextView mText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gson_example);
    mText = (TextView) findViewById(R.id.treeInfo);

    String jsonString = getJsonFromRaw();

    Gson gson = new Gson();
    Type listType = new TypeToken<ArrayList<TreeNodeObject>>() {}.getType();
    ArrayList<TreeNodeObject> jsonArr = gson.fromJson(jsonString, listType);
    ArrayList<TreeNodeObject> mTreeNodeList = new ArrayList<>();

    for (TreeNodeObject obj : jsonArr) {
      traversalHelper(obj, mTreeNodeList);

      printTreeNodeInfo(mTreeNodeList);
      mTreeNodeList.clear();
      mText.append("------------------------------------\n");
    }
  }

  private void traversalHelper(TreeNodeObject treeNode, ArrayList<TreeNodeObject> traversal) {
    traversal.add(treeNode);
    for (TreeNodeObject child : treeNode.getChildren_node()) {

      traversalHelper(child, traversal);
    }
  }

  private void printTreeNodeInfo(ArrayList<TreeNodeObject> treeList) {

    for (TreeNodeObject mChildNode : treeList) {
      mText.append("obj.getScene_img_id() : " + mChildNode.getScene_img_id() + "\n");
      mText.append("obj.isRoot() : " + mChildNode.isRoot() + "\n");

      for (ChildCoordObject child_coord : mChildNode.getChildren_coord()) {
        mText.append("child_coord.getX():" + child_coord.getX() + "\n");
        mText.append("child_coord.getY():" + child_coord.getY() + "\n");
        mText.append("child_coord.getZ():" + child_coord.getZ() + "\n");
      }
    }
  }

  private String getJsonFromRaw() {
    InputStream is = getResources().openRawResource(R.raw.tree);
    Writer writer = new StringWriter();
    char[] buffer = new char[1024];

    try {
      Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      int n;

      while ((n = reader.read(buffer)) != -1) {
        writer.write(buffer, 0, n);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return writer.toString();
  }
}

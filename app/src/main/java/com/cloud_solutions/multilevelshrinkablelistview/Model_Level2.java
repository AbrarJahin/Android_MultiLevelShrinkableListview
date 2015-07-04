package com.cloud_solutions.multilevelshrinkablelistview;

import java.util.ArrayList;

/**
 * second level item
 */

public class Model_Level2 {
    private String pSubCatName;
    private ArrayList<Model_Level3> mModelLevel3Array;

    public Model_Level2(String pSubCatName, ArrayList<Model_Level3> mModelLevel3Array) {
        super();
        this.pSubCatName = pSubCatName;
        this.mModelLevel3Array = mModelLevel3Array;
    }

    public String getpSubCatName() {
        return pSubCatName;
    }

    public void setpSubCatName(String pSubCatName) {
        this.pSubCatName = pSubCatName;
    }

    public ArrayList<Model_Level3> set_Model_of_Level_3_from_Level_2() {
        return mModelLevel3Array;
    }

    public void set_Model_of_Level_3_from_Level_2(ArrayList<Model_Level3> mModelLevel3Array) {
        this.mModelLevel3Array = mModelLevel3Array;
    }
}
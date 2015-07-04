package com.cloud_solutions.multilevelshrinkablelistview;

import java.util.ArrayList;

/**
 *
 * first level item
 *
 */

public class Model_Level1
{
    private String pName;

    private ArrayList<Model_Level2> mModelLevel2List;

    public Model_Level1(String pName, ArrayList<Model_Level2> mModelLevel2List)
    {
        super();
        this.pName = pName;
        this.mModelLevel2List = mModelLevel2List;
    }

    public String getName()
    {
        return pName;
    }

    public void setName(String pName)
    {
        this.pName = pName;
    }

    public ArrayList<Model_Level2> get_Model_of_Level_2_from_Level_1()
    {
        return mModelLevel2List;
    }

    public void set_Model_of_Level_2_from_Level_1(ArrayList<Model_Level2> mModelLevel2List)
    {
        this.mModelLevel2List = mModelLevel2List;
    }
}
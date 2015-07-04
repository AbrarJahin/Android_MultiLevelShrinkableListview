package com.cloud_solutions.multilevelshrinkablelistview;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{
    private ArrayList<Model_Level1>mainList;            //For storing all data in main list
    private LinearLayout Main_scrollable_part_Layout_for_Level_1_data_showing;               //Main view's linear part's reference - for future change making
                                                //Total level=3, so 2 boolean value is needed to store status
    private boolean is_Level_1_View_Clicked =   false;  //For level 1 item clicked -> store current level 1 state
    private boolean is_Level_2_View_Clicked =   false;  //For level 2 item clicked -> store current level 2 state

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main_scrollable_part_Layout_for_Level_1_data_showing = (LinearLayout) findViewById(R.id.Main_View_Reference);

        storeAllDataInArrayList();

        showAllDataInShrinkableList();
    }

    void storeAllDataInArrayList()                  //Store all data
    {
        ArrayList<Model_Level2>subArrayList1;
        ArrayList<Model_Level2>subArrayList2;

        //Make array list one is for main-list and other is for sub-list
        mainList=new ArrayList<Model_Level1>();
        subArrayList1=new ArrayList<Model_Level2>();
        subArrayList2=new ArrayList<Model_Level2>();

        //This arraylists are used to put items in sublists
        ArrayList<Model_Level3> subArrayListItem1=new ArrayList<Model_Level3>();
        ArrayList<Model_Level3> subArrayListItem2=new ArrayList<Model_Level3>();
        ArrayList<Model_Level3> subArrayListItem3=new ArrayList<Model_Level3>();

        //Add main categories in Mainlists along with their items it
        mainList.add(new Model_Level1("Mobiles", subArrayList1));
        mainList.add(new Model_Level1("Accessories", subArrayList2));

        //Add arrylist in category
        subArrayList1.add(new Model_Level2("Motorola", subArrayListItem1));

        //Add items means arrylist
        subArrayListItem1.add(new Model_Level3("Moto X", "29999"));
        subArrayListItem1.add(new Model_Level3("Moto G", "12999"));
        subArrayListItem1.add(new Model_Level3("Moto E", "6999"));


        subArrayList2.add(new Model_Level2("Covers", subArrayListItem2));
        subArrayList2.add(new Model_Level2("Headphones", subArrayListItem3));


        subArrayListItem2.add(new Model_Level3("FlipCover", "599"));
        subArrayListItem2.add(new Model_Level3("pouch", "249"));
        subArrayListItem2.add(new Model_Level3("BackCover", "499"));

        subArrayListItem3.add(new Model_Level3("Wired Headphones", "399"));
        subArrayListItem3.add(new Model_Level3("Wireless Headphones", "1999"));
    }

    void showAllDataInShrinkableList()              //Show all data and set on click events
    {
        //Adds data into Level 1 row
        for (int i = 0; i < mainList.size(); i++)
        {
            LayoutInflater inflater_for_Level_1_data_showing = null;
            inflater_for_Level_1_data_showing = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View Level_1_View = inflater_for_Level_1_data_showing.inflate(R.layout.row_level_1, null);

            final TextView Level_1_ProductName = (TextView) Level_1_View.findViewById(R.id.textViewName);
            final RelativeLayout Level_1_Layout =(RelativeLayout)Level_1_View.findViewById(R.id.layout_Level_1_relative);
            final ImageView Level_1_Arrow=(ImageView)Level_1_View.findViewById(R.id.imgLevel_1_Arrow);
            final LinearLayout Level_1_scrollable_part_Layout_for_Level_2_data_showing=(LinearLayout)Level_1_View.findViewById(R.id.Level_1_Scroll_for_Level_2);

            //checks if menu is already opened or not
            if(is_Level_1_View_Clicked ==false)
            {
                Level_1_scrollable_part_Layout_for_Level_2_data_showing.setVisibility(View.GONE);
                Level_1_Arrow.setBackgroundResource(R.drawable.arow_left);
            }
            else
            {
                Level_1_scrollable_part_Layout_for_Level_2_data_showing.setVisibility(View.VISIBLE);
                Level_1_Arrow.setBackgroundResource(R.drawable.arow_down);
            }

            //Handles onclick effect on list item of Level 1
            Level_1_Layout.setOnTouchListener(new OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    if (is_Level_1_View_Clicked == false)
                    {
                        is_Level_1_View_Clicked = true;
                        Level_1_Arrow.setBackgroundResource(R.drawable.arow_down);
                        Level_1_scrollable_part_Layout_for_Level_2_data_showing.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        is_Level_1_View_Clicked = false;
                        Level_1_Arrow.setBackgroundResource(R.drawable.arow_left);
                        Level_1_scrollable_part_Layout_for_Level_2_data_showing.setVisibility(View.GONE);
                    }
                    return false;               //Stop propagating in other views
                }
            });

            final String Level_1_Item_Name = mainList.get(i).getName();
            Level_1_ProductName.setText(Level_1_Item_Name);

            //Adds data into Level 2 row for current level 1 row item
            for (int j = 0; j < mainList.get(i).get_Model_of_Level_2_from_Level_1().size(); j++)
            {
                LayoutInflater inflater_for_level_2_data_showing = null;
                inflater_for_level_2_data_showing = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View Level_2_View = inflater_for_level_2_data_showing.inflate(R.layout.row_level_2, null);

                TextView Level_2_Item_Name = (TextView) Level_2_View.findViewById(R.id.Level_2_Name);
                final RelativeLayout Level_2_Layout=(RelativeLayout)Level_2_View.findViewById(R.id.Level_2_Layout);
                final ImageView imageLevel_2_Arrow=(ImageView)Level_2_View.findViewById(R.id.imageLevel_2_Arrow);
                final LinearLayout Level_2_scrollable_part_Layout_for_Level_3_data_showing=(LinearLayout)Level_2_View.findViewById(R.id.Level_2_Scroll_for_Level_3);

                //checkes if menu is already opened or not
                if(is_Level_2_View_Clicked ==false)
                {
                    Level_2_scrollable_part_Layout_for_Level_3_data_showing.setVisibility(View.GONE);
                    imageLevel_2_Arrow.setBackgroundResource(R.drawable.arow_left);
                }
                else
                {
                    Level_2_scrollable_part_Layout_for_Level_3_data_showing.setVisibility(View.VISIBLE);
                    imageLevel_2_Arrow.setBackgroundResource(R.drawable.arow_down);
                }

                //Handles onclick effect on list item of level 2
                Level_2_Layout.setOnTouchListener(new OnTouchListener()
                {
                    @Override
                    public boolean onTouch(View v, MotionEvent event)
                    {
                        if (is_Level_2_View_Clicked == false)
                        {
                            is_Level_2_View_Clicked = true;
                            imageLevel_2_Arrow.setBackgroundResource(R.drawable.arow_down);
                            Level_2_scrollable_part_Layout_for_Level_3_data_showing.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            is_Level_2_View_Clicked = false;
                            imageLevel_2_Arrow.setBackgroundResource(R.drawable.arow_left);
                            Level_2_scrollable_part_Layout_for_Level_3_data_showing.setVisibility(View.GONE);
                        }
                        return false;       //Stop propagating in other views
                    }
                });

                final String Level_2_Name = mainList.get(i).get_Model_of_Level_2_from_Level_1().get(j).getpSubCatName();
                Level_2_Item_Name.setText(Level_2_Name);

                //Adds data into Level 3 row for current level 2 row item
                for (int k = 0; k < mainList.get(i).get_Model_of_Level_2_from_Level_1().get(j).set_Model_of_Level_3_from_Level_2().size(); k++)
                {
                    LayoutInflater inflater_for_level_3_data_showing = null;
                    inflater_for_level_3_data_showing = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View Level_3_View = inflater_for_level_3_data_showing.inflate(R.layout.row_level_3, null);

                    TextView Level_3_Item_Name = (TextView) Level_3_View.findViewById(R.id.Level_3_Item_Name);
                    TextView Level_3_Item_Price = (TextView) Level_3_View.findViewById(R.id.Level_3_Item_Price);

                    final LinearLayout Level_3_Layout=(LinearLayout)Level_3_View.findViewById(R.id.Level_3_Layout);
                    final String getLevel_3_Item_Name = mainList.get(i).get_Model_of_Level_2_from_Level_1().get(j).set_Model_of_Level_3_from_Level_2().get(k).getItemName();
                    final String getLevel_3_Item_Price = mainList.get(i).get_Model_of_Level_2_from_Level_1().get(j).set_Model_of_Level_3_from_Level_2().get(k).getItemPrice();

                    Level_3_Item_Name.setText(getLevel_3_Item_Name);
                    Level_3_Item_Price.setText(getLevel_3_Item_Price);

                    //Handles onclick effect on list item of level 3
                    Level_3_Layout.setOnTouchListener(new OnTouchListener()
                    {
                        @Override
                        public boolean onTouch(View v, MotionEvent event)
                        {
                            //Log.e("Value to see",Integer.toString(i)+j+k);
                            //String message_to_show = "test toast";//Integer.toString(finalI)+" "+ Integer.toString(finalI) +" "+ Integer.toString(finalI);
                            //Toast.makeText(getApplicationContext(), message_to_show, Toast.LENGTH_SHORT).show();
                            /////////////////////////////////////////////////////////////////////////////////////
                            return false;       //Stop propagating in other views
                        }
                    });
                    ///////////////////////////////////////////////////

                    Level_2_scrollable_part_Layout_for_Level_3_data_showing.addView(Level_3_View);
                }

                Level_1_scrollable_part_Layout_for_Level_2_data_showing.addView(Level_2_View);
            }

            Main_scrollable_part_Layout_for_Level_1_data_showing.addView(Level_1_View);
        }
    }
}
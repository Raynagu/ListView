package com.admin.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dynamic.*

class DynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        val listItem = mutableListOf<String>("Android", "IOS", "Windows", "Linux")

        dynamicList.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem)

        dynamicList.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "clicked ${listItem[i]}", Toast.LENGTH_SHORT).show()
        }

        btn_newItem.setOnClickListener {
            val newItem = edit_newItem.text.toString()
            if(newItem.isEmpty()){
                edit_newItem.error = "Please enter an item name"
            }else{
                listItem.add(newItem)
                edit_newItem.text.clear()
                dynamicList.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem)
            }
        }
    }
}

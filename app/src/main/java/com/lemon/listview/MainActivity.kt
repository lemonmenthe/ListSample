package com.lemon.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val listView: ListView by lazy{   // 리스트 변수 선언
        findViewById(R.id.listView)
    }
    /** sample **/
    var UserList = arrayListOf<User>(
    User(R.drawable.lemon,"샘플이름","14","리스트 샘플 객체"),
    User(R.drawable.ic_baseline_label_important_24,"가나다","24","두번째 샘플"),
    User(R.drawable.lemon,"주말","15","빨리간다"),
    User(R.drawable.lemon,"은하","64","빛나다"),
    User(R.drawable.ic_baseline_star_border_24,"별이","42","별빛")
    )

    override fun onCreate(savedInstanceState: Bundle?) {  // 액티비티 시작지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // main layout 실행

//        val item = arrayOf("사과","배","딸기","키위")  // sample list
//        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,item)  // 리스트뷰는 adpater가있어야함

        val Adapter = UserAdpater(this,UserList)
        listView.adapter = Adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User // 위치 가져오기
            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()


        }
    }
}
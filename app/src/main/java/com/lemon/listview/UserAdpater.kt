package com.lemon.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class UserAdpater(val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
       return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    /* View를 가져왔을때 꾸며주는 부분 */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)  //레이아웃 붙여넣기
        val profile = view.findViewById<ImageView>(R.id.iv_profile)   // 프로필 이미지
        val name = view.findViewById<TextView>(R.id.tV_name) // 이름
        val age = view.findViewById<TextView>(R.id.tv_age) // 나이
        val greet = view.findViewById<TextView>(R.id.tV_greet) // 설명

        val user = UserList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view
    }

}
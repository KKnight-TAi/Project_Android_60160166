package com.example.a60160166_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass.
 */
class DataRealtime : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_data_realtime, container, false)
        // Inflate the layout for this fragment

        val btn1 = view.findViewById<Button>(R.id.btn1)
        val btn2 = view.findViewById<Button>(R.id.btn2)
        val btn3 = view.findViewById<Button>(R.id.btn3)
        val btn4 = view.findViewById<Button>(R.id.btn4)
        val Back_main_fm = view.findViewById(R.id.BACK_main) as Button
        //ประกาศตัวแปร DatabaseReference รับค่า Instance และอ้างถึง path ที่เราต้องการใน database
        val mRootRef = FirebaseDatabase.getInstance().getReference()

        //อ้างอิงไปที่ path ที่เราต้องการจะจัดการข้อมูล ตัวอย่างคือ users และ messages
        val mUsersRef = mRootRef.child("users")
        val mMessagesRef = mRootRef.child("messages")

        btn1.setOnClickListener {
            val mMessagesRef2 = mRootRef.child("data")

            val key = mMessagesRef.push().key
            val postValues: HashMap<String, Any> = HashMap()
            postValues["username"] = "COMMENT"
            postValues["text"] = "VERY GOOD"

            val childUpdates: MutableMap<String, Any> = HashMap()

            childUpdates["$key"] = postValues

            mMessagesRef2.updateChildren(childUpdates)
        }

        btn2.setOnClickListener {
            val mMessagesRef2 = mRootRef.child("data")

            val key = mMessagesRef.push().key
            val postValues: HashMap<String, Any> = HashMap()
            postValues["username"] = "COMMENT"
            postValues["text"] = "GOOD"

            val childUpdates: MutableMap<String, Any> = HashMap()

            childUpdates["$key"] = postValues

            mMessagesRef2.updateChildren(childUpdates)
        }

        btn3.setOnClickListener {

            val mMessagesRef2 = mRootRef.child("data")

            val key = mMessagesRef.push().key
            val postValues: HashMap<String, Any> = HashMap()
            postValues["username"] = "COMMENT"
            postValues["text"] = "BAD"

            val childUpdates: MutableMap<String, Any> = HashMap()

            childUpdates["$key"] = postValues

            mMessagesRef2.updateChildren(childUpdates)

        }
        btn4.setOnClickListener {

            val mMessagesRef2 = mRootRef.child("data")

            val key = mMessagesRef.push().key
            val postValues: HashMap<String, Any> = HashMap()
            postValues["username"] = "COMMENT"
            postValues["text"] = "VERY BAD"

            val childUpdates: MutableMap<String, Any> = HashMap()

            childUpdates["$key"] = postValues

            mMessagesRef2.updateChildren(childUpdates)

        }
        Back_main_fm.setOnClickListener {
            val back_profile = profile()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,back_profile,"fragment_third")
            transaction.addToBackStack("fragment_third")
            transaction.commit()

        }
        return view

    }
    data class FriendlyMessage(
        var username: String? = "",
        var text: String? = ""
    )
}

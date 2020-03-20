package com.example.a60160166_project

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class Recycler_view : Fragment() {

    override fun onCreateView(inflater : LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        // Inflate the layout for this fragment

        val jsonString : String = loadJsonFromAsset("recipes.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray("recipes")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyLayout)
        val BACK = view.findViewById(R.id.BACK) as Button
        //ตั้งค่า Layout
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)
        recyclerView.layoutManager = layoutManager

        //ตั้งค่า Adapter
        val adapter = MyRecyclerAdapter(activity!!,jsonArray)
        recyclerView.adapter = adapter

        recyclerView.setOnClickListener {
            val fragment_Description= Description()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, fragment_Description,"fragment_third")
            transaction.addToBackStack("fragment_third")
            transaction.commit()

        }
        BACK.setOnClickListener {

            val builder: android.app.AlertDialog.Builder =
                android.app.AlertDialog.Builder(this.context)
            builder.setTitle("กลับสู้หน้าหลัก")
            builder.setMessage("ต้องการกลับสู่หน้าหลักหรือไม่")
            builder.setPositiveButton("ยืนยัน") { _, _ ->
                val back_profile = profile()
                val fm = fragmentManager
                val transaction : FragmentTransaction = fm!!.beginTransaction()
                transaction.replace(R.id.layout,back_profile,"fragment_third")
                transaction.addToBackStack("fragment_third")
                transaction.commit()
            }
            builder.setNegativeButton("ยกเลิก",
                DialogInterface.OnClickListener { _, _ ->
                    //dialog.dismiss();
                })

            builder.show()

        }
        return view
    }
    private fun loadJsonFromAsset(filename: String, context: Context): String? {
        val json: String?

        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: java.io.IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }


}

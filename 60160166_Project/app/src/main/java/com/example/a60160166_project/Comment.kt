package com.example.a60160166_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class Comment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val manager = fragmentManager
        val transaction = manager!!.beginTransaction()
        val ShowData = ShowData()
        transaction.replace(R.id.show, ShowData,"fragment_ShowData")
        transaction.addToBackStack("fragment_ShowData")
        
        val DataRealtime = DataRealtime()
        transaction.replace(R.id.add, DataRealtime,"fragment_DataRealtime")
        transaction.addToBackStack("fragment_DataRealtime")

        transaction.commit()


    }


}

package com.example.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.widget.Button

interface FragmentTwoActions {

    fun fragmentTwoButtonPressed()

}

class FragmentTwo : Fragment() {

    val TAG = "FragmentTwo"

    var delegate : FragmentTwo.FragmentTwoActions? = null

    interface FragmentTwoActions {

        fun fragmentTwoButtonPressed()

    }

    override fun onAttach(context: Context?) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")

        var view = inflater.inflate(R.layout.fragment_2, container, false)

        var button = view.findViewById<Button>(R.id.button2)

        button.setOnClickListener({
            buttonPressed(it)
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }

    fun buttonPressed(view: View){

        try {

            delegate = context as FragmentTwo.FragmentTwoActions

            delegate!!.fragmentTwoButtonPressed()

        } catch (e: ClassCastException) {

        }
    }
}
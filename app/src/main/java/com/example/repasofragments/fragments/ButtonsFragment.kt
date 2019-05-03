package com.example.repasofragments.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.repasofragments.R
import com.example.repasofragments.constants.consts
import kotlinx.android.synthetic.main.fragment_buttons.view.*



class ButtonsFragment : Fragment() {

    private var listenerTool: ButtonsListenerTools? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_buttons, container, false)

        setNavigationListeners(view)
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ButtonsListenerTools) {
            listenerTool = context
        } else {
            throw RuntimeException(context.toString() + " must implement ButtonListenerTools") as Throwable
        }

    }

    private fun setNavigationListeners(view: View){
        view.fragment_buttons_Button_previous.setOnClickListener{
            listenerTool?.onClick(consts.left_ID)
        }
        view.fragment_buttons_Button_next.setOnClickListener{
            listenerTool?.onClick(consts.right_ID)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerTool = null

    }

    interface ButtonsListenerTools{
        fun onClick(nav_direction: String)
    }


}

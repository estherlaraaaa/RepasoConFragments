package com.example.repasofragments.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.repasofragments.R
import kotlinx.android.synthetic.main.fragment_image.view.*


class ImageFragment : Fragment() {

    lateinit var img_url : String

    companion object {

        @JvmStatic
        fun newInstance(url: String): ImageFragment {
            val instance = ImageFragment()
            instance.img_url = url

            return instance
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_image, container, false)
        Glide.with(this)
            .load(img_url)
            .into(view.fragment_image_ImageView_imageHolder)

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()

    }


}

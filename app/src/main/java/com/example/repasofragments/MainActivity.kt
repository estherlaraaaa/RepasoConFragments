package com.example.repasofragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.repasofragments.constants.consts
import com.example.repasofragments.fragments.ButtonsFragment
import com.example.repasofragments.fragments.ImageFragment

class MainActivity : AppCompatActivity(), ButtonsFragment.ButtonsListenerTools {

    val img_frag_1 = ImageFragment.newInstance("https://static.giantbomb.com/uploads/scale_small/13/135472/1891758-001bulbasaur.png")
    val img_frag_2 = ImageFragment.newInstance("https://static.giantbomb.com/uploads/scale_small/13/135472/1891761-004charmander.png")
    val img_frag_3 = ImageFragment.newInstance("https://static.giantbomb.com/uploads/scale_small/13/135472/1891764-007squirtle.png")
    val fragment_list = listOf<ImageFragment>(img_frag_1,img_frag_2,img_frag_3)
    var curr: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialFragment()
    }

    private fun changeFragment(newFragment: ImageFragment){
        supportFragmentManager.beginTransaction().replace(R.id.activity_main_FrameLayout_imageFragmentHolder, newFragment).commit()
    }

    private fun setInitialFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.activity_main_FrameLayout_imageFragmentHolder, img_frag_1).commit()
    }

    override fun onClick(nav_direction: String) {
        if(nav_direction == consts.left_ID){
            if(curr == 0){
                curr = 2
                changeFragment(fragment_list[curr])
            }
            else{
                curr -=1
                changeFragment(fragment_list[curr])
            }
        }
        if(nav_direction == consts.right_ID){
            if(curr == 2){
                curr = 0
                changeFragment(fragment_list[curr])
            }
            else{
                curr +=1
                changeFragment(fragment_list[curr])
            }
        }
    }
}

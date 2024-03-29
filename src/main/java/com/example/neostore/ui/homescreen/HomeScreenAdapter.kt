package com.example.neostore.ui.homescreen

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.neostore.R

class HomeScreenAdapter(private val context: Context) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private var images =
        arrayOf(R.drawable.slider_img1, R.drawable.slider_img2, R.drawable.slider_img3, R.drawable.slider_img4)

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 === p1
        //return true
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.custom_layout, null)
        val image = v.findViewById<View>(R.id.slider_image_view) as ImageView
        image.scaleType = ImageView.ScaleType.FIT_XY
        image.setImageResource(images[position])
        val vp = container as ViewPager
        vp.addView(v, 0)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}

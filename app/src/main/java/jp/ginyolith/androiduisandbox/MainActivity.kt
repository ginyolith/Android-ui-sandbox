package jp.ginyolith.androiduisandbox

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageButton
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder


class MainActivity : AppCompatActivity() {

    private var mSwipeView: SwipePlaceHolderView? = null
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSwipeView = findViewById(R.id.swipeView)
        mContext = applicationContext

        mSwipeView!!.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
                .setDisplayViewCount(3)
                .setSwipeDecor(SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view))

        for (profile in Utils.loadProfiles(this.applicationContext)!!) {
            mSwipeView!!.addView(TinderCard(mContext, profile, mSwipeView))
        }

        findViewById<ImageButton>(R.id.rejectBtn).setOnClickListener {
            mSwipeView!!.doSwipe(false)
        }

        findViewById<ImageButton>(R.id.acceptBtn).setOnClickListener {
            mSwipeView!!.doSwipe(true)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}
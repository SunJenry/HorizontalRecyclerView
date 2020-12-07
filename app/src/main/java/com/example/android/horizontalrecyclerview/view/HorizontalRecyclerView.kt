package com.example.android.horizontalrecyclerview.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.recyclerview.widget.RecyclerView

/**
 * Create by sun on 2020/9/10 2:39 PM
 */
class HorizontalRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    companion object {
        const val TAG = "HorizontalRecyclerView"
    }

    private var _scaledTouchSlop: Int = 0

    private var _lastTouchX: Float = 0f
    private var _lastTouchY: Float = 0f

    init {
        init()
    }

    private fun init() {
        val viewConfiguration = ViewConfiguration.get(context)
        _scaledTouchSlop = viewConfiguration.scaledTouchSlop
    }

    override fun setScrollingTouchSlop(slopConstant: Int) {
        super.setScrollingTouchSlop(slopConstant)
        val get = ViewConfiguration.get(context)
        _scaledTouchSlop = get.scaledTouchSlop
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev == null) return super.dispatchTouchEvent(ev)

        when (ev.action) {

            MotionEvent.ACTION_DOWN -> {
                parent.requestDisallowInterceptTouchEvent(true)
            }

            MotionEvent.ACTION_MOVE -> {

                val x = ev.x
                val y = ev.y

                val disX: Float = x - _lastTouchX
                val disY: Float = y - _lastTouchY

                if (Math.abs(disX) > Math.abs(disY)) {
                    if (disX > 0) {
                        val canScrollLeft = canScrollHorizontally(-1)
                        parent.requestDisallowInterceptTouchEvent(canScrollLeft)
                    } else if (disX < 0) {
                        val canScrollRight = canScrollHorizontally(1)
                        parent.requestDisallowInterceptTouchEvent(canScrollRight)
                    }
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }

            MotionEvent.ACTION_UP -> {

            }
        }

        _lastTouchX = ev.x
        _lastTouchY = ev.y

        return super.dispatchTouchEvent(ev)
    }
}
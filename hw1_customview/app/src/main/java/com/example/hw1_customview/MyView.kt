package com.example.hw1_customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.*

class MyView : View {

    private var paint = Paint()
    private var path = Path()

    private var paintX: Float = -100F
    private var paintY: Float = -100F


    constructor(context: Context) : super(context)
    constructor(context: Context,attrs: AttributeSet) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.RED

        val random = Random()
        val num = random.nextInt(3)

        if (num == 0) {
            canvas.drawRect(paintX, paintY, paintX + 100, paintY + 100, paint)
        }
        else if (num == 1){
        canvas.drawCircle(paintX, paintY, 100F, paint)
        }
        else {
        path.moveTo(paintX, paintY)
        path.lineTo(paintX - 100, paintY + 200)
        path.lineTo(paintX + 100, paintY + 200)
        path.lineTo(paintX, paintY)
        canvas.drawPath(path, paint)
        path.reset()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event.action==MotionEvent.ACTION_DOWN){

            paintX = event.x
            paintY = event.y

            invalidate()
            //performClick()
            return true
        }

        return super.onTouchEvent(event)
    }

}
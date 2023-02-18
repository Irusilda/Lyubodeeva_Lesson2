package com.example.lyubodeeva_lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MyClock
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : View(context, attrs, defStyleAttr) {

        private var paint: Paint = Paint().apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeWidth = 10f
        }
        private val radius = 300f
        private var hourHandSize = radius - radius / 2
        private var minuteHandSize = radius - radius / 5
        private var secondHandSize = radius - radius / 10

        private var hourHandColor = Color.RED
        private var minuteHandColor = Color.BLACK
        private var secondHandColor = Color.BLUE

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCircle(canvas)
        drawClock(canvas)
    }

    private fun drawCircle(canvas: Canvas?) {
        val w = (width / 2).toFloat()
        val h = (height / 2).toFloat()
        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        canvas?.drawCircle(w, h, radius, paint)
    }

    private fun drawClock(canvas: Canvas?) {
        val calendars = Calendar.getInstance()
        val hourHand = calendars.get(Calendar.HOUR_OF_DAY)
        val minuteHand = calendars.get(Calendar.MINUTE).toFloat()
        val secondHand = calendars.get(Calendar.SECOND)
        drawHourHand(canvas, (hourHand + minuteHand / 60) * 5f)
        drawMinuteHand(canvas, minuteHand)
        drawSecondHand(canvas, secondHand.toFloat())
        drawLines(canvas)
        postInvalidateDelayed(500)
    }

    private fun drawHourHand(canvas: Canvas?, location: Float) {
        paint.strokeWidth = 20f
        paint.color = hourHandColor
        val angle = PI * location / 30 - PI / 2
        canvas?.drawLine(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            ((width / 2).toFloat() + cos(angle) * hourHandSize).toFloat(),
            ((height / 2).toFloat() + sin(angle) * hourHandSize).toFloat(),
            paint
        )
    }

    private fun drawMinuteHand(canvas: Canvas?, location: Float) {
        paint.strokeWidth = 8f
        paint.color = minuteHandColor
        val angle = PI * location / 30 - PI / 2
        canvas?.drawLine(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            ((width / 2).toFloat() + cos(angle) * minuteHandSize).toFloat(),
            ((height / 2).toFloat() + sin(angle) * minuteHandSize).toFloat(),
            paint
        )
    }

    private fun drawSecondHand(canvas: Canvas?, location: Float) {
        paint.strokeWidth = 6f
        paint.color = secondHandColor
        val angle = PI * location / 30 - PI / 2
        canvas?.drawLine(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            ((width / 2).toFloat() + cos(angle) * secondHandSize).toFloat(),
            ((height / 2).toFloat() + sin(angle) * secondHandSize).toFloat(),
            paint
        )
    }

    private fun drawLines(canvas: Canvas?) {
        paint.color = Color.BLACK
        paint.strokeWidth = 20f

        for (i in 1..12) {
            val angle: Double = i * 30.0
            canvas?.drawLine(
                (width / 2).toFloat() + radius * cos(Math.toRadians(angle)).toFloat(),
                (height / 2).toFloat() + radius * sin(Math.toRadians(angle)).toFloat(),
                (width / 2).toFloat() + 250f * cos(Math.toRadians(angle)).toFloat(),
                (height / 2).toFloat() + 250f * sin(Math.toRadians(angle)).toFloat(),
                paint
            )
        }
    }
}

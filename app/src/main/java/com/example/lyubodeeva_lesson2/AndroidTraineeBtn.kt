package com.example.lyubodeeva_lesson2
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lyubodeeva_lesson2.databinding.AndroidTraineeBtnBinding

class AndroidTraineeBtn
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int,
    defStyleRes: Int

    ) : ConstraintLayout (context, attrs, defStyleAttr) {

    private val binding: AndroidTraineeBtnBinding

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context,attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context,attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.android_trainee_btn, this, true)
        binding = AndroidTraineeBtnBinding.bind(this)
        initializeandSetAttr(attrs, defStyleAttr, defStyleRes)
    }

    private fun initializeandSetAttr(attrs: AttributeSet?,defStyleAttr: Int, defStyleRes: Int ) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.AndroidTraineeBtn,
        defStyleAttr,
        defStyleRes)
        with(binding) {
            val trainee_title = typedArray.getString(R.styleable.AndroidTraineeBtn_trainee_title)
            val trainee_subtitle = typedArray.getString(R.styleable.AndroidTraineeBtn_trainee_subtitle)
            val trainee_icon =
                typedArray.getInt(R.styleable.AndroidTraineeBtn_trainee_icon, R.drawable.logo)


            setTraineeIcon(trainee_icon)
            setTraineeTitle(trainee_title)
            setTraineeSubtitle(trainee_subtitle)
            typedArray.recycle()
        }
    }

    fun setTraineeSubtitle(traineeSubtitle: String?) {
        binding.traineeSubtitle.text = traineeSubtitle
    }

    fun setTraineeTitle(traineeTitle: String?) {
        binding.traineeTitle.text = traineeTitle

    }

    fun setTraineeIcon(traineeIcon: Int) {
        binding.traineeLogo.setImageResource(traineeIcon)

    }
}


package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), CustomTitle {

    lateinit var bindingFrag: FragmentLoginBinding
    private val PASSWORD_CONST = "12345"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingFrag = FragmentLoginBinding.inflate(inflater)
        return bindingFrag.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFrag.apply {
            userPassword.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    signInBtn.alpha = 1f
                    signInBtn.isClickable = true
                }

                override fun afterTextChanged(s: Editable?) {
                    if (userPassword.text.isNullOrEmpty()) {
                        signInBtn.alpha = 0.5f
                        signInBtn.isClickable = false
                    }
                }
            })
            signInBtn.setOnClickListener {
                if (userPassword.text.toString() == PASSWORD_CONST) {

                    val countDownTimer = object : CountDownTimer(20000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            val progress = (millisUntilFinished / 100).toInt()
                            logofragProgress.progress = progress
                        }

                        override fun onFinish() {
                            logofragProgress.visibility = View.GONE
                        }
                    }
                    logofragProgress.visibility = View.VISIBLE
                    signInBtn.visibility = View.GONE
                    countDownTimer.start()

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.place_holder, MainFragment.newInstance())
                        .commit()

                } else {
                    passwordLayout.error = getString(R.string.error_text)
                    passwordLayout.isErrorEnabled = true
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    override fun getTitleRes(): Int = R.string.login_frag_bar_title
}
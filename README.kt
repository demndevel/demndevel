package com.problemsolver.panacea

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import com.problemsolver.panacea.databinding.TestFragmentActivityBinding

class TestFragmentActivity : AppCompatActivity() {
	private lateinit var binding: TestFragmentActivityBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = TestFragmentActivityBinding.inflate(layoutInflater)

		setContentView(binding.root)

		val firstFragment = BlankFragment()
		val secondFragment = SecondBlankFragment()

		supportFragmentManager.beginTransaction().apply {
			replace(R.id.frameForFragment, firstFragment)

			commit()
		}

		binding.btnFragment1.setOnClickListener {
			supportFragmentManager.beginTransaction().apply {
				replace(R.id.frameForFragment, firstFragment)

				commit()
			}
		}

		binding.btnFragment2.setOnClickListener {
			supportFragmentManager.beginTransaction().apply {
				replace(R.id.frameForFragment, secondFragment)

				addToBackStack(null)

				commit()
			}
		}
	}
}

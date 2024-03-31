package ru.netology.nmedia.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityNewPostBinding

class NewPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewPostBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(root)
            edit.requestFocus()
            edit.setText(intent.getStringExtra(Intent.EXTRA_TEXT))
            ok.setOnClickListener {
                val text = edit.text.toString()
                if (edit.text.isNotBlank()) {
                    setResult(RESULT_OK, Intent().putExtra(Intent.EXTRA_TEXT, text))
                } else setResult(RESULT_CANCELED)
                finish()
            }
    }
    }

    companion object {
        const val KEY_TEXT = "post_text"
    }
}

object NewPostContract: ActivityResultContract<Unit, String?> () {
    override fun createIntent(context: Context, input: Unit) = Intent(context, NewPostActivity::class.java)

    override fun parseResult(resultCode: Int, intent: Intent?) = intent?.getStringExtra(NewPostActivity.KEY_TEXT)
}
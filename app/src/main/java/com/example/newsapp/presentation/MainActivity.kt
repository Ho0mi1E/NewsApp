package com.example.newsapp.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R
import com.example.newsapp.presentation.clickListner.ShareClickListener
import com.example.newsapp.presentation.recycler.NewsAdapter
import com.example.newsapp.presentation.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val textView = TextView.OnEditorActionListener { _, _, _ ->
        openRecycler()
        closeKeyboard()
        false
    }

    private val shareNews by lazy {
        object : ShareClickListener {
            override fun clickListener(url: String?) {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, "News")
                    putExtra(Intent.EXTRA_TEXT, url)
                }
                startActivity(Intent.createChooser(intent, "Share"))
            }
        }
    }
    private val viewModel: NewsViewModel by viewModel()
    private val adapter = NewsAdapter(shareNews)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        editText.setOnEditorActionListener(textView)
    }

    @SuppressLint("SetTextI18n")
    private fun openRecycler() {
        viewModel.loadNews(editText.text.toString())
        viewModel.news.observe(this) { map ->
            textCount.text = "Количество результатов : ${map.keys.first()}"
            adapter.submitNews(map.values.first())
        }
        recycler.adapter = adapter
    }
    private fun closeKeyboard(){
        val imm: InputMethodManager = getSystemService(
            Context.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }
}
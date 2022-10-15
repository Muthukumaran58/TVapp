package com.example.tvapp.Activity

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.example.tvapp.Models.Movie
import com.example.tvapp.R
import kotlin.properties.Delegates

//creating views and Bind objects
class CardPresenter : Presenter() {

    private var mDefaultCardImage: Drawable? = null
    private var sSelectedBackgroundColor: Int by Delegates.notNull()
    private var sDefaultBackgroundColor: Int by Delegates.notNull()

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")

        if (parent != null) {
            sDefaultBackgroundColor =
                ContextCompat.getColor(parent.context, R.color.default_background)
        }
        if (parent != null) {
            sSelectedBackgroundColor =
                ContextCompat.getColor(parent.context, R.color.selected_background)
        }
        if (parent != null) {
            mDefaultCardImage = ContextCompat.getDrawable(parent.context, R.drawable.istockphoto)
        }

        val cardView = object : ImageCardView(parent?.context) {
            override fun setSelected(selected: Boolean) {
                updateCardBackgroundColor(this, selected)
                super.setSelected(selected)
            }
        }

        //creating the focus to the movie tray
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        updateCardBackgroundColor(cardView, false)
        return Presenter.ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val movie = item as Movie
        val cardView = viewHolder?.view as ImageCardView

        Log.d(TAG, "onBindViewHolder")

        //setting the view
        if (movie.cardImageUrl != null) {
            cardView.titleText = movie.title
            cardView.contentText = movie.studio
            cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)
            Glide.with(viewHolder.view.context)
                .load(movie.cardImageUrl)
                .centerCrop()
                .error(mDefaultCardImage)
                .into(cardView.mainImageView)
        }
    }

    private fun updateCardBackgroundColor(view: ImageCardView, selected: Boolean) {
        val color = if (selected) sSelectedBackgroundColor else sDefaultBackgroundColor
        view.setBackgroundColor(color)
        view.setInfoAreaBackgroundColor(color)

    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        Log.d(TAG, "onUnbindViewHolder")
        val cardView = viewHolder.view as ImageCardView
        // Remove references to images so that the garbage collector can free up memory
        cardView.badgeImage = null
        cardView.mainImage = null
    }


    companion object {
        private val TAG = "CardPresenter"

        //setting the Height and Width for the card
        private val CARD_WIDTH = 313
        private val CARD_HEIGHT = 176
    }
}

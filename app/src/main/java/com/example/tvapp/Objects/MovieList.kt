package com.example.tvapp.Objects

import com.example.tvapp.Models.Movie

//movie list object class
object MovieList {


    val MOVIE_CATEGORY = arrayOf(
        "CAT_A",
        "CAT_B",
        "CAT_C"
    )


    val list: List<Movie> by lazy {
        setupMovies()
    }
    private var count: Long = 0

    private fun setupMovies(): List<Movie> {
        val title = arrayOf(
            "1917",
            "7 Days in Entebbe",
            "A Simple Murder",
            "#LoveBytes",
            "Aahat",
            "#Bro"
        )


        val studio = arrayOf(
            "English",
            "English",
            "Hindi",
            "Hindi",
            "Hindi",
            "Telugu"
        )


        val cardImageUrl = arrayOf(
            "https://origin-staticv2.sonyliv.com/landscape_thumb/1917_generic_Landscape_Thumb.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/7DAYS_Landscape_Thumb.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/SM_Landscape_Thumb_A.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/5603920247001.jpg",
            "https://origin-staticv2.sonyliv.com/cms/4671143122001/thumbnail/4671143122001_thumb.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/Bro2_Landscape_Thumb.jpg",
        )

        val bgImageUrl = arrayOf(
            "https://origin-staticv2.sonyliv.com/landscape_thumb/1917_generic_Landscape_Thumb.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/7DAYS_Landscape_Thumb.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/SM_Landscape_Thumb_A.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/5603920247001.jpg",
            "https://origin-staticv2.sonyliv.com/cms/4671143122001/thumbnail/4671143122001_thumb.jpg",
            "https://origin-staticv2.sonyliv.com/landscape_thumb/Bro2_Landscape_Thumb.jpg",

            )

        val list = title.indices.map {
            buildMovieInfo(
                title[it],
                studio[it],
                cardImageUrl[it],
                bgImageUrl[it]
            )
        }

        return list
    }

    private fun buildMovieInfo(
        title: String,
        studio: String,
        cardImageUrl: String,
        backgroundImageUrl: String
    ): Movie {
        val movie = Movie()
        movie.id = count++
        movie.title = title
        movie.studio = studio
        movie.cardImageUrl = cardImageUrl
        movie.backgroundImageUrl = backgroundImageUrl

        return movie
    }

}


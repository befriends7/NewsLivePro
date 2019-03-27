package com.jeugene.newslive

class datalist
{

data class datas(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: Results,
    val status: String
)

data class Results(
    val bestsellers_date: String,
    val books: List<Book>,
    val corrections: List<Any>,
    val display_name: String,
    val list_name: String,
    val list_name_encoded: String,
    val next_published_date: String,
    val normal_list_ends_at: Int,
    val previous_published_date: String,
    val published_date: String,
    val published_date_description: String,
    val updated: String
)

data class Book(
    val age_group: String,
    val amazon_product_url: String,
    val article_chapter_link: String,
    val asterisk: Int,
    val author: String,
    val book_image: String,
    val book_image_height: Int,
    val book_image_width: Int,
    val book_review_link: String,
    val buy_links: List<BuyLink>,
    val contributor: String,
    val contributor_note: String,
    val dagger: Int,
    val description: String,
    val first_chapter_link: String,
    val isbns: List<Isbn>,
    val price: Int,
    val primary_isbn10: String,
    val primary_isbn13: String,
    val publisher: String,
    val rank: Int,
    val rank_last_week: Int,
    val sunday_review_link: String,
    val title: String,
    val weeks_on_list: Int
)

data class Isbn(
    val isbn10: String,
    val isbn13: String
)

data class BuyLink(
    val name: String,
    val url: String
)

}
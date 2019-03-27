package com.jeugene.newslive

public class datalst2
{

 data class datalst(
    val copyright: String,
    val response: Response,
    val status: String
)

data class Response(
    val docs: List<Doc>,
    val meta: Meta
)

data class Meta(
    val hits: Int,
    val offset: Int,
    val time: Int
)

data class Doc(
    val _id: String,
    val blog: Blog,
    val byline: Byline,
    val document_type: String,
    val headline: Headline,
    val keywords: List<Any>,
    val lead_paragraph: String,
    val multimedia: List<Any>,
    val news_desk: String,
    val pub_date: String,
    val score: Int,
    val section_name: String,
    val snippet: String,
    val source: String,
    val subsectoinName: String,
    val type_of_material: String,
    val uri: String,
    val web_url: String,
    val word_count: Int
)

class Blog(
)

data class Headline(
    val content_kicker: Any,
    val kicker: Any,
    val main: String,
    val name: Any,
    val print_headline: String,
    val seo: Any,
    val sub: Any
)

data class Byline(
    val organization: String,
    val original: String,
    val person: List<Any>
)

}
package com.jay.kakaoimages.api

data class GetImagesResponse(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Document(
        val collection: String,
        val datetime: String,
        val display_sitename: String,
        val doc_url: String,
        val height: Int,
        val image_url: String,
        val thumbnail_url: String,
        val width: Int
    )

    data class Meta(
        val is_end: Boolean,
        val pageable_count: Int,
        val total_count: Int
    )
}
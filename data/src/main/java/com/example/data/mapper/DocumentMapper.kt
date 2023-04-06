package com.example.data.mapper

import com.example.data.dto.DocumentDto
import com.example.domain.model.Document

fun DocumentDto?.toDocumentModel(): Document {
    return if (this == null) Document()
    else Document(
        datetime = datatime ?: "",
        contents = contents ?: "",
        title = title ?: "",
        url = url ?: ""
    )
}

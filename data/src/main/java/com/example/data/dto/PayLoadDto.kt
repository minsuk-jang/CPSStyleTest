package com.example.data.dto

import com.example.domain.model.Meta

data class PayLoadDto(
    val meta: Meta?,
    val documents: List<DocumentDto>?
)
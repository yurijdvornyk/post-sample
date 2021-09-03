package com.example.postdetailssample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SamplePost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
): Parcelable
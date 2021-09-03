package com.example.postdetailssample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleCompany(
    val name: String,
    val catchPhrase: String,
    val bs: String
): Parcelable
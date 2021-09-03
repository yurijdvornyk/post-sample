package com.example.postdetailssample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleAddress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: SampleGeoLocation
): Parcelable

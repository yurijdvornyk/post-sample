package com.example.postdetailssample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleGeoLocation(
    val lat: String,
    val lng: String
) : Parcelable

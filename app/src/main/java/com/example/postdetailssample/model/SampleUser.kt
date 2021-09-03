package com.example.postdetailssample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleUser(
    val id: Int,
    val name: String,
    val email: String,
    val address: SampleAddress,
    val phone: String,
    val website: String,
    val company: SampleCompany
) : Parcelable
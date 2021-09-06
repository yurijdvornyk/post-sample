package com.example.postdetailssample.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class SamplePost(
    @PrimaryKey val userId: Int,
    val id: Int,
    val title: String,
    val body: String
): Parcelable
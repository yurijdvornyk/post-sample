package com.example.postdetailssample.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class SampleUser(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String,
    @Ignore val address: SampleAddress?,
    val phone: String,
    val website: String,
    @Ignore val company: SampleCompany?
) : Parcelable {

    constructor(id: Int, name: String, email: String, phone: String, website: String) : this(
        id = id,
        name = name,
        email = email,
        address = null,
        phone = phone,
        website = website,
        company = null
    )
}
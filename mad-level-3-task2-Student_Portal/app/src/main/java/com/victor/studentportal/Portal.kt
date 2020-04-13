package com.victor.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal(
    var name: String,
    var link: String
) : Parcelable
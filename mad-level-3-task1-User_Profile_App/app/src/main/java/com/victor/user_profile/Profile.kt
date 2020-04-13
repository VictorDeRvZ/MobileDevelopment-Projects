package com.victor.user_profile

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize


data class profile( val firstName: String,
                    val lastName: String,
                    val description: String,
                    val imageUri: Uri?) : Parcelable {

}

package com.opensooq.OpenSooq.ui.imagePicker.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Hani AlMomani on 23,April,2019
 */

@Parcelize
internal data class ImageItem(
    var imagePath: String,
    var source: ImageSource,
    var selected: Int,
    var selectedPosition: Int? = null
) : Parcelable {

    companion object {
        const val SELECTED = 1
        const val NOT_SELECTED = 0
    }

    fun isCustomPositionActivated(): Boolean {
        return selected == SELECTED
    }

}

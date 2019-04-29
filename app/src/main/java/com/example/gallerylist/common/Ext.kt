package com.example.gallerylist.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * here we can add extention function to the project
 */
fun ViewGroup.infalte(layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)
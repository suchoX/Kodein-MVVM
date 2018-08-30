package com.sucho.kodeinexample.data.model

import com.google.gson.annotations.SerializedName
import com.sucho.kodeinexample.data.model.Joke

data class JokeListResponse(
  @SerializedName("type")
  val type: String,
  @SerializedName("value")
  val value: ArrayList<out Joke>)
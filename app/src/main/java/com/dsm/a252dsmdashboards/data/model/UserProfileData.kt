package com.dsm.a252dsmdashboards.data.model

import com.google.firebase.firestore.PropertyName

data class UserProfileData(
    val uid: String ="",
    @get:PropertyName("tipo_documento") @set:PropertyName("tipo_documento")
    var tipoDocumento: String? =""
)

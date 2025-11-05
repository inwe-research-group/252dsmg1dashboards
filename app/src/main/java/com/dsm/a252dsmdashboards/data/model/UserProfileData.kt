package com.dsm.a252dsmdashboards.data.model

import com.google.firebase.firestore.PropertyName

data class UserProfileData(
    val uid: String ="",
    val email: String? ="",
    val displayName: String? ="",
    val photoUrl: String? ="",

    @get:PropertyName("nombre") @set:PropertyName("nombre")
    var nombre: String? ="",
    @get:PropertyName("apellidopaterno") @set:PropertyName("apellidopaterno")
    var apellidoPaterno: String? ="",
    @get:PropertyName("apellidomaterno") @set:PropertyName("apellidomaterno")
    var apellidoMaterno: String? ="",
    @get:PropertyName("fechanacimiento") @set:PropertyName("fechanacimiento")
    var fechaNacimiento: com.google.firebase.Timestamp?=null,
    @get:PropertyName("tipo_documento") @set:PropertyName("tipo_documento")
    var tipoDocumento: String? ="",
    @get:PropertyName("numero_documento") @set:PropertyName("numero_documento")
    var numeroDocumento: String? ="",
    @get:PropertyName("genero") @set:PropertyName("genero")
    var genero: String? ="",
    var telefono: String? ="",
    @get:PropertyName("estado") @set:PropertyName("estado")
    var estado: String? =null,
    @get:PropertyName("tipousuarioid") @set:PropertyName("tipousuarioid")
    var tipousuarioid: String? =null,
    @get:PropertyName("legacyTipoUsuarioId") @set:PropertyName("legacyTipoUsuarioId")
    var legacyTipoUsuarioId: Int? =null,
    @get:PropertyName("ubigeoid") @set:PropertyName("ubigeoid")
    var ubigeoid: String? =null,
)

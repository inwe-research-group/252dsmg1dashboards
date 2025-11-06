package com.dsm.a252dsmdashboards.data.repository

import android.util.Log
import com.dsm.a252dsmdashboards.data.model.UserProfileData
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AccountRepository(private val firestore: FirebaseFirestore){
    companion object{
        private const val TAG="AccountRepository"
        private const val USER_COLLECTION="usuarios"
    }
    suspend fun getAllUsers(): Result<List<UserProfileData>>{
        return try {
            val snapshot=firestore.collection(USER_COLLECTION).get().await()
            val users=snapshot.documents.mapNotNull { doc->
                val uid=doc.getString("uid")?: doc.id
                val email=doc.getString("correo")
                val nombre=doc.getString("nombre")?: ""
                val apellidoPaterno=doc.getString("apellidopaterno")?: ""
                val apellidoMaterno=doc.getString("apellidomaterno")?: ""
                val displayName="$nombre $apellidoPaterno".trim()
                val photoUrl=doc.getString("photoUrl")?: ""
                val fechaNacimiento=doc.getTimestamp("fechanacimiento")
                val tipoDocumento=doc.getString("tipo_documento")
                val numeroDocumento=doc.getString("numero_documento")
                val genero=doc.getString("genero")
                val telefono=doc.getString("telefono")
                val estado=doc.getString("estado")
                val legacyTipoUusuarioId=doc.getLong("legacyTipoUusuarioId")?.toInt()
                UserProfileData(
                    uid=uid,
                    email=email,
                    displayName=displayName,
                    photoUrl=photoUrl,
                    nombre=nombre,
                    apellidoPaterno=apellidoPaterno,
                    apellidoMaterno=apellidoMaterno,
                    fechaNacimiento=fechaNacimiento,
                    tipoDocumento=tipoDocumento,
                    genero=genero,
                    telefono=telefono,
                    estado=estado,
                    legacyTipoUsuarioId = legacyTipoUusuarioId
                )
            }
            Result.success(users)
        }catch (e: Exception){
            Log.e(TAG,"Error al obtener la lista de usuarios",e)
            Result.failure(e)
        }
    }
}
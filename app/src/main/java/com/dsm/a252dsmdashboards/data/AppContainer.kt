package com.dsm.a252dsmdashboards.data

import com.dsm.a252dsmdashboards.data.repository.AccountRepository
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val dashboardRepository: AccountRepository
}
class DefaultAppContainer(): AppContainer {
    //Instancia unica de firebase
    private val firestore: FirebaseFirestore by lazy{
        FirebaseFirestore.getInstance()
    }

    override val dashboardRepository: AccountRepository by lazy{
        AccountRepository(firestore);
    }

}
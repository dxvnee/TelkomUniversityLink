package org.d3if3121.telkomuniversitylink.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import org.d3if3121.telkomuniversitylink.model.User

class UserRepository {
    val firestore = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()

    suspend fun getUserById(userId: String): User? {
        val userDoc = firestore.collection("users").document(userId).get().await()
        return userDoc.toObject(User::class.java)
    }
}
package app.harshit.objectdetection

import app.harshit.objectdetection.callback.OnFragmentInteractionListener
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.objects.FirebaseVisionObject
import com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetector
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred

suspend fun FirebaseVisionObjectDetector.processImageAwait(var1 : FirebaseVisionImage): List<FirebaseVisionObject> {
    return Tasks.await(this.processImage(var1))
}

fun <T> Task<T>.asDeferred(): Deferred<T> {
    val deferred = CompletableDeferred<T>()

    deferred.invokeOnCompletion {
        if (deferred.isCancelled) {
            // optional, handle coroutine cancellation however you'd like here
        }
    }

    this.addOnSuccessListener { result -> deferred.complete(result) }
    this.addOnFailureListener { exception -> deferred.completeExceptionally(exception) }

    return deferred
}

/*
fun <T> OnFragmentInteractionListener<T>.asDeferred(): Deferred<T> {
    val deferred = CompletableDeferred<T>()

    deferred.invokeOnCompletion {
        if (deferred.isCancelled) {
            // optional, handle coroutine cancellation however you'd like here
        }
    }

    this.onFragmentInteraction { result -> deferred.complete(result) }

    return deferred
}*/

package app.harshit.objectdetection.callback

import com.google.android.gms.tasks.Task

interface OnFragmentInteractionListener {
    fun onFragmentInteraction(str: String): Task<Boolean>
}
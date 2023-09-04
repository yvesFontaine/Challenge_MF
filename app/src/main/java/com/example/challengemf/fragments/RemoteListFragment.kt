package com.example.challengemf.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengemf.R
import com.example.challengemf.fragments.adapter.CharacterAdapter
import com.example.challengemf.viewModel.CharacterViewModel

class RemoteListFragment : Fragment() {

    // Déclarez ici vos variables de vue, adaptateur, ViewModel, etc.

    private lateinit var viewModel: CharacterViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_remote_list, container, false)

        // Initialisez et configurez votre RecyclerView ici
        recyclerView = view.findViewById(R.id.recyclerViewRemote)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CharacterAdapter() // Initialisez votre adaptateur ici
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisez votre ViewModel ici
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
//        viewModel.getCharacters()
//            .subscribeOn(Schedulers.io()) // Effectue l'appel réseau sur un thread de fond
//            //.observeOn(AndroidSchedulers.mainThread()) // Observe les résultats sur le thread principal
//            .subscribe(
//                { characters ->
//                    adapter.submitList(characters)
//                },
//                { error ->
//                    // Gérez les erreurs ici
//                }
//            )
        // Observer les données depuis le ViewModel
        viewModel.getCharacterLiveData().observe(viewLifecycleOwner) {
            // Mettez à jour votre adaptateur avec les nouvelles données
            adapter.submitList(it)
            Log.v(null,"TEMA FRERO $it")
        }
    }
}



package com.example.challengemf.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.challengemf.R
import com.example.challengemf.model.Character

class CharacterAdapter : ListAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageViewCharacter: ImageView = itemView.findViewById(R.id.imageViewCharacter)
        private val textViewCharacterName: TextView = itemView.findViewById(R.id.textViewCharacterName)
        private val textViewCharacterDescription: TextView = itemView.findViewById(R.id.textViewCharacterDescription)

        fun bind(character: Character) {
            // Utilisez les vues findViewById pour accéder aux éléments de liste
            //imageViewCharacter.setImageResource(R.drawable.ic_character) // Remplacez par la ressource de votre image
            textViewCharacterName.text = character.name
            textViewCharacterDescription.text = character.status
        }
    }

    class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}


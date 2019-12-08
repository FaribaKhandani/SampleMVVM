package com.sample.mvvm.ui.main_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.mvvm.data.model.artist.ArtistData
import com.sample.mvvm.databinding.ItemArtistViewBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    private  var artistData = mutableListOf<ArtistData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val binding: ItemArtistViewBinding =
            ItemArtistViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  artistData.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.onBind(artistData[position])
    }

    fun addItemsToList(data: MutableList<ArtistData>?) {
        data?.let {
            artistData=data
            notifyDataSetChanged()
        }

    }


    class ArtistViewHolder(private val binding: ItemArtistViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(artistData: ArtistData) {
            val viewModel = ArtistItemViewModel(artistData)
            binding.viewModel = viewModel
            binding.executePendingBindings()


        }

    }
}